package shared.model.clauseelement.graphproc.selelements;

import java.util.List;

public class LogicalExpression extends SelectionFunction{
    private List<BooleanAndFunction> selVar;

    public LogicalExpression(List<BooleanAndFunction> selVar) {
        this.selVar = selVar;
    }
}


