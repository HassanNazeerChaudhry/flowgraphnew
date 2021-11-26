package shared.model.patternelements;

import shared.model.ClauseElement;
import shared.model.PatternElement;

import java.util.ArrayList;
import java.util.List;

public class TemporalClause extends PatternElement {

    List<ClauseElement> cElements;

    public TemporalClause() {
        this.cElements = new ArrayList<>();
    }



    public void addClauseElements(ClauseElement clauseElement){
        cElements.add(clauseElement);
    }


}




