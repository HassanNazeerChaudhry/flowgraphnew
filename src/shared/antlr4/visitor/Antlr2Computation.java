package shared.antlr4.visitor;

import shared.antlr4.pattern.PatternBaseVisitor;
import shared.antlr4.pattern.PatternParser;
import shared.model.clauseelement.GraphProc.Computation;

public class Antlr2Computation extends PatternBaseVisitor<Computation> {
    @Override
    public Computation visitComputationFunction(PatternParser.ComputationFunctionContext ctx) {
        return super.visitComputationFunction(ctx);
    }

    @Override
    public Computation visitComputationReturnVariables(PatternParser.ComputationReturnVariablesContext ctx) {
        return super.visitComputationReturnVariables(ctx);
    }

    @Override
    public Computation visitComputationParameters(PatternParser.ComputationParametersContext ctx) {
        return super.visitComputationParameters(ctx);
    }
}
