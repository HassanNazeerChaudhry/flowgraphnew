package shared.model.enumerators;

public enum Ops {
    AVG,
    MAX,
    MIN,
    COUNT,
    SELECT,
    ERROR;



    public  String opString;

    Ops() {
    }

    Ops(String opString) {
        this.opString = opString;
    }


    public Ops convertStr2Ops(String oprStr){
        switch(oprStr){
            case  "AVG": return Ops.AVG;
            case "MAX": return Ops.MAX;
            case "MIN": return Ops.MIN;
            case "COUNT": return Ops.COUNT;
            case "SELECT": return Ops.SELECT;
            default: return Ops.ERROR;
        }
    }



}
