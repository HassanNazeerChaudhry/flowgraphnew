package shared.model.enumerators;

public enum Operator {
    EQUAL("=="),
    GREATER(">"),
    LESS("<"),
    GREATEREQUAL(">="),
    LESSEQUAL("<="),
    ERROR("");

    public  String opString;

    Operator() {
    }

    Operator(String opString) {
        this.opString = opString;
    }


    public Operator convertStr2Operator(String oprStr){
        switch(oprStr){
            case  "==": return Operator.EQUAL;
            case ">": return Operator.GREATER;
            case "<": return Operator.LESS;
            case ">=": return Operator.GREATEREQUAL;
            case "<=": return Operator.LESSEQUAL;
            default: return Operator.ERROR;
        }
    }
}


