package shared.sequence;

import java.io.Serializable;
import java.util.HashMap;

public class PatternElement implements Serializable {

    private Event.EventEnum type;
    private HashMap<String,String> payload;
    private Integer position;

    public PatternElement(Event.EventEnum type, HashMap<String, String> payload, Integer position) {
        this.type = type;
        this.payload = payload;
        this.position = position;
    }

    public PatternElement() {
        this.payload = new HashMap<>();
        this.position = 0;
    }

    public Event.EventEnum getType() {
        return type;
    }

    public void setType(String type) {
        switch(type){
            case "vertexinsert": this.type = Event.EventEnum.VERTEX_ADDITION; break;
            case "vertexupdate": this.type = Event.EventEnum.VERTEX_UPDATE;break;
            case "vertexdelete": this.type = Event.EventEnum.VERTEX_DELETION;break;
            case "edgeinsert": this.type = Event.EventEnum.EDGE_ADDITION;break;
            case "edgeupdate": this.type = Event.EventEnum.EDGE_UPDATE;break;
            case "edgedelete": this.type = Event.EventEnum.EDGE_DELETION;break;
            case "computation result": this.type = Event.EventEnum.COMPUTATION_RESULT;break;
            default: this.type = null;
        }
    }

    public HashMap<String, String> getPayload() {
        return payload;
    }

    public void setPayload(HashMap<String, String> payload) {
        this.payload = payload;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }
}
