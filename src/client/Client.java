package client;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import com.typesafe.config.ConfigValueFactory;
import org.apache.flink.api.java.Utils;
import org.apache.flink.api.java.utils.ParameterTool;
import shared.PropertyHandler;
import shared.messages.HelloClientMsg;
import shared.messages.LaunchMsg;
import shared.UtilLib;

import java.io.*;
import java.util.Scanner;

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


    }

}
