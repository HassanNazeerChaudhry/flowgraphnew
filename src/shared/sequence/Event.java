package shared.sequence;

import akka.japi.Pair;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Event implements Serializable {

    public enum EventEnum {
        VERTEX_ADDITION ,
        VERTEX_DELETION,
        VERTEX_UPDATE,
        EDGE_ADDITION,
        EDGE_DELETION,
        EDGE_UPDATE,
        COMPUTATION_RESULT //maybe here
    }
    //future: string type
    private EventEnum type;
    private HashMap<String,String> payload;
    private Long timestamp;

    public Event(EventEnum type, HashMap<String, String> payload, Long timestamp) {
        this.type = type;
        this.payload = payload;
        this.timestamp = timestamp;
    }

    public Event() {
        this.payload = new HashMap<>();
    }

    public EventEnum getType() {
        return type;
    }

    public void setType(EventEnum type) {
        this.type = type;
    }

    public HashMap<String, String> getPayload() {
        return payload;
    }

    public void setPayload(HashMap<String, String> payload) {
        this.payload = payload;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
