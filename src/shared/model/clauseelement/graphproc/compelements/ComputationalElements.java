package shared.model.clauseelement.graphproc.compelements;

public class ComputationalElements {
    private FunctionName functionName;
    private ComputationalVariable computationalVariable;
    private ComputationParameter computationParameter;

    public ComputationalElements() {
    }

    public ComputationalElements(FunctionName functionName, ComputationalVariable computationalVariable, ComputationParameter computationParameter) {
        this.functionName = functionName;
        this.computationalVariable = computationalVariable;
        this.computationParameter = computationParameter;
    }


}
