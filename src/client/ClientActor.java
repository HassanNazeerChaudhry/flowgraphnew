package client;

import akka.actor.AbstractActor;
import akka.actor.ActorSelection;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import shared.messages.PartitionMsg;
import shared.messages.SelectMsg;
import shared.messages.vertexcentric.InstallComputationMsg;
import shared.messages.StartMsg;
import shared.messages.graphchanges.*;


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
    }


    @Override
    public Receive createReceive() {
        return receiveBuilder().
                match(StartMsg.class, this::OnClientStartMessage).
                match(ChangeEdgeMsg.class,this::onChangeEdgeMsg).
                match(ChangeVertexMsg.class, this::onChangeVertexMsg).
                match(SelectMsg.class, this::onSelectMsg).
                match(PartitionMsg.class, this::onPartitionMsg).
                match(InstallComputationMsg.class, this::onInstallComputationMsg).
                build();
    }



    public void OnClientStartMessage(StartMsg msg){
        log.info("StartClientMsg at client");
        jobManager.tell(msg, self());
    }

    public void onChangeEdgeMsg(ChangeEdgeMsg msg){
        log.info("ChangeEdgeMsg at client");
        jobManager.tell(msg, self());
    }


    public void onChangeVertexMsg(ChangeVertexMsg msg){
        log.info("ChangeVertexMsg at client");
        jobManager.tell(msg, self());
    }


    public void onSelectMsg(SelectMsg msg){
        log.info("Select Msg at client");
        jobManager.tell(msg, self());
    }


    public void onPartitionMsg(PartitionMsg msg){
        log.info("Partition Msg at client");
        jobManager.tell(msg, self());
    }


    public void onInstallComputationMsg(InstallComputationMsg msg){
        log.info("ChangeVertexMsg at client");
        jobManager.tell(msg, self());
    }



    static final Props props(String jobManagerAddr) {
        return Props.create(ClientActor.class, jobManagerAddr);
    }

}



