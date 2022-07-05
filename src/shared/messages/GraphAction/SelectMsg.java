package shared.messages.GraphAction;


import shared.model.enumerators.ConjugationType;
import shared.model.enumerators.GraphOps;
import shared.model.enumerators.Modifier;
import shared.model.enumerators.Operator;

import java.io.Serializable;

public class SelectMsg extends GraphActions implements Serializable {

    private Modifier modType;
    private   String varName;
    private Operator operator;
    private   String oprandName;
    private ConjugationType conjType;
    private GraphOps type;
    private GraphOps lastOp;

    public SelectMsg(Modifier modType, String varName, Operator operator, String oprandName, ConjugationType conjType) {
        this.modType = modType;
        this.varName = varName;
        this.operator = operator;
        this.oprandName = oprandName;
        this.conjType = conjType;
        this.type= GraphOps.SELECT;
        this.lastOp=GraphOps.COMPUTE;
    }


    public GraphOps getLastOp() {
        return lastOp;
    }

    public GraphOps getType() {
        return type;
    }

    public Modifier getModType() {
        return modType;
    }

    public String getVarName() {
        return varName;
    }

    public Operator getOperator() {
        return operator;
    }

    public String getOprandName() {
        return oprandName;
    }

    public ConjugationType getConjType() {
        return conjType;
    }
}
