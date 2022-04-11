package shared.model.graphcollection;

import shared.model.enumerators.ConjugationType;
import shared.model.enumerators.Operator;

import java.io.Serializable;

public class SelectObject implements Serializable {

    public   String varName;
    public Operator opreator;
    public   String oprandName;
    public ConjugationType conjType;

    public SelectObject(String varName, Operator opreator, String oprandName, ConjugationType conjType) {
        this.varName = varName;
        this.opreator = opreator;
        this.oprandName = oprandName;
        this.conjType = conjType;
    }

}
