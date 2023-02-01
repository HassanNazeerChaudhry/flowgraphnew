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

        HashMap<String, GraphActions> shuffleList1=(HashMap<String, GraphActions>)fullList.clone();
        HashMap<String, GraphActions> shuffleList2=(HashMap<String, GraphActions>)fullList.clone();


        ArrayList<String> clauseKeys = new ArrayList<String>(){{
            add("compute");
            add("select");
            add("partitioning");
            add("extract");
            add( "streamOP");
            add( "extract");
            add( "evaluate");
        }};

        //two pattern weights assigne
//        List<String> keys1 = new ArrayList<>();
//        List<String> keys2 = new ArrayList<>();
//
//        String var1="1";
//        String var2="2";
//
//        for(int i=0; i<=6;i++){
//            keys1.add(clauseKeys.get(i)+ var2);
//            keys2.add(clauseKeys.get(i)+ var1);
//
//        }

        Map<String, List<String>> listKeys = new HashMap<>();
//        for(int i=0;i<graphActionList.size();i++){
//            String name="keys"+i;
//            listKeys.put(name, new ArrayList<String>());
//        }

        for(int j=0;j<graphActionList.size();j++){
            String name="keys"+j;
            List<String> key=new ArrayList();;

            for(int i=0; i<=6;i++){
                    String var=(j+1)+"";
                    key.add(clauseKeys.get(i)+ var);
                }

            listKeys.put(name,key);
        }






        if(graphActionList.size()==2){
            if(isOptimizableTwo( graphActionList)){

                shuffleList1.keySet().retainAll(keys1);
                shuffleList1.put("followedBy1", fullList.get("followedBy1"));
                shuffleList2.keySet().retainAll(keys2);
                shuffleList1.putAll(shuffleList2);
            }
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



        Integer [] shuffleWeights=isOptimizableN(graphActionListTest);

    }


    public boolean isOptimizableTwo(ArrayList<GraphActions> graphActionList) {


        InstallComputationMsg g1= (InstallComputationMsg)graphActionList.get(0);
        InstallComputationMsg g2= (InstallComputationMsg)graphActionList.get(1);

        //Heavy	Light
        //Light  Heavy
        if(g1.getComputationCoeff()<g2.getComputationCoeff()){
            isShuffle=true;

        }
        else{

            isShuffle=false;
        }
        return isShuffle;


    }

    public ArrayList<Integer> isOptimizableThree(ArrayList<GraphActions> graphActionList) {

        ArrayList<Integer> shiftPattern = new ArrayList<Integer>();




        InstallComputationMsg g1= (InstallComputationMsg)graphActionList.get(0);
        InstallComputationMsg g2= (InstallComputationMsg)graphActionList.get(1);
        InstallComputationMsg g3= (InstallComputationMsg)graphActionList.get(1);


        if(g1.getComputationCoeff()==g2.getComputationCoeff() || g1.getComputationCoeff()>g2.getComputationCoeff()){
           if(g2.getComputationCoeff()<g3.getComputationCoeff()) {
               shiftPattern.add(1);
               shiftPattern.add(3);
               shiftPattern.add(2);
           }else{
               shiftPattern.add(1);
               shiftPattern.add(2);
               shiftPattern.add(3);
           }
        }else {
            if(g2.getComputationCoeff()>g3.getComputationCoeff()) {
                shiftPattern.add(2);
                shiftPattern.add(3);
                shiftPattern.add(1);
            }else{
                shiftPattern.add(1);
                shiftPattern.add(3);
                shiftPattern.add(2);

            }



        }
     return shiftPattern;

    }

    public Integer []  isOptimizableN(ArrayList<GraphActions> graphActionList) {

        InstallComputationMsg[ ] installComputationsList = new InstallComputationMsg[graphActionList.size()];
        Integer [] weights=new Integer[graphActionList.size()];

        for(int i=0;i<graphActionList.size();i++){
            installComputationsList[i]= (InstallComputationMsg)graphActionList.get(i);
            weights[i]=installComputationsList[i].getComputationCoeff();
        }



        int[] sortedIndices = IntStream.range(0, weights.length)
                .boxed().sorted((i, j) -> weights[j].compareTo(weights[i]) )
                .mapToInt(ele -> ele).toArray();


        return weights;


    }






}
