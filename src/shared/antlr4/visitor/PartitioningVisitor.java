package shared.antlr4.visitor;

import shared.antlr4.pattern.PatternBaseVisitor;
import shared.antlr4.pattern.PatternParser;
import shared.model.clauseelement.graphproc.partitioningelements.PartitioningElements;
import shared.model.patternelements.TemporalClause;
import shared.variables.Operands;

public class PartitioningVisitor extends PatternBaseVisitor<PartitioningElements> {

    public PartitioningVisitor() {
    }


    @Override
    public PartitioningElements visitPartitionFunction(PatternParser.PartitionFunctionContext ctx) {
        TemporalVariableVisitor temporalVariableVisitor= new TemporalVariableVisitor();
        PartitioningElements partitioningElement=new PartitioningElements();

       if(ctx.getChildCount()>1){
              for(int i=2; i<ctx.getChildCount()-1;i+=2){
                  partitioningElement.addOperands(temporalVariableVisitor.visit(ctx.getChild(i)));
              }
       }else{
           partitioningElement.addOperands(temporalVariableVisitor.visit(ctx.getChild(0)));
       }

       return partitioningElement;

    }
}
