package client;

import akka.actor.AbstractActor;
import akka.actor.AbstractActorWithStash;
import akka.actor.ActorSelection;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import shared.PropertyHandler;
import shared.messages.HelloClientMsg;

public class ClientActor extends AbstractActor {


    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);

    private final String jobManagerAddr;
    private ActorSelection jobManager = null;

    private ClientActor(String jobManagerAddr) {
        this.jobManagerAddr = jobManagerAddr;
    }

    @Override
    public void preStart() throws Exception {
        super.preStart();
        jobManager = getContext().actorSelection(jobManagerAddr);

        if (!Boolean.parseBoolean(PropertyHandler.getProperty("debugLog"))) {
            getContext().getSystem().eventStream().setLogLevel(0);
        }
    }


    @Override
    public Receive createReceive() {
        return receiveBuilder(). //
                match(HelloClientMsg.class, this::onHelloClientMsg).
                build();
    }

    private final void onHelloClientMsg(HelloClientMsg msg) {
        log.info("HelloClientMsg");
        jobManager.tell(msg, self());
    }



    @Override
    public void postStop() throws Exception {
        PropertyHandler.exit();
        super.postStop();
    }



    static final Props props(String jobManagerAddr) {
        return Props.create(ClientActor.class, jobManagerAddr);
    }



}
