package shared.messages;

import shared.model.graphcollection.PartitioningCollection;
import shared.model.graphcollection.SelectCollection;

import java.io.Serializable;

public class PartitionMsg implements Serializable {
    PartitioningCollection partCollection;

    public PartitionMsg(PartitioningCollection partCollection) {
        this.partCollection = partCollection;
    }

    public PartitioningCollection getPartCollection() {
        return partCollection;
    }

    public void setPartCollection(PartitioningCollection partCollection) {
        this.partCollection = partCollection;
    }

}
