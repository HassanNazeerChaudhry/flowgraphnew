package client;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigValueFactory;
import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.flink.api.java.utils.ParameterTool;
import shared.antlr4.InputParser;

import shared.antlr4.pattern.PatternParser;
import shared.antlr4.visitor.PatternEntryVisitor;
import shared.computations.NamesSet;
import shared.computations.TraingleCounting;
import shared.messages.PartitionMsg;
import shared.messages.SelectMsg;
import shared.messages.vertexcentric.InstallComputationMsg;
import shared.messages.StartMsg;
import shared.PropertyHandler;
import shared.Utils;
import com.typesafe.config.ConfigFactory;
import shared.messages.graphchanges.*;
import shared.model.Pattern;
import shared.model.graphcollection.PartitioningCollection;
import shared.model.graphcollection.PartitioningObject;
import shared.model.graphcollection.SelectCollection;
import shared.model.enumerators.ConjugationType;
import shared.model.enumerators.Operator;
import shared.model.graphcollection.SelectObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

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



        if (Utils.waitConnection(jobManagerAddr, jobManagerPort, null)) {
            clientActor = sys.actorOf(ClientActor.props(jobManager), "Client");
        } else {
            throw new RuntimeException("Unable to reach Job manager @ " + jobManagerAddr +", " + jobManagerPort);
        }

        clientActor.tell(new StartMsg(), ActorRef.noSender());

        //sending compuation traingle counting
        final InstallComputationMsg<NamesSet, HashSet<HashSet<String>>> compMsg = new InstallComputationMsg<>("TraingleCounting",
                () -> new TraingleCounting());
        clientActor.tell(compMsg, ActorRef.noSender());


        //sending select operation
        HashSet<SelectObject> selectObjectCollection=new HashSet();
        SelectObject selectObject=new SelectObject("name", Operator.EQUAL,"Alessandro", ConjugationType.NULL);
        selectObjectCollection.add(selectObject);
        SelectCollection selectCollection= new SelectCollection(selectObjectCollection);
        SelectMsg selectMsg= new SelectMsg(selectCollection);
        clientActor.tell(selectMsg, ActorRef.noSender());


        //sending partitioning operation
        HashSet<PartitioningObject> partitioningObjectCollection=new HashSet();
        PartitioningObject partitioningObject=new PartitioningObject("country");
        partitioningObjectCollection.add(partitioningObject);
        PartitioningCollection partitioningCollection= new PartitioningCollection(partitioningObjectCollection);
        PartitionMsg partitionMsg= new PartitionMsg(partitioningCollection);
        clientActor.tell(partitionMsg, ActorRef.noSender());




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
