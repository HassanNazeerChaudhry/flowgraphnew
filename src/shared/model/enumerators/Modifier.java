package shared.model.enumerators;

public enum Modifier {
    VERTEX,
    EDGE,
    ERROR;

    public  String modifierString;

    Modifier() {
    }


    Modifier(String modifierString) {
        this.modifierString = modifierString;
    }


    public Modifier convertStr2Modifier(String modifierString){
        switch(modifierString){
            case  "Vertex": return Modifier.VERTEX;
            case "Edge": return Modifier.EDGE;
            default: return Modifier.ERROR;
        }
    }
}


