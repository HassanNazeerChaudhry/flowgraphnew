package shared.messages.vertexcentric;

import java.io.Serializable;

public class StartComputationMsg implements Serializable {
    private static final long serialVersionUID = 4422724784491860068L;

    private final long timestamp;

    @Override
    public String toString() {
        return "StartComputationMsg";
    }

    public long getTimestamp() {
        return timestamp;
    }

    public StartComputationMsg(long timestamp) {
        super();
        this.timestamp = timestamp;
    }
}