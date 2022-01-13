package shared.antlr4.visitor;

import shared.antlr4.pattern.PatternBaseVisitor;
import shared.antlr4.pattern.PatternParser;
import shared.model.clauseelement.graphproc.Computation;
import shared.model.clauseelement.graphproc.Partition;
import shared.model.clauseelement.graphproc.ProcElement;
import shared.model.clauseelement.graphproc.Selection;

public class ProcElementVisitor extends PatternBaseVisitor<ProcElement> {



    @Override
    public ProcElement visitComputation(PatternParser.ComputationContext ctx) {
        ComputationVisitor computationVisitor= new ComputationVisitor();
        Computation computation= new Computation();
        computation.addComputationElement(computationVisitor.visit(ctx.getChild(1)));
        return  computation;
    }

    @Override
    public ProcElement visitSelection(PatternParser.SelectionContext ctx) {
        SelectionVisitor selectionVisitor=new SelectionVisitor();
        Selection selection= new Selection();
        selection.addSelectionFunction(selectionVisitor.visit(ctx.getChild(2)));
        return selection;

    }

    @Override
    public ProcElement visitPartition(PatternParser.PartitionContext ctx) {
        PartitioningVisitor partitioningVisitor= new PartitioningVisitor();
        Partition partition= new Partition();



        if (ctx.getChild(0).equals(".SubGraphByV(")) {

            partition=new Partition(true,false,   partitioningVisitor.visit(ctx.getChild(1)));
        } else if (ctx.getChild(0).equals(".SubGraphByE(")) {

            partition=new Partition(false,true,   partitioningVisitor.visit(ctx.getChild(1)));
        }

        return partition;
    }





}
