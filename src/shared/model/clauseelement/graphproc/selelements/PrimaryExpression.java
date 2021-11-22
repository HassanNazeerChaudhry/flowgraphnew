package shared.model.clauseelement.graphproc.selelements;

public class PrimaryExpression {
      private LogicalExpression exp;
      private BooleanPredicate predicate;

    public PrimaryExpression(LogicalExpression exp, BooleanPredicate predicate) {
        this.exp = exp;
        this.predicate = predicate;
    }

    public LogicalExpression getExp() {
        return exp;
    }

    public BooleanPredicate getPredicate() {
        return predicate;
    }


    public void setExp(LogicalExpression exp) {
        this.exp = exp;
    }

    public void setPredicate(BooleanPredicate predicate) {
        this.predicate = predicate;
    }
}


