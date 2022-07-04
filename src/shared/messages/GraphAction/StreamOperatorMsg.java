package shared.messages.GraphAction;

import shared.model.enumerators.StreamOps;

import java.io.Serializable;

public class StreamOperatorMsg extends GraphActions implements Serializable {
    private StreamOps streamOps;
    private String fieldName;
    private String type;

    public StreamOperatorMsg(StreamOps streamOps, String fieldName) {
        this.streamOps = streamOps;
        this.fieldName = fieldName;
        this.type="streamOp";
    }

    public String getType() {
        return type;
    }

    public StreamOps getStreamOps() {
        return streamOps;
    }

    public String getFieldName() {
        return fieldName;
    }
}
