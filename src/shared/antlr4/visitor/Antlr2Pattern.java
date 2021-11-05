package shared.antlr4.visitor;

import shared.antlr4.pattern.PatternBaseVisitor;
import shared.antlr4.pattern.PatternParser;

import java.util.regex.Pattern;

public class Antlr2Pattern  extends PatternBaseVisitor<Pattern> {

    @Override
    public Pattern visitPatternEntry(PatternParser.PatternEntryContext ctx) {
        return super.visitPatternEntry(ctx);
    }

    @Override
    public Pattern visitFollowedBy(PatternParser.FollowedByContext ctx) {
        return super.visitFollowedBy(ctx);
    }

    @Override
    public Pattern visitGraphProc(PatternParser.GraphProcContext ctx) {
        return super.visitGraphProc(ctx);
    }

    @Override
    public Pattern visitGraphModf(PatternParser.GraphModfContext ctx) {
        return super.visitGraphModf(ctx);
    }
}
