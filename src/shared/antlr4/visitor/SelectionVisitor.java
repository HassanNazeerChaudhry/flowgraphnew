package shared.antlr4.visitor;

import shared.antlr4.pattern.PatternBaseVisitor;
import shared.antlr4.pattern.PatternParser;
import shared.model.clauseelement.graphproc.selelements.BooleanAndFunction;
import shared.model.clauseelement.graphproc.selelements.BooleanPredicate;
import shared.model.clauseelement.graphproc.selelements.LogicalExpression;
import shared.model.clauseelement.graphproc.selelements.SelectionFunction;

import java.util.ArrayList;
import java.util.List;


public class SelectionVisitor extends PatternBaseVisitor<SelectionFunction> {

    public SelectionVisitor() {
    }

    @Override
    public SelectionFunction visitSelection(PatternParser.SelectionContext ctx) {
        SelectionFunction sFunc=visit(ctx.getChild(1));
        return sFunc;
    }

    @Override
    public SelectionFunction visitLogicalExpression(PatternParser.LogicalExpressionContext ctx) {
        List<SelectionFunction> selVar= new ArrayList<>();;


        if(ctx.getChildCount()>1){
            selVar.add(visit(ctx.getChild(0)));
        }
        else{
            for(int i=0; i<ctx.getChildCount()+1;i+=2){
                selVar.add(visit(ctx.getChild(i)));
            }

        }



        return selVar;



    }

    @Override
    public SelectionFunction visitEdgeSelection(PatternParser.EdgeSelectionContext ctx) {
        return super.visitEdgeSelection(ctx);
    }




    @Override
    public SelectionFunction visitBooleanAndExpression(PatternParser.BooleanAndExpressionContext ctx) {
        return super.visitBooleanAndExpression(ctx);
    }

    @Override
    public SelectionFunction visitUnaryExpression(PatternParser.UnaryExpressionContext ctx) {
        return super.visitUnaryExpression(ctx);
    }


    @Override
    public SelectionFunction visitSelectionFunction(PatternParser.SelectionFunctionContext ctx) {
        return super.visitSelectionFunction(ctx);
    }


    @Override
    public SelectionFunction visitPrimaryExpression(PatternParser.PrimaryExpressionContext ctx) {
        return super.visitPrimaryExpression(ctx);
    }


    @Override
    public SelectionFunction visitOperands(PatternParser.OperandsContext ctx) {
        return super.visitOperands(ctx);
    }


    public SelectionFunction visitSellabel(PatternParser.SellabelContext ctx) {
        return super.visitSellabel(ctx);
    }

    public SelectionFunction visitSelvalue(PatternParser.SelvalueContext ctx) {
        return super.visitSelvalue(ctx);
    }
}
