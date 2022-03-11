package shared.vertexcentric;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public interface Inbox<MsgType extends Serializable> extends Serializable {

    public List<MsgSenderPair<MsgType>> messagesFor(String recipients);

    public Set<String> recipients();

}