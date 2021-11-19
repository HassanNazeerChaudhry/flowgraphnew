package shared.antlr4.visitor;

import shared.antlr4.pattern.PatternBaseVisitor;
import shared.antlr4.pattern.PatternParser;
import shared.model.clauseelement.graphproc.ProcElement;

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
    public ProcElement visitPartByV(PatternParser.PartByVContext ctx) {
        return super.visitPartByV(ctx);
    }

    @Override
    public ProcElement visitPartByE(PatternParser.PartByEContext ctx) {
        return super.visitPartByE(ctx);
    }


}
