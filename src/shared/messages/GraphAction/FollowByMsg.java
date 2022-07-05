package shared.messages.GraphAction;

import shared.model.enumerators.GraphOps;

import java.io.Serializable;

public class FollowByMsg extends GraphActions implements Serializable {
    private int time;
    private GraphOps type;


    public FollowByMsg() {
    }

    public FollowByMsg(int time) {
        this.time = time;
        this.type= GraphOps.FOLLOWEDBY;

    }

    public GraphOps getType() {
        return type;
    }

    public Integer getTime() {
        return time;
    }
}
