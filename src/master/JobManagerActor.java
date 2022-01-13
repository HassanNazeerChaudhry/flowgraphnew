package master;

import akka.actor.AbstractActorWithStash;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import shared.PropertyHandler;
import shared.messages.*;
import java.io.IOException;
import java.io.Serializable;

public class JobManagerActor extends AbstractActorWithStash {
    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);
    public Boolean directedEdges = true;


    @Override
    public Receive createReceive() {
        log.info("Creating JobMamager");
        try {
            directedEdges = PropertyHandler.getProperty("directedEdges").equals("true");

            if (!Boolean.parseBoolean(PropertyHandler.getProperty("debugLog"))) {
                getContext().getSystem().eventStream().setLogLevel(Logging.ErrorLevel());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return waitSlaves();
    }


    private final Receive waitSlaves() { //Startup phase
        return receiveBuilder().
                match(HelloClientMsg.class, this::onHelloClientMsg).
                match(SlaveAnnounceMsg.class, this::onSlaveAnnounceMsg).
                match(LaunchMsg.class, this::onLaunchMsg).
                match(AckMsg.class, this::onAckMsg).
                match(Serializable.class, x-> stash()).
                build();
    }




    private final void onHelloClientMsg(HelloClientMsg msg){
        log.info(msg.toString());


    }

    private final void onSlaveAnnounceMsg(SlaveAnnounceMsg msg) {
        log.info(msg.toString());


    }

    private final void onLaunchMsg(LaunchMsg msg) {
        log.info(msg.toString());


    }


    private final void onAckMsg(AckMsg msg){
        log.info(msg.toString());


    }




    /**
     * Props for this actor
     */
    public static final Props props() {
        return Props.create(JobManagerActor.class);
    }





}
