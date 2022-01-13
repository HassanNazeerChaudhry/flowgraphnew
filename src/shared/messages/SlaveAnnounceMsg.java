package shared.messages;

import java.io.Serializable;

public class SlaveAnnounceMsg implements Serializable {
    public final String slaveName;
    public final int numThreads;


    public SlaveAnnounceMsg(String slaveName, int numThreads) {
        this.slaveName = slaveName;
        this.numThreads = numThreads;
    }

    @Override
    public String toString(){
        return "New Slave: " + slaveName +" with " + numThreads + " threads.";
    }
}
