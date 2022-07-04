package taskmanager;

import akka.actor.AbstractActor;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import shared.graph.*;
import shared.messages.GraphAction.ExtractMsg;
import shared.messages.GraphAction.PartitionMsg;
import shared.messages.GraphAction.SelectMsg;
import shared.messages.graphchanges.*;
import shared.messages.vertexcentric.*;
import shared.model.enumerators.Modifier;
import shared.vertexcentric.InOutboxImpl;
import shared.vertexcentric.VertexCentricComputation;


import java.io.Serializable;
import java.util.*;
import java.util.function.Supplier;

public class WorkerActor  extends AbstractActor {
    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);
    private final int workerId;

    //name of vertex, <timestamp, object of vertex>
    private final Map<String, HashMap<Long, Vertex>> vertices = new HashMap<>();
    //name of edge, <timestamp, set of edges>
    private final Map<String, HashMap<Long, Set<Edge>>> edges = new HashMap<>();

    //name of selected vertex, <timestamp, object of vertex>
    private final Map<String, Vertex> selVertices = new HashMap<>();
    //key is the property to partition and vertex
    private final Map<String, Set<Vertex>> partVertices = new HashMap<>();

    private final Map<String,HashMap<String, String>> extractVertices = new HashMap<>();


    //name of selected vertex, <timestamp, object of vertex>
    private final Map<String, Set<Edge>> selEdges = new HashMap<>();

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
              //  match(UpdateEdgeMsg.class, this::onUpdateEdgeMsg). //
                match(InstallComputationMsg.class, this::onInstallComputationMsg). //
                match(SelectMsg.class, this::onSelectMsg).
                match(PartitionMsg.class, this::onPartitionMsg).
                match(ExtractMsg.class, this::onExtractMsg).
                match(StartComputationMsg.class, this::onStartComputationMsg). //
                match(ComputationMsg.class, this::onComputationMsg). //
                match(ResultRequestMsg.class, this::onResultRequestMsg). //
                build();
    }






    private final void onAddVertexMsg(AddVertexMsg msg) {

        try {
            HashMap<Long, Vertex> vertexTimeCol;
            Boolean isInsertable=false;

    /*        if(msg.getName().equals("v1")){

                String vName=msg.getName();
            }
*/
            //If vertex is already in the store
            if(vertices.containsKey(msg.getName())){
                //find if the last state of vertex was deleted
                vertexTimeCol= vertices.get(msg.getName());

                //and if it has last delete status
                if(vertexUtility.isDeletedVertex(vertexTimeCol)){
                    isInsertable=true;
                }
                //otherwise its a duplicate kay do nothing
                else{
                    log.info("Duplicate key, no action performed");
                }
            }
            //if vertex does not exist create a new key, value pair and add it into vertex store
            else{
                vertexTimeCol = new HashMap<Long, Vertex>();
                isInsertable=true;
            }



            if(isInsertable){
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



               for( Vertex item:vertexTimeCol.values()){

                   modVertex=(Vertex) item.clone();



               }


                //if vertex is already deleted
                if(vertexUtility.isDeletedVertex(vertexTimeCol)){
                    log.info("Key already deleted");
                }
                //otherwise delete the vertex
                else{
                    modVertex.setIsDeleted(true);
                    //remove the existing context and store it back with modified property
                    vertexTimeCol.put(msg.timestamp(), modVertex);
                    vertices.remove(msg.getName());
                    vertices.put(msg.getName(), vertexTimeCol);


                    //delete all the edges going out from that vertex
                    HashMap<Long, Set<Edge>> edgeList=edges.get(msg.getName());


                    if(edgeList!=null){
                        Set<Edge> setEdges=edgeList.get(edgeList.size()-1);

                        Set<Edge> newsetEdges=new HashSet<>();
                        for (Edge e : setEdges) {
                            e.setIsDeleted(true);
                            newsetEdges.add(e);
                        }

                        edgeList.put(msg.timestamp(),newsetEdges);
                        edges.remove(msg.getName());
                        edges.put(msg.getName(),edgeList);
                    }

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
                if(vertexUtility.isDeletedVertex(vertexTimeCol)){
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


            if(!vertices.isEmpty()){
                HashMap<Long, Vertex> vertexColl=  vertices.get(msg.getSource());
                HashMap<Long, Set<Edge>> edgeSetColl= new HashMap<>();
                Set<Edge> edgeColl= new HashSet<>();
                Edge e= new Edge();


                //check if source vertex exists and is not deleted
                if(vertices.containsKey(msg.getSource()) && !vertexUtility.isDeletedVertex(vertexColl)){

                    //if the edge already exists
                    edgeSetColl=edges.get(msg.getSource());
                    e = new Edge(msg.getSource(), msg.getDestination(),msg.getState());

                    //check if there are no matching edges before
                    if(edgeSetColl==null){
                        edgeSetColl= new HashMap<>();
                        edgeColl.add(e);
                        edgeSetColl.put(msg.timestamp(), edgeColl);
                        edges.put(msg.getSource(), edgeSetColl);

                    }
                    //if edge does not exists simply add it without checking any thing
                    else{


                                //get the last time instance
                                edgeColl =vertexUtility.getLastEdgeSet(edgeSetColl);

                                 if(edgeColl.contains(e)){
                                     //if the given edge is in the deletion state
                                                 if (vertexUtility.isEdgeDeleted(edgeColl, e)) {
                                                             //remove and add the edge back to set its deletion state to true
                                                             edgeColl.remove(e);
                                                             edgeColl.add(e);

                                                             //update the edges collection with the new edge
                                                             edgeSetColl.put(msg.timestamp(), edgeColl);

                                                             edges.remove(msg.getSource());
                                                             edges.put(msg.getSource(), edgeSetColl);


                                                 } else{

                                                     log.info("The edge already exists");

                                                 }

                                      }
                                 else{
                                     edgeColl.add(e);
                                     edgeSetColl.put(msg.timestamp(), edgeColl);
                                     edges.remove(msg.getSource());
                                     edges.put(msg.getSource(),edgeSetColl);


                                 }


                               }

                }
                else{
                    log.info("The source vertex for edge does not exist or is in delete state");
                }


            }
            else{
                log.info("The source vertex does not exist");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }



        log.info(edges.toString());


    }





 private final void onDelEdgeMsg(DelEdgeMsg msg) {
        log.info(msg.toString());

        try{

            HashMap<Long, Set<Edge>> edgeSetColl= new HashMap<>();
            HashMap<Long, Vertex> vertexColl=  vertices.get(msg.getSource());
            Set<Edge> edgeColl= new HashSet<>();
            Set<Edge> newedgeColl= new HashSet<>();
            Edge e= new Edge();

           //if the vertex exists and is not deleted
            if(vertices.containsKey(msg.getSource()) && !vertexUtility.isDeletedVertex(vertexColl)){

                        //if the edge exists
                        edgeSetColl=edges.get(msg.getSource());
                        e = new Edge(msg.getSource(), msg.getDestination());

                        //if the edge collection is empty
                        if(edgeSetColl==null){
                            log.info("The edge does not exist");
                        }
                        else{
                            edgeColl=vertexUtility.getLastEdgeSet(edgeSetColl);

                                   //to delete an edge the edge must exist and is not already deleted
                                    if(edgeColl.contains(e) && !vertexUtility.isEdgeDeleted(edgeColl, e)){

                                        //iterate through
                                        for(Edge eVal:edgeColl){

                                            if(eVal.equals(e)){
                                               e.setIsDeleted(true);
                                                newedgeColl.add(e);

                                            }else{
                                                newedgeColl.add(eVal);

                                            }

                                        }


                                        edgeSetColl.put(msg.timestamp(), newedgeColl);
                                        edges.put(msg.getSource(),edgeSetColl);


                                    }
                                    else{
                                        log.info("The edge does not exist or is already deleted");

                                    }
                        }



            }else{
                log.info("The source vertex does not exist or deleted");
            }


        }
        catch (Exception exp){
            log.info(exp.getMessage());
        }

        log.info(edges.toString());
    }



   /* private final void onUpdateEdgeMsg(UpdateEdgeMsg msg) {
        log.info(msg.toString());
        HashMap<Long, Edge> edgeTimeCol;
        try{
            // the edge must exist before it could be updated
            if(edges.containsKey(msg.getSource())){
                //retrieve existing context
//                edgeTimeCol=  edges.get(msg.getSource());
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
//                    edges.put(msg.getSource(), edgeTimeCol);
                }

            } else {
                log.info("Key not found for given edge");
            }

        }
        catch (Exception exp){
            log.info(exp.getMessage());
        }

        log.info(edges.toString());
    }*/

    private final void onInstallComputationMsg(
            InstallComputationMsg<? extends Serializable, ? extends Serializable> msg) {
        log.info("The installation message at worker "+msg.toString());
        computationsSupplier = msg.getComputationSupplier();


    }

    private final void onSelectMsg(SelectMsg msg){
        log.info(msg.toString());

                switch(msg.getModType()) {
                    case VERTEX:
                        Modifier m1=msg.getModType();
                     if(vertices!=null){
                            for(Map.Entry<String, HashMap<Long, Vertex>> vEntry:vertices.entrySet()){
                                       String vName= vEntry.getKey();


                                       HashMap<Long, Vertex> vTimeStore= vEntry.getValue();
                                       Vertex vertex=(Vertex) vTimeStore.entrySet().stream().reduce((prev, next) -> next).orElse(null).getValue();


                                if(vertex!=null){
                                           if(!vertex.getIsDeleted()){
                                               GraphState graphState=vertex.getState();
                                              Map<String, String[]> attributes=graphState.getAttributes();


                                              for(Map.Entry<String, String[]> attEntry:attributes.entrySet()){
                                                 if(attEntry.getKey().equals(msg.getVarName())){

                                                        String[] valEntries=attEntry.getValue();

                                                        String oprandName=msg.getOprandName();
                                                     switch(msg.getOperator()) {
                                                         case EQUAL:
                                                               if(valEntries[0].equals(oprandName)){
                                                                   selVertices.put(vName, vertex);
                                                               }

                                                             break;
                                                         case GREATER:
                                                             if(Integer.parseInt(valEntries[0])>Integer.parseInt(oprandName)){
                                                                 selVertices.put(vName, vertex);
                                                             }
                                                             break;

                                                         case LESS:
                                                             if(Integer.parseInt(valEntries[0])<Integer.parseInt(oprandName)){
                                                                 selVertices.put(vName, vertex);
                                                             }
                                                             break;

                                                         case GREATEREQUAL:
                                                             if(Integer.parseInt(valEntries[0])>=Integer.parseInt(oprandName)){
                                                                 selVertices.put(vName, vertex);
                                                             }
                                                             break;

                                                         case LESSEQUAL:
                                                             if(Integer.parseInt(valEntries[0])<=Integer.parseInt(oprandName)){
                                                                 selVertices.put(vName, vertex);
                                                             }
                                                             break;

                                                     }

                                                 }
                                              }

                                           }
                                   }


                            }
                      }

                        break;
                    case EDGE:
                        Modifier m2=msg.getModType();


                        if(edges!=null){
                                for(Map.Entry<String, HashMap<Long, Set<Edge>>> eEntry:edges.entrySet()){
                                            String eName= eEntry.getKey();


                                            HashMap<Long, Set<Edge>> eTimeStore= eEntry.getValue();

                                            Set<Edge> edgesSet= eTimeStore.entrySet().stream().reduce((prev, next) -> next).orElse(null).getValue();
                                            Set<Edge> selEdgesSet= new HashSet<Edge>();
                                            for(Edge edgeElement:edgesSet){
                                                    if(edges!=null) {
                                                            if (!edgeElement.getIsDeleted()) {
                                                                GraphState graphState=edgeElement.getState();
                                                                Map<String, String[]> attributes=graphState.getAttributes();

                                                                        for(Map.Entry<String, String[]> attEntry:attributes.entrySet()) {
                                                                            if (attEntry.getKey().equals(msg.getVarName())) {
                                                                                String[] valEntries=attEntry.getValue();
                                                                                selEdges.clear();

                                                                                String oprandName=msg.getOprandName();
                                                                                switch(msg.getOperator()) {
                                                                                    case EQUAL:
                                                                                        if(valEntries[0].equals(oprandName)){

                                                                                            selEdgesSet.add(edgeElement);
                                                                                        }

                                                                                        break;
                                                                                    case GREATER:
                                                                                        if(Integer.parseInt(valEntries[0])>Integer.parseInt(oprandName)){
                                                                                            selEdgesSet.add(edgeElement);
                                                                                        }
                                                                                        break;

                                                                                    case LESS:
                                                                                        if(Integer.parseInt(valEntries[0])<Integer.parseInt(oprandName)){
                                                                                            selEdgesSet.add(edgeElement);
                                                                                        }
                                                                                        break;

                                                                                    case GREATEREQUAL:
                                                                                        if(Integer.parseInt(valEntries[0])>=Integer.parseInt(oprandName)){
                                                                                            selEdgesSet.add(edgeElement);
                                                                                        }
                                                                                        break;

                                                                                    case LESSEQUAL:
                                                                                        if(Integer.parseInt(valEntries[0])<=Integer.parseInt(oprandName)){
                                                                                            selEdgesSet.add(edgeElement);
                                                                                        }
                                                                                        break;

                                                                                }
                                                                                //selected edges
                                                                                if(selEdgesSet.size()!=0){
                                                                                    selEdges.put(eName,selEdgesSet);
                                                                                }


                                                                            }
                                                                         }
                                                            }
                                                    }

                                            }


                                }

                        }
                        break;

                }





        for(Map.Entry<String, Set<Edge>> entryEdge:selEdges.entrySet()){
          Set<Edge> entrySetEdge=entryEdge.getValue();

          for(Edge edgeSetEdge:entrySetEdge){
              log.info(edgeSetEdge.toString());
          }

        }

    }


    private final void onPartitionMsg(PartitionMsg msg){
        log.info(msg.toString());

            switch (msg.getModType()) {
                case VERTEX:
                    if(vertices!=null){
                        for(Map.Entry<String, HashMap<Long, Vertex>> vEntry:vertices.entrySet()){
                            String vName= vEntry.getKey();



                            HashMap<Long, Vertex> vTimeStore= vEntry.getValue();
                            Vertex vertex=(Vertex) vTimeStore.entrySet().stream().reduce((prev, next) -> next).orElse(null).getValue();

                            if(vertex!=null) {
                                if (!vertex.getIsDeleted()) {
                                    GraphState graphState = vertex.getState();
                                    Map<String, String[]> attributes = graphState.getAttributes();
                                    String groupBy=   msg.getGroupBy();
                                    String[] partAttribute=attributes.get(groupBy);

                                    if(partVertices.containsKey(partAttribute[0].toString())){
                                        Set<Vertex> setVertices= partVertices.get(partAttribute[0].toString());
                                        setVertices.add(vertex);
                                        partVertices.remove(partAttribute[0].toString());
                                        partVertices.put(partAttribute[0].toString(),setVertices);
                                    }else{
                                        Set<Vertex> setVertices=new HashSet<>();
                                        setVertices.add(vertex);
                                        partVertices.put(partAttribute[0].toString(),setVertices);

                                    }



                                }
                            }

                        }
                    }


                    break;
                case EDGE:
                    if(edges!=null) {
                        for (Map.Entry<String, HashMap<Long, Set<Edge>>> eEntry : edges.entrySet()) {
                            String eName = eEntry.getKey();


                            HashMap<Long, Set<Edge>> eTimeStore = eEntry.getValue();

                            Set<Edge> edgesSet = eTimeStore.entrySet().stream().reduce((prev, next) -> next).orElse(null).getValue();
                            Set<Edge> selEdgesSet = new HashSet<Edge>();




                        }
                    }


                    break;


            }






    }



    private final void onExtractMsg(ExtractMsg msg) {



            switch (msg.getModType()) {
                case VERTEX:
                    if (vertices != null && vertices.size()!=0) {
                      String freeVar= msg.getFreeVar();

                           for(Map.Entry<String, HashMap<Long, Vertex>> vEntry:vertices.entrySet()){
                               HashMap<Long, Vertex> vTimeStore= vEntry.getValue();
                               Vertex vertex= vTimeStore.entrySet().stream().reduce((prev, next) -> next).orElse(null).getValue();
                               if(!vertex.getIsDeleted()){
                                       String name=vertex.getName();
                                       Map<String, String[]> attributes=vertex.getState().getAttributes();
                                       HashMap<String,String> attributeSet = new HashMap<String,String>();
                                       String[] attributeValSet;
                                       for(Map.Entry<String, String[]> attributeItem: attributes.entrySet()){
                                           if(attributeItem.getKey().equals(freeVar)){
                                               attributeValSet= attributeItem.getValue();
                                               attributeSet.put(attributeItem.getKey(), attributeValSet[0]);
                                           }
                                       }
                                       extractVertices.put(name,attributeSet);
                               }
                           }

                    }

                case EDGE:
                    if (edges != null && edges.size()!=0) {

                            for(Map.Entry<String,HashMap<Long, Set<Edge>>> eEntry:edges.entrySet()){

                                HashMap<Long, Set<Edge>> eTimeStore= eEntry.getValue();

                                Set<Edge> setEdge= eTimeStore.entrySet().stream().reduce((prev, next) -> next).orElse(null).getValue();

                                for(Edge edgeElement:setEdge) {
                                    if (edges != null) {
                                        if (!edgeElement.getIsDeleted()) {

                                        }
                                    }
                                }


                            }

                    }
            }


    }




    private final void onStartComputationMsg(StartComputationMsg msg) {
        log.info(msg.toString());

        try{
                    final InOutboxImpl box = new InOutboxImpl<>();
                    final Set results = new HashSet<>();


                    if (computationsSupplier != null) {

                              for ( final Map.Entry<String, HashMap<Long, Vertex>> vertexTimeStore : vertices.entrySet()) {
                                    String vertexName= vertexTimeStore.getKey();

                                    //get the vertex in given time context, which for now is taken as current time stamp
                                    HashMap<Long, Vertex> timeValueSet=vertexTimeStore.getValue();
                                    Collection<Vertex> vertexCol= timeValueSet.values();
                                    Vertex vertex=  vertexCol.stream().reduce((prev, next) -> next).orElse(null);

                                        //if vertex exists in the current time context
                                        if(!vertex.getIsDeleted()){
                                            if (computationsSupplier != null) {
                                                computations.put(vertexName,
                                                        (VertexCentricComputation<? extends Serializable, ? extends Serializable>) computationsSupplier.get());
                                            }

                                            if(!edges.isEmpty() && edges!=null){
                                                HashMap<Long, Set<Edge>> edgeTimeStore=  edges.get(vertexName);
                                                   if(edgeTimeStore!=null){
                                                      Set<Long> timeKey= edgeTimeStore.keySet();
                                                      long lastKey= timeKey.stream().reduce((first, second) -> second).orElse(null);

                                                       Set<Edge> edgeSet=  edgeTimeStore.get(lastKey);

                                                       computations.get(vertexName).startIteration(vertex,edgeSet ,box,results,msg.getTimestamp());
                                                   }
                                            }


                                        }

                              }

                    }
                    else{
                       sender().tell(new FailedComputationMsg(), self());
                    }

                     sender().tell(new ComputationMsg<>(box, 0, false), self());

        }
        catch(Exception e){
            log.info(e.getMessage());
        }

    }


    private final void onComputationMsg(ComputationMsg<? extends Serializable> msg) {
        log.info(msg.toString());
        final InOutboxImpl outbox = new InOutboxImpl();
        for (final String recipientName : msg.recipients()) {
            if (!vertices.containsKey(recipientName)) {
                continue;
            }


            final HashMap<Long, Vertex> recipientStore = vertices.get(recipientName);

            Collection<Vertex> recipientCol= recipientStore.values();
            Vertex recipient=  recipientCol.stream().reduce((prev, next) -> next).orElse(null);


            HashMap<Long, Set<Edge>> outgoingEdgesTimeStore=  edges.get(recipientName);

            final VertexCentricComputation<? extends Serializable, ? extends Serializable> comp = computations
                    .get(recipientName);

            final List inbox = msg.messagesFor(recipientName);
            final Set output = new HashSet();


            if(outgoingEdgesTimeStore!=null){
                Set<Long> timeKey= outgoingEdgesTimeStore.keySet();
                long lastKey= timeKey.stream().reduce((first, second) -> second).orElse(null);

                Set<Edge> outgoingEdges=  outgoingEdgesTimeStore.get(lastKey);

                /*if(edges.containsKey("v3") && msg.getSuperstep()==2){

                    HashMap<Long, Set<Edge>> str= edges.get("v3");
                }
              */
                comp.iterate(recipient, outgoingEdges, inbox, outbox, output, msg.getSuperstep());
            }


        }
        sender().tell(new ComputationMsg<>(outbox, msg.getSuperstep(), false), self());
    }




    private final void onResultRequestMsg(ResultRequestMsg msg) {
        log.info(msg.toString());

        if(edges.containsKey("v3")){

            HashMap<Long, Set<Edge>> str= edges.get("v3");
        }



        VertexCentricComputation c = null;
        Set<HashSet<HashSet<String>>> results = new HashSet<>();
            for (VertexCentricComputation comp : computations.values()) {
                c = comp;
                HashSet<HashSet<String>> msgResult = (HashSet<HashSet<String>>) comp.getResult();
                results.add(msgResult);
            }

            if (c != null) {
                HashSet<HashSet<String>> finalResult = (HashSet<HashSet<String>>) c.mergeResults(results);
                sender().tell(new ResultReplyMsg(finalResult), self());
            } else {
                sender().tell(new ResultReplyMsg(new HashSet<HashSet<String>>()), self());
            }
    }





    public static final Props props(int workerId) {
        return Props.create(WorkerActor.class, workerId);
    }

}
