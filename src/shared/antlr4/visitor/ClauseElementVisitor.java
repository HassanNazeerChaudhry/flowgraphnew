package shared.antlr4.visitor;

import shared.antlr4.pattern.PatternBaseVisitor;
import shared.antlr4.pattern.PatternParser;
import shared.model.ClauseElement;
import shared.model.Pattern;
import shared.model.clauseelement.Extraction;
import shared.model.clauseelement.GraphProcessing;
import shared.model.clauseelement.graphproc.Computation;
import shared.model.clauseelement.graphproc.ProcElement;
import shared.model.clauseelement.graphproc.selelements.SelectionFunction;

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
        ExtractionVisitor extractionVisitor = new ExtractionVisitor();
        Extraction extraction = new Extraction();

        if (ctx.getChild(0).equals(".extractV(")) {

            extraction.addExtraction(true, false);
        } else if (ctx.getChild(0).equals(".extractE(")) {
            extraction.addExtraction(false, true);

        }


        extraction.addExtractionLabel(ctx.getChild(1).getText());
        if(ctx.getChildCount()>3){

            for(int i=3; i<ctx.getChildCount();i+=2){

                extraction.addExtractionLabel(ctx.getChild(i).getText());
            }

        }

     return extraction;

    }






    @Override
    public ClauseElement visitOperationFunction(PatternParser.OperationFunctionContext ctx) {
        return super.visitOperationFunction(ctx);
    }


    @Override
    public ClauseElement visitEvaluation(PatternParser.EvaluationContext ctx) {
        return super.visitEvaluation(ctx);
    }



    @Override
    public ClauseElement visitGraphModificationEvent(PatternParser.GraphModificationEventContext ctx) {
        return super.visitGraphModificationEvent(ctx);
    }
}
