package shared.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GraphUtility {

    public boolean isDeletedVertex(HashMap<Long, Vertex> vertexTimeCol){

        Vertex vertex= new Vertex();
        for(Map.Entry<Long, Vertex> entry: vertexTimeCol.entrySet() ){
            vertex=entry.getValue();
        }

        return vertex.getIsDeleted();
    }


    public Set<Edge> getLastEdgeSet(HashMap<Long, Set<Edge>> edgeSetColl){

       Set<Edge> lastEntry=new HashSet<>();
       for(Map.Entry <Long, Set<Edge>> singleEntry: edgeSetColl.entrySet()){
           lastEntry=singleEntry.getValue();

        }

       return lastEntry;

    }


    public boolean isEdgeDeleted(Set<Edge> setEdges, Edge e1){

        Boolean isDetected;

        for (Edge e : setEdges) {
           if (e.equals(e1) && e.getIsDeleted()) {
                   isDetected=true;
                   break;
           }
           else
               isDetected=false;

        }
         return false;

    }






}
