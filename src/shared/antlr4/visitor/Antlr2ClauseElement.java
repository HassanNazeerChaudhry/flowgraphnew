package shared.antlr4.visitor;


import shared.antlr4.pattern.PatternBaseVisitor;
import shared.antlr4.pattern.PatternParser;
import shared.model.ClauseElement;

public class Antlr2ClauseElement   extends PatternBaseVisitor<ClauseElement> {

    @Override
    public ClauseElement visitGraphProcessing(PatternParser.GraphProcessingContext ctx) {
        return super.visitGraphProcessing(ctx);
    }

    @Override
    public ClauseElement visitEvaluation(PatternParser.EvaluationContext ctx) {
        return super.visitEvaluation(ctx);
    }

    @Override
    public ClauseElement visitExtraction(PatternParser.ExtractionContext ctx) {
        return super.visitExtraction(ctx);
    }
}
