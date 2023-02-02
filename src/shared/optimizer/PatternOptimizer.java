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
    private boolean isShuffle;

    public PatternOptimizer() {


        this.isShuffle=false;
    }

    public void extractComputes(InstallPatternMsg Pattern){
        graphActions=Pattern.getGraphActions();

        for (Map.Entry<String, GraphActions> e : graphActions.entrySet()) {

           if(e.getKey().toString().contains("compute")){
               aryList.add(e.getValue());

           }


        }


        shufflePattern(aryList, graphActions);


    }


    public void shufflePattern(ArrayList<GraphActions> graphActionList, HashMap<String, GraphActions> fullList){

        HashMap<String, GraphActions> shuffleListFinal=(HashMap<String, GraphActions>)fullList.clone();
        HashMap<String, GraphActions> shuffleListTemp=(HashMap<String, GraphActions>)fullList.clone();



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
                    key.add(clauseKeys.get(i)+ var);
                }

            listKeys.put(name,key);
        }



        ArrayList<GraphActions> graphActionListTest=new ArrayList<GraphActions>();


        final InstallComputationMsg<NamesSet, HashSet<HashSet<String>>> compMsg1 = new InstallComputationMsg<>("TraingleCounting",
                () -> new TraingleCounting(),1);
        graphActionListTest.add(compMsg1);

        final InstallComputationMsg<NamesSet, HashSet<HashSet<String>>> compMsg2 = new InstallComputationMsg<>("TraingleCounting",
                () -> new TraingleCounting(),1);
        graphActionListTest.add(compMsg2);


        final InstallComputationMsg<Integer, Integer> compMsg3 = new InstallComputationMsg<>("MaxIncomingEdges",
                () -> new MaxIncomingEdges(),2);
        graphActionListTest.add(compMsg3);
        int [] shuffleWeights=isOptimizableN(graphActionListTest);

        shuffleListFinal.keySet().retainAll(listKeys.get("keys1"));

        for(int j=0;j<graphActionList.size()-1;j++){
            shuffleListFinal.put("followedBy1", fullList.get("followedBy1"));
            shuffleListTemp.keySet().retainAll(listKeys.get("keys0"));
            shuffleListFinal.putAll(shuffleListTemp);
        }


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
