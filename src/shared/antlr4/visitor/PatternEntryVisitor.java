package shared.antlr4.visitor;

import shared.antlr4.pattern.PatternBaseVisitor;
import shared.antlr4.pattern.PatternParser;
import shared.model.Pattern;


public class PatternEntryVisitor  extends PatternBaseVisitor<Pattern> {

    @Override
    public Pattern visitPatternEntry(PatternParser.PatternEntryContext ctx) {

        Pattern pattern= new Pattern();
        PatternElementVisitor patternElementVisitor=new PatternElementVisitor();


        for(int i=0; i<ctx.getChildCount(); i++){
            if(i==0){
                pattern.addExpression(patternElementVisitor.visit(ctx.getChild(i)));
            }else{
                //EOF , do nothing
            }

        }

        return pattern;

    }
}

