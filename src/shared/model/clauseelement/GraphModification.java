package shared.model.clauseelement;


import shared.model.ClauseElement;


public class GraphModification  extends ClauseElement {

    MODIFIER modifier;
    CHANGE change;

    enum MODIFIER {
        Vertex,
        EDGE,
        HIGH
    }

    enum CHANGE {
        DELETE,
        ADD,
        MODIFY
    }

    public GraphModification(MODIFIER modifier, CHANGE change) {
        this.modifier = modifier;
        this.change = change;
    }



}
