package shared.messages;

import akka.actor.ActorRef;

import java.io.Serializable;
import java.util.HashMap;
import java.util.NavigableMap;
import java.util.TreeMap;

public class TaskManagerInitMsg implements Serializable {

    private static final long serialVersionUID = 200007L;

    private final NavigableMap<Integer, ActorRef> taskManagers = new TreeMap<>();
    private final int numWorkers;

    public TaskManagerInitMsg(NavigableMap<Integer, ActorRef> taskManagers, int numWorkers) {
        this.taskManagers.putAll(taskManagers);
        this.numWorkers = numWorkers;
    }

    public final NavigableMap<Integer, ActorRef> getTaskManagers() {
        return taskManagers;
    }

    public final int getNumWorkers() {
        return numWorkers;
    }

    @Override
    public String toString() {
        return "TaskManagerInitMsg(numWorkers=" + numWorkers + ")";
    }
}
