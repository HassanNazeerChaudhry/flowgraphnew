package shared.messages.graphchanges;

import shared.graph.Vertex;

public abstract class ChangeVertexMsg implements ChangeGraphMsg {
    private static final long serialVersionUID = 38064559285786875L;

    protected final Vertex vertex;
    private final long timestamp;
    private final String msgType;

    public ChangeVertexMsg(Vertex vertex, long timestamp, String msgType) {
        super();
        this.vertex = vertex;
        this.timestamp = timestamp;
        this.msgType=msgType;
    }

    public String getName() {
        return vertex.getName();
    }

    public Vertex getVertex() {
        return vertex;
    }

    public String getMsgType() {
        return msgType;
    }

    @Override
    public long timestamp() {
        return timestamp;
    }
}