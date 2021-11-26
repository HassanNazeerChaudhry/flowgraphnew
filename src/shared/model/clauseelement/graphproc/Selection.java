package shared.model.clauseelement.graphproc;
import shared.model.clauseelement.graphproc.selelements.SelectionFunction;

import java.util.List;

public class Selection extends ProcElement {
    List<SelectionFunction> selVar;

    public Selection(List<SelectionFunction> selVar) {
        this.selVar = selVar;
    }


    public Selection() {
    }


    public void addSelectionFunction (SelectionFunction selectionFunction){
        selVar.add(selectionFunction);


    }
}
