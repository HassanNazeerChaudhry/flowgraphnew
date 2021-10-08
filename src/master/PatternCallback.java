package master;

import akka.actor.ActorRef;
import akka.event.LoggingAdapter;
import shared.patterns.Pattern;
import shared.sequence.Event;
import shared.sequence.SequenceHandler;
import shared.sequence.SubPatternElement;

import java.io.Serializable;
import java.util.ArrayList;

public interface PatternCallback {


    <Msg extends Serializable> void sendToAllSlaves(Msg message);

    <Msg extends Serializable> void sendToSlave(Msg message, String name);

    long getCurrentTimestamp();

    void becomeReceiveChangeState ();

    void becomeAwaitAckFromAll();

    void becomeAwaitAckFromOne();

    int getNumSlaves();

    void putInOngoingAggregateList (int identifier, OngoingAggregate ongoingAggregate);

    ActorRef getSelf();

    LoggingAdapter getLogger ();

    void applySequenceComputationResult(long currentTimestamp);

    void addSequenceHandler(SequenceHandler sequenceHandler);

//    boolean belongsToSequenceHandler(Event event);

}
