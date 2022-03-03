package shared.messages.graphchanges;

import akka.japi.Pair;
import shared.graph.Vertex;

import java.util.ArrayList;

public class AddVertexMsg extends ChangeVertexMsg {
    private static final long serialVersionUID = -1506565987690135540L;

    public AddVertexMsg(Vertex vertex, long timestamp) {
        super(vertex, timestamp);
    }

    @Override
    public String toString() {
        return "AddVertexMsg(" + vertex + ", " + timestamp() + ")";
    }
}