package shared.messages.GraphAction;

import shared.model.enumerators.Operator;

import java.io.Serializable;

public class EvaluateMsg extends GraphActions implements Serializable {
    private Operator operatorName;
    private Integer operand;
    private String type;

    public EvaluateMsg(Operator operatorName, Integer operand) {
        this.operatorName = operatorName;
        this.operand = operand;
        type="evaluate";
    }

    public String getType() {
        return type;
    }

    public Operator getOperatorName() {
        return operatorName;
    }

    public Integer getOperand() {
        return operand;
    }
}
