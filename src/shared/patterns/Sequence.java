package shared.patterns;

import master.PatternCallback;
import org.jetbrains.annotations.Nullable;
import shared.AkkaMessages.InstallSequenceMsg;
import shared.PropertyHandler;
import shared.sequence.Event;
import shared.sequence.PatternElement;
import shared.sequence.SequenceHandler;
import shared.sequence.SubPatternElement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Sequence extends Pattern {
    private final ArrayList<PatternElement> queries;
    private final ArrayList<Long> windows; //size = queries.size()-1=> list of within windows of events in the query

    public Sequence(Trigger trigger, String variablesToBeGenerated, PatternCallback transportLayer,
                    ArrayList<PatternElement> queries, ArrayList<Long> windows) {
        super(trigger, variablesToBeGenerated, transportLayer);
        this.queries = queries;
        this.windows = windows;
    }

    public ArrayList<PatternElement> getQueries() {
        ArrayList<PatternElement> result = new ArrayList<>();
        result.addAll(queries);
        return result;
    }

    public ArrayList<Long> getWindows() {
        ArrayList<Long> result = new ArrayList<>();
        result.addAll(windows);
        return result;
    }

    @Override
    boolean startPatternLogic() {

        return false;
    }


    @Override
    public boolean processMessage(Serializable message) {
        return true;
    }

    private void setReduceCollectAggregates () { }
}
