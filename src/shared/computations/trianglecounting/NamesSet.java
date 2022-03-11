package shared.computations.trianglecounting;

import shared.graph.Edge;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class NamesSet implements Serializable {
    private final String[] names = new String[3];
    private int size = 0;

    public NamesSet(String name) {
        names[0] = name;
        size = 1;
    }

    private NamesSet(String[] names, int size) {
        this.names[0] = names[0];
        this.names[1] = names[1];
        this.names[2] = names[2];
        this.size = size;
    }
    public NamesSet copy() {
        return new NamesSet(names, size);
    }

    public void add(String name) {
        assert size == 1;
        size = 2;
        names[1] = name;
    }

    public boolean merge(NamesSet other) {
        assert size == 2;
        assert other.size == 2;
        assert !names[1].equals(other.names[1]);
        if (!names[0].equals(other.names[0])) {
            return false;
        } else {
            names[2] = other.names[1];
            size = 3;
            return true;
        }
    }

    public boolean merge(String mySelf, Set<Edge> outgoingEdges) {
        if (outgoingEdges.stream().anyMatch(edge -> edge.getDestination().equals(names[0]))) {
            names[2] = mySelf;
            return true;
        } else {
            return false;
        }
    }

    public final HashSet<String> getNames() {
        HashSet<String> result = new HashSet<>();
        result.add(names[0]);
        result.add(names[1]);
        result.add(names[2]);
        return result;
    }

    @Override
    public String toString() {
        String str = "";
        if (size>0) {
            str = str + names[0];
        }
        if (size>1) {
            str = str + ", " + names[1];
        }
        if (size>2) {
            str = str + ", " + names[2];
        }
        return str;
    }


}
