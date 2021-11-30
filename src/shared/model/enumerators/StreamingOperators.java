package shared.model.enumerators;

public enum StreamingOperators {
    MAP,
    FLATMAP,
    REDUCE,
    FILTER,
    GROUPBY,
    MERGE,
    COLLECT,
    ERROR;

    public  String opString;

    StreamingOperators() {
    }

    StreamingOperators(String opString) {
        this.opString = opString;
    }


    public StreamingOperators convertStr2Operator(String oprStr){
        switch(oprStr){
            case  "MAP": return StreamingOperators.MAP;
            case "FLATMAP": return StreamingOperators.FLATMAP;
            case "REDUCE": return StreamingOperators.REDUCE;
            case "FILTER": return StreamingOperators.FILTER;
            case "GROUPBY": return StreamingOperators.GROUPBY;
            case "MERGE": return StreamingOperators.MERGE;
            case "COLLECT": return StreamingOperators.COLLECT;
            default: return StreamingOperators.ERROR;
        }
    }


}
