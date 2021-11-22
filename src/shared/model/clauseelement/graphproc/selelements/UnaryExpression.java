package shared.model.clauseelement.graphproc.selelements;

public class UnaryExpression {
    private boolean isNot;
    private PrimaryExpression exp;

    public UnaryExpression(boolean isNot, PrimaryExpression exp) {
        this.isNot = isNot;
        this.exp = exp;
    }
}


