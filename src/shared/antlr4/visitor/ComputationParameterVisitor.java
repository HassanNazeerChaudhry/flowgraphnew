package shared.antlr4.visitor;

import shared.antlr4.pattern.PatternBaseVisitor;
import shared.antlr4.pattern.PatternParser;
import shared.model.clauseelement.graphproc.compelements.ComputationParameter;


public class ComputationParameterVisitor  extends PatternBaseVisitor<ComputationParameter> {


    @Override
    public ComputationParameter visitComputationParameters(PatternParser.ComputationParametersContext ctx) {
     String lVal=  ctx.getChild(1).getText();
     String rVal= ctx.getChild(4).getText();
     ComputationParameter computationParameter= new ComputationParameter(lVal, rVal);

     return computationParameter;

    }



}
