package client;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigValueFactory;

import org.apache.flink.api.java.utils.ParameterTool;
import shared.antlr4.InputParser;
import org.antlr.v4.runtime.tree.ParseTree;
import shared.antlr4.pattern.PatternParser;
import shared.antlr4.visitor.PatternEntryVisitor;

import shared.computations.MaxIncomingEdges;
import shared.computations.NamesSet;
import shared.computations.TraingleCounting;

import shared.messages.*;
import shared.messages.GraphAction.*;

import shared.messages.vertexcentric.InstallComputationMsg;
import shared.messages.graphchanges.*;

import shared.PropertyHandler;
import shared.Utils;
import com.typesafe.config.ConfigFactory;

import shared.model.Pattern;
import shared.model.enumerators.*;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedHashMap;

public class Client {

    public static void main(String[] args) throws IOException {
        final ParameterTool param = ParameterTool.fromArgs(args);

        final String configFile = param.get("config", Utils.getAkkaConfPath("client.conf"));
        final String jobManagerAddr = PropertyHandler.getProperty("masterIp");
        final int jobManagerPort = Integer.parseInt(PropertyHandler.getProperty("masterPort"));

        final String jobManager = "akka.tcp://JobManager@" + jobManagerAddr + ":" + jobManagerPort + "/user/JobManager";

        Config conf = ConfigFactory.parseFile(new File(configFile));
        conf = conf.withValue("akka.remote.netty.tcp.hostname", ConfigValueFactory.fromAnyRef(Utils.getLocalIP()));
        final ActorSystem sys = ActorSystem.create("Client", conf);
        final ActorRef clientActor;


        //reading pattern file and passing it through antlr
        String fileName="src/resources/test1.txt";
        PatternParser parser=Utils.getParser(fileName);
        //tell antlr to build a parse tree parse from start symbol 'Pattern'
        ParseTree antlrAST= parser.patternEntry();
        PatternEntryVisitor patternEntryVisitor= new PatternEntryVisitor();
        Pattern pattern= patternEntryVisitor.visit(antlrAST);

        //container for all events sent by the client
        LinkedHashMap<String, GraphActions> graphActions= new LinkedHashMap<>();


        if (Utils.waitConnection(jobManagerAddr, jobManagerPort, null)) {
            clientActor = sys.actorOf(ClientActor.props(jobManager), "Client");
        } else {
            throw new RuntimeException("Unable to reach Job manager @ " + jobManagerAddr +", " + jobManagerPort);
        }

        clientActor.tell(new StartMsg(), ActorRef.noSender());

        //sending compuation traingle counting
        final InstallComputationMsg<NamesSet, HashSet<HashSet<String>>> compMsg1 = new InstallComputationMsg<>("TraingleCounting",
                () -> new TraingleCounting(),1);
        graphActions.put("compute1",compMsg1);


        //sending select operation
//        SelectMsg selectObject1=new SelectMsg(Modifier.VERTEX, "age", Operator.GREATER,"18", ConjugationType.NULL);
//        graphActions.put("select1",selectObject1);


        //sending partitioning operation
        PartitionMsg partitioningObject1=new PartitionMsg("country", Modifier.VERTEX);
        graphActions.put("partitioning1",partitioningObject1);


        //sending extraction operation
        ExtractMsg extractObject1=new ExtractMsg("country", Modifier.VERTEX);
        graphActions.put("extract1",extractObject1);

        //Streaming operation
        StreamOperatorMsg streamOperatorObject1=new StreamOperatorMsg(StreamOps.AVG, "age");
        graphActions.put("streamOP1",streamOperatorObject1);


        // evaluate operator operation
        EvaluateMsg evaluateObject1=new EvaluateMsg(Operator.GREATEREQUAL,30);
        graphActions.put("evaluate1",evaluateObject1);


        // evaluate operator operation
        FollowByMsg followedByObject1=new FollowByMsg(7);
        graphActions.put("followedBy1",followedByObject1);


        //sending compuation traingle counting
        final InstallComputationMsg<Integer, Integer> compMsg2 = new InstallComputationMsg<>("MaxIncomingEdges",
                () -> new MaxIncomingEdges(),2);
        graphActions.put("compute2",compMsg2);



        //sending select operation
//        SelectMsg selectObject2=new SelectMsg(Modifier.VERTEX,"age", Operator.GREATER,"18", ConjugationType.NULL);
//        graphActions.put("select2",selectObject2);


        //sending partitioning operation
        PartitionMsg partitioningObject2=new PartitionMsg("country", Modifier.VERTEX);
        graphActions.put("partitioning2",partitioningObject2);

        //sending extraction operation
//        ExtractMsg extractObject2=new ExtractMsg("country", Modifier.VERTEX);
//        graphActions.put("extract2",extractObject2);


        //Streaming operation
        StreamOperatorMsg streamOperatorObject2=new StreamOperatorMsg(StreamOps.AVG, "age");
        graphActions.put("streamOP2",streamOperatorObject2);


        // evaluate operator operation
        EvaluateMsg evaluateObject2=new EvaluateMsg(Operator.GREATEREQUAL,30);
        graphActions.put("evaluate2",evaluateObject2);


        FollowByMsg followedByObject2=new FollowByMsg(7);
        graphActions.put("followedBy2",followedByObject2);


        //sending compuation traingle counting
        final InstallComputationMsg<Integer, Integer> compMsg3 = new InstallComputationMsg<>("MaxIncomingEdges",
                () -> new MaxIncomingEdges(),2);
        graphActions.put("compute3",compMsg3);



        //sending select operation
        SelectMsg selectObject3=new SelectMsg(Modifier.VERTEX,"age", Operator.GREATER,"18", ConjugationType.NULL);
        graphActions.put("select3",selectObject3);


        //sending partitioning operation
        PartitionMsg partitioningObject3=new PartitionMsg("country", Modifier.VERTEX);
        graphActions.put("partitioning3",partitioningObject3);

        //sending extraction operation
        ExtractMsg extractObject3=new ExtractMsg("country", Modifier.VERTEX);
        graphActions.put("extract3",extractObject3);


        //Streaming operation
        StreamOperatorMsg streamOperatorObject3=new StreamOperatorMsg(StreamOps.AVG, "age");
        graphActions.put("streamOP3",streamOperatorObject3);


        // evaluate operator operation
        EvaluateMsg evaluateObject3=new EvaluateMsg(Operator.GREATEREQUAL,30);
        graphActions.put("evaluate3",evaluateObject3);


        FollowByMsg followedByObject3=new FollowByMsg(7);
        graphActions.put("followedBy3",followedByObject3);


        //sending compuation traingle counting
        final InstallComputationMsg<Integer, Integer> compMsg4 = new InstallComputationMsg<>("MaxIncomingEdges",
                () -> new MaxIncomingEdges(),2);
        graphActions.put("compute4",compMsg4);



        //sending select operation
        SelectMsg selectObject4=new SelectMsg(Modifier.VERTEX,"age", Operator.GREATER,"18", ConjugationType.NULL);
        graphActions.put("select4",selectObject4);


        //sending partitioning operation
        PartitionMsg partitioningObject4=new PartitionMsg("country", Modifier.VERTEX);
        graphActions.put("partitioning4",partitioningObject4);

        //sending extraction operation
        ExtractMsg extractObject4=new ExtractMsg("country", Modifier.VERTEX);
        graphActions.put("extract4",extractObject4);


        //Streaming operation
        StreamOperatorMsg streamOperatorObject4=new StreamOperatorMsg(StreamOps.AVG, "age");
        graphActions.put("streamOP4",streamOperatorObject4);


        // evaluate operator operation
        EvaluateMsg evaluateObject4=new EvaluateMsg(Operator.GREATEREQUAL,30);
        graphActions.put("evaluate4",evaluateObject4);




        clientActor.tell(new InstallPatternMsg(graphActions), ActorRef.noSender());


        BufferedReader reader;
        try {
            int numberOfLines = Integer.parseInt(PropertyHandler.getProperty("numRecordsAsInput"));
            reader = new BufferedReader(new FileReader(PropertyHandler.getProperty("datasetPath")));
            String line = reader.readLine();
            for (int i = 0; i < numberOfLines+1; i++) {
                if (!line.isBlank()) {
                    java.io.Serializable parsed = InputParser.parse(line);

                    if ( parsed instanceof AddEdgeMsg ) {
                        AddEdgeMsg msg = (AddEdgeMsg) parsed;

                        clientActor.tell(msg, ActorRef.noSender());
                    }
                    else if (parsed instanceof UpdateEdgeMsg ) {
                        UpdateEdgeMsg msg = (UpdateEdgeMsg) parsed;
                        clientActor.tell(msg, ActorRef.noSender());
                    }
                    else if (parsed instanceof DelEdgeMsg ) {
                        DelEdgeMsg msg = (DelEdgeMsg) parsed;
                        clientActor.tell(msg, ActorRef.noSender());
                    }
                    else if (parsed instanceof AddVertexMsg  ) {
                        AddVertexMsg msg = (AddVertexMsg) parsed;
                        clientActor.tell(msg, ActorRef.noSender());
                    }
                    else if (parsed instanceof UpdateVertexMsg  ) {
                        UpdateVertexMsg msg = (UpdateVertexMsg) parsed;
                        clientActor.tell(msg, ActorRef.noSender());
                    }
                    else if (parsed instanceof DelVertexMsg  ) {
                        DelVertexMsg msg = (DelVertexMsg) parsed;
                        clientActor.tell(msg, ActorRef.noSender());
                    }
                }
                line = reader.readLine();
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        //endregion


    }

}
