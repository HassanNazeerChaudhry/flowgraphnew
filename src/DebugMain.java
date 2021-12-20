import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import shared.antlr4.pattern.PatternLexer;
import shared.antlr4.pattern.PatternParser;
import shared.antlr4.visitor.PatternEntryVisitor;
import shared.model.Pattern;

import java.io.IOException;

public class DebugMain {


    // the main function body
    public static void main(String[] args) {



      //  if (args.length!=1) {
        //    System.err.print("Usage: file Name");
        //  } else {

         // String fileName=args[0];
          String fileName="test1.txt";
          PatternParser parser=getParser(fileName);
          //tell antlr to build a parse tree parse from start symbol 'Pattern'
           ParseTree antlrAST= parser.patternEntry();
           PatternEntryVisitor patternEntryVisitor= new PatternEntryVisitor();
           Pattern pattern= patternEntryVisitor.visit(antlrAST);
           int a=2;

        //  }

    }



    private static PatternParser getParser(String fName){
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
    }
}


