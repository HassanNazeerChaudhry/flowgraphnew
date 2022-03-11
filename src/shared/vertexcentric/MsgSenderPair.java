package shared.vertexcentric;

import java.io.Serializable;

public class MsgSenderPair<MsgType extends Serializable> implements Serializable {
    private static final long serialVersionUID = -9095277425205444931L;

    private final String sender;
    private final MsgType msg;

    public MsgSenderPair(String sender, MsgType msg) {
        super();
        this.sender = sender;
        this.msg = msg;
    }

    public String getSender() {
        return sender;
    }

    public MsgType getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "MsgSenderPair [sender=" + sender + ", msg=" + msg + "]";
    }

}
