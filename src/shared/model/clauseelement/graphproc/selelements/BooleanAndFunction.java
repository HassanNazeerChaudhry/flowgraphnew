package shared.model.clauseelement.graphproc.selelements;

import java.util.List;

public class BooleanAndFunction extends SelectionFunctionAbstract {

    private List<SelectionFunctionAbstract> selVar;

    public BooleanAndFunction() {
    }


    public void addBooleanAndExpression(List<SelectionFunctionAbstract> selVar){
        this.selVar=selVar;
    }

}



