package shared.AkkaMessages;

import shared.sequence.Event;
import shared.sequence.SubPatternElement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class AckMsgResultsSequence implements Serializable {

    private static final long serialVersionUID = 200160L;

    private final ArrayList<ArrayList<Event>> results;
    private boolean isFullPattern;

    public AckMsgResultsSequence(ArrayList<ArrayList<Event>> results,boolean isFullPattern) {
        this.results = results;
        this.isFullPattern = isFullPattern;
    }

    public boolean isFullPattern() {
        return isFullPattern;
    }

    public ArrayList<ArrayList<Event>> getResults() {
        ArrayList<ArrayList<Event>> result = new ArrayList<>();
        result.addAll(results);
        return result;
    }

    @Override
    public String toString() {
        return "AckMsgResultsSequence{" +
                "results=" + results +
                '}';
    }
}
