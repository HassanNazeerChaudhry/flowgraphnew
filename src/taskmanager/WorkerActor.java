package taskmanager;

import akka.actor.AbstractActor;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import shared.graph.*;
import shared.messages.graphchanges.*;
import shared.messages.vertexcentric.InstallComputationMsg;
import shared.messages.vertexcentric.StartComputationMsg;
import shared.vertexcentric.InOutboxImpl;
import shared.vertexcentric.VertexCentricComputation;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

public class WorkerActor  extends AbstractActor {
    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);
    private final int workerId;

    //name of vertex, <timestamp, object of vertex>
    private final Map<String, HashMap<Long, Vertex>> vertices = new HashMap<>();
    //name of edge, <timestamp, set of edges>
    private final Map<String, HashMap<Long, Edge>> edges = new HashMap<>();


    // Iterative vertex centric computation
    private final Map<String, VertexCentricComputation<? extends Serializable, ? extends Serializable>> computations = new HashMap<>();
    private Supplier<?> computationsSupplier = null;


    GraphUtility vertexUtility= new GraphUtility();



    private WorkerActor(int workerId) {
        this.workerId = workerId;
    }


    @Override
    public Receive createReceive() {
        return receiveBuilder().
                match(AddVertexMsg.class, this::onAddVertexMsg). //
                match(DelVertexMsg.class, this::onDelVertexMsg). //
                match(UpdateVertexMsg.class, this::onUpdateVertexMsg). //
                match(AddEdgeMsg.class, this::onAddEdgeMsg). //
                match(DelEdgeMsg.class, this::onDelEdgeMsg). //
                match(UpdateEdgeMsg.class, this::onUpdateEdgeMsg). //
                match(InstallComputationMsg.class, this::onInstallComputationMsg). //
                match(StartComputationMsg.class, this::onStartComputationMsg). //
                build();
    }






    private final void onAddVertexMsg(AddVertexMsg msg) {

        try {
            HashMap<Long, Vertex> vertexTimeCol;

            //If vertex is already in the store
            if(vertices.containsKey(msg.getName())){
                //find if the last state of vertex was deleted
                vertexTimeCol= vertices.get(msg.getName());
                Vertex vertex= new Vertex();
                //and if it has last delete status
                if(vertexUtility.isDeletedVertex(vertexTimeCol,vertex)){
                    vertexTimeCol.put(msg.timestamp(), msg.getVertex());
                    vertices.put(msg.getName(), vertexTimeCol);
                }
                //otherwise its a duplicate kay do nothing
                else{
                    log.info("Duplicate key, no action performed");
                }

            }
            //if vertex does not exist create a new key, value pair and add it into vertex store
            else{
                vertexTimeCol = new HashMap<Long, Vertex>();
                vertexTimeCol.put(msg.timestamp(), msg.getVertex());
                vertices.put(msg.getName(), vertexTimeCol);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        log.info(vertices.toString());
    }

    private final void onDelVertexMsg(DelVertexMsg msg) {
        log.info(msg.toString());

        HashMap<Long, Vertex> vertexTimeCol;
        try{
            // the vertex must exist before it could be deleted
            if(vertices.containsKey(msg.getName())){
                //retrieve the existing context
                vertexTimeCol=vertices.get(msg.getName());
                Vertex modVertex= new Vertex();


                //if vertex is already deleted
                if(vertexUtility.isDeletedVertex(vertexTimeCol,modVertex)){
                    log.info("Key already deleted");
                }
                //otherwise delete the vertex
                else{
                    modVertex.setIsDeleted(true);
                    //replish the existing context and store it back with modified property
                    vertexTimeCol.put(msg.timestamp(), modVertex);
                    vertices.remove(msg.getName());
                    vertices.put(msg.getName(), vertexTimeCol);
                }

            }
            else {
                log.info("Key not found for given Vertex");
            }

        }
        catch (Exception exp){
            log.info(exp.getMessage());
        }

        log.info(vertices.toString());
    }


    private final void onUpdateVertexMsg(UpdateVertexMsg msg) {
        log.info(msg.toString());

        HashMap<Long, Vertex> vertexTimeCol;
        try{
            // the vertex must exist before it could be updated
            if(vertices.containsKey(msg.getName())){
                //retrieve existing context
                vertexTimeCol=vertices.get(msg.getName());
                Vertex modVertex= new Vertex();

                //if vertex is already deleted
                if(vertexUtility.isDeletedVertex(vertexTimeCol,modVertex)){
                    log.info("Deleted key can't be updated");
                }
                //otherwise delete the vertex
                else{
                    //update the existing context with the next one
                    vertexTimeCol.put(msg.timestamp(), msg.getVertex());
                    //delete existing context and insert back with the updated context
                    vertices.remove(msg.getName());
                    vertices.put(msg.getName(), vertexTimeCol);
                }

            } else {
                log.info("Key not found for given Vertex");
            }

        }
        catch (Exception exp){
            log.info(exp.getMessage());
        }

        log.info(vertices.toString());
    }





    private final void onAddEdgeMsg(AddEdgeMsg msg) {

        try{
            HashMap<Long, Edge> edgeTimeCol;
            //If edge is already in the store
            if(edges.containsKey(msg.getSource())){
                //find if the last state of vertex was deleted
                edgeTimeCol=  edges.get(msg.getSource());
                Edge edge= new Edge();


                //and if it has last delete status
                if(vertexUtility.isDeletedEdge(edgeTimeCol, edge)){
                    edgeTimeCol.put(msg.timestamp(), new Edge(msg.getSource(), msg.getDestination()));
                    edges.put(msg.getSource(), edgeTimeCol);
                }
                //otherwise its a duplicate kay do nothing
                else{
                    log.info("Duplicate key, no action performed");
                }

            }
            //if edge does not exist create a new key, value pair and add it into edge store
            else{
                edgeTimeCol = new HashMap<Long,Edge>();
                edgeTimeCol.put(msg.timestamp(), new Edge(msg.getSource(), msg.getDestination()));
                edges.put(msg.getSource(), edgeTimeCol);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        log.info(edges.toString());
    }

    private final void onDelEdgeMsg(DelEdgeMsg msg) {
        log.info(msg.toString());
        HashMap<Long, Edge> edgeTimeCol;
        try{
            // the vertex must exist before it could be deleted
            if(edges.containsKey(msg.getSource())){
                //retrieve the existing context
                edgeTimeCol=  edges.get(msg.getSource());
                Edge modEdge= new Edge(msg.getSource(), msg.getDestination());


                //if vertex is already deleted
                if(vertexUtility.isDeletedEdge(edgeTimeCol, modEdge)){
                    log.info("Key already deleted");
                }
                //otherwise delete the vertex
                else {
                    //set the property to delete
                    modEdge.setIsDeleted(true);
                    //delete the existing context and store it back with modified property
                    edgeTimeCol.put(msg.timestamp(), modEdge);
                    edges.remove(msg.getSource());
                    edges.put(msg.getSource(),edgeTimeCol);
                }


            }
            else {
                log.info("Key not found for given Edge");
            }

        }
        catch (Exception exp){
            log.info(exp.getMessage());
        }

        log.info(edges.toString());
    }



    private final void onUpdateEdgeMsg(UpdateEdgeMsg msg) {
        log.info(msg.toString());
        HashMap<Long, Edge> edgeTimeCol;
        try{
            // the edge must exist before it could be updated
            if(edges.containsKey(msg.getSource())){
                //retrieve existing context
                edgeTimeCol=  edges.get(msg.getSource());
                Edge modEdge= new Edge(msg.getSource(), msg.getDestination());

                //the deleted edge can't be updated
                if(vertexUtility.isDeletedEdge(edgeTimeCol, modEdge)){
                    log.info("Deleted key can't be updated");
                }
                //otherwise update the edge
                else{
                    //update the existing context with the next one
                    edgeTimeCol.put(msg.timestamp(), new Edge(msg.getSource(), msg.getDestination()));
                    //delete existing context and insert back with the updated context
                    edges.remove(msg.getSource());
                    edges.put(msg.getSource(), edgeTimeCol);
                }

            } else {
                log.info("Key not found for given edge");
            }

        }
        catch (Exception exp){
            log.info(exp.getMessage());
        }

        log.info(edges.toString());
    }

    private final void onInstallComputationMsg(
            InstallComputationMsg<? extends Serializable, ? extends Serializable> msg) {
        log.info("The installation message at worker "+msg.toString());
        computationsSupplier = msg.getComputationSupplier();


    }

    private final void onStartComputationMsg(StartComputationMsg msg) {
        log.info(msg.toString());

    }


    public static final Props props(int workerId) {
        return Props.create(WorkerActor.class, workerId);
    }

}
