import client.Client;
import master.JobManager;
import shared.PropertyHandler;
import shared.Utils;
import taskmanager.TaskManager;

import java.io.IOException;

public class DebugMain {

    public static void main(String[] args) throws IOException {

        try{

            if (Utils.getLocalIP().equals(PropertyHandler.getProperty("masterIp")) || PropertyHandler.getProperty("masterIp").equals("127.0.0.1")) {
                JobManager.main(new String[0]);




                int numOfWorkers = Integer.parseInt(PropertyHandler.getProperty("numOfWorkers"));
                PropertyHandler.processes.set(PropertyHandler.processes.intValue() + numOfWorkers);
                for (int i = 0; i < numOfWorkers; i++) {
                    TaskManager.main(new String[0]);
                }


                Client.main(new String[0]);

            }

        } catch (Exception exp){
            System.out.println(exp.getMessage());
        }



    }
}


