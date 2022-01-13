package shared.antlr4.visitor;

import shared.antlr4.pattern.PatternBaseVisitor;
import shared.antlr4.pattern.PatternParser;
import shared.model.clauseelement.OpFuncAbstract;
import shared.model.clauseelement.OperationalFunction;
import shared.model.enumerators.StreamingOperators;
import shared.variables.TupleField;

public class OperationalFunctionVisitor extends PatternBaseVisitor<OpFuncAbstract> {

    @Override
    public OpFuncAbstract visitOperationFunction(PatternParser.OperationFunctionContext ctx) {
        OperationalFunction operationalFunction;

    if(ctx.getChildCount()>3){
        StreamingOperators streamingOperators= StreamingOperators.ERROR;
        operationalFunction= new OperationalFunction(streamingOperators.convertStr2Operator(ctx.getChild(0).getText()), ctx.getChild(2).getText(),new TupleField(ctx.getChild(3).getText()) );

    } else if(ctx.getChildCount()>2){
        StreamingOperators streamingOperators= StreamingOperators.ERROR;
        operationalFunction= new OperationalFunction(streamingOperators.convertStr2Operator(ctx.getChild(0).getText()),new TupleField(ctx.getChild(3).getText()) );

    }else{
        StreamingOperators streamingOperators= StreamingOperators.ERROR;
        operationalFunction= new OperationalFunction(streamingOperators.convertStr2Operator(ctx.getChild(0).getText()) );


    }

      return operationalFunction;


    }
}
