package shared.model.graphcollection;

import shared.model.enumerators.StreamOps;

import java.io.Serializable;

public class StreamOperatorObject extends GraphActions implements Serializable {
    public StreamOps streamOps;
    public String fieldName;

    public StreamOperatorObject(StreamOps streamOps, String fieldName) {
        this.streamOps = streamOps;
        this.fieldName = fieldName;
    }

    public StreamOps getStreamOps() {
        return streamOps;
    }

    public String getFieldName() {
        return fieldName;
    }
}


