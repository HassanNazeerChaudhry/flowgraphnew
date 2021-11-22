package shared.model.clauseelement.graphproc.selelements;


import shared.variables.Operands;

public class BooleanPredicate extends  SelectionFunction {


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

    private String op1;
    private String op2;
    private String opr;

    public BooleanPredicate(String op1, String op2, String opr) {
        this.op1 = op1;
        this.op2 = op2;
        this.opr = opr;
    }






}


