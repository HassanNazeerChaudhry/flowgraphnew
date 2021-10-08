package shared.sequence;

import org.agrona.collections.Object2IntHashMap;
import shared.patterns.Pattern;
import shared.streamProcessing.ExtractedStream;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SequenceHandler implements Serializable {

    /**
     * Hash Map of past events where first element is
     * the timestamp of the earliest event in the array
     * and the second element is the array of partial results
     */
    //todo: keep TreeMap of timestamp and events
    private TreeMap<Integer, TreeMap<Long, Event>> pastEvents;
    private final TreeMap<Integer, SubPatternElement> patternElements;
    private final TreeMap<Integer, Long> windows;
    private boolean isFullPattern;

    public SequenceHandler() {
        this.pastEvents = new TreeMap<>();
        this.patternElements = new TreeMap<>();
        this.windows = new TreeMap<>();
    }

    public SequenceHandler(ArrayList<SubPatternElement> patternElements, ArrayList<Long> windows, boolean isFullPattern) {
        this.pastEvents = new TreeMap<>();
        this.patternElements = new TreeMap<>();
        this.windows = new TreeMap<>();
        this.isFullPattern = isFullPattern;
        addPatternElements(patternElements,windows);

    }

    public void addPatternElements(ArrayList<SubPatternElement> patternElements, ArrayList<Long> windows) {
        for(int i=0;i<patternElements.size();i++){
            SubPatternElement elem = patternElements.get(i);
            this.patternElements.put(elem.getPosition(), elem);
            this.pastEvents.put(elem.getPosition(), new TreeMap<>());
                if(i!=0 && (isFullPattern || elem.getPosition()!=0))
                    this.windows.put(elem.getPosition(), windows.get(i-1));
        }
    }

    public boolean isFullPattern() {
        return isFullPattern;
    }

    public ArrayList<ArrayList<Event>> apply(Event newEvent) {
        ArrayList<ArrayList<Event>> result = new ArrayList<>();
            for (Integer position : this.patternElements.keySet()){
                SubPatternElement current =patternElements.get(position);
                if (current.getType() == newEvent.getType() && equalPayload(current.getPayload(),newEvent.getPayload())) {
                    result = applyForEvent(patternElements.get(position), position, newEvent, result);
                    break;
                }
            }

//        if(isFullPattern){
            ArrayList<ArrayList<Event>> toReturn = (ArrayList<ArrayList<Event>>) result.stream()
                    .filter(partRes -> partRes.size() == this.patternElements.size()).collect(Collectors.toList());
            return toReturn;
//        }
//
//        return result;
    }



    private ArrayList<ArrayList<Event>> applyForEvent(PatternElement current, Integer currPosition, Event newEvent,
                                                      ArrayList<ArrayList<Event>> result) {

            this.pastEvents.get(currPosition).put(newEvent.getTimestamp(), newEvent);
            //check if event is the last one in the pattern->start computation of the result if true
            if (isLast(currPosition)) {
                deleteOldEvents(currPosition,newEvent);
                result.add(new ArrayList<>(Arrays.asList(newEvent)));
                result = computeInputEventSequences(currPosition, result);
            }
        return result;
    }

    public void deleteOldEvents(Integer currPosition, Event event) {
        if (isFirst(currPosition)) return;
        int previousIndex = this.pastEvents.lowerKey(currPosition);
        if(previousIndex==-1) return;
        TreeMap<Long, Event> previousInputEvents = this.pastEvents.get(previousIndex);
        if (previousInputEvents.size() == 0) return;
        ArrayList<Long> toDelete = new ArrayList<>();
        previousInputEvents.keySet().forEach(t->{
            if(t>=event.getTimestamp() - this.windows.get(currPosition)) return;
            toDelete.add(t);
        });
        toDelete.forEach(x->previousInputEvents.remove(x));
        pastEvents.put(previousIndex, previousInputEvents);
        if(previousInputEvents.size()==0) return;
        Event oldest = previousInputEvents.entrySet().stream().findFirst().get().getValue();
        deleteOldEvents(previousIndex, oldest);
    }


    public ArrayList<ArrayList<Event>> computeInputEventSequences(Integer currPosition, ArrayList<ArrayList<Event>> result) {
        if (isFirst(currPosition)) return result;
        int previousPosition = this.patternElements.lowerKey(currPosition);
        TreeMap<Long, Event> previousEvents = this.pastEvents.get(previousPosition);
        if (previousEvents.size() == 0) return result;
        PatternElement previousElement = this.patternElements.get(previousPosition);
        ArrayList<ArrayList<Event>> toAdd = new ArrayList<>();
        result.forEach(partRes->{
            Long window = windows.get(currPosition);
            Event lastAdded = partRes.get(partRes.size()-1);
            previousEvents.forEach((t, e) -> {
                if (t < (lastAdded.getTimestamp() - window) ) return;
                if(equalVariablePayload(previousPosition,e,partRes)) {
                    ArrayList<Event> temp = new ArrayList<>();
                    temp.addAll(partRes);
                    temp.add(e);
                    toAdd.add(temp);
                }
            });
        });
        result = toAdd;
        return computeInputEventSequences(previousPosition, result);
    }

    private boolean equalVariablePayload(int previousPosition, Event event, ArrayList<Event> partialResult) {
        ArrayList<String> varNames = new ArrayList<>();
        HashMap<String,String> currentPayload,previousPayload;
        previousPayload = this.patternElements.get(previousPosition).getPayload();
        for(int i=partialResult.size()-1;i>=0;i--){
            if(this.patternElements.higherKey(previousPosition)==null) break;
           int currentPosition = this.patternElements.higherKey(previousPosition);
          currentPayload = this.patternElements.get(currentPosition).getPayload();


          for(Map.Entry<String,String> entry: previousPayload.entrySet()){
              if(entry.getValue().startsWith("$") && currentPayload.containsValue(entry.getValue()) ){
                  String currentEventValue = partialResult.get(i).getPayload().get(
                          getPayloadKey(currentPayload,entry.getValue()));
                  String newEventValue = event.getPayload().get(entry.getKey());
                  if(!currentEventValue.equals(newEventValue)) return false;
              }
          }
          previousPosition = currentPosition;
        }
        return true;
    }

    private String getPayloadKey(HashMap<String, String> payload, String value) {
       for(Map.Entry<String,String> entry:payload.entrySet())
           if(entry.getValue().equals(value)) return entry.getKey();
        return "";
    }


    public boolean isLast(int position) {
        if(position==this.patternElements.lastKey()) return true;
        return false;
//        PatternElement lastEvent =patternElements.lastEntry().getValue();
//        if (event.getType() == lastEvent.getType() && equalPayload(event.getPayload(), lastEvent.getPayload()))
//            return true;
//        return false;
    }

    public boolean isFirst(int position) {
        if(position==this.patternElements.firstKey()) return true;
        return false;
    }


    private boolean equalPayload(HashMap<String, String> currentPayload, HashMap<String, String> newPayload) {
        if(currentPayload.size()>newPayload.size()) return false;
        for(Map.Entry<String,String> entry:currentPayload.entrySet()){
            if(!newPayload.containsKey(entry.getKey())) return false;
            if(!entry.getValue().startsWith("$") &&
                    !newPayload.get(entry.getKey()).equals(entry.getValue())) return false;
        }
    return true;
    }

    public boolean detectElementHere(String vertexName, String workerName){
        boolean result = this.patternElements.values().stream().anyMatch(x->
                ( x.getPayload().containsValue(vertexName) && x.getDetectOn().equals(workerName)));
        return workerName.equals("master")? result:
                result || this.patternElements.values().stream().anyMatch(x->x.getDetectOn().equals("all"));
    }
    public boolean belongsToSequenceHandler(Event event) {
        for (Integer position : this.patternElements.keySet()) {
            SubPatternElement current = patternElements.get(position);
            if (current.getType() == event.getType() && equalPayload(current.getPayload(), event.getPayload()))
                return true;
        }
        return false;
    }

    public ArrayList<String> getNewFieldNames(ExtractedStream.StreamType streamType) {
        return null;
    }
}
