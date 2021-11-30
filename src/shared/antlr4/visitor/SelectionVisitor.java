package shared.antlr4.visitor;

import shared.antlr4.pattern.PatternBaseVisitor;
import shared.antlr4.pattern.PatternParser;
import shared.model.clauseelement.graphproc.selelements.*;
import shared.model.enumerators.Operator;

import java.util.ArrayList;
import java.util.List;


public class SelectionVisitor extends PatternBaseVisitor<SelectionFunctionAbstract> {

    public SelectionVisitor() {
    }

    @Override
    public SelectionFunctionAbstract visitSelectionFunction(PatternParser.SelectionFunctionContext ctx) {
         SelectionFunction selectionFunction= new SelectionFunction();
         selectionFunction.addNewSelection(visit(ctx.getChild(0)), visit(ctx.getChild(1)));
         return selectionFunction;
    }

    @Override
    public SelectionFunctionAbstract visitLogicalExpression(PatternParser.LogicalExpressionContext ctx) {
        LogicalExpression logicalExpression= new LogicalExpression();
        List<SelectionFunctionAbstract> selVar= new ArrayList<>();


        if(ctx.getChildCount()>1){
            selVar.add(visit(ctx.getChild(0)));
        }
        else{
            for(int i=0; i<ctx.getChildCount()+1;i+=2){
                selVar.add(visit(ctx.getChild(i)));
            }

        }
        logicalExpression.addLogicalExpression(selVar);
        return logicalExpression;
    }

    @Override
    public SelectionFunctionAbstract visitEdgeSelection(PatternParser.EdgeSelectionContext ctx) {
        return super.visitEdgeSelection(ctx);
    }




    @Override
    public SelectionFunctionAbstract visitBooleanAndExpression(PatternParser.BooleanAndExpressionContext ctx) {
        BooleanAndFunction booleanAndFunction= new BooleanAndFunction();
        List<SelectionFunctionAbstract> selVar= new ArrayList<>();



        if(ctx.getChildCount()>1){
            selVar.add(visit(ctx.getChild(0)));
        }
        else{
            for(int i=0; i<ctx.getChildCount()+1;i+=2){
                selVar.add(visit(ctx.getChild(i)));
            }

        }
        booleanAndFunction.addBooleanAndExpression(selVar);
        return booleanAndFunction;
    }

    @Override
    public SelectionFunctionAbstract visitUnaryExpression(PatternParser.UnaryExpressionContext ctx) {
        UnaryExpression unaryExpression= new UnaryExpression();

        if(ctx.getChildCount()>1){
            unaryExpression.addExpression(true, visit(ctx.getChild(1)));
        }else{
            unaryExpression.addExpression(visit(ctx.getChild(0)));
        }

        return unaryExpression;
    }





    @Override
    public SelectionFunctionAbstract visitPrimaryExpression(PatternParser.PrimaryExpressionContext ctx) {
        TemporalVariableVisitor temporalVariableVisitor= new TemporalVariableVisitor();
        PrimaryExpression primaryExpression=new PrimaryExpression();
        Operator opr=Operator.ERROR;
        primaryExpression.addnewExpression(temporalVariableVisitor.visit(ctx.getChild(0)),temporalVariableVisitor.visit(ctx.getChild(1)), opr.convertStr2Operator(ctx.getChild(2).getText()));
        return primaryExpression;
    }


}
