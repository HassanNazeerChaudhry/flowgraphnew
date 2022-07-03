package shared.model.graphcollection;

import shared.model.enumerators.Operator;

import java.io.Serializable;

public class EvaluateObject extends GraphActions implements Serializable {

    public Operator operatorName;
    public Integer operand;

    public EvaluateObject(Operator operatorName, Integer operand) {
        this.operatorName = operatorName;
        this.operand = operand;
    }

    public Operator getOperatorName() {
        return operatorName;
    }

    public Integer getOperand() {
        return operand;
    }

}



