package taskmanager;

import akka.actor.*;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import shared.Utils;
import shared.messages.TaskManagerInitMsg;
import shared.messages.TaskManagerAnnounceMsg;
import shared.messages.graphchanges.*;
import shared.messages.vertexcentric.ComputationMsg;
import shared.messages.vertexcentric.FailedComputationMsg;
import shared.messages.vertexcentric.InstallComputationMsg;
import shared.messages.vertexcentric.StartComputationMsg;
import shared.vertexcentric.InOutboxImpl;
import shared.vertexcentric.MsgSenderPair;
import shared.vertexcentric.VertexCentricComputation;

import java.util.*;

public class TaskManagerActor  extends AbstractActor {
    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);


    private final String name;
    private final int numMyWorkers;
    private final String jobManagerAddr;

    // Data computed during initialization
    private ActorSelection jobManager;
    private final Map<Integer, ActorRef> workers = new HashMap<>();
    private VertexCentricComputation computation=null;


    // Information received from the job manager upon initialization
    private int numAllWorkers;
    private NavigableMap<Integer, ActorRef> taskManagers;


    // State for vertex centric computation
    int numWaitingFor = 0;
    private InOutboxImpl superstepBox;


    private TaskManagerActor(String name, int numMyWorkers, String jobManagerAddr) {
        this.name = name;
        this.numMyWorkers = numMyWorkers;
        this.jobManagerAddr = jobManagerAddr;
    }



    @Override
    public void preStart() throws Exception {
        super.preStart();
        jobManager = getContext().actorSelection(jobManagerAddr);
        jobManager.tell(new TaskManagerAnnounceMsg(name, numMyWorkers), self());
    }


    @Override
    public Receive createReceive() {
        return preInitState();
    }

    /**
     * States
     */

    private final Receive preInitState() {
        return receiveBuilder(). //
                match(TaskManagerInitMsg.class, this::onTaskManagerInitMsg). //
                build();
    }



    private final Receive receiveChangeState(){
        return receiveBuilder().
                match(ChangeVertexMsg.class, this::onChangeVertexMsg). //
                match(ChangeEdgeMsg.class, this::onChangeEdgeMsg). //
                match(InstallComputationMsg.class, this::onInstallComputationMsg). //
                match(StartComputationMsg.class, this::onStartComputationMsg). //
                match(ComputationMsg.class, this::onComputationMsg). //
                match(FailedComputationMsg.class, this::onFailedComputationMsg). //
                build();

    }




    public void onTaskManagerInitMsg(TaskManagerInitMsg initMsg){
        log.info(initMsg.toString());
        taskManagers = initMsg.getTaskManagers();
        numAllWorkers = initMsg.getNumWorkers();

        // Compute the identifier of my first worker
        int firstWorkerId = 0;
        for (final Map.Entry<Integer, ActorRef> entry : taskManagers.entrySet()) {
            if (entry.getValue().equals(self())) {
                firstWorkerId = entry.getKey();
                break;
            }
        }

        // Initialize my workers
        for (int i = 0; i < numMyWorkers; i++) {
            final int workerId = firstWorkerId + i;
            final ActorRef worker = getContext().actorOf(WorkerActor.props(workerId), name + "_worker_" + i);
            workers.put(workerId, worker);
        }

        getContext().become(receiveChangeState());
    }


    private final void onChangeVertexMsg(ChangeVertexMsg msg) {
        log.info(msg.toString());
        final int workerId = Utils.computeResponsibleWorkerFor(msg.getName(), numAllWorkers);
        workers.get(workerId).forward(msg, getContext());
    }

    private final void onChangeEdgeMsg(ChangeEdgeMsg msg) {
        log.info(msg.toString());
        final int workerId = Utils.computeResponsibleWorkerFor(msg.getSource(), numAllWorkers);
        workers.get(workerId).forward(msg, getContext());
    }



    private final void onInstallComputationMsg(InstallComputationMsg msg){
        log.info(msg.toString());
        computation=(VertexCentricComputation) msg.getComputationSupplier().get();
        this.workers.values().stream().forEach(workers -> workers.tell(msg, self()));


    }

    private final void onStartComputationMsg(StartComputationMsg msg) {
        log.info(msg.toString());
        workers.values().forEach(worker -> worker.tell(msg, self()));
        numWaitingFor = workers.size();
        superstepBox = new InOutboxImpl<>();


    }

    private final void onComputationMsg(ComputationMsg msg) {
        log.info(msg.toString());

            if (msg.isFromJobManager()) {
                    workers.values().forEach(worker -> worker.tell(msg, self()));
                    numWaitingFor = workers.size();
                    superstepBox = new InOutboxImpl<>();
            } else {
                numWaitingFor--;
                for (final String recipient : (Set<String>) msg.recipients()) {
                    for (final MsgSenderPair pair : (List<MsgSenderPair>) msg.messagesFor(recipient)) {
                        superstepBox.add(recipient, pair);
                    }
                }
                if (numWaitingFor == 0) {
                    jobManager.tell(new ComputationMsg<>(superstepBox, msg.getSuperstep(), false), self());
                }
            }

    }

    private final void onFailedComputationMsg(FailedComputationMsg msg) {
        log.info("Computation message in job manager");
        jobManager.tell(msg, self());

    }





    /**
     * Props for this actor
     */
    public static final Props props(String name, int numMyWorkers, String jobManagerAddr) {
        return Props.create(TaskManagerActor.class, name, numMyWorkers, jobManagerAddr);
    }

}