package shared.messages.graphchanges;

import java.io.Serializable;

public interface ChangeGraphMsg extends Serializable {
    public long timestamp();
}
