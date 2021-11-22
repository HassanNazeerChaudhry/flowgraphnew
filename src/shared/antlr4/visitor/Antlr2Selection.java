package shared.antlr4.visitor;

import shared.antlr4.pattern.PatternBaseVisitor;
import shared.antlr4.pattern.PatternParser;
import shared.model.clauseelement.graphproc.compelements.ComputationalElements;
import shared.model.clauseelement.graphproc.selelements.BooleanPredicate;
import shared.model.clauseelement.graphproc.selelements.SelectionFunction;
import shared.variables.Operands;

public class Antlr2Selection extends PatternBaseVisitor<SelectionFunction> {

    @Override
    public SelectionFunction visitSelectionFunction(PatternParser.SelectionFunctionContext ctx) {
        return super.visitSelectionFunction(ctx);
    }

    @Override
    public SelectionFunction visitEdgeSelection(PatternParser.EdgeSelectionContext ctx) {
        return super.visitEdgeSelection(ctx);
    }

    @Override
    public SelectionFunction visitLogicalExpression(PatternParser.LogicalExpressionContext ctx) {
        return super.visitLogicalExpression(ctx);
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
    public SelectionFunction visitPrimaryExpression(PatternParser.PrimaryExpressionContext ctx) {
        return super.visitPrimaryExpression(ctx);
    }

    @Override
    public SelectionFunction visitBoolPredicate(PatternParser.BoolPredicateContext ctx) {

        String operand1= ctx.getChild(0).getText();
        String operator=  ctx.getChild(1).getText();
        String operand2= ctx.getChild(2).getText();

        return new BooleanPredicate(operand1, operator, operand2);



    }
}
