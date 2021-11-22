package shared.variables;

public class TemporalVariables extends Operands{
    private boolean isWithin;
    private boolean isEvery;
    private Variable var;
    private float timeUnit;



    public TemporalVariables(Variable var) {
        this.var = var;
    }

    public TemporalVariables(boolean isWithin, Variable var, float timeUnit) {
        this.isWithin = isWithin;
        this.var = var;
        this.timeUnit = timeUnit;
    }


    public TemporalVariables(boolean isWithin, boolean isEvery, Variable var, float timeUnit) {
        this.isWithin = isWithin;
        this.isEvery = isEvery;
        this.var = var;
        this.timeUnit = timeUnit;
    }




}

