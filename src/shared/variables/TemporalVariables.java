package shared.variables;

public class TemporalVariables extends Operands{
    private boolean isWithin;
    private boolean isEvery;
    private Variable var;
    private float timeUnit;

    public TemporalVariables(boolean isWithin, boolean isEvery, String varName, float timeUnit) {
        this.isWithin = isWithin;
        this.isEvery = isEvery;
        this.var = new Variable(varName);
        this.timeUnit = timeUnit;
    }




}

