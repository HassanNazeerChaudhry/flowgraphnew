package shared.vertexcentric;

import shared.graph.Edge;
import shared.graph.Vertex;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

public abstract class VertexCentricComputation<MsgType extends Serializable, OutputType extends Serializable>
        implements Serializable {
    private static final long serialVersionUID = 1093114867982442180L;

    /**
     * Start an iteration, triggered when a change occurs.
     *
     * @param vertex
     *          The vertex.
     * @param outgoingEdges
     *          The outgoing edges.
     * @param outbox
     *          The outbox for messages to other vertices.
     * @param output
     *          The results of the computation (if any).
     * @param timestamp
     *          The current timestamp.
     */
    public abstract void startIteration(Vertex vertex, Set<Edge> outgoingEdges, Outbox<MsgType> outbox,
                                        Set<OutputType> output, long timestamp);

    /**
     * Performs an iteration in an iterative computation. It can trigger an
     * iterative computation by producing some messages for other vertices and/or
     * produce some output.
     *
     * @param vertex
     *          The vertex.
     * @param outgoingEdges
     *          The outgoing edges.
     * @param inbox
     *          The incoming messages from other vertices.
     * @param outbox
     *          The outbox for messages to other vertices.
     * @param output
     *          The results of the computation (if any).
     * @param superstep
     *          The current superstep (starting from 0).
     */
    public abstract void iterate(Vertex vertex, Set<Edge> outgoingEdges, Collection<MsgSenderPair<MsgType>> inbox,
                                 Outbox<MsgType> outbox, Set<OutputType> output, int superstep);

    /**
     * Return the result of the computation for this vertex.
     *
     * @return The result of the computation for this vertex.
     */
    public abstract OutputType getResult();

    public abstract OutputType mergeResults(Set<OutputType> results);

}
