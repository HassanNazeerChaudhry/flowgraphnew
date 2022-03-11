package shared.vertexcentric;

import java.io.Serializable;

public interface Outbox<MsgType extends Serializable> extends Serializable {

    public void add(String recipient, MsgSenderPair<MsgType> msg);

}