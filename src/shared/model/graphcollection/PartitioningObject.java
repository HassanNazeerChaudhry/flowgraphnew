package shared.model.graphcollection;

import shared.model.enumerators.ConjugationType;
import shared.model.enumerators.Modifier;

import java.io.Serializable;

public class PartitioningObject extends GraphActions implements Serializable {
    public   String groupBy;
    public Modifier modType;

    public PartitioningObject(String groupBy) {
        this.groupBy = groupBy;
    }

    public PartitioningObject(String groupBy, Modifier modType) {
        this.groupBy = groupBy;
        this.modType = modType;
    }



    public Modifier getModType() {
        return modType;
    }

    public String getGroupBy() {
        return groupBy;
    }

    public void setGroupBy(String groupBy) {
        this.groupBy = groupBy;
    }
}
