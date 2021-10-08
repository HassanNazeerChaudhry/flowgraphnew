package shared.patterns;

import java.util.ArrayList;

public class DeltaNodes {


    ArrayList<String> nodeIdentityCollection=new ArrayList<>();


    private int deltaNodeCount;
    public String termModifier;

    public DeltaNodes(int deltaNodeCount, String termModifier) {
        this.deltaNodeCount = deltaNodeCount;
        this.termModifier = termModifier;
    }

    public DeltaNodes(int deltaNodeCount) {
        this.deltaNodeCount = deltaNodeCount;
    }

    public DeltaNodes(String termModifier) {
        this.termModifier = termModifier;
    }

    public void NodeModifier(int deltaNodeCount){

        if(deltaNodeCount>15){


        }

    }

}
