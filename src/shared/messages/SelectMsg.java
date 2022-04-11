package shared.messages;


import shared.model.graphcollection.SelectCollection;
import java.io.Serializable;
import java.util.HashSet;

public class SelectMsg implements Serializable {

    SelectCollection selCollection;

    public SelectMsg(SelectCollection selCollection) {
        this.selCollection = selCollection;
    }

    public SelectCollection getSelCollection() {
        return selCollection;
    }
}
