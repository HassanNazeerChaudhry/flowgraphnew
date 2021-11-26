package shared.model.patternelements;

import shared.model.PatternElement;
import shared.variables.Operands;
import shared.variables.TemporalVariables;

public class FollowedBy extends PatternElement {
    Operands tVar;


    public FollowedBy() {
    }

    public FollowedBy(Operands tVar) {
        this.tVar = tVar;
    }

    public void settVar(Operands tVar) {
        this.tVar = tVar;
    }


}
