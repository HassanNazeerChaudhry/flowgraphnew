package shared.antlr4.visitor;

import shared.antlr4.pattern.PatternBaseVisitor;
import shared.antlr4.pattern.PatternParser;
import shared.model.clauseelement.GraphProc.ProcElement;

public class Antrl2ProcElement extends PatternBaseVisitor<ProcElement> {

    @Override
    public ProcElement visitComputation(PatternParser.ComputationContext ctx) {
        return super.visitComputation(ctx);
    }

    @Override
    public ProcElement visitSelection(PatternParser.SelectionContext ctx) {
        return super.visitSelection(ctx);
    }

    @Override
    public ProcElement visitPartition(PatternParser.PartitionContext ctx) {
        return super.visitPartition(ctx);
    }
}
