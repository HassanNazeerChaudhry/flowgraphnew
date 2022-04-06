package shared.messages.graphchanges;

import akka.japi.Pair;
import shared.graph.Edge;

import javax.annotation.Nullable;
import java.util.ArrayList;

public class AddEdgeMsg extends ChangeEdgeMsg {
    private static final long serialVersionUID = -1645490952494467247L;

    public AddEdgeMsg(Edge edge, long timestamp) {
        super(edge, timestamp,"Add");
    }

    @Override
    public String toString() {
        return "AddEdgeMsg(" + edge + ", " + timestamp() + ")";
    }

}