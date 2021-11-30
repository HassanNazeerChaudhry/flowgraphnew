package shared.antlr4.visitor;

import shared.antlr4.pattern.PatternBaseVisitor;
import shared.antlr4.pattern.PatternParser;
import shared.model.PatternElement;
import shared.model.patternelements.FollowedBy;
import shared.model.patternelements.TemporalClause;

public class PatternElementVisitor extends PatternBaseVisitor<PatternElement> {

    public PatternElementVisitor() {
    }

   //graph proc include graph processing, extraction, operational function, evaluation
    @Override
    public PatternElement visitGraphProc(PatternParser.GraphProcContext ctx) {
       ClauseElementVisitor clauseElementVisitor= new ClauseElementVisitor();
        TemporalClause temporalClause=new TemporalClause();

       if(ctx.getChildCount()>1){
           temporalClause.addClauseElements(clauseElementVisitor.visit(ctx.getChild(0)));   // graphProcessing
           temporalClause.addClauseElements(clauseElementVisitor.visit(ctx.getChild(1))); // extraction

        //operational function
        for(int i=2; i<ctx.getChildCount()-1; i++ ){
            temporalClause.addClauseElements(clauseElementVisitor.visit(ctx.getChild(i)));
        }


           temporalClause.addClauseElements(clauseElementVisitor.visit(ctx.getChild(ctx.getChildCount()-1)));     //evaluation


       }else{ // graphModificationEvent

         //do nothing, would be handled by another visitor
       }

     return temporalClause;
    }


    //graph proc include graph processing, extraction, operational function, evaluation
    @Override
    public PatternElement visitGraphModf(PatternParser.GraphModfContext ctx) {
        ClauseElementVisitor clauseElementVisitor= new ClauseElementVisitor();
        TemporalClause temporalClause=new TemporalClause();

        temporalClause.addClauseElements(clauseElementVisitor.visit(ctx.getChild(0)));
        return temporalClause;
    }



    @Override
    public PatternElement visitFollowedBy(PatternParser.FollowedByContext ctx) {
        FollowedBy followedBy= new FollowedBy();
        TemporalVariableVisitor temporalVariableVisitor= new TemporalVariableVisitor();
        followedBy.settVar(temporalVariableVisitor.visit(ctx.getChild(1)));
        return followedBy;
    }
}




