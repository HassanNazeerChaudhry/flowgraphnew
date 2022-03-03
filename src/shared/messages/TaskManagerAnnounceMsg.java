package shared.messages;

import java.io.Serializable;

public class TaskManagerAnnounceMsg implements Serializable {

    private final String name;
    private final int numWorkers;

    public TaskManagerAnnounceMsg(String name, int numWorkers) {
        super();
        this.name = name;
        this.numWorkers = numWorkers;
    }

    public String getName() {
        return name;
    }

    public int getNumWorkers() {
        return numWorkers;
    }

    @Override
    public String toString() {
        return "TaskManagerAnnounceMsg(name=" + name + ", numWorkers=" + numWorkers + ")";
    }

}

