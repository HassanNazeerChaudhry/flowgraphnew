package shared.graph;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GraphState implements Serializable {
    private static final long serialVersionUID = -3630884489728856662L;

    private Map<String, String[]> attributes = new HashMap<>();

    public GraphState() {
        this.attributes= new HashMap<>();
    }

    public GraphState(Map<String, String[]> attributes) {
        this.attributes.putAll(attributes);
    }

    public Map<String, String[]> getAttributes() {
        return attributes;
    }


    public Set<String> keySet() {
        return attributes.keySet();
    }





}

