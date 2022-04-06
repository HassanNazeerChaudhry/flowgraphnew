package shared.messages.graphchanges;

import shared.graph.Edge;

public abstract class ChangeEdgeMsg implements ChangeGraphMsg {
    private static final long serialVersionUID = 6374466780497705858L;

    protected final Edge edge;
    private final long timestamp;
    private final String msgType;

    public ChangeEdgeMsg(Edge edge, long timestamp, String msgType) {
        this.edge = edge;
        this.timestamp = timestamp;
        this.msgType=msgType;
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

    public String getMsgType() {
        return msgType;
    }

    @Override
    public long timestamp() {
        return timestamp;
    }



}
