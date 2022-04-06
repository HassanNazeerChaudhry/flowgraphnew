package shared.messages.graphchanges;
import shared.graph.Vertex;



public class UpdateVertexMsg extends ChangeVertexMsg {
    private static final long serialVersionUID = 1576447800862056924L;

    public UpdateVertexMsg(Vertex vertex, long timestamp) {
        super(vertex, timestamp,"Update");
    }

    @Override
    public String toString() {
        return "UpdateVertexMsg(" + vertex + ", " + timestamp() + ")";
    }
}