package shared.messages.GraphAction;


import shared.model.graphcollection.ExtractObject;

import java.io.Serializable;

public class ExtractMsg implements Serializable {
   ExtractObject extractObject;

    public ExtractMsg(ExtractObject extractObject) {
        this.extractObject = extractObject;
    }

    public ExtractObject getExtractObject() {
        return extractObject;
    }
}
