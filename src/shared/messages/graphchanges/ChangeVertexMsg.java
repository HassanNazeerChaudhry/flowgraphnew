package shared.messages.graphchanges;

import shared.graph.Vertex;

public abstract class ChangeVertexMsg implements ChangeGraphMsg {
    private static final long serialVersionUID = 38064559285786875L;

    protected final Vertex vertex;
    private final long timestamp;

    public ChangeVertexMsg(Vertex vertex, long timestamp) {
        super();
        this.vertex = vertex;
        this.timestamp = timestamp;
    }

    public String getName() {
        return vertex.getName();
    }

    public Vertex getVertex() {
        return vertex;
    }

    @Override
    public long timestamp() {
        return timestamp;
    }
}