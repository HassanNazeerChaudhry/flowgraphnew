package taskmanager;

import akka.actor.AbstractActor;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import shared.graph.Edge;
import shared.graph.Vertex;
import shared.messages.graphchanges.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WorkerActor  extends AbstractActor {
    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);
    private final int workerId;

    //name of vertex, <timestamp, object of vertex>
    private final Map<String, HashMap<Long, Vertex>> vertices = new HashMap<>();
    //name of edge, <timestamp, set of edges>
    private final Map<String, HashMap<Long, Edge>> edges = new HashMap<>();




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
                build();
    }




    private final void onAddVertexMsg(AddVertexMsg msg) {

        try {
            HashMap<Long, Vertex> vertexTimeCol;


            if(vertices.containsKey(msg.getName())){
                vertexTimeCol= vertices.get(msg.getName());




                log.info("Duplicate key encountered");
            }else{
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
            if(vertices.containsKey(msg.getName())){
                vertexTimeCol=vertices.get(msg.getName());
                Vertex modVertex= msg.getVertex();
                modVertex.setIsDeleted(true);
                vertexTimeCol.put(msg.timestamp(), modVertex);

                vertices.remove(msg.getName());
                vertices.put(msg.getName(), vertexTimeCol);
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
            if(vertices.containsKey(msg.getName())){
                vertexTimeCol=vertices.get(msg.getName());
                vertexTimeCol.put(msg.timestamp(), msg.getVertex());
                vertices.remove(msg.getName());
                vertices.put(msg.getName(), vertexTimeCol);
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
        HashMap<Long, Edge> edgeTimeCol;

        if (edges.containsKey(msg.getSource())){
            edgeTimeCol=  edges.get(msg.getSource());
        }else{
            edgeTimeCol = new HashMap<Long,Edge>();
        }

        edgeTimeCol.put(msg.timestamp(), new Edge(msg.getSource(), msg.getDestination()));
        edges.put(msg.getSource(), edgeTimeCol);
        log.info(edges.toString());
    }

    private final void onDelEdgeMsg(DelEdgeMsg msg) {
        log.info(msg.toString());

    }



    private final void onUpdateEdgeMsg(UpdateEdgeMsg msg) {
        log.info(msg.toString());

    }





    public static final Props props(int workerId) {
        return Props.create(WorkerActor.class, workerId);
    }

}
