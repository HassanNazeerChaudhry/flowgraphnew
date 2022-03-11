package shared.graph;

import java.util.HashMap;
import java.util.Map;

public class GraphUtility {

    public boolean isDeletedVertex(HashMap<Long, Vertex> vertexTimeCol, Vertex vertex){


        for(Map.Entry<Long, Vertex> entry: vertexTimeCol.entrySet() ){
            vertex=entry.getValue();
        }

        return vertex.getIsDeleted();
    }


    public boolean isDeletedEdge(HashMap<Long, Edge> edgeTimeCol, Edge edge){

        for(Map.Entry<Long, Edge> entry: edgeTimeCol.entrySet() ){
            edge=entry.getValue();
        }

        return edge.getIsDeleted();
    }






}
