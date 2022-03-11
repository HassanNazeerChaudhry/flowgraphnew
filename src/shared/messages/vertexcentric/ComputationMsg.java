package shared.messages.vertexcentric;

import shared.vertexcentric.Inbox;
import shared.vertexcentric.MsgSenderPair;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public class ComputationMsg<MsgType extends Serializable> implements Serializable {
    private static final long serialVersionUID = -3771118939226472136L;

    private final Inbox<MsgType> content;
    private final int superstep;
    private final boolean fromJobManager;

    public ComputationMsg(Inbox<MsgType> content, int superstep, boolean fromJobManager) {
        this.content = content;
        this.superstep = superstep;
        this.fromJobManager = fromJobManager;
    }

    public List<MsgSenderPair<MsgType>> messagesFor(String recipient) {
        return content.messagesFor(recipient);
    }

    public Set<String> recipients() {
        return content.recipients();
    }

    public final int getSuperstep() {
        return superstep;
    }

    public final boolean isFromJobManager() {
        return fromJobManager;
    }

    @Override
    public String toString() {
        return "ComputationMsg [superstep=" + superstep + ", fromJobManager=" + fromJobManager + ", content=" + content
                + "]";
    }

}