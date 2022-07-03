package shared.model.graphcollection;

import java.io.Serializable;

public class FollowByObject extends GraphActions implements Serializable {
   public Integer time;

    public FollowByObject(Integer time) {
        this.time = time;
    }

    public Integer getTime() {
        return time;
    }
}
