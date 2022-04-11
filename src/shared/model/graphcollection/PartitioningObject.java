package shared.model.graphcollection;

import java.io.Serializable;

public class PartitioningObject implements Serializable {
    public   String groupBy;

    public PartitioningObject(String groupBy) {
        this.groupBy = groupBy;
    }

    public String getGroupBy() {
        return groupBy;
    }

    public void setGroupBy(String groupBy) {
        this.groupBy = groupBy;
    }
}
