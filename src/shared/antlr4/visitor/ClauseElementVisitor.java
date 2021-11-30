package shared.antlr4.visitor;

import shared.antlr4.pattern.PatternBaseVisitor;
import shared.antlr4.pattern.PatternParser;
import shared.model.ClauseElement;
import shared.model.clauseelement.GraphModification;
import shared.model.enumerators.Change;
import shared.model.enumerators.Modifier;
import shared.model.enumerators.Operator;
import shared.model.clauseelement.Evaluation;
import shared.model.clauseelement.Extraction;
import shared.model.clauseelement.GraphProcessing;

import java.util.ArrayList;
import java.util.List;

public class ClauseElementVisitor   extends PatternBaseVisitor<ClauseElement> {

    public ClauseElementVisitor() {


    }



    @Override
    public ClauseElement visitGraphProcessing(PatternParser.GraphProcessingContext ctx) {
        ProcElementVisitor procElementVisitor= new ProcElementVisitor();
        GraphProcessing graphProcessing= new GraphProcessing();
        graphProcessing.addProcElement(procElementVisitor.visit(ctx.getChild(0)));
        return graphProcessing;

    }


    @Override
    public ClauseElement visitExtraction(PatternParser.ExtractionContext ctx) {

        boolean isVertexExtraction=false;
        boolean isEdgeExtraction=false;
        List<String> labelCollection= new ArrayList<>();


        if (ctx.getChild(0).equals(".extractV(")) {
            isVertexExtraction= true;
            isEdgeExtraction   =false;
        } else if (ctx.getChild(0).equals(".extractE(")) {
            isVertexExtraction= false;
            isEdgeExtraction   =true;
        }

        labelCollection.add(ctx.getChild(1).getText());


        if(ctx.getChildCount()>3){

            for(int i=3; i<ctx.getChildCount();i+=2){
                labelCollection.add(ctx.getChild(i).getText());
            }

        }
        return new Extraction(isVertexExtraction,isEdgeExtraction,labelCollection);


    }



    @Override
    public ClauseElement visitOperationFunction(PatternParser.OperationFunctionContext ctx) {
        return super.visitOperationFunction(ctx);
    }


    @Override
    public ClauseElement visitEvaluation(PatternParser.EvaluationContext ctx) {
        Evaluation evaluation= new Evaluation();
        Operator opr=Operator.ERROR;
        int value=Integer.parseInt(ctx.getChild(3).getText());
        evaluation.addEvaluation(opr.convertStr2Operator(ctx.getChild(1).getText()),value, ctx.getChild(5).getText() );
        return evaluation;
    }




    @Override
    public ClauseElement visitGraphModificationEvent(PatternParser.GraphModificationEventContext ctx) {
        Modifier mdf=Modifier.ERROR;
        Change chg= Change.ERROR;
        return new GraphModification(mdf.convertStr2Modifier(ctx.getChild(0).getText()), chg.convertStr2Change(ctx.getChild(1).getText()));
    }
}
