package shared.messages.graphchanges;

import shared.graph.Vertex;

public class DelVertexMsg extends ChangeVertexMsg {
    private static final long serialVersionUID = 454090178763778660L;

    public DelVertexMsg(Vertex vertex, long timestamp) {
        super(vertex, timestamp, "Del");
    }

    @Override
    public String toString() {
        return "DelVertexMsg(" + vertex + ", " + timestamp() + ")";
    }

}