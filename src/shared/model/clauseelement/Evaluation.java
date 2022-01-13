package shared.model.clauseelement;

import shared.model.ClauseElement;
import shared.model.enumerators.Operator;

public class Evaluation extends ClauseElement {

    private Operator operator;
    private int value;
    private String fireEvent;

    public Evaluation(Operator operator, int value) {
        this.operator = operator;
        this.value = value;
        this.fireEvent="Default";
    }

    public Evaluation(Operator operator, int value, String fireEvent) {
        this.operator = operator;
        this.value = value;
        this.fireEvent = fireEvent;
    }

    public Evaluation() {
    }


    public void addEvaluation(Operator operator, int value){
        this.operator=operator;
        this.value=value;
        this.fireEvent="Default";

    }


    public void addEvaluation(Operator operator, int value, String fireEvent){
        this.operator=operator;
        this.value=value;
        this.fireEvent=fireEvent;

    }

}
