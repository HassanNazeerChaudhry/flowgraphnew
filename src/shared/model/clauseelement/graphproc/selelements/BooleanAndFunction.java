package shared.model.clauseelement.graphproc.selelements;

import java.util.List;

public class BooleanAndFunction {

    private List<UnaryExpression> selVar;


    public BooleanAndFunction(List<UnaryExpression> selVar) {
        this.selVar = selVar;
    }
}


