package shared.AkkaMessages;

import shared.sequence.Event;
import shared.sequence.PatternElement;
import shared.sequence.SubPatternElement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class InstallSequenceMsg implements Serializable {

    private static final long serialVersionUID = -5307219757087710277L;
    private final ArrayList<SubPatternElement> parameters;
    private final ArrayList<Long> windows;
    private final boolean isFull;

    public InstallSequenceMsg(ArrayList<SubPatternElement> parameters, ArrayList<Long> windows, boolean isFull) {
        this.parameters = parameters;
        this.windows = windows;
        this.isFull = isFull;
    }

    public ArrayList<SubPatternElement> getParameters() {
        ArrayList<SubPatternElement> result = new ArrayList<>();
        result.addAll(parameters);
        return result;
    }



    public ArrayList<Long> getWindows() {
        ArrayList<Long> result = new ArrayList<>();
        result.addAll(windows);
        return result;
    }

    public boolean isFull() {
        return isFull;
    }



    @Override
    public String toString() {
        return "InstallSequenceMsg{" +
                "parameters=" + parameters +
                ", windows=" + windows +
                '}';
    }
}
