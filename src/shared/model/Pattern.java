package shared.model;

import java.util.ArrayList;
import java.util.List;

public class Pattern {

    List<PatternElement> pElements;


    public Pattern() {
        this.pElements = new ArrayList<>();
    }

    public void addExpression(PatternElement pElement){
        pElements.add(pElement);
    }



}



