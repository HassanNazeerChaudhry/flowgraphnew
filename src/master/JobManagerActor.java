package master;

import akka.actor.AbstractActorWithStash;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import shared.Utils;
import shared.messages.*;
import shared.messages.graphchanges.*;
import shared.messages.vertexcentric.*;
import shared.vertexcentric.InOutboxImpl;
import shared.vertexcentric.MsgSenderPair;
import shared.vertexcentric.VertexCentricComputation;

import java.util.*;


public class JobManagerActor extends AbstractActorWithStash {

    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);

    //list of task managers and workers
    private final NavigableMap<Integer, ActorRef> taskManagers = new TreeMap<>();
    private int numWorkers = 0;

    //computation to be performed
    private VertexCentricComputation computation = null;

    //variables for iterative computation
    private Map<Integer, InOutboxImpl> superstepMsgs = new HashMap<>();
    private int receivedReplies = 0;
    private int expectedReplies = 0;


    @Override
    public Receive createReceive() {
        return waitSlaves();
    }


    private final Receive waitSlaves() { //Startup phase
        return receiveBuilder().
                match(StartMsg.class, this::onStartMessage).
                match(TaskManagerAnnounceMsg.class, this::onTaskManagerAnnounceMsg).
                build();
    }

    private final Receive receiveChangeState(){
        return receiveBuilder().
                match(ChangeEdgeMsg.class, this::onChangeEdgeMsg). //
                match(ChangeVertexMsg.class, this::onChangeVertexMsg). //
                match(InstallComputationMsg.class, this::onInstallComputationMsg). //
                build();

    }

    private final Receive iterativeComputationState() {
        return receiveBuilder(). //
                match(ComputationMsg.class, this::onComputationMsg). //
                match(FailedComputationMsg.class, this::onFailedComputationMsg). //
                match(ChangeGraphMsg.class, msg -> stash()). //
                build();
    }




    public void onStartMessage(StartMsg msg){
        log.info("StartClientMsg at jobmanager");
        for (final ActorRef taskManager : taskManagers.values()) {
            final TaskManagerInitMsg initMsg = new TaskManagerInitMsg(taskManagers, numWorkers);
            taskManager.tell(initMsg, self());
        }
        getContext().become(receiveChangeState());

    }


    public void onTaskManagerAnnounceMsg(TaskManagerAnnounceMsg msg){
        log.info("Slave Annoucement message at jobmanager");
        taskManagers.put(numWorkers, getSender());
        numWorkers += msg.getNumWorkers();

    }



    private final void onChangeVertexMsg(ChangeVertexMsg msg) {
        log.info(msg.toString());
        int responsibleWorker = Utils.computeResponsibleWorkerFor(msg.getName(), numWorkers);
        final ActorRef taskManager = taskManagers.floorEntry(responsibleWorker).getValue();
        taskManager.forward(msg, getContext());

        //variables related to graph computation and iterative computation
        expectedReplies = taskManagers.size();
        receivedReplies = 0;
        taskManagers.values().forEach(tm -> tm.tell(new StartComputationMsg(msg.timestamp()), self()));
       getContext().become(iterativeComputationState());
    }

    private final void onChangeEdgeMsg(ChangeEdgeMsg msg) {
        log.info(msg.toString());
        final int responsibleWorker = Utils.computeResponsibleWorkerFor(msg.getSource(), numWorkers);
        final ActorRef taskManager = taskManagers.floorEntry(responsibleWorker).getValue();
        taskManager.forward(msg, getContext());

        //variables related to graph computation and iterative computation
        expectedReplies = taskManagers.size();
        receivedReplies = 0;
        taskManagers.values().forEach(tm -> tm.tell(new StartComputationMsg(msg.timestamp()), self()));
        getContext().become(iterativeComputationState());

    }

    private final void onInstallComputationMsg(InstallComputationMsg msg){
        log.info(msg.toString());
        computation = (VertexCentricComputation) msg.getComputationSupplier().get();
        this.taskManagers.values().stream().forEach(taskManagers -> taskManagers.tell(msg, self()));
    }



    private final void onFailedComputationMsg(FailedComputationMsg msg) {
        log.info("Failed message in job manager");
        getContext().become(receiveChangeState());
        unstashAll();

    }


    private final void onComputationMsg(ComputationMsg msg) {
        log.info("Computation message in job manager");



            for (final String recipientName : (Set<String>) msg.recipients()) {
                for (final MsgSenderPair p : (List<MsgSenderPair>) msg.messagesFor(recipientName)) {
                    final int responsibleWorker = Utils.computeResponsibleWorkerFor(recipientName, numWorkers);
                    final int taskManager = taskManagers.floorEntry(responsibleWorker).getKey();
                    InOutboxImpl box = superstepMsgs.get(taskManager);
                    if (box == null) {
                        box = new InOutboxImpl<>();
                        superstepMsgs.put(taskManager, box);
                    }
                    box.add(recipientName, p);
                }
            }




        receivedReplies++;

        if (receivedReplies == expectedReplies) {
            getContext().become(receiveChangeState());
            unstashAll();
        }




    }

    /**
     * Props for this actor
     */
    public static final Props props() {
        return Props.create(JobManagerActor.class);
    }
}
