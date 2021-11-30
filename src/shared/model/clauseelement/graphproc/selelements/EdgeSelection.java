package shared.model.clauseelement.graphproc.selelements;

public class EdgeSelection extends SelectionFunctionAbstract {

   LogicalExpression logicalExpression;

    public EdgeSelection(LogicalExpression logicalExpression) {
        this.logicalExpression = logicalExpression;
    }


}
