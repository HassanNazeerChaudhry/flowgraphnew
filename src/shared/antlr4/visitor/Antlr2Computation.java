package shared.antlr4.visitor;

import shared.antlr4.pattern.PatternBaseVisitor;
import shared.antlr4.pattern.PatternParser;
import shared.computations.Computations;
import shared.computations.solvers.InDegree;
import shared.computations.solvers.PageRank;
import shared.computations.solvers.TriangleCount;
import shared.model.clauseelement.graphproc.compelements.ComputationParameter;
import shared.model.clauseelement.graphproc.compelements.ComputationalElements;
import shared.model.clauseelement.graphproc.compelements.ComputationalVariable;
import shared.model.clauseelement.graphproc.compelements.FunctionName;


import java.util.Arrays;
import java.util.List;

public class Antlr2Computation extends PatternBaseVisitor<ComputationalElements> {

private List<String> vars;
private List<String> semanticErrors;
private List<String> fNameList = Arrays.asList("Triangle", "PRank", "InDegree");

    @Override
    public ComputationalElements visitComputationFunction(PatternParser.ComputationFunctionContext ctx) {
        String funcName=ctx.getChild(0).getText();

        if(!fNameList.contains(funcName)){
            semanticErrors.add("Error: computation function "+funcName+ " does not exist");
        }

        return new FunctionName(funcName);

    }





    @Override
    public ComputationalElements visitComputationReturnVariables(PatternParser.ComputationReturnVariablesContext ctx) {
        String varName=ctx.getChild(1).getText();



        if(vars.contains(varName)){
              semanticErrors.add("Error: Variable "+varName+ "already declared");

        }
        else{
            vars.add(varName);
        }


        return new ComputationalVariable(varName);

    }



    @Override
    public ComputationalElements visitComputationParameters(PatternParser.ComputationParametersContext ctx) {
        String lVal=ctx.getChild(1).getText();
        String rVal=ctx.getChild(3).getText();
        return new ComputationParameter(lVal,rVal);

    }
}
