package shared.model.clauseelement.graphproc.partitioningelements;

import shared.variables.Operands;
import java.util.ArrayList;
import java.util.List;

public class PartitioningElements {
    List<Operands> operands=new ArrayList<>();

    public PartitioningElements(List<Operands> operands) {
        this.operands = operands;
    }

    public PartitioningElements() {
    }


    public void addOperands(Operands opr){
        operands.add(opr);
    }

}
