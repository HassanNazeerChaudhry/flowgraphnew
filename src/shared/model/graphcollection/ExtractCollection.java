package shared.model.graphcollection;

import java.util.HashSet;

public class ExtractCollection extends GraphActions{
    HashSet<ExtractObject> extractCollection=new HashSet();

    public ExtractCollection(HashSet<ExtractObject> extractCollection) {
        this.extractCollection = extractCollection;
    }

    public HashSet<ExtractObject> getExtractCollection() {
        return extractCollection;
    }


}


