package shared.graph;

import java.io.Serializable;
import java.util.Map;

public class Edge implements Serializable {
    private static final long serialVersionUID = 7275396653146184686L;

    private final String source;
    private final String destination;
    private final GraphState state;
    private Boolean isDeleted;


    public Edge(String source, String destination) {
        this.source = source;
        this.destination = destination;
        this.state=new GraphState();
        this.isDeleted=false;
    }

    public Edge(String source, String destination, GraphState state) {
        super();
        this.source = source;
        this.destination = destination;
        this.state = state;
        this.isDeleted=false;
    }

    public Edge(String source, String destination, Map<String, String[]> attributes) {
        super();
        this.source = source;
        this.destination = destination;
        this.state = new GraphState(attributes);
        this.isDeleted=false;
    }



    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }


    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDel) {
        this.isDeleted=isDel;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (destination == null ? 0 : destination.hashCode());
        result = prime * result + (source == null ? 0 : source.hashCode());
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
        final Edge other = (Edge) obj;
        if (destination == null) {
            if (other.destination != null) {
                return false;
            }
        } else if (!destination.equals(other.destination)) {
            return false;
        }
        if (source == null) {
            if (other.source != null) {
                return false;
            }
        } else if (!source.equals(other.source)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Edge(" + source + ", " + destination + ")";
    }

}
