package shared.model.clauseelement;

import shared.model.enumerators.Ops;
import shared.model.enumerators.StreamingOperators;
import shared.variables.TupleField;

import java.util.ArrayList;
import java.util.List;

public class OperationalFunction extends  OpFuncAbstract {
   StreamingOperators streamingOperators=StreamingOperators.ERROR;
   String functionName;
   TupleField tupleFields;
   Ops operator= Ops.ERROR;


   public OperationalFunction(StreamingOperators streamingOperators) {
      this.streamingOperators = streamingOperators;
   }

   public OperationalFunction(Ops operator) {
      this.operator = operator;
   }

   public OperationalFunction(TupleField tupleFields, Ops operator) {
      this.tupleFields=tupleFields;
      this.operator = operator;
   }

   public OperationalFunction(StreamingOperators streamingOperators, TupleField tupleFields) {
      this.streamingOperators = streamingOperators;
      this.tupleFields = tupleFields;
   }

   public OperationalFunction(StreamingOperators streamingOperators, String functionName, TupleField tupleFields) {
      this.streamingOperators = streamingOperators;
      this.functionName = functionName;
      this.tupleFields = tupleFields;
   }



}
