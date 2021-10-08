package master;

import akka.actor.AbstractActorWithStash;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.Pair;
import shared.AkkaMessages.*;
import shared.AkkaMessages.modifyGraph.*;
import shared.PropertyHandler;
import shared.Utils;
import shared.antlr4.GPatternParser;
import shared.computation.Computation;
import shared.patterns.Pattern;
import shared.patterns.Sequence;
import shared.patterns.Trigger;
import shared.sequence.*;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;


public class JobManagerActor extends AbstractActorWithStash implements PatternCallback {

	public static final Pair<String, String[]> DESTINATION_EDGE = new Pair<>("_DEST", new String[]{"true"});

	private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);

	public Boolean directedEdges = true;

	/**
	 * Ref to slave and associated number of threads
	 */
	private final Map<ActorRef, Integer> slaves = new HashMap<>();

	/**
	 * Map hash values to slaves
	 */
	private final HashMap<Integer, ActorRef> hashMapping = new HashMap<>();

	/**
	 * Clients Refs
	 */
	private final Set<ActorRef> clients = new HashSet<>();

	private final HashMap<String, Computation> computations = new HashMap<>();

	private final AtomicInteger waitingResponses = new AtomicInteger(0);

	private final ConcurrentHashMap<Integer, OngoingAggregate> aggregates = new ConcurrentHashMap<>();

	private long currentTimestamp;

	private State nextState = this::waitSlaves;

	private PatternLogic patternLogic;

	private final HashSet<String> validVariables = new HashSet<>();

	private ArrayList<SequenceHandler> sequenceHandlers = new ArrayList<>();


	//region: getter/setter



	public void addSequenceHandler(SequenceHandler sequenceHandler){
		this.sequenceHandlers.add(sequenceHandler);
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

	public HashMap<String, Computation> getComputations() {
		return computations;
	}

	public AtomicInteger getWaitingResponses() {
		return waitingResponses;
	}

	public ConcurrentHashMap<Integer, OngoingAggregate> getAggregates() {
		return aggregates;
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

	//endregion


	@Override
	public Receive createReceive() {

//		log.info("Creating JobMamager");
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



	/**
	 * States
	 */


	private final Receive waitSlaves() { //Startup phase
		return receiveBuilder().
			match(HelloClientMsg.class, this::onHelloClientMsg).
		    match(SlaveAnnounceMsg.class, this::onSlaveAnnounceMsg).
		    match(LaunchMsg.class, this::onLaunchMsg).
			match(AckMsg.class, this::onAckMsg).
			match(Serializable.class, x-> stash()).
		    build();
	}

	private final Receive waitAck() {
		return receiveBuilder().
				match(AckMsg.class, this::onAckMsg).
				match(AckMsgComputationTerminated.class, this::onAckMsg).
				match(AggregateMsg.class, this::onAggregateMsg).
				match(AckMsgResultsSequence.class, this::onAckMsg).
				match(Serializable.class, x-> stash()).
				build();
	}




	//here AddEdgeMsg, DeleteEdgeMsg, UpdateVertexMsg,UpdateEdgeMsg and DeleteVertexMsg can come from the
	// client as input stream events, which we can then analyze and decide wether to send to slaves or not
	private final Receive receiveChangeState() { //Compute a new graph change
		return receiveBuilder().
		    match(AddEdgeMsg.class, this::onAddEdgeMsg).
		    match(DeleteEdgeMsg.class, this::onDeleteEdgeMsg).
		    match(DeleteVertexMsg.class, this::onDeleteVertexMsg).
			match(UpdateVertexMsg.class, this::onUpdateVertexMsg).
			match(UpdateEdgeMsg.class, this::onUpdateEdgeMsg).
			match(InstallComputationMsg.class, this::onInstallComputationMsg).
			match(TerminateMsg.class, this::onTerminateMsg).
		    build();
	}


	/**
	 * Message processing
	 */

	private final void onHelloClientMsg(HelloClientMsg msg){
		this.clients.add(sender());

	}


	private final void  applySequence(Event.EventEnum type, HashMap<String, String> attributes, Long timestamp, String vertexName){
		Event newEvent = new Event(type,attributes,timestamp);
		if(this.sequenceHandlers.size()>0 ){
			SequenceHandler handler = applySequenceHere(newEvent,vertexName);
			if(handler!=null){
				ArrayList<ArrayList<Event>> result = handler.apply(newEvent);
				if(result.size()>0) onAckMsg(new AckMsgResultsSequence(result,true));
			}


		}
	}

	private HashMap<String, String> getEdgePayload(ArrayList<Pair<String, String[]>> attributes,String vertexName, String destId) {
		HashMap<String, String> result = new HashMap<>();
		for(Pair<String, String[]>pair:attributes)
			result.put(pair.first(),pair.second()[0]);
		result.put("destId",destId);
		result.put("vertexName",vertexName);
		return result;
	}
	private HashMap<String, String> getVertexPayload(ArrayList<Pair<String, String[]>> attributes, String vertexName) {
		HashMap<String, String> result = new HashMap<>();
		for(Pair<String, String[]>pair:attributes)
			result.put(pair.first(),pair.second()[0]);
		result.put("vertexName",vertexName);
		return result;
	}

	private SequenceHandler applySequenceHere(Event event,String vertexName) {
		for(SequenceHandler sequenceHandler: this.sequenceHandlers){
			if(sequenceHandler.belongsToSequenceHandler(event) ) {
				if (vertexName == null || sequenceHandler.detectElementHere(vertexName, "master"))
					return sequenceHandler;
			}
		}

		return null;
	}


	private final void onAddEdgeMsg(AddEdgeMsg msg){
		ActorRef slave = getActor(msg.getSourceName());
		slave.tell(new AddEdgeMsg(msg.getSourceName(), msg.getDestinationName(), msg.getAttributes(), msg.getTimestamp()), self());
//		if(applySequenceHere(msg.getSourceName())){
			applySequence(Event.EventEnum.EDGE_ADDITION,
					getEdgePayload(msg.getAttributes(),msg.getSourceName(),msg.getDestinationName()), msg.getTimestamp(),msg.getSourceName());
//		}
		waitingResponses.set(1);
		if (!directedEdges) {
			ArrayList<Pair<String, String[]>> destinationAttribute = msg.getAttributes();
			destinationAttribute.add(DESTINATION_EDGE);
			slave.tell(new AddEdgeMsg(msg.getDestinationName(), msg.getSourceName(), destinationAttribute, msg.getTimestamp()), self());
			waitingResponses.incrementAndGet();
		}
		startNewIteration(msg.getTimestamp(), Trigger.TriggerEnum.EDGE_ADDITION);
	}

	private final void onDeleteEdgeMsg(DeleteEdgeMsg msg){
		ActorRef slave = getActor(msg.getSourceName());
		slave.tell(new DeleteEdgeMsg(msg.getSourceName(), msg.getDestinationName(), msg.getTimestamp()), self());
//		if(applySequenceHere(msg.getSourceName())){
			HashMap<String,String> payload = new HashMap<>();
			payload.put("vertexName",msg.getSourceName());
			payload.put("destId",msg.getDestinationName());
			applySequence(Event.EventEnum.EDGE_DELETION,payload, msg.getTimestamp(),msg.getSourceName());
//		}
		waitingResponses.set(1);
		if (!directedEdges) {
			slave.tell(new DeleteEdgeMsg(msg.getDestinationName(), msg.getSourceName(), msg.getTimestamp()), self());
			waitingResponses.incrementAndGet();
		}
		startNewIteration(msg.getTimestamp(), Trigger.TriggerEnum.EDGE_DELETION);
	}

	private final void onDeleteVertexMsg(DeleteVertexMsg msg){
		ActorRef slave = getActor(msg.getVertexName());
		slave.tell(new DeleteVertexMsg(msg.getVertexName(),  msg.getTimestamp()), self());
//		if(applySequenceHere(msg.getVertexName())){
			HashMap<String,String> payload = new HashMap<>();
			payload.put("vertexName",msg.getVertexName());
			applySequence(Event.EventEnum.VERTEX_DELETION,payload, msg.getTimestamp(),msg.getVertexName());
//		}
		waitingResponses.set(1);
		startNewIteration(msg.getTimestamp(), Trigger.TriggerEnum.VERTEX_DELETION);
	}

	private final void onUpdateVertexMsg(UpdateVertexMsg msg){
		ActorRef slave = getActor(msg.getVertexName());
		slave.tell(new UpdateVertexMsg(msg.getVertexName(), msg.getAttributes(), msg.getTimestamp(), msg.isInsertion()), self());
//		if(applySequenceHere(msg.vertexName)){
			if(msg.isInsertion()) applySequence(Event.EventEnum.VERTEX_ADDITION,
					getVertexPayload(msg.getAttributes(),msg.getVertexName()),msg.getTimestamp(),msg.getVertexName());
			else applySequence(Event.EventEnum.VERTEX_UPDATE,
					getVertexPayload(msg.getAttributes(),msg.getVertexName()),msg.getTimestamp(),msg.getVertexName());


//		}
		waitingResponses.set(1);
		if (!msg.isInsertion()){
			startNewIteration(msg.getTimestamp(), Trigger.TriggerEnum.VERTEX_UPDATE);
		} else {
			startNewIteration(msg.getTimestamp(), Trigger.TriggerEnum.VERTEX_ADDITION);
		}
	}

	private final void onUpdateEdgeMsg(UpdateEdgeMsg msg){
		ActorRef slave = getActor(msg.sourceId);
		slave.tell(new UpdateEdgeMsg(msg.sourceId, msg.destId, msg.getAttributes(), msg.getTimestamp()), self());
//		if(applySequenceHere(msg.sourceId)){
			applySequence(Event.EventEnum.EDGE_UPDATE,
					getEdgePayload(msg.getAttributes(),msg.sourceId,msg.destId), msg.getTimestamp(),msg.sourceId);
//		}

		waitingResponses.set(1);
		if (!directedEdges) {
            ArrayList<Pair<String, String[]>> destinationAttribute = msg.getAttributes();
            destinationAttribute.add(DESTINATION_EDGE);
			slave.tell(new UpdateEdgeMsg(msg.destId, msg.sourceId, destinationAttribute, msg.getTimestamp()), self());
			waitingResponses.incrementAndGet();
		}
		startNewIteration(msg.getTimestamp(), Trigger.TriggerEnum.EDGE_UPDATE);
	}

	private final void onSlaveAnnounceMsg(SlaveAnnounceMsg msg) {
//		log.info(msg.toString());
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
//		log.info(msg.toString());

		//region: map hashmap
		// puts slaves into a hashmap so that we can keep track of them later on
		// hashMapping is the map that keeps track of them
		hashMapping.clear();
		int index = 0;
		for (Map.Entry<ActorRef, Integer> slave: slaves.entrySet()) {
			for (int i = 0; i < slave.getValue(); i++) {
				hashMapping.put(index, slave.getKey());
				index = index + 1;
			}
		}
		//endregion


		//Get Pattern and parse it
		patternLogic = new PatternLogic(this);
		Sequence s = null;
		try {
			ArrayList<Pattern> parsed = GPatternParser.parse(Files.readString(Paths.get(PropertyHandler.getProperty("patternPath")), StandardCharsets.US_ASCII), this);
			patternLogic.installPattern(parsed);
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Unable to read file PATTERNPATH");
		}

		sendToAllSlaves(new DistributeHashMapMsg(hashMapping));
		becomeAwaitAckFromAll();
//		this.sequenceHandler = patternLogic.sendSequence();
		patternLogic.startNewIteration(this.currentTimestamp, Trigger.TriggerEnum.ALL, validVariables);


		//Send mapping to slaves and wait corresponding number of acks



		nextState = this::receiveChangeState;
	}

	private final void onTerminateMsg (TerminateMsg msg) {
//		log.info(msg.toString());

		//Stop slaves
		for (ActorRef slave: slaves.keySet()) {
			getContext().getSystem().stop(slave);
		}
		//Stop clients
		for (ActorRef client: this.clients) {
			getContext().getSystem().stop(client);
		}
		getContext().getSystem().stop(self());
		PropertyHandler.exit();

	}


	private final void onAckMsg(AckMsgResultsSequence msg){
		if(msg.isFullPattern()){
			this.clients.forEach(client -> client.tell(new FireMsg(""+msg.getResults().get(0).size()), self()));
			PropertyHandler.writeOnPerformanceLog("EXITING_SEQUENCE_"+ System.currentTimeMillis());
		}
		else{
//			this.sequenceHandler.resetPatternElements();
			for(ArrayList<Event> result: msg.getResults()){
				for(int i=result.size()-1;i>=0;i--){
					applySequence(result.get(i).getType(),
							result.get(i).getPayload(),result.get(i).getTimestamp(),null);
				}
			}
		}

	}



	private final void onAckMsg(AckMsg msg){
//		log.info(msg.toString() + " from " + sender() + "| Waiting " + (waitingResponses.get()-1) + " responses");
		if(waitingResponses.decrementAndGet() == 0){
			this.patternLogic.runElement(null);
		}


	}

	public void applySequenceComputationResult(long timestamp) {
//		if(currentElement==null)
//			return;
		applySequence(Event.EventEnum.COMPUTATION_RESULT,new HashMap<>(),timestamp,null);

	}

	private final void onAckMsg(AckMsgComputationTerminated msg) {
//		log.info(msg.toString()+ " from " + sender());

		this.patternLogic.runElement(msg);

		if(waitingResponses.decrementAndGet() == 0) {
			this.patternLogic.runElement(null);
		}

	}

	private final void onAggregateMsg(AggregateMsg msg){

		OngoingAggregate ongoing = this.aggregates.get(msg.aggregate.getTransactionId());
		ongoing.aggregates.add(msg.aggregate);
		ongoing.collectedActors.add(sender());

		//If finished -> remove aggregate and fire event
		if (ongoing.performOperatorIfCollectedAll(this.validVariables)){

			String event = ongoing.getEvaluation();
			if ( event != null ){
				this.clients.forEach(client -> client.tell(new FireMsg(event), self()));
			}

			this.aggregates.remove(msg.aggregate.getTransactionId());

		}

	}

	private final void onInstallComputationMsg(InstallComputationMsg msg) {
//		log.info(msg.toString());
		computations.put(msg.getIdentifier(), msg.getComputation());
		for (final ActorRef slave : slaves.keySet()) {
			slave.tell(msg, self());
		}
		nextState = this::receiveChangeState;
		waitingResponses.set(slaves.size());
		getContext().become(waitAck());
	}


	//region: PatternCallback

	@Override
	public <Msg extends Serializable> void sendToAllSlaves(Msg message) {
		this.slaves.keySet().stream().forEach(slave -> slave.tell(message, self()));
//		log.info(message + " sent to all slaves");
	}

	@Override
	public <Msg extends Serializable> void sendToSlave(Msg message, String name) {
		ActorRef slave = getActor(name);
		if(slave!=null) slave.tell(message, self());
	}

	public long getCurrentTimestamp() {
		return currentTimestamp;
	}

	@Override
	public void becomeReceiveChangeState() {

		getContext().become(receiveChangeState());
		unstashAll();
	}

	@Override
	public void becomeAwaitAckFromAll() {
		this.waitingResponses.addAndGet(this.slaves.size());
		getContext().become(waitAck());
	}

	@Override
	public void becomeAwaitAckFromOne() {
		this.waitingResponses.addAndGet(1);
		getContext().become(waitAck());
	}


	@Override
	public int getNumSlaves() {
		return this.slaves.size();
	}

	@Override
	public void putInOngoingAggregateList(int identifier, OngoingAggregate ongoingAggregate) {
		//todo:what is the identifier here?
		this.aggregates.put(identifier, ongoingAggregate);
	}

	@Override
	public LoggingAdapter getLogger() {
		return this.log;
	}

	//endregion



	/**
	 * Props for this actor
	 */
	public static final Props props() {
		return Props.create(JobManagerActor.class);
	}

	/*
		Utils functions
	 */
	public ActorRef getActor(String name) {
		return hashMapping.get(Utils.getPartition(name, hashMapping.size()));
	}

	private void startNewIteration(Long timestamp, Trigger.TriggerEnum trigger) {
		if (this.currentTimestamp > timestamp) {
			throw new RuntimeException("Decreasing timestamps: old = " + this.currentTimestamp + ", new = " + timestamp);
		}
		this.currentTimestamp = timestamp;
		this.validVariables.clear();
		patternLogic.startNewIteration(currentTimestamp, trigger, this.validVariables);
	}
	@FunctionalInterface
	public interface State{
		Receive invoke();
	}
}
