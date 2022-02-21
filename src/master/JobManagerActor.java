package master;

import akka.actor.AbstractActorWithStash;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.Pair;
import shared.PropertyHandler;
import shared.UtilLib;
import shared.messages.AckMsg;
import shared.messages.HelloClientMsg;
import shared.messages.LaunchMsg;
import shared.messages.SlaveAnnounceMsg;
import shared.messages.graphChanges.*;


import java.io.IOException;
import java.io.Serializable;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;


public class JobManagerActor extends AbstractActorWithStash {
    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);
    public Boolean directedEdges = true;
    public static final Pair<String, String[]> DESTINATION_EDGE = new Pair<>("_DEST", new String[]{"true"});

    /** Ref to slave and associated number of threads  */
    private final Map<ActorRef, Integer> slaves = new HashMap<>();

    /**
     * Map hash values to slaves
     */
    private final HashMap<Integer, ActorRef> hashMapping = new HashMap<>();

    /**
     * Clients Refs
     */
    private final Set<ActorRef> clients = new HashSet<>();

    private State nextState = this::waitSlaves;

    private long currentTimestamp;

    private final AtomicInteger waitingResponses = new AtomicInteger(0);


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

    private final Receive receiveChangeState() { //Compute a new graph change
        return receiveBuilder().
                match(AddEdgeMsg.class, this::onAddEdgeMsg).
                match(DeleteEdgeMsg.class, this::onDeleteEdgeMsg).
                match(DeleteVertexMsg.class, this::onDeleteVertexMsg).
                match(UpdateVertexMsg.class, this::onUpdateVertexMsg).
                match(UpdateEdgeMsg.class, this::onUpdateEdgeMsg).
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
        log.info(msg.toString());

        //region: map hashmap
        hashMapping.clear();
        int index = 0;
        for (Map.Entry<ActorRef, Integer> slave: slaves.entrySet()) {
            for (int i = 0; i < slave.getValue(); i++) {
                hashMapping.put(index, slave.getKey());
                index = index + 1;
            }
        }
        //endregion


        nextState = this::receiveChangeState;

    }


    private final void onAddEdgeMsg(AddEdgeMsg msg){
        ActorRef slave = getActor(msg.getSourceName());
        slave.tell(new AddEdgeMsg(msg.getSourceName(), msg.getDestinationName(), msg.getAttributes(), msg.getTimestamp()), self());
        waitingResponses.set(1);
        if (!directedEdges) {
            ArrayList<Pair<String, String[]>> destinationAttribute = msg.getAttributes();
            destinationAttribute.add(DESTINATION_EDGE);
            slave.tell(new AddEdgeMsg(msg.getDestinationName(), msg.getSourceName(), destinationAttribute, msg.getTimestamp()), self());
            waitingResponses.incrementAndGet();
        }

    }

    private final void onDeleteEdgeMsg(DeleteEdgeMsg msg){
        ActorRef slave = getActor(msg.getSourceName());
        slave.tell(new DeleteEdgeMsg(msg.getSourceName(), msg.getDestinationName(), msg.getTimestamp()), self());
        waitingResponses.set(1);
        if (!directedEdges) {
            slave.tell(new DeleteEdgeMsg(msg.getDestinationName(), msg.getSourceName(), msg.getTimestamp()), self());
            waitingResponses.incrementAndGet();
        }

    }

    private final void onDeleteVertexMsg(DeleteVertexMsg msg){
        ActorRef slave = getActor(msg.getVertexName());
        slave.tell(new DeleteVertexMsg(msg.getVertexName(),  msg.getTimestamp()), self());
        waitingResponses.set(1);

    }

    private final void onUpdateVertexMsg(UpdateVertexMsg msg){
        ActorRef slave = getActor(msg.getVertexName());
        slave.tell(new UpdateVertexMsg(msg.getVertexName(), msg.getAttributes(), msg.getTimestamp(), msg.isInsertion()), self());
        waitingResponses.set(1);

    }

    private final void onUpdateEdgeMsg(UpdateEdgeMsg msg){
        ActorRef slave = getActor(msg.sourceId);
        slave.tell(new UpdateEdgeMsg(msg.sourceId, msg.destId, msg.getAttributes(), msg.getTimestamp()), self());
        waitingResponses.set(1);
        if (!directedEdges) {
            ArrayList<Pair<String, String[]>> destinationAttribute = msg.getAttributes();
            destinationAttribute.add(DESTINATION_EDGE);
            slave.tell(new UpdateEdgeMsg(msg.destId, msg.sourceId, destinationAttribute, msg.getTimestamp()), self());
            waitingResponses.incrementAndGet();
        }

    }




    private final void onAckMsg(AckMsg msg){
        log.info(msg.toString());


    }

    @FunctionalInterface
    public interface State{
        Receive invoke();
    }


    public LoggingAdapter getLog() {
        return log;
    }

    public Map<ActorRef, Integer> getSlaves() {
        return slaves;
    }

    public HashMap<Integer, ActorRef> getHashMapping() {
        return hashMapping;
    }

    public State getNextState() {
        return nextState;
    }

    public void setNextState(State nextState) {
        this.nextState = nextState;
    }


    public void setCurrentTimestamp(long currentTimestamp) {
        this.currentTimestamp = currentTimestamp;
    }



    private ActorRef getActor(String name) {
        return hashMapping.get(UtilLib.getPartition(name, hashMapping.size()));
    }

    /**
     * Props for this actor
     */
    public static final Props props() {
        return Props.create(JobManagerActor.class);
    }


}
