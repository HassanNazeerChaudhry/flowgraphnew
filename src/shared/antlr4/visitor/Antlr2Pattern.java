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
    public Pattern visitGraphModificationEvent(PatternParser.GraphModificationEventContext ctx) {
        return super.visitGraphModificationEvent(ctx);
    }



}
