package shared.variables;

public class Variable extends Operands {

   private String varName;


    public Variable(String varName) {
        this.varName = varName;
    }

    public String getVarName() {
        return varName;
    }


    public void setVarName(String varName) {
        this.varName = varName;
    }
}
