package shared.model.enumerators;


public enum Change {
    DELETE,
    ADD,
    MODIFY,
    ERROR;

    public  String changeString;

    Change() {
    }

    Change(String changeString) {
        this.changeString = changeString;
    }


    public Change convertStr2Change(String changeString){
        switch(changeString){
            case  "Delete": return Change.DELETE;
            case "Add": return Change.ADD;
            case "Modify": return Change.MODIFY;
            default: return Change.ERROR;
        }
    }
}