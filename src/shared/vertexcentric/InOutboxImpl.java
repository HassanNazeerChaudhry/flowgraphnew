package shared.vertexcentric;

import java.io.Serializable;
import java.util.*;

public class InOutboxImpl<MsgType extends Serializable> implements Outbox<MsgType>, Inbox<MsgType> {
    private static final long serialVersionUID = -937195671440301526L;

    // Recipient -> List of messages
    private final Map<String, List<MsgSenderPair<MsgType>>> messages = new HashMap<>();

    @Override
    public final void add(String recipient, MsgSenderPair<MsgType> msg) {
        List<MsgSenderPair<MsgType>> vertexMessages = messages.get(recipient);
        if (vertexMessages == null) {
            vertexMessages = new ArrayList<>();
            messages.put(recipient, vertexMessages);
        }
        vertexMessages.add(msg);
    }

    @Override
    public final List<MsgSenderPair<MsgType>> messagesFor(String recipient) {
        return messages.get(recipient);
    }

    @Override
    public final Set<String> recipients() {
        return messages.keySet();
    }

    @Override
    public String toString() {
        return "InOutboxImpl " + messages;
    }

}