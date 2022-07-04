package shared.messages.GraphAction;

import java.io.Serializable;

public class FollowByMsg extends GraphActions implements Serializable {
    private int time;
    private String type;


    public FollowByMsg() {
    }

    public FollowByMsg(int time) {
        this.time = time;
        this.type="followedBy";
    }

    public String getType() {
        return type;
    }

    public Integer getTime() {
        return time;
    }
}
