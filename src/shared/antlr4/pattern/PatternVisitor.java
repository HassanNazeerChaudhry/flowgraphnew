// Generated from /Users/chaudhryhassan/Desktop/FlowGraph-main/src/shared/antlr4/pattern/Pattern.g4 by ANTLR 4.9.1

 package shared.antlr4.pattern;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PatternParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PatternVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PatternParser#patternEntry}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPatternEntry(PatternParser.PatternEntryContext ctx);
	/**
	 * Visit a parse tree produced by {@link PatternParser#temporalPattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemporalPattern(PatternParser.TemporalPatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link PatternParser#graphModificationEvent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGraphModificationEvent(PatternParser.GraphModificationEventContext ctx);
	/**
	 * Visit a parse tree produced by {@link PatternParser#temporalClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemporalClause(PatternParser.TemporalClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GraphProc}
	 * labeled alternative in {@link PatternParser#graphProcessing}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGraphProc(PatternParser.GraphProcContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GraphProcTemp}
	 * labeled alternative in {@link PatternParser#graphProcessing}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGraphProcTemp(PatternParser.GraphProcTempContext ctx);
	/**
	 * Visit a parse tree produced by {@link PatternParser#computation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComputation(PatternParser.ComputationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PatternParser#selection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelection(PatternParser.SelectionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PartByV}
	 * labeled alternative in {@link PatternParser#partition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartByV(PatternParser.PartByVContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PartByE}
	 * labeled alternative in {@link PatternParser#partition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartByE(PatternParser.PartByEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExtractByV}
	 * labeled alternative in {@link PatternParser#extraction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtractByV(PatternParser.ExtractByVContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExtractByE}
	 * labeled alternative in {@link PatternParser#extraction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtractByE(PatternParser.ExtractByEContext ctx);
	/**
	 * Visit a parse tree produced by {@link PatternParser#evaluation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEvaluation(PatternParser.EvaluationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PatternParser#computationFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComputationFunction(PatternParser.ComputationFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PatternParser#computationReturnVariables}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComputationReturnVariables(PatternParser.ComputationReturnVariablesContext ctx);
	/**
	 * Visit a parse tree produced by {@link PatternParser#computationParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComputationParameters(PatternParser.ComputationParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link PatternParser#aliasedParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAliasedParameter(PatternParser.AliasedParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link PatternParser#followedBy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFollowedBy(PatternParser.FollowedByContext ctx);
	/**
	 * Visit a parse tree produced by {@link PatternParser#modifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModifier(PatternParser.ModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link PatternParser#change}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChange(PatternParser.ChangeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PatternParser#selectionFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectionFunction(PatternParser.SelectionFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PatternParser#edgeSelection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEdgeSelection(PatternParser.EdgeSelectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PatternParser#logicalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalExpression(PatternParser.LogicalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PatternParser#booleanAndExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanAndExpression(PatternParser.BooleanAndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PatternParser#unaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpression(PatternParser.UnaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PatternParser#primaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryExpression(PatternParser.PrimaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PatternParser#boolPredicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolPredicate(PatternParser.BoolPredicateContext ctx);
	/**
	 * Visit a parse tree produced by {@link PatternParser#operands}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperands(PatternParser.OperandsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PatternParser#partitionFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartitionFunction(PatternParser.PartitionFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PatternParser#operationFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperationFunction(PatternParser.OperationFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PatternParser#oneFieldOperationAlias}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOneFieldOperationAlias(PatternParser.OneFieldOperationAliasContext ctx);
	/**
	 * Visit a parse tree produced by {@link PatternParser#emission}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmission(PatternParser.EmissionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PatternParser#temporalVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemporalVariable(PatternParser.TemporalVariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link PatternParser#functionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionName(PatternParser.FunctionNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link PatternParser#label}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabel(PatternParser.LabelContext ctx);
	/**
	 * Visit a parse tree produced by {@link PatternParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(PatternParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link PatternParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(PatternParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link PatternParser#fireEvent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFireEvent(PatternParser.FireEventContext ctx);
	/**
	 * Visit a parse tree produced by {@link PatternParser#tupleField}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTupleField(PatternParser.TupleFieldContext ctx);
}