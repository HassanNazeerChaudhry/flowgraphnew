package master;

import akka.actor.AbstractActorWithStash;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import shared.PropertyHandler;
import shared.messages.AckMsg;
import shared.messages.HelloClientMsg;
import shared.messages.LaunchMsg;
import shared.messages.SlaveAnnounceMsg;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class JobManagerActor extends AbstractActorWithStash {
    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);
    public Boolean directedEdges = true;

    /** Ref to slave and associated number of threads  */
    private final Map<ActorRef, Integer> slaves = new HashMap<>();


    private final Set<ActorRef> clients = new HashSet<>();



    @Override
    public Receive createReceive() {
        log.info("Creating JobManager");
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
        this.clients.add(sender());
    }


    private final void onSlaveAnnounceMsg(SlaveAnnounceMsg msg) {
        log.info(msg.toString());

        slaves.put(getSender(), msg.numThreads);
        try {
            int maxSize = Integer.parseInt(PropertyHandler.getProperty("numberOfSlaves")) * Integer.parseInt(PropertyHandler.getProperty("numOfWorkers"));
            if (slaves.size() == maxSize) {
                this.onLaunchMsg(new LaunchMsg());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

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
