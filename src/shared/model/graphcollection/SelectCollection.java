package shared.model.graphcollection;

import shared.model.enumerators.ConjugationType;
import shared.model.enumerators.Operator;
import shared.variables.Operands;

import java.io.Serializable;
import java.util.HashSet;

public class SelectCollection  extends GraphActions{
    HashSet<SelectObject> selectCollection=new HashSet();

    public SelectCollection(HashSet<SelectObject> selectCollection) {
        this.selectCollection = selectCollection;
    }

    public HashSet<SelectObject> getSelectCollection() {
        return selectCollection;
    }
}
