package shared.antlr4.visitor;

import shared.antlr4.pattern.PatternBaseVisitor;
import shared.antlr4.pattern.PatternParser;
import shared.model.Pattern;
import shared.model.PatternElement;

import java.util.ArrayList;
import java.util.List;


public class PatternEntryVisitor  extends PatternBaseVisitor<Pattern> {

    @Override
    public Pattern visitPatternEntry(PatternParser.PatternEntryContext ctx) {

        Pattern pattern= new Pattern();
        PatternElementVisitor patternElementVisitor=new PatternElementVisitor();


        for(int i=0; i<ctx.getChildCount()+1; i++){
            if(i==ctx.getChildCount()-1){
                //EOF , do nothing
            }else{
              pattern.addExpression(patternElementVisitor.visit(ctx.getChild(i)));
            }

        }

        return pattern;

    }
}

