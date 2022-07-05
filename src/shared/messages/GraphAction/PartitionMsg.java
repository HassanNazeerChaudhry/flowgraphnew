package shared.messages.GraphAction;

import shared.model.enumerators.GraphOps;
import shared.model.enumerators.Modifier;

import java.io.Serializable;

public class PartitionMsg extends GraphActions implements Serializable {
    private   String groupBy;
    private Modifier modType;
    private GraphOps type;
    private GraphOps lastOp;


    public PartitionMsg(String groupBy, Modifier modType) {
        this.groupBy = groupBy;
        this.modType = modType;
        this.type= GraphOps.PARTITION;
        this.lastOp=GraphOps.SELECT;
    }

    public GraphOps getLastOp() {
        return lastOp;
    }

    public GraphOps getType() {
        return type;
    }

    public String getGroupBy() {
        return groupBy;
    }

    public Modifier getModType() {
        return modType;
    }
}
