package shared.model.graphcollection;

import shared.model.enumerators.ConjugationType;
import shared.model.enumerators.Modifier;
import shared.model.enumerators.Operator;

import java.io.Serializable;

public class SelectObject extends GraphActions implements Serializable {
    public Modifier modType;
    public   String varName;
    public Operator operator;
    public   String oprandName;
    public ConjugationType conjType;

    public SelectObject(String varName, Operator opreator, String oprandName, ConjugationType conjType,Modifier modType) {
        this.varName = varName;
        this.operator = opreator;
        this.oprandName = oprandName;
        this.conjType = conjType;
        this.modType=modType;
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
