package shared.antlr4.visitor;

import shared.antlr4.pattern.PatternBaseVisitor;
import shared.antlr4.pattern.PatternParser;
import shared.model.ClauseElement;
import shared.model.clauseelement.graphproc.Computation;
import shared.model.clauseelement.graphproc.ProcElement;

public class ProcElementVisitor extends PatternBaseVisitor<ProcElement> {



    @Override
    public ProcElement visitComputation(PatternParser.ComputationContext ctx) {
        ComputationVisitor computationVisitor= new ComputationVisitor();
        Computation computation= new Computation();
        computation.addComputationElement(computationVisitor.visit(ctx.getChild(0)));
        return  computation;
    }

    @Override
    public ProcElement visitSelection(PatternParser.SelectionContext ctx) {
        SelectionVisitor selectionVisitor=new SelectionVisitor();


        return super.visitSelection(ctx);
    }

    @Override
    public ProcElement visitPartition(PatternParser.PartitionContext ctx) {
        PartitioningVisitor partitioningVisitor= new PartitioningVisitor();


        return super.visitPartition(ctx);
    }



}
