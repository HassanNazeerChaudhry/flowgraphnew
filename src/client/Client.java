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

import shared.computations.NamesSet;
import shared.computations.TraingleCounting;

import shared.messages.*;
import shared.messages.GraphAction.GraphActionsMsg;
import shared.messages.GraphAction.InstallPatternMsg;
import shared.messages.vertexcentric.InstallComputationMsg;
import shared.messages.graphchanges.*;

import shared.PropertyHandler;
import shared.Utils;
import com.typesafe.config.ConfigFactory;

import shared.model.Pattern;
import shared.model.graphcollection.*;
import shared.model.enumerators.*;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

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
        Map<String, GraphActions> graphActions= new HashMap<>();

        if (Utils.waitConnection(jobManagerAddr, jobManagerPort, null)) {
            clientActor = sys.actorOf(ClientActor.props(jobManager), "Client");
        } else {
            throw new RuntimeException("Unable to reach Job manager @ " + jobManagerAddr +", " + jobManagerPort);
        }

        clientActor.tell(new StartMsg(), ActorRef.noSender());


        //sending compuation traingle counting
        final InstallComputationMsg<NamesSet, HashSet<HashSet<String>>> compMsg = new InstallComputationMsg<>("TraingleCounting",
                () -> new TraingleCounting());
       // clientActor.tell(compMsg, ActorRef.noSender());
        graphActions.put("compute",compMsg);


        //sending select operation
        SelectObject selectObject=new SelectObject("age", Operator.GREATER,"18", ConjugationType.NULL, Modifier.EDGE);
        graphActions.put("select",selectObject);


        //sending partitioning operation
         PartitioningObject partitioningObject=new PartitioningObject("country", Modifier.VERTEX);
         graphActions.put("Partitioning",partitioningObject);

        //sending extraction operation
          ExtractObject extractObject=new ExtractObject("country", Modifier.VERTEX);
          graphActions.put("extract",extractObject);

        //Streaming operation
        StreamOperatorObject streamOperatorObject=new StreamOperatorObject(StreamOps.AVG, "age");
        graphActions.put("streamOP",streamOperatorObject);


        // evaluate operator operation
        EvaluateObject evaluateObject=new EvaluateObject(Operator.GREATEREQUAL,30);
        graphActions.put("evaluate",evaluateObject);


        // evaluate operator operation
        FollowByObject followedByObject=new FollowByObject(7);
        graphActions.put("followedBy",followedByObject);


        //sending compuation traingle counting
        final InstallComputationMsg<NamesSet, HashSet<HashSet<String>>> compMsg1 = new InstallComputationMsg<>("TraingleCounting",
                () -> new TraingleCounting());
        // clientActor.tell(compMsg, ActorRef.noSender());
        graphActions.put("compute",compMsg1);


        //sending select operation
        SelectObject selectObject1=new SelectObject("age", Operator.GREATER,"18", ConjugationType.NULL, Modifier.EDGE);
        graphActions.put("select",selectObject1);


        //sending partitioning operation
        PartitioningObject partitioningObject1=new PartitioningObject("country", Modifier.VERTEX);
        graphActions.put("Partitioning",partitioningObject1);

        //sending extraction operation
        ExtractObject extractObject1=new ExtractObject("country", Modifier.VERTEX);
        graphActions.put("extract",extractObject1);

        //Streaming operation
        StreamOperatorObject streamOperatorObject1=new StreamOperatorObject(StreamOps.AVG, "age");
        graphActions.put("streamOP",streamOperatorObject1);


        // evaluate operator operation
        EvaluateObject evaluateObject1=new EvaluateObject(Operator.GREATEREQUAL,30);
        graphActions.put("evaluate",evaluateObject1);


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
