package shared.messages.GraphAction;

import shared.model.enumerators.GraphOps;
import shared.model.enumerators.Operator;

import java.io.Serializable;

public class EvaluateMsg extends GraphActions implements Serializable {
    private Operator operatorName;
    private Integer operand;
    private GraphOps type;
    private GraphOps lastOp;

    public EvaluateMsg(Operator operatorName, Integer operand) {
        this.operatorName = operatorName;
        this.operand = operand;
        this.type= GraphOps.EVALUATE;
        this.lastOp=GraphOps.STREAMOP;
    }

    public GraphOps getLastOp() {
        return lastOp;
    }

    public GraphOps getType() {
        return type;
    }

    public Operator getOperatorName() {
        return operatorName;
    }

    public Integer getOperand() {
        return operand;
    }
}
