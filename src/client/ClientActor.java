package client;

import akka.actor.AbstractActor;
import akka.actor.ActorSelection;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import shared.PropertyHandler;
import shared.messages.HelloClientMsg;
import shared.messages.LaunchMsg;
import shared.messages.TerminateMsg;

import java.io.Serializable;

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
                match(LaunchMsg.class, this::onStartMsg).
                match(Serializable.class, this::onUpdateGraphMsg).
                match(TerminateMsg.class, this::onTerminateMsg).
                build();
    }

    private final void onHelloClientMsg(HelloClientMsg msg) {
        log.info("HelloClientMsg");
        jobManager.tell(msg, self());
    }


    private final void onStartMsg(LaunchMsg msg) {
        log.info("StartMsg");
        jobManager.tell(msg, self());
    }

    private final void onTerminateMsg(TerminateMsg msg) {
        log.info("TerminateMsg");
        jobManager.tell(msg, self());
    }


    private final void onUpdateGraphMsg(Serializable msg) {
        log.info(msg.toString());
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
