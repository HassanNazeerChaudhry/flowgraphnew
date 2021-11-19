package shared.model.clauseelement.graphproc;


import shared.model.clauseelement.graphproc.compelements.ComputationalElements;

import java.util.List;

public class Computation extends ProcElement {

    List<ComputationalElements> compVar;

    public Computation(List<ComputationalElements> compVar) {
        this.compVar = compVar;
    }
}
