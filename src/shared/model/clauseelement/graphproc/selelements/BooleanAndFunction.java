package shared.model.clauseelement.graphproc.selelements;

import java.util.List;

public class BooleanAndFunction extends  SelectionFunction{

    private List<UnaryExpression> selVar;


    public BooleanAndFunction() {

    }

    public BooleanAndFunction(List<UnaryExpression> selVar) {
        this.selVar = selVar;
    }
}


