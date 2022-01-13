package shared.model.clauseelement.graphproc;


import shared.model.clauseelement.graphproc.compelements.ComputationalElements;

import java.util.List;

public class Computation extends ProcElement {

    ComputationalElements computationalElements;

    public Computation() {
    }

    public Computation(ComputationalElements computationalElements) {
        this.computationalElements = computationalElements;
    }

   public void addComputationElement(ComputationalElements computationalElements){
        this.computationalElements=computationalElements;
   }
}
