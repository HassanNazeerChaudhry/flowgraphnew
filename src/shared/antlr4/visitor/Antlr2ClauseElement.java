package shared.antlr4.visitor;


import shared.antlr4.pattern.PatternBaseVisitor;
import shared.antlr4.pattern.PatternParser;
import shared.model.ClauseElement;

public class Antlr2ClauseElement   extends PatternBaseVisitor<ClauseElement> {
    @Override
    public ClauseElement visitTemporalClause(PatternParser.TemporalClauseContext ctx) {
        return super.visitTemporalClause(ctx);
    }

    @Override
    public ClauseElement visitFollowedBy(PatternParser.FollowedByContext ctx) {
        return super.visitFollowedBy(ctx);
    }

    @Override
    public ClauseElement visitGraphProc(PatternParser.GraphProcContext ctx) {
        return super.visitGraphProc(ctx);
    }


    @Override
    public ClauseElement visitExtractByV(PatternParser.ExtractByVContext ctx) {
        return super.visitExtractByV(ctx);
    }

    @Override
    public ClauseElement visitExtractByE(PatternParser.ExtractByEContext ctx) {
        return super.visitExtractByE(ctx);
    }

    @Override
    public ClauseElement visitEvaluation(PatternParser.EvaluationContext ctx) {
        return super.visitEvaluation(ctx);
    }




}
