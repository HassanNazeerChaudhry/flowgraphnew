package shared.model.graphcollection;

import shared.model.enumerators.Modifier;

import java.io.Serializable;


public class ExtractObject extends GraphActions implements Serializable   {
    public   String freeVar;
    public Modifier modType;

    public ExtractObject(String freeVar) {
        this.freeVar = freeVar;
    }

    public ExtractObject(String freeVar, Modifier modType) {
        this.freeVar = freeVar;
        this.modType = modType;
    }

    public Modifier getModType() {
        return modType;
    }

    public String getFreeVar() {
        return freeVar;
    }


}

