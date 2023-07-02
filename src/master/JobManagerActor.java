package master;

import akka.actor.AbstractActorWithStash;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import shared.Utils;
import shared.messages.*;
import shared.messages.GraphAction.*;
import shared.messages.graphchanges.*;
import shared.messages.vertexcentric.*;
import shared.optimizer.PatternOptimizer;
import shared.vertexcentric.*;


import java.util.*;


public class JobManagerActor extends AbstractActorWithStash {

    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);

    //list of task managers and workers
    private final NavigableMap<Integer, ActorRef> taskManagers = new TreeMap<>();
    private int numWorkers = 0;
    private int coldStartPeriod; // duration till which evaluate is not started
    private PatternOptimizer pOpt=new PatternOptimizer();
    //computation to be performed
    private VertexCentricComputation computation = null;

    //variables for iterative computation
    private Map<Integer, InOutboxImpl> superstepMsgs = new HashMap<>();
    private HashMap<String, GraphActions> graphActions = new HashMap<String, GraphActions>();
    private HashMap<String, GraphActions> graphActionsLight = new HashMap<String, GraphActions>();
    private String currentGraphActionKey;
    Iterator hmIterator;

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
                match(InstallPatternMsg.class, this::onInstallPatternMsg).
                build();
    }

    private final Receive receiveChangeState(){
        return receiveBuilder().
                match(ChangeEdgeMsg.class, this::onChangeEdgeMsg). //
                match(ChangeVertexMsg.class, this::onChangeVertexMsg).
                build();

    }

    private final Receive graphActionState() {
        return receiveBuilder(). //
                match(GraphActionsMsg.class, this::onGraphActionMsg). //
                match(ChangeGraphMsg.class, msg -> stash()). //
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



    public void onStartMessage(StartMsg msg){
        log.info("StartClientMsg at jobmanager");
        coldStartPeriod=1;

        for (final ActorRef taskManager : taskManagers.values()) {
            final TaskManagerInitMsg initMsg = new TaskManagerInitMsg(taskManagers, numWorkers);
            taskManager.tell(initMsg, self());
        }


    }

    public void onTaskManagerAnnounceMsg(TaskManagerAnnounceMsg msg){
        log.info("Slave Annoucement message at jobmanager");
        taskManagers.put(numWorkers, getSender());
        numWorkers += msg.getNumWorkers();

    }


    private final void onInstallPatternMsg(InstallPatternMsg msg){
        log.info(msg.toString());
        graphActions=msg.getGraphActions();

        //Code for the pattern optimizer
       pOpt.extractComputes(msg);


       //flag to check if it is shuffled or not

        //find which is lightest computation in the collection
        InstallComputationMsg computeMsg= new InstallComputationMsg();
        int currentComputationCoeff=0;

         String currentKey;

         //Finds which is the light computation in the given pattern
        for (Map.Entry<String, GraphActions> e : graphActions.entrySet()) {

            if (e.getKey().startsWith("compute")) {
                computeMsg=(InstallComputationMsg)e.getValue();
                if(computeMsg.getComputationCoeff()>currentComputationCoeff)
                    currentComputationCoeff=computeMsg.getComputationCoeff();
                    currentKey=e.getKey();
            }
        }


        //get entire clause for light computation
        for (Map.Entry<String, GraphActions> e : graphActions.entrySet()) {

            if (e.getKey().endsWith(String.valueOf(currentComputationCoeff))){
                graphActionsLight.put(e.getKey(),e.getValue());
            }
        }

        

       hmIterator = graphActionsLight.entrySet().iterator();






       /* FollowByMsg gAction= new FollowByMsg();

        Optional<String> firstKey = graphActions.keySet().stream().findFirst();
        if (firstKey.isPresent()) {
            currentGraphActionKey = firstKey.get();
        }



        //Iterate through all bundled messages and find the last followBy
       for (Map.Entry<String, GraphActions> e : graphActions.entrySet()) {
            if (e.getKey().startsWith("followedBy")) {
                 gAction=(FollowByMsg)e.getValue();
            }
        }

        //gets the time in the last followBy command and set the lazy evaluation window
        lazyWindow=gAction.getTime();*/


        getContext().become(receiveChangeState());

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

        //wait until the lazy window has expired
        if(coldStartPeriod==0){
            //start computation message to task manager
            //taskManagers.values().forEach(tm -> tm.tell(new StartComputationMsg(msg.timestamp()), self()));
            taskManagers.values().forEach(tm -> tm.tell(new GraphActionsMsg(), self()));
            getContext().become(graphActionState());
        }else{
            coldStartPeriod--;
        }

    }

    private final void onChangeEdgeMsg(ChangeEdgeMsg msg) {
        log.info(msg.toString());


        final int responsibleWorker = Utils.computeResponsibleWorkerFor(msg.getSource(), numWorkers);
        final ActorRef taskManager = taskManagers.floorEntry(responsibleWorker).getValue();
        taskManager.forward(msg, getContext());


        //variables related to graph computation and iterative computation
        expectedReplies = taskManagers.size();
        receivedReplies = 0;

        //wait until the lazy window has expired
        if(coldStartPeriod==0){
            //start computation message to task manager
           // taskManagers.values().forEach(tm -> tm.tell(new StartComputationMsg(msg.timestamp()), self()));
            taskManagers.values().forEach(tm -> tm.tell(new GraphActionsMsg(), self()));
            getContext().become(graphActionState());
        }else{
            coldStartPeriod--;
        }


    }

    private final void onGraphActionMsg(GraphActionsMsg msg){
        log.info(msg.toString());


        if (hmIterator.hasNext()) {

            Map.Entry mapElement
                    = (Map.Entry)hmIterator.next();
            GraphActions graphItem =(GraphActions) mapElement.getValue();
            String elementKey =(String)mapElement.getKey();
            taskManagers.values().forEach(tm -> tm.tell(graphItem, self()));

        }else{
            getContext().become(receiveChangeState());
            unstashAll();
        }



    }



    private final void onFailedComputationMsg(FailedComputationMsg msg) {
        log.info("Failed message in job manager");
        getContext().become(receiveChangeState());
        unstashAll();

    }


    private final void onComputationMsg(ComputationMsg msg) {
        log.info("Computation message in job manager");

        getContext().become(graphActionState());
        taskManagers.values().stream().forEach(taskManagers -> taskManagers.tell(new GraphActionsMsg(), self()));

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






    /**
     * Props for this actor
     */
    public static final Props props() {
        return Props.create(JobManagerActor.class);
    }
}
