package client;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import com.typesafe.config.ConfigValueFactory;
import org.apache.flink.api.java.utils.ParameterTool;
import shared.PropertyHandler;
import shared.antlr4.InputParser;
import shared.messages.HelloClientMsg;
import shared.UtilLib;
import shared.messages.TerminateMsg;

import java.io.*;

public class Client {
    public static void main(String[] args) throws IOException {
        final ParameterTool param = ParameterTool.fromArgs(args);

        final String configFile = param.get("config", UtilLib.getAkkaConfPath("client.conf"));
        final String jobManagerAddr = PropertyHandler.getProperty("masterIp");
        final int jobManagerPort = Integer.parseInt(PropertyHandler.getProperty("masterPort"));


        final String jobManager = "akka.tcp://JobManager@" + jobManagerAddr + ":" + jobManagerPort + "/user/JobManager";

        Config conf = ConfigFactory.parseFile(new File(configFile));
        conf = conf.withValue("akka.remote.netty.tcp.hostname", ConfigValueFactory.fromAnyRef(UtilLib.getLocalIP()));
        final ActorSystem sys = ActorSystem.create("Client", conf);
        final ActorRef clientActor;

        if (UtilLib.waitConnection(jobManagerAddr, jobManagerPort, null)) {
            clientActor = sys.actorOf(ClientActor.props(jobManager), "Client");
        } else {
            throw new RuntimeException("Unable to reach Job manager @ " + jobManagerAddr +", " + jobManagerPort);
        }

        clientActor.tell(new HelloClientMsg(), ActorRef.noSender());

        try {
               automaticMode(clientActor);

        } catch (IOException e) {
            e.printStackTrace();
        }
        clientActor.tell(new TerminateMsg(), ActorRef.noSender());
    }



    private static void automaticMode(ActorRef clientActor) throws IOException {

        int numRecords = Integer.parseInt(PropertyHandler.getProperty("numRecordsAsInput"));
        long numTotalRecords = UtilLib.countLines(PropertyHandler.getProperty("datasetPath"));
        try {

            BufferedReader lineReader = new BufferedReader(new FileReader(PropertyHandler.getProperty("datasetPath")));

            for (int i = 0; i < (numTotalRecords-numRecords-1); i++) {
                lineReader.readLine();
            }

            for (int i = (int)(numTotalRecords-numRecords-1); i < numTotalRecords; i++) {
                String line = lineReader.readLine();
                if (line!=null && !line.trim().equals("")) {
                    Serializable parsedMessage = InputParser.parse(line);
                    if (parsedMessage == null) throw new NullPointerException(line);
                    clientActor.tell(parsedMessage, ActorRef.noSender());
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Parsing error, no other messages are sent to task manager");
        }
    }



}
