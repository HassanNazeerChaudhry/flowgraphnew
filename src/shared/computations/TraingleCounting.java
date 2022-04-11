package shared.computations;

import shared.graph.Edge;
import shared.graph.Vertex;
import shared.vertexcentric.MsgSenderPair;
import shared.vertexcentric.Outbox;
import shared.vertexcentric.VertexCentricComputation;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TraingleCounting extends VertexCentricComputation<NamesSet, HashSet<HashSet<String>>> {
    private static final long serialVersionUID = 6607890356679716721L;

    private final Set<NamesSet> nonTriangles = new HashSet<>();
    private final Set<NamesSet> triangles = new HashSet<>();

    private String mySelf = ""; // FIXME

    @Override
    public void startIteration(Vertex vertex, Set<Edge> outgoingEdges, Outbox<NamesSet> outbox, Set<HashSet<HashSet<String>>> output,
                               long timestamp) {
        // Send a message to all my neighbors
        nonTriangles.clear();
        triangles.clear();
        for (final Edge outgoingEdge : outgoingEdges) {
            outbox.add(outgoingEdge.getDestination(), new MsgSenderPair<>(vertex.getName(),new NamesSet(vertex.getName())));
        }
    }



    @Override
    public void iterate(Vertex vertex, Set<Edge> outgoingEdges, Collection<MsgSenderPair<NamesSet>> inbox, Outbox<NamesSet> outbox, Set<HashSet<HashSet<String>>> output, int superstep)
    {
        if (vertex!=null) {
            mySelf = vertex.getName();
        }
        if (superstep == 1) {
            for (MsgSenderPair<NamesSet> pair : inbox) {
                NamesSet receivedSet = pair.getMsg().copy();
                receivedSet.add(vertex.getName());
                for (Edge edge : outgoingEdges) {
                    outbox.add(edge.getDestination(), new MsgSenderPair<>(vertex.getName(), receivedSet.copy()));
                }
                nonTriangles.add(receivedSet);
            }
            System.out.println("STEP1: " + vertex.getName() + " "+ nonTriangles);
        } else if (superstep == 2) {
            Iterator<NamesSet> it = nonTriangles.iterator();
            System.out.println("NT: " + vertex.getName() + " " + nonTriangles);
            while (it.hasNext()) {
                NamesSet candidate = it.next();
                // Non-cyclic condition
                for (MsgSenderPair<NamesSet> pair : inbox) {
                    NamesSet receivedSet = pair.getMsg();
                    System.out.println("REC: "+ vertex.getName() + " " + receivedSet);
                    NamesSet candidateCopy = candidate.copy();
                    if (candidateCopy.merge(receivedSet)) {
                        //it.remove();
                        triangles.add(candidateCopy);
                        System.out.println("TRI: "+ vertex.getName() + " " + candidate);
                        System.out.println("TRIS: "+ triangles);
                        // break;
                    }
                }
                // Cyclic condition
                NamesSet candidateCopy = candidate.copy();
                if (candidateCopy.merge(vertex.getName(), outgoingEdges)) {
                    //it.remove();
                    triangles.add(candidateCopy);
                }
            }
        }

    }

    @Override
    public HashSet<HashSet<String>> getResult() {
        System.out.println("RESULTS" + mySelf + ": " + triangles);
        HashSet<HashSet<String>> results = new HashSet<>();
        for (NamesSet t : triangles) {
            results.add(t.getNames());
        }
        return results;
    }

    @Override
    public HashSet<HashSet<String>> mergeResults(Set<HashSet<HashSet<String>>> results) {
        HashSet<HashSet<String>> result = new HashSet<>();
        for (HashSet<HashSet<String>> set : results) {
            for (HashSet<String> triangle : set) {
                result.add(triangle);
            }
        }
        return result;
    }

}
