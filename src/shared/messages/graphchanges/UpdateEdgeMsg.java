package shared.messages.graphchanges;

import shared.graph.Edge;

public class UpdateEdgeMsg extends ChangeEdgeMsg {
    private static final long serialVersionUID = 1576447800862056924L;

    public UpdateEdgeMsg(Edge edge, long timestamp) {
        super(edge, timestamp,"Update");
    }

    @Override
    public String toString() {
        return "UpdateEdgeMsg(" + edge + ", " + timestamp() + ")";
    }
}