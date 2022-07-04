package shared.messages.GraphAction;


import shared.model.enumerators.ConjugationType;
import shared.model.enumerators.Modifier;
import shared.model.enumerators.Operator;

import java.io.Serializable;

public class SelectMsg extends GraphActions implements Serializable {

    private Modifier modType;
    private   String varName;
    private Operator operator;
    private   String oprandName;
    private ConjugationType conjType;
    private String type;

    public SelectMsg(Modifier modType, String varName, Operator operator, String oprandName, ConjugationType conjType) {
        this.modType = modType;
        this.varName = varName;
        this.operator = operator;
        this.oprandName = oprandName;
        this.conjType = conjType;
        this.type="select";
    }

    public String getType() {
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
