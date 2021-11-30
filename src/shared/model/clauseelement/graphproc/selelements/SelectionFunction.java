package shared.model.clauseelement.graphproc.selelements;

public class SelectionFunction extends SelectionFunctionAbstract {
    private  SelectionFunctionAbstract logicalExpression;
    private SelectionFunctionAbstract edgeSelection;

    public SelectionFunction(LogicalExpression logicalExpression, EdgeSelection edgeSelection) {
        this.logicalExpression = logicalExpression;
        this.edgeSelection = edgeSelection;
    }


    public SelectionFunction() {
    }

    public void addNewSelection(SelectionFunctionAbstract logicalExpression, SelectionFunctionAbstract edgeSelection){
         this.logicalExpression=logicalExpression;
         this.edgeSelection=edgeSelection;
    }

}
