package shared.model.clauseelement.graphproc;

import shared.model.clauseelement.graphproc.partitioningelements.PartitioningElements;

public class Partition  extends ProcElement{

    private boolean isPartbyV;
    private boolean isPartbyE;
    PartitioningElements partitioningElements;

    public Partition() {
    }

    public Partition(boolean isPartbyV, boolean isPartbyE) {
        this.isPartbyV = isPartbyV;
        this.isPartbyE = isPartbyE;
    }


    public Partition(boolean isPartbyV, boolean isPartbyE, PartitioningElements partitioningElements) {
        this.isPartbyV = isPartbyV;
        this.isPartbyE = isPartbyE;
        this.partitioningElements = partitioningElements;
    }

    public  void addnewPartitionElement(PartitioningElements partitioningElement){
        this.partitioningElements=partitioningElement;
    }
}



