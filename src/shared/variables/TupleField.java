package shared.variables;

import java.util.ArrayList;
import java.util.List;

public class TupleField {
    List<String> tupleField= new ArrayList<>();

    public TupleField() {
    }

    public void addTupleValue(String tupleValue){
        tupleField.add(tupleValue);

    }
}
