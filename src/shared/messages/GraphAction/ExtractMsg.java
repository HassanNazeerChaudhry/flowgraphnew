package shared.messages.GraphAction;


import shared.model.enumerators.GraphOps;
import shared.model.enumerators.Modifier;

import java.io.Serializable;

public class ExtractMsg extends GraphActions implements Serializable {
    private   String freeVar;
    private Modifier modType;
    private GraphOps type;
    private GraphOps lastOp;

    public ExtractMsg(String freeVar, Modifier modType) {
        this.freeVar = freeVar;
        this.modType = modType;
        this.type= GraphOps.EXTRACT;
        this.lastOp=GraphOps.PARTITION;
    }

    public GraphOps getLastOp() {
        return lastOp;
    }

    public GraphOps getType() {
        return type;
    }

    public String getFreeVar() {
        return freeVar;
    }

    public Modifier getModType() {
        return modType;
    }
}
