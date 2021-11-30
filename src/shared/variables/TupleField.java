package shared.variables;

import java.util.ArrayList;
import java.util.List;

public class TupleField {
    String tupleField;

    public TupleField() {
    }


    public TupleField(String tupleField) {
        this.tupleField = tupleField;
    }

    public void addTupleValue(String tupleValue){
        tupleField=tupleValue;

    }


}
