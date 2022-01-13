package shared.antlr4.visitor;

import shared.antlr4.pattern.PatternBaseVisitor;
import shared.antlr4.pattern.PatternParser;
import shared.model.clauseelement.graphproc.compelements.ComputationalElements;
import shared.model.clauseelement.graphproc.compelements.ComputationalVariable;
import shared.model.clauseelement.graphproc.compelements.FunctionName;


import java.util.Arrays;
import java.util.List;

public class ComputationVisitor extends PatternBaseVisitor<ComputationalElements> {

private List<String> vars;
private List<String> semanticErrors;
private List<String> fNameList = Arrays.asList("Triangle", "PageRank", "InDegree");

    @Override
    public ComputationalElements visitComputationFunction(PatternParser.ComputationFunctionContext ctx) {
        String funcName=ctx.getChild(0).getText(); //get function name
        String returnVariable=ctx.getChild(2).getText(); // get variable name
        returnVariable=returnVariable.substring(1,returnVariable.length());
        FunctionName functionName= new FunctionName(funcName);

        ComputationalVariable computationalVariable= new ComputationalVariable(returnVariable);
        ComputationParameterVisitor computationParameter= new ComputationParameterVisitor();
        ComputationalElements computationalElements= new ComputationalElements(functionName,computationalVariable, computationParameter.visit(ctx.getChild(3)));

        return computationalElements;
    }



}
