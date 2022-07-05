package shared.messages.GraphAction;

import shared.model.enumerators.GraphOps;
import shared.model.enumerators.StreamOps;

import java.io.Serializable;

public class StreamOperatorMsg extends GraphActions implements Serializable {
    private StreamOps streamOps;
    private String fieldName;
    private GraphOps type;
    private GraphOps lastOp;

    public StreamOperatorMsg(StreamOps streamOps, String fieldName) {
        this.streamOps = streamOps;
        this.fieldName = fieldName;
        this.type= GraphOps.STREAMOP;
        this.lastOp=GraphOps.EXTRACT;
    }



    public GraphOps getLastOp() {
        return lastOp;
    }

    public GraphOps getType() {
        return type;
    }

    public StreamOps getStreamOps() {
        return streamOps;
    }

    public String getFieldName() {
        return fieldName;
    }
}
