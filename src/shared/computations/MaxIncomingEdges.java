package shared.computations;
import shared.graph.Edge;
import shared.graph.Vertex;
import shared.vertexcentric.MsgSenderPair;
import shared.vertexcentric.Outbox;
import shared.vertexcentric.VertexCentricComputation;

import java.util.Collection;
import java.util.Set;


public class MaxIncomingEdges extends VertexCentricComputation<Integer, Integer> {
    private static final long serialVersionUID = 6607890356679716721L;

    private int maxIncomingEdges = 0;

    @Override
    public void startIteration(Vertex vertex, Set<Edge> outgoingEdges, Outbox<Integer> outbox, Set<Integer> output,
                               long timestamp) {
        // Send a message to all my neighbors
        for (final Edge outgoingEdge : outgoingEdges) {
            outbox.add(outgoingEdge.getDestination(), new MsgSenderPair<>(vertex.getName(), 1));
        }
    }

    @Override
    public void iterate(Vertex vertex, Set<Edge> outgoingEdges, Collection<MsgSenderPair<Integer>> inbox,
                        Outbox<Integer> outbox, Set<Integer> output, int superstep) {
        // In the first superstep, I collect the messages, compute my incoming
        // edges, and distribute the number to all neighbors.
        if (superstep == 1) {
            maxIncomingEdges = inbox.size();
            sendMaxToAllNeighbors(vertex, outgoingEdges, outbox);
            sendMaxAsOutput(output);
        }
        // In the next superstep, if the maximum from my neighbors is larger than
        // the currently known maximum, update the maximum and send it to all
        // neighbors
        else {
            inbox.stream(). //
                    map(p -> p.getMsg()). //
                    reduce(Math::max). //
                    ifPresent(max -> {
                if (max > maxIncomingEdges) {
                    maxIncomingEdges = max;
                    sendMaxToAllNeighbors(vertex, outgoingEdges, outbox);
                    sendMaxAsOutput(output);
                }
            });
        }
    }

    @Override
    public Integer getResult() {
        return maxIncomingEdges;
    }

    private final void sendMaxToAllNeighbors(Vertex vertex, Set<Edge> outgoingEdges, Outbox<Integer> outbox) {
        for (final Edge outgoingEdge : outgoingEdges) {
            outbox.add(outgoingEdge.getDestination(), new MsgSenderPair<>(vertex.getName(), maxIncomingEdges));
        }
    }

    private final void sendMaxAsOutput(Set<Integer> output) {
        output.add(maxIncomingEdges);
    }

    @Override
    public Integer mergeResults(Set<Integer> results) {
        int max = 0;
        for (int val : results) {
            if (val>max) {
                max = val;
            }
        }
        return max;
    }

}