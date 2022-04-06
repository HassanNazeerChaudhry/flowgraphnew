package shared.messages.graphchanges;

import shared.graph.Edge;

public class DelEdgeMsg extends ChangeEdgeMsg {
    private static final long serialVersionUID = -5784453450812729470L;

    public DelEdgeMsg(Edge edge, long timestamp) {
        super(edge, timestamp,"Del");
    }

    @Override
    public String toString() {
        return "DelEdgeMsg(" + edge + ", " + timestamp() + ")";
    }

}