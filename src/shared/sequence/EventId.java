package shared.sequence;

import java.io.Serializable;
import java.util.Objects;

public class EventId implements Serializable {
    public enum EventIdType  {VALUE,VARIABLE}
    private EventIdType type;
    private String id;

    public EventId(EventIdType type, String id) {
        this.type = type;
        this.id = id;
    }

    public EventId( String id) {
        this.type = EventIdType.VALUE;
        this.id = id;
    }

    public  boolean isValue(){return type.equals(EventIdType.VALUE);}
    public  boolean isVariable(){return type.equals(EventIdType.VARIABLE);}

    public void setType(EventIdType type){this.type = type;}

    public EventIdType getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EventId)) return false;
        EventId eventId = (EventId) o;
        return type == eventId.type &&
                Objects.equals(id, eventId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, id);
    }
}
