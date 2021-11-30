package shared.model.clauseelement.graphproc.selelements;

import java.util.List;

public class LogicalExpression extends SelectionFunctionAbstract {
    private List<SelectionFunctionAbstract> selVar;

    public LogicalExpression() {
    }


    public void addLogicalExpression(List<SelectionFunctionAbstract> selVar){
       this.selVar=selVar;
    }
}



