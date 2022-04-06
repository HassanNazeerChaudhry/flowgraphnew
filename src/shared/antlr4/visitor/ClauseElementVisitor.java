package shared.antlr4.visitor;

import shared.antlr4.pattern.PatternBaseVisitor;
import shared.antlr4.pattern.PatternParser;
import shared.model.ClauseElement;
import shared.model.clauseelement.*;
import shared.model.enumerators.Change;
import shared.model.enumerators.Modifier;
import shared.model.enumerators.Operator;
import shared.variables.Operands;
import shared.variables.Value;

import java.util.ArrayList;
import java.util.List;

public class ClauseElementVisitor   extends PatternBaseVisitor<ClauseElement> {

    public ClauseElementVisitor() {


    }

    @Override
    public ClauseElement visitGraphProcessing(PatternParser.GraphProcessingContext ctx) {
        ProcElementVisitor procElementVisitor= new ProcElementVisitor();
        GraphProcessing graphProcessing= new GraphProcessing();
        graphProcessing.addProcElement(procElementVisitor.visit(ctx.getChild(1)));
        return graphProcessing;

    }





    @Override
    public ClauseElement visitExtraction(PatternParser.ExtractionContext ctx) {

        boolean isVertexExtraction=false;
        boolean isEdgeExtraction=false;
        List<String> labelCollection= new ArrayList<>();
        String extractType=ctx.getChild(0).getText();

        if (extractType.equals(".extractV(")) {
            isVertexExtraction= true;
            isEdgeExtraction   =false;
        } else if (extractType.equals(".extractE(")) {
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


        TemporalVariableVisitor temporalVariableVisitor= new TemporalVariableVisitor();
        Operands operand= temporalVariableVisitor.visit(ctx.getChild(5));
        Value val=(Value) operand;
        int value=val.getVal();
        Operator operator = opr.convertStr2Operator(ctx.getChild(2).getText());

        evaluation.addEvaluation(operator, value);


        return evaluation;
    }




    @Override
    public ClauseElement visitGraphModificationEvent(PatternParser.GraphModificationEventContext ctx) {
        Modifier mdf=Modifier.ERROR;
        Change chg= Change.ERROR;
        return new GraphModification(mdf.convertStr2Modifier(ctx.getChild(0).getText()), chg.convertStr2Change(ctx.getChild(1).getText()));
    }
}
