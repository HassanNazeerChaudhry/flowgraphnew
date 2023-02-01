package client;

import akka.actor.AbstractActor;
import akka.actor.ActorSelection;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import shared.messages.GraphAction.InstallPatternMsg;
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
                match(InstallPatternMsg.class, this::onInstallPatternMsg).
                build();
    }



    public void OnClientStartMessage(StartMsg msg){
        log.info("" +
                "StartClientMsg at client");
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


    public void onInstallPatternMsg(InstallPatternMsg msg){
        log.info("Graph actions Msg at client");
        jobManager.tell(msg, self());
    }




    static final Props props(String jobManagerAddr) {
        return Props.create(ClientActor.class, jobManagerAddr);
    }

}



