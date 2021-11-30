package shared.model.clauseelement.graphproc;
import shared.model.clauseelement.graphproc.selelements.SelectionFunctionAbstract;

import java.util.List;

public class Selection extends ProcElement {
    List<SelectionFunctionAbstract> selVar;

    public Selection(List<SelectionFunctionAbstract> selVar) {
        this.selVar = selVar;
    }


    public Selection() {
    }


    public void addSelectionFunction (SelectionFunctionAbstract selectionFunction){
        selVar.add(selectionFunction);


    }
}
