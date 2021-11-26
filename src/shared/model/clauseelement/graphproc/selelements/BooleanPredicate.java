package shared.model.clauseelement.graphproc.selelements;


import shared.variables.Operands;

public class BooleanPredicate extends  SelectionFunction {


    public enum Operator {

        EQUAL("=="),
        GREATER(">"),
        LESS("<"),
        GREATEREQUAL(">="),
        LESSEQUAL("<="),
        ERROR("");

        public final String opString;

        Operator(String opString) {
            this.opString = opString;
        }
    }

    private Operands op1;
    private Operator opr;
    private Operands op2;

    public BooleanPredicate() {
    }

    public BooleanPredicate(Operands op1, Operator opr, Operands op2) {
        this.op1 = op1;
        this.opr = opr;
        this.op2 = op2;
    }

    public Operator convertStr2Operator(String oprStr){
        switch(oprStr){
            case  "==": return Operator.EQUAL;
            case ">": return Operator.GREATER;
            case "<": return Operator.LESS;
            case ">=": return Operator.GREATEREQUAL;
            case "<=": return Operator.LESSEQUAL;
            default: return Operator.ERROR;
        }
    }



}


