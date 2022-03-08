package shared.graph;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

public class Vertex implements Serializable {
    private static final long serialVersionUID = 3771725367350734078L;
    private final String name;
    private final GraphState state;
    private Boolean isDeleted;

    public Vertex() {
        this.name = "";
        this.state=new GraphState();
    }

    public Vertex(String name, String destination) {
        this.name = name;
        this.state=new GraphState();
        this.isDeleted=false;
    }



    public Vertex(String name, GraphState state) {
        this.name = name;
        this.state = state;
        this.isDeleted=false;
    }



    public Vertex(String name, Map<String, String[]> attributes) {
        this.name = name;
        this.state = new GraphState(attributes);
        this.isDeleted=false;
    }




    public GraphState getState() { return state; }

    public String getName() {
        return name;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDel) {
        this.isDeleted=isDel;
    }


    public Set<String> keySet() {
        return state.keySet();
    }



    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (name == null ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vertex other = (Vertex) obj;
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vertex(" + name + " [" + state + "])";
    }

}
