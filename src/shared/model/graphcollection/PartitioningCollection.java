package shared.model.graphcollection;

import java.util.HashSet;

public class PartitioningCollection extends GraphActions{
    HashSet<PartitioningObject> PartitioningCollection=new HashSet();

    public PartitioningCollection(HashSet<PartitioningObject> partitioningCollection) {
        PartitioningCollection = partitioningCollection;
    }

    public HashSet<PartitioningObject> getPartitioningCollection() {
        return PartitioningCollection;
    }

    public void setPartitioningCollection(HashSet<PartitioningObject> partitioningCollection) {
        PartitioningCollection = partitioningCollection;
    }

}
