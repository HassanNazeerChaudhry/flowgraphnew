package shared.model.clauseelement.graphproc.selelements;

public class UnaryExpression extends SelectionFunctionAbstract {
    private boolean isNot;
    private SelectionFunctionAbstract exp;

    public UnaryExpression(boolean isNot, SelectionFunctionAbstract exp) {
        this.isNot = isNot;
        this.exp = exp;
    }

    public UnaryExpression() {
    }

    public void addExpression(boolean isNot, SelectionFunctionAbstract exp){
        this.isNot=isNot;
        this.exp=exp;
    }

    public void addExpression(SelectionFunctionAbstract exp){
        this.isNot=false;
        this.exp=exp;
    }

}


