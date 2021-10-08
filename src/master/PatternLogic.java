package master;

import org.jetbrains.annotations.Nullable;
import shared.AkkaMessages.InstallSequenceMsg;
import shared.AkkaMessages.NewTimestampMsg;
import shared.PropertyHandler;
import shared.patterns.Pattern;
import shared.patterns.Sequence;
import shared.patterns.Trigger;
import shared.sequence.*;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class PatternLogic {

    private List<Pattern> patternElements;
    private Iterator<Pattern> currentPattern;
    private Pattern currentElement;
    private Pattern previousElement;
    private PatternCallback transportLayer;

    private long currentTimestamp;
    private Trigger.TriggerEnum triggerEvent;
    private HashSet<String> validVariable;
    private int sequenceSize;

    public PatternLogic(PatternCallback transportLayer) {
        this.transportLayer = transportLayer;
        this.patternElements = new ArrayList<>();
        this.sequenceSize = 0;
    }

    public Pattern getCurrentElement() {
        return currentElement;
    }

    public void installPattern (List<Pattern> patternElements) {
        this.patternElements = patternElements;
    }

    public void startNewIteration (long currentTimestamp,
                                   Trigger.TriggerEnum triggerEvent,
                                   HashSet<String> validVariables) {

        this.currentTimestamp = currentTimestamp;
        this.triggerEvent = triggerEvent;
        this.validVariable = validVariables;
        this.currentElement = null;
        this.previousElement = null;
        currentPattern = patternElements.iterator();

        transportLayer.sendToAllSlaves(new NewTimestampMsg(currentTimestamp));
        transportLayer.becomeAwaitAckFromAll();


    }

    /**
     * Run current element or take the following if finished
     * If pattern is finished, change receive state
     */
    public void runElement (@Nullable Serializable message) {

        if (patternElements.isEmpty()) {
            //No installed pattern
            transportLayer.becomeReceiveChangeState();
            return;
        } else if (currentElement == null) {
            //First step
            applyNext();

        } else if (currentElement.processMessage(message)) {
            //this is where something is computed
            applyNext();
        }
    }

    // apply the next pattern element
    private void applyNext() {

        if (currentPattern.hasNext()) {
            previousElement = currentElement;
            currentElement = currentPattern.next();
            if(currentElement instanceof Sequence){
                this.sendSequence(currentElement);
                this.patternElements.remove(currentElement);
                if(patternElements.size()>0){
                    currentPattern = patternElements.iterator();
                    //if it was the first element
                    if(previousElement==null && currentPattern.hasNext())
                        currentElement = currentPattern.next();
                    else{
                        while (!currentElement.equals(previousElement)){
                            if(currentPattern.hasNext())
                                currentElement = currentPattern.next();
                        }
                    }
                }
                transportLayer.becomeReceiveChangeState();

            } else{
                while (currentElement.applyIfTriggered(currentTimestamp, triggerEvent, validVariable)) {
                    if (currentPattern.hasNext()) {
                        currentElement = currentPattern.next();
                    } else {
                        transportLayer.becomeReceiveChangeState();
                        break;
                    }
                }
            }

        } else {
            transportLayer.becomeReceiveChangeState();
        }
    }

    public void sendSequence(Pattern p) {
//        for(Pattern p: patternElements) {
//            if (p instanceof Sequence) {
                this.sequenceSize = ((Sequence) p).getQueries().size();

                //Original data coming from the input
                final ArrayList<Long> windows = ((Sequence) p).getWindows();
                final ArrayList<PatternElement> queryEvents = ((Sequence)p).getQueries();

                ArrayList<SubPatternElement> masterEvents = new ArrayList<>();
                HashMap<String, ArrayList<PatternElement>> elementsForWorkers = new HashMap<>();
                HashMap<String, ArrayList<Long>> elementsWindows = new HashMap<>();

                //add every part of the query to the map
                for (int i = 0; i < queryEvents.size(); i++){
                    queryEvents.get(i).setPosition(i);
                    addEventToMap(elementsForWorkers, queryEvents,elementsWindows,windows,masterEvents,i);
                }

//                (o1, o2) -> o1.getPosition()<o2.getPosition());

                sendToWorkers(elementsForWorkers,elementsWindows,masterEvents,queryEvents.size());
                Collections.sort(masterEvents,Comparator.comparing(SubPatternElement::getPosition));
                SequenceHandler fullSequence = new SequenceHandler(masterEvents,windows,true);
                transportLayer.addSequenceHandler(fullSequence);
        PropertyHandler.writeOnPerformanceLog("ENTERING_SEQUENCE_"+ System.currentTimeMillis());


//                this.patternElements.remove(p);


//            }
//        }

    }



    public void addEventToMap(HashMap<String, ArrayList<PatternElement>> elements, ArrayList<PatternElement> queryEvents,
                              HashMap<String, ArrayList<Long>> elementsWindows, ArrayList<Long> windows,
                              ArrayList<SubPatternElement> masterEvents, int i){
        PatternElement current = queryEvents.get(i); //current element in the query
        String currentId = getElementId(current);
        if(currentId==null) masterEvents.add(new SubPatternElement(current,"master"));
        else if(elements.containsKey(currentId)){
            //events with the same id
            ArrayList<PatternElement> sequenceElements = elements.get(currentId); //events with same id as current
            PatternElement lastAdded = sequenceElements.get(sequenceElements.size()-1); //needed later for windows
            //add it to the map
            sequenceElements.add(current);
            elements.put(currentId, sequenceElements);
            //check to see the what should be the window
            long sum = queryEvents.indexOf(lastAdded)==i-1? windows.get(i-1)
                    :sumTimes(elementsWindows.size(), i,windows);
            addWindowToMap(elementsWindows,currentId,sum);
        }else
            elements.put(currentId, new ArrayList<>(Arrays.asList(current)));
    }

    public void addWindowToMap(HashMap<String, ArrayList<Long>> elementsWindows, String elementId, Long time ){
        if(elementsWindows.containsKey(elementId)){
            ArrayList<Long> times = elementsWindows.get(elementId);
            times.add(time);
            elementsWindows.put(elementId,times);
        }else
            elementsWindows.put(elementId, new ArrayList<>(Arrays.asList(time)));
    }

    private void sendToWorkers(HashMap<String, ArrayList<PatternElement>> elements,HashMap<String, ArrayList<Long>> elementsWindows,
                        ArrayList<SubPatternElement> masterEvents,int querySize) {
        elements.keySet().stream().forEach(x->{
            ArrayList<SubPatternElement> elementsToSend = new ArrayList<>();
            if(elements.get(x).size()>1) {
                elementsToSend = (ArrayList<SubPatternElement>) elements.get(x).stream().map(elem->
                                new SubPatternElement(elem, x.startsWith("$")?"all":x)).collect(Collectors.toList());
                boolean isFullPattern = elementsToSend.size()==querySize;
                if (!x.startsWith("$")) {
                    transportLayer.sendToSlave(
                            new InstallSequenceMsg(elementsToSend, elementsWindows.get(x),isFullPattern), x);
                    transportLayer.becomeAwaitAckFromOne();
                }else {
                    transportLayer.sendToAllSlaves(
                            new InstallSequenceMsg(elementsToSend, elementsWindows.get(x),isFullPattern));
                    transportLayer.becomeAwaitAckFromAll();
                }
                masterEvents.addAll(elementsToSend);


            }else if(elements.get(x).size()==1)
                masterEvents.add(new SubPatternElement(elements.get(x).get(0),"master"));
        });
    }

    private String getElementId(PatternElement current) {
            return current.getPayload().get("vertexName");
    }

    public long sumTimes(int start,int end, ArrayList<Long> windows){
        long sum = 0;
        for(int j=start; j<end; j++)
            sum += windows.get(j).longValue();
        return sum;
    }

    public int getSequenceSize() {
        return sequenceSize;
    }
}
