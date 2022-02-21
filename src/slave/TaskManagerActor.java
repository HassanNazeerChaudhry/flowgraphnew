package slave;

import akka.actor.AbstractActorWithStash;
import akka.actor.ActorRef;
import akka.actor.ActorSelection;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.Pair;
import shared.PropertyHandler;
import shared.graph.VertexM;
import shared.messages.AckMsg;
import shared.messages.DistributeHashMapMsg;
import shared.messages.SlaveAnnounceMsg;
import shared.messages.graphChanges.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class TaskManagerActor extends AbstractActorWithStash {

    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);
    private ActorSelection master;
    private final String name;
    private final String masterAddress;

    private Map<Integer, ActorRef> slaves;
    private HashMap<String, VertexM> vertices;
    private final AtomicInteger waitingResponses = new AtomicInteger(0);



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
        return preInitState();
    }


    private final Receive preInitState() {
        return receiveBuilder(). //
                match(DistributeHashMapMsg.class, this::onDistributeHashMapMsg). //
                build();
    }

    private final Receive initializedState() {
        return receiveBuilder().
                match(AddEdgeMsg.class, this::onAddEdgeMsg). //
                match(DeleteEdgeMsg.class, this::onDeleteEdgeMsg). //
                match(DeleteVertexMsg.class, this::onDeleteVertexMsg). //
                match(UpdateVertexMsg.class, this::onUpdateVertexMsg). //
                match(UpdateEdgeMsg.class, this::onUpdateEdgeMsg). //
                build();
    }




    /**
     * Message processing
     */

    private final void onDistributeHashMapMsg(DistributeHashMapMsg initMsg) {
        log.info(initMsg.toString());
        slaves = initMsg.getHashMapping();

        //region: Initialize Graph
        vertices = new HashMap<>();

        master.tell(new AckMsg(), self());
        getContext().become(initializedState());
    }



    private void updateVertexOperations(UpdateVertexMsg msg) {
        VertexM vertex = vertices.get(msg.getVertexName());
        if (vertex == null){ //Create a new vertex
            vertex = new VertexM(msg.vertexName, new VertexM.State());
        }
        for (Pair<String, String[]> attribute : msg.getAttributes()) {
            vertex.setLabelVartex(attribute.first(), attribute.second());
        }
        vertices.putIfAbsent(vertex.getNodeId(), vertex);
    }




    private void updateEdgeOperations(UpdateEdgeMsg msg) {
        VertexM vertex = vertices.get(msg.sourceId);
        if (vertex == null){
            vertex = new VertexM(msg.sourceId, new VertexM.State());
        }

        VertexM.State edgeState = vertex.getEdgeState(msg.destId);
        if (edgeState == null) {
            vertex.addEdge(msg.destId);
        }
        for (Pair<String, String[]> attribute : msg.getAttributes()) {
            edgeState.put(attribute.first(), attribute.second());
        }
    }




    private final void onAddEdgeMsg(AddEdgeMsg msg) {
        log.info(msg.toString());
        VertexM vertex = vertices.get(msg.getSourceName());
        vertex.addEdge(msg.getDestinationName());
        for (Pair<String, String[]> attribute : msg.getAttributes()) {
            vertex.setLabelEdge(msg.getDestinationName(), attribute.first(), attribute.second());
        }

        master.tell(new AckMsg(), self());

    }



    private final void onDeleteEdgeMsg(DeleteEdgeMsg msg) {
        log.info(msg.toString());
        VertexM vertex = vertices.get(msg.getSourceName());
        vertex.deleteEdge(msg.getDestinationName());

        master.tell(new AckMsg(), self());

    }



    private final void onDeleteVertexMsg(DeleteVertexMsg msg) {
        log.info(msg.toString());
        vertices.remove(msg.getVertexName());

        master.tell(new AckMsg(), self());

    }



    private final void onUpdateVertexMsg(UpdateVertexMsg msg) {
        log.info(msg.toString());
        updateVertexOperations(msg);
        master.tell(new AckMsg(), self());

    }



    private final void onUpdateEdgeMsg(UpdateEdgeMsg msg) {
        log.info(msg.toString());
        updateEdgeOperations(msg);
        master.tell(new AckMsg(), self());

    }



    /**
     * Other slave has received my Outgoing messages
     */
    private final void onAckMsg(AckMsg msg){
        log.info(msg.toString() + " from " + sender().path() + ", I am " + self().path());

        if (this.waitingResponses.decrementAndGet() <= 0) {
            getContext().become(initializedState());
            unstashAll();
            master.tell(new AckMsg(), self());

            if (this.waitingResponses.get() < 0)
                log.error("Warning: waiting responses = " + this.waitingResponses.get());

        }

        log.info("Waiting " + this.waitingResponses + " responses");
    }


    /**
     * Props for this actor
     */
    public static final Props props(String name, String jobManagerAddr) {
        return Props.create(TaskManagerActor.class, name, jobManagerAddr);
    }


}
