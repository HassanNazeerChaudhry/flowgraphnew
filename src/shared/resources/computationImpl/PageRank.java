package shared.resources.computationImpl;

import akka.japi.Pair;
import shared.computation.Computation;
import shared.computation.Vertex;
import shared.data.StepMsg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Implementation of PageRank working on DirectedGraphs
 *
 * PageRank with convergence condition
 * Convergence condition
 * The sum of Ranks is equal to numberOfVertices if numberVertices parameter isn't specified
 *
 * Parameters:
 *          0: maxIterations (default = 100)
 *          1: dumpingFactor (default = 0.85)
 *          2: numberVertices (default = 1)
 *          3: threshold (default 0.0)
 *
 * Return Values :
 *          0: Rank label name
 */
public class PageRank extends Computation {

    private int maxNumOfIterations;
    private double initialValue;
    private double threshold;
    private double dumpingFactor;
    private double aFactor; // equal to ( 1 - dumpingFactor )

    private HashMap<String, Double> ranks;
    private HashMap<String, HashMap<String, Double>> receivedRanks;

    @Override
    public List<StepMsg> iterate(Vertex vertex, List<StepMsg> incoming, int iterationStep) {

        if (iterationStep == 1) {
            receivedRanks.put(vertex.getNodeId(), new HashMap<>());
        }

        //Calculate new weight for current vertex
        double sum = 0;
        HashMap<String, Double> incomingRanks = receivedRanks.get(vertex.getNodeId());
        for (StepMsg msg : incoming) {
            incomingRanks.put(msg.originVertex, (Double)msg.computationValues);
        }

        for (double w : incomingRanks.values()) {
            sum = sum + w;
        }
        double newWeight = aFactor + dumpingFactor * sum;

        //Stop conditions
        if (newWeight - ranks.get(vertex.getNodeId()) <= threshold || iterationStep >= maxNumOfIterations) {
            ranks.put(vertex.getNodeId(), newWeight );
            voteToHalt();
            return null;
        }

        ranks.put(vertex.getNodeId(), newWeight );

        //Send weight
        List<StepMsg> outbox = new ArrayList<>();
        Double weightToSend = newWeight / vertex.getEdges().length;

        for (String dest: vertex.getEdges()) {
            outbox.add(new StepMsg(dest, vertex.getNodeId(), weightToSend));
        }
        return outbox;

    }

    @Override
    public List<StepMsg> firstIterate(Vertex vertex) {

        List<StepMsg> outbox = new ArrayList<>();
        double weightToSend =  initialValue / vertex.getEdges().length;
        this.ranks.put(vertex.getNodeId(), aFactor);

        for (String dest: vertex.getEdges()) {
            outbox.add(new StepMsg(dest, vertex.getNodeId(), weightToSend));
        }
        voteToHalt();
        return outbox;
    }

    @Override
    public List<Pair<String, String[]>> computeResults(Vertex vertex) {

        List<Pair<String, String[]>> returnLabels = new ArrayList<>();

        returnLabels.add(new Pair<>(
                this.computationParameters.returnVarNames().get(0),
                new String[]{String.valueOf(this.ranks.get(vertex.getNodeId()))}
                ));

        return returnLabels;
    }

    @Override
    public void preStart() {

        String maxNumOfIterations = computationParameters.getParameter("maxIterations");
        String dumpingFactor = computationParameters.getParameter("dumpingFactor");
        String numberVertices = computationParameters.getParameter("numberVertices");
        String threshold = computationParameters.getParameter("threshold");

        try {
            this.maxNumOfIterations = Integer.parseInt(maxNumOfIterations);
        } catch (NullPointerException |NumberFormatException e) {
            this.maxNumOfIterations = 100;
        }

        try {
            this.dumpingFactor = Double.parseDouble(dumpingFactor);
        } catch (NullPointerException |NumberFormatException e) {
            this.dumpingFactor = 0.85;
        }

        try {
            this.initialValue = 1.0 / Integer.parseInt(numberVertices);
        } catch (NullPointerException |NumberFormatException e) {
            this.initialValue = 1.0;
        }

        try {
            this.threshold = Double.parseDouble(threshold);
        } catch (NullPointerException |NumberFormatException e) {
            this.threshold = 0.0;
        }

        this.aFactor = 1.0 - this.dumpingFactor;
        this.ranks = new HashMap<>();
        this.receivedRanks = new HashMap<>();

    }
}
