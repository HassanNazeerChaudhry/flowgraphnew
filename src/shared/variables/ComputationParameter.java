package shared.variables;

public class ComputationParameter {
    private String varName;
    private int value;

    public ComputationParameter(String varName, int value) {
        this.varName = varName;
        this.value = value;
    }

    public String getVarName() {
        return varName;
    }

    public int getValue() {
        return value;
    }

    public void setVarName(String varName) {
        this.varName = varName;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
