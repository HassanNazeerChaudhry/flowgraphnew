package shared.messages.GraphAction;

import shared.model.enumerators.Modifier;

import java.io.Serializable;

public class PartitionMsg extends GraphActions implements Serializable {
    private   String groupBy;
    private Modifier modType;
    private String type;


    public PartitionMsg(String groupBy, Modifier modType) {
        this.groupBy = groupBy;
        this.modType = modType;
        this.type="partition";
    }

    public String getType() {
        return type;
    }

    public String getGroupBy() {
        return groupBy;
    }

    public Modifier getModType() {
        return modType;
    }
}
