package slave;

import akka.actor.AbstractActorWithStash;
import akka.actor.ActorSelection;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import shared.PropertyHandler;
import shared.messages.SlaveAnnounceMsg;

public class TaskManagerActor extends AbstractActorWithStash {

    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);
    private ActorSelection master;
    private final String name;
    private final String masterAddress;

    private TaskManagerActor(String name, String masterAddress) {
        this.name = name;
        this.masterAddress = masterAddress;
    }

    @Override
    public void preStart() throws Exception {
        super.preStart();
        master = getContext().actorSelection(masterAddress);
        master.tell(new SlaveAnnounceMsg(name, 1), self());

        if (!Boolean.parseBoolean(PropertyHandler.getProperty("debugLog"))) {
            getContext().getSystem().eventStream().setLogLevel(Logging.ErrorLevel());
        }
    }

    @Override
    public Receive createReceive() {
        return null;
    }







    /**
     * Props for this actor
     */
    public static final Props props(String name, String jobManagerAddr) {
        return Props.create(TaskManagerActor.class, name, jobManagerAddr);
    }


}
