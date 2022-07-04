package shared.messages.GraphAction;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class InstallPatternMsg implements Serializable {

    private Map<String, GraphActions> graphActions= new HashMap<>();

    public InstallPatternMsg(Map<String, GraphActions> graphActions) {
        this.graphActions = graphActions;
    }

    public Map<String, GraphActions> getGraphActions() {
        return graphActions;
    }
}
