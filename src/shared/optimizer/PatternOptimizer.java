package shared.optimizer;

import shared.computations.MaxIncomingEdges;
import shared.computations.NamesSet;
import shared.computations.TraingleCounting;
import shared.messages.GraphAction.GraphActions;
import shared.messages.GraphAction.InstallPatternMsg;
import shared.messages.vertexcentric.InstallComputationMsg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PatternOptimizer {
    private HashMap<String, GraphActions> graphActions;
    private ArrayList<GraphActions> aryList= new ArrayList<>();
    HashMap<String, GraphActions> shuffleListFinal;
    private boolean isShuffle;

    public PatternOptimizer() {


        this.isShuffle=false;
    }

    public void extractComputes(InstallPatternMsg Pattern){
        graphActions=Pattern.getGraphActions();


        //gets the compute caluses
        for (Map.Entry<String, GraphActions> e : graphActions.entrySet()) {

           if(e.getKey().toString().contains("compute")){
               aryList.add(e.getValue());

           }


        }


        shuffleListFinal=shufflePattern(aryList, graphActions);


    }


    public HashMap<String, GraphActions> shufflePattern(ArrayList<GraphActions> graphActionList, HashMap<String, GraphActions> fullList){

        shuffleListFinal=(HashMap<String, GraphActions>)fullList.clone();
        HashMap<String, GraphActions> shuffleListTemp;



        ArrayList<String> clauseKeys = new ArrayList<String>(){{
            add("compute");
            add("select");
            add("partitioning");
            add("extract");
            add( "streamOP");
            add( "extract");
            add( "evaluate");
        }};



        Map<String, List<String>> listKeys = new HashMap<>();

        for(int j=0;j<graphActionList.size();j++){
            String name="keys"+j;
            List<String> key=new ArrayList();;

            for(int i=0; i<=6;i++){
                    String var=(j+1)+"";
                    if(fullList.containsKey(clauseKeys.get(i)+ var)){

                        key.add(clauseKeys.get(i)+ var);
                    }

                }

            listKeys.put(name,key);
        }



        int [] shuffleWeights=isOptimizableN(graphActionList);
        String strKeySeq="keys"+shuffleWeights[0];

        shuffleListFinal.keySet().retainAll(listKeys.get(strKeySeq));
        String followStr;
        for(int j=0;j<graphActionList.size()-1;j++){
            shuffleListTemp=(HashMap<String, GraphActions>)fullList.clone();
            followStr="followedBy"+Integer.toString(j+1);
            shuffleListFinal.put(followStr, fullList.get(followStr));

            shuffleListTemp.keySet().retainAll(listKeys.get("keys"+shuffleWeights[j+1]));
            shuffleListFinal.putAll(shuffleListTemp);
        }

       return shuffleListFinal;
    }


    public int []  isOptimizableN(ArrayList<GraphActions> graphActionList) {

        InstallComputationMsg[ ] installComputationsList = new InstallComputationMsg[graphActionList.size()];
        Integer [] weights=new Integer[graphActionList.size()];

        for(int i=0;i<graphActionList.size();i++){
            installComputationsList[i]= (InstallComputationMsg)graphActionList.get(i);
            weights[i]=installComputationsList[i].getComputationCoeff();
        }



        int[] sortedIndices = IntStream.range(0, weights.length)
                .boxed().sorted((i, j) -> weights[j].compareTo(weights[i]) )
                .mapToInt(ele -> ele).toArray();


        return sortedIndices;


    }






}
