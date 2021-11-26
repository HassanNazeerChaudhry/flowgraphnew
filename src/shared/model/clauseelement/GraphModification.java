package shared.model.clauseelement;


import shared.model.ClauseElement;
import shared.model.enumerators.Change;
import shared.model.enumerators.Modifier;


public class GraphModification  extends ClauseElement {

    Modifier modifier;
    Change change;

    public GraphModification() {
    }

    public GraphModification(Modifier modifier, Change change) {
        this.modifier = modifier;
        this.change = change;
    }




}
