package shared.model.clauseelement.graphproc.selelements;

import shared.model.enumerators.Operator;
import shared.variables.Operands;

public class PrimaryExpression extends SelectionFunctionAbstract {

      private Operands opr1;
       private Operands opr2;
      private Operator op;

    public PrimaryExpression(Operands opr1, Operands opr2, Operator op) {
        this.opr1 = opr1;
        this.opr2 = opr2;
        this.op = op;
    }


    public PrimaryExpression() {
    }


    public void addnewExpression(Operands opr1,  Operands opr2, Operator op){
      this.opr1=opr1;
      this.opr2=opr2;
      this.op=op;
    }


}


