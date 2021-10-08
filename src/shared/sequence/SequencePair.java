package shared.sequence;

import java.io.Serializable;

public class SequencePair implements Serializable {

    public Event first;
    public Event second;
    public long window;

    public SequencePair(Event first, Event second, long window) {
        this.first = first;
        this.second = second;
        this.window = window;
    }

    public SequencePair() {
    }
}
