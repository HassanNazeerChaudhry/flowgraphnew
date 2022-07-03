package shared.messages.GraphAction;


import shared.model.graphcollection.SelectObject;

import java.io.Serializable;

public class SelectMsg implements Serializable {

    public SelectObject selectObject;

    public SelectMsg(SelectObject selectObject) {
        this.selectObject = selectObject;
    }

    public SelectObject getSelectObject() {
        return selectObject;
    }
}
