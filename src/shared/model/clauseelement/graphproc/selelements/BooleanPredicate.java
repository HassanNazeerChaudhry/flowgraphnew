package shared.model.clauseelement.graphproc.selelements;


import shared.model.enumerators.Operator;
import shared.variables.Operands;

public class BooleanPredicate extends SelectionFunctionAbstract {


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





}


