package shared.messages.GraphAction;


import shared.model.enumerators.Modifier;

import java.io.Serializable;

public class ExtractMsg extends GraphActions implements Serializable {
    private   String freeVar;
    private Modifier modType;
    private String type;

    public ExtractMsg(String freeVar, Modifier modType) {
        this.freeVar = freeVar;
        this.modType = modType;
        this.type="extract";
    }

    public String getType() {
        return type;
    }

    public String getFreeVar() {
        return freeVar;
    }

    public Modifier getModType() {
        return modType;
    }
}
