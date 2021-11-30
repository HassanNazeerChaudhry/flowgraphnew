package shared.model.clauseelement;

import shared.model.enumerators.Ops;
import shared.model.enumerators.StreamingOperators;
import shared.variables.TupleField;

import java.util.ArrayList;
import java.util.List;

public class OperationalFunction extends  OpFuncAbstract {
   StreamingOperators streamingOperators=StreamingOperators.ERROR;
   String functionName;
   List<TupleField> tupleFields= new ArrayList<>();
   Ops operator= Ops.ERROR;


   public OperationalFunction(StreamingOperators streamingOperators) {
      this.streamingOperators = streamingOperators;
   }

   public OperationalFunction(Ops operator) {
      this.operator = operator;
   }

   public OperationalFunction(TupleField tupleFields, Ops operator) {
      this.tupleFields.add(tupleFields);
      this.operator = operator;
   }

   public OperationalFunction(StreamingOperators streamingOperators, List<TupleField> tupleFields) {
      this.streamingOperators = streamingOperators;
      this.tupleFields = tupleFields;
   }

   public OperationalFunction(StreamingOperators streamingOperators, String functionName, List<TupleField> tupleFields) {
      this.streamingOperators = streamingOperators;
      this.functionName = functionName;
      this.tupleFields = tupleFields;
   }



}
