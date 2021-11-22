package shared.model.clauseelement.graphproc.selelements;


import shared.variables.Operands;

public class BooleanPredicate {


    public enum Operator {

        EQUAL("=="),
        GREATER(">"),
        LESS("<"),
        GREATEREQUAL(">="),
        LESSEQUAL("<=");

        public final String opString;

        Operator(String opString) {
            this.opString = opString;
        }
    }

    private Operands op1;
    private Operands op2;
    private Operator opr;

    public BooleanPredicate(Operands op1, Operands op2, Operator opr) {
        this.op1 = op1;
        this.op2 = op2;
        this.opr = opr;
    }



}


