package shared.model.clauseelement;

import shared.model.ClauseElement;

import java.util.ArrayList;
import java.util.List;

public class Extraction extends ClauseElement {
    private boolean isVertexExtraction;
    private boolean isEdgeExtraction;
    List<String> labelCollection= new ArrayList<>();



    public Extraction(boolean isVertexExtraction, boolean isEdgeExtraction, String label, List<String> labelCollection) {
        this.isVertexExtraction = isVertexExtraction;
        this.isEdgeExtraction = isEdgeExtraction;

    }

    public Extraction() {
    }

    public void addExtraction(boolean isVertexExtraction, boolean isEdgeExtraction){
        this.isVertexExtraction=isVertexExtraction;
        this.isEdgeExtraction=isEdgeExtraction;
    }


    public void addExtractionLabel(String label){
      labelCollection.add(label);
    }




}
