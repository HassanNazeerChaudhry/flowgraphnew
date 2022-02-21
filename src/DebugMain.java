//import org.antlr.v4.runtime.CharStream;
//import org.antlr.v4.runtime.CharStreams;
//import org.antlr.v4.runtime.CommonTokenStream;
//import org.antlr.v4.runtime.tree.ParseTree;
//import shared.antlr4.pattern.PatternLexer;
//import shared.antlr4.pattern.PatternParser;
import client.Client;
import master.JobManager;
import org.apache.flink.api.java.Utils;
import shared.PropertyHandler;
import shared.UtilLib;
import shared.antlr4.visitor.PatternEntryVisitor;
import shared.model.Pattern;
import slave.TaskManager;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

public class DebugMain {


    // the main function body
    public static void main(String[] args) throws IOException {

        //  String fileName="src/resources/test2.txt";
        //  PatternParser parser=getParser(fileName);
          //tell antlr to build a parse tree parse from start symbol 'Pattern'
        //  ParseTree antlrAST= parser.patternEntry();
        //  PatternEntryVisitor patternEntryVisitor= new PatternEntryVisitor();
        //  Pattern pattern= patternEntryVisitor.visit(antlrAST);
        //  int a=2;

        //Write standard output on file
        if (Boolean.parseBoolean(PropertyHandler.getProperty("outOnFile"))) {
            // Creating a File object that represents the disk file.
            PrintStream o = new PrintStream(new File(PropertyHandler.getProperty("logPath") + "output"+ UtilLib.getLocalIP() +".txt"));

            System.setOut(o);

        }

        if (UtilLib.getLocalIP().equals(PropertyHandler.getProperty("masterIp")) || PropertyHandler.getProperty("masterIp").equals("127.0.0.1")) {
            JobManager.main(new String[0]);
            Client.main(new String[0]);
            PropertyHandler.processes.set(2);
        }

        int numOfWorkers = Integer.parseInt(PropertyHandler.getProperty("numOfWorkers"));
        PropertyHandler.processes.set(PropertyHandler.processes.intValue() + numOfWorkers);
        for (int i = 0; i < numOfWorkers; i++) {
            //Process pr1 = Runtime.getRuntime().exec("java -jar /home/pietro/Desktop/slave.jar ");
            TaskManager.main(new String[0]);
        }


    }



   /* private static PatternParser getParser(String fName){
        PatternParser patternParser=null;


        try {
            CharStream input= CharStreams.fromFileName(fName);
            PatternLexer lexer= new PatternLexer(input);
            CommonTokenStream tokens= new CommonTokenStream(lexer);
            patternParser=new PatternParser(tokens);


        } catch (IOException e) {
            e.printStackTrace();
        }


        return patternParser;
    }*/
}


