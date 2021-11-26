package shared.model.clauseelement;

import shared.model.clauseelement.graphproc.ProcElement;
import shared.model.ClauseElement;

import java.util.ArrayList;
import java.util.List;

public class  GraphProcessing  extends ClauseElement {
    List<ProcElement> pElements;

    public GraphProcessing() {
        this.pElements = new ArrayList<>();
    }


    public GraphProcessing(List<ProcElement> pElements) {
        this.pElements = pElements;
    }

    public void addProcElement(ProcElement procElement){
        pElements.add(procElement);

    }

}
