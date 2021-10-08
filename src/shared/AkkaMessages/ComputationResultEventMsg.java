package shared.AkkaMessages;

import shared.sequence.Event;
import shared.sequence.EventId;

import java.io.Serializable;
import java.util.ArrayList;

public class ComputationResultEventMsg implements Serializable {

    private static final long serialVersionUID = -5307219757087710377L;
    private Event.EventEnum type;
    private EventId id;

    public ComputationResultEventMsg(Event.EventEnum type, EventId id) {
        this.type = type;
        this.id = id;
    }



    public Event.EventEnum getType() {
        return type;
    }

    public EventId getId() {
        return id;
    }
}
