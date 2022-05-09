package shared.messages;

import shared.model.graphcollection.ExtractCollection;


import java.io.Serializable;

public class ExtractMsg implements Serializable {
   ExtractCollection extractCollection;

    public ExtractMsg(ExtractCollection extractCollection) {
        this.extractCollection = extractCollection;
    }

    public ExtractCollection getExtractCollection() {
        return extractCollection;
    }
}
