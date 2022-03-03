package shared.messages.graphchanges;

import shared.graph.Edge;

public abstract class ChangeEdgeMsg implements ChangeGraphMsg {
    private static final long serialVersionUID = 6374466780497705858L;

    protected final Edge edge;
    private final long timestamp;

    public ChangeEdgeMsg(Edge edge, long timestamp) {
        this.edge = edge;
        this.timestamp = timestamp;
    }

    /**
     * The edge.
     */
    public final Edge getEdge() {
        return edge;
    }

    /**
     * The source of the edge.
     */
    public final String getSource() {
        return edge.getSource();
    }

    /**
     * The destination of the edge.
     */
    public String getDestination() {
        return edge.getDestination();
    }

    @Override
    public long timestamp() {
        return timestamp;
    }
}
