package shared.model.clauseelement;

import shared.model.ClauseElement;

import java.util.ArrayList;
import java.util.List;

public class Extraction extends ClauseElement {
    private boolean isVertexExtraction;
    private boolean isEdgeExtraction;
    List<String> labelCollection= new ArrayList<>();



    public Extraction(boolean isVertexExtraction, boolean isEdgeExtraction, List<String> labelCollection) {
        this.isVertexExtraction = isVertexExtraction;
        this.isEdgeExtraction = isEdgeExtraction;
        this.labelCollection=labelCollection;
    }





}
