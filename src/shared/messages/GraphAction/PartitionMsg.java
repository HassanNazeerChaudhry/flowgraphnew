package shared.messages.GraphAction;

import shared.model.graphcollection.PartitioningObject;

import java.io.Serializable;

public class PartitionMsg implements Serializable {
    PartitioningObject partitioningObject;

    public PartitionMsg(PartitioningObject partitioningObject) {
        this.partitioningObject = partitioningObject;
    }

    public PartitioningObject getPartitioningObject() {
        return partitioningObject;
    }
}
