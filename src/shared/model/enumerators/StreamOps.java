package shared.model.enumerators;

public enum StreamOps {
    MAX,
    MIN,
    AVG,
    ERROR;

    public  String StreamOpString;

    StreamOps() {
    }


    StreamOps(String StreamOpString) {
        this.StreamOpString = StreamOpString;
    }


    public StreamOps convertStr2StreamOP(String StreamOpString){
        switch(StreamOpString){
            case  "MAX": return StreamOps.MAX;
            case "MIN": return StreamOps.MIN;
            case "AVG": return StreamOps.AVG;
            default: return StreamOps.ERROR;
        }
    }
}



