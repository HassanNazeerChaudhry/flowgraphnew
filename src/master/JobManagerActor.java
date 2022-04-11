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
import shared.model.graphcollection.GraphActions;
import shared.vertexcentric.*;


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
    private Map<String, GraphActions> graphActions= new HashMap<>();
    private int receivedReplies = 0;
    private int expectedReplies = 0;

    private List<ResultReplyMsg> msgBuffer = new ArrayList<>();
    int msgCount = 0;




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
                match(SelectMsg.class, this::onSelectMsg).
                match(PartitionMsg.class, this::onPartitionMsg).
                build();

    }

    private final Receive iterativeComputationState() {
        return receiveBuilder(). //
                match(ComputationMsg.class, this::onComputationMsg). //
                match(FailedComputationMsg.class, this::onFailedComputationMsg). //
                match(ChangeGraphMsg.class, msg -> stash()). //
                build();
    }


    private final Receive waitingForReplyState() {
        return receiveBuilder(). //
                match(ResultReplyMsg.class, this::onResultReplyMsg). //
                match(ChangeGraphMsg.class, msg -> stash()). //
                build();
    }

    private final Receive graphActionState() {
        return receiveBuilder(). //
                match(GraphAction.class, this::onGraphActionMsg). //
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


   //TODO: find more better partitioning scheme, right now its just hashing
    private final void onChangeVertexMsg(ChangeVertexMsg msg) {
        log.info(msg.toString());
        //look for the responsbile worker and forward the change vertex messages to it

        switch( msg.getMsgType()) {
            case "Add": case "Update":
                int responsibleWorker = Utils.computeResponsibleWorkerFor(msg.getName(), numWorkers);
                final ActorRef taskManager = taskManagers.floorEntry(responsibleWorker).getValue();
                taskManager.forward(msg, getContext());
                break;
            case "Del":
                 taskManagers.values().forEach(tm -> tm.tell(msg, self()));
                break;


        }

        //variables related to graph computation and iterative computation
        expectedReplies = taskManagers.size();
        receivedReplies = 0;

        //start computation message to task manager
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


    private final void onSelectMsg(SelectMsg msg){
        log.info(msg.toString());

        graphActions.put("Selection",msg.getSelCollection());
        //this.taskManagers.values().stream().forEach(taskManagers -> taskManagers.tell(msg, self()));
    }

    private final void onPartitionMsg(PartitionMsg msg){
        log.info(msg.toString());
        graphActions.put("Partitioning",msg.getPartCollection());
        //this.taskManagers.values().stream().forEach(taskManagers -> taskManagers.tell(msg, self()));
    }



    private final void onFailedComputationMsg(FailedComputationMsg msg) {
        log.info("Failed message in job manager");
        getContext().become(receiveChangeState());
        unstashAll();

    }


    private final void onComputationMsg(ComputationMsg msg) {
        log.info("Computation message in job manager");

        getContext().become(graphActionState());
        taskManagers.values().stream().forEach(taskManagers -> taskManagers.tell(new GraphAction(), self()));

          /*  for (final String recipientName : (Set<String>) msg.recipients()) {
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

        // If all the replies §have been received, start a new superstep (if
        // necessary)
        if (receivedReplies == expectedReplies) {
            expectedReplies = superstepMsgs.size();
            // No more supersteps are necessary, send request for result

            if (expectedReplies == 0) {
                taskManagers. //
                        values(). //
                        stream(). //
                        forEach(tm -> tm.tell(new ResultRequestMsg(), self()));
                getContext().become(waitingForReplyState());
            }
            // Start a new superstep
            else {
                final Set<ActorRef> involvedTaskManagers = new HashSet<>();
                for (final int taskMangerId : superstepMsgs.keySet()) {
                    final ActorRef taskManager = taskManagers.get(taskMangerId);
                    involvedTaskManagers.add(taskManager);
                    final Inbox box = superstepMsgs.get(taskMangerId);
                    taskManager.tell(new ComputationMsg<>(box, msg.getSuperstep() + 1, true), self());
                }
                expectedReplies = involvedTaskManagers.size();
                receivedReplies = 0;
                superstepMsgs = new HashMap<>();
            }
        }
*/



    }


    private final void onResultReplyMsg(ResultReplyMsg msg) {
        log.info(msg.toString());
        //wait for multiple message before aggregation

        msgCount++;
        if (msgCount==taskManagers.size()) {
            Set<HashSet<HashSet<String>>> results = new HashSet<>();
            for (ResultReplyMsg msgb : msgBuffer) {
                HashSet<HashSet<String>> msgResult = (HashSet<HashSet<String>>) msgb.getResult();
                results.add(msgResult);
            }
            HashSet<HashSet<String>> finalResult = (HashSet<HashSet<String>>) computation.mergeResults(results);
            msgCount = 0;
            msgBuffer.clear();
            getContext().become(receiveChangeState());
            unstashAll();
        } else {
            msgBuffer.add(msg);
        }
    }


    private final void onGraphActionMsg(GraphAction msg){
        log.info(msg.toString());

        log.info(Integer.toString(graphActions.size()) );

        getContext().become(receiveChangeState());
        unstashAll();
    }



    /**
     * Props for this actor
     */
    public static final Props props() {
        return Props.create(JobManagerActor.class);
    }
}
