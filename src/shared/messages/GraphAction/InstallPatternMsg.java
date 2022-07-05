package shared.messages.GraphAction;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class InstallPatternMsg implements Serializable {

    private HashMap<String, GraphActions> graphActions= new HashMap<>();

    public InstallPatternMsg(HashMap<String, GraphActions> graphActions) {
        this.graphActions = graphActions;
    }

    public HashMap<String, GraphActions> getGraphActions() {
        return graphActions;
    }
}
