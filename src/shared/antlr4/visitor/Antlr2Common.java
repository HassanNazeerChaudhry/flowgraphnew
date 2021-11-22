package shared.antlr4.visitor;


import shared.antlr4.pattern.PatternBaseVisitor;
import shared.antlr4.pattern.PatternParser;
import shared.variables.Operands;
import shared.variables.TemporalVariables;
import shared.variables.Value;
import shared.variables.Variable;
import java.util.List;

public class Antlr2Common extends PatternBaseVisitor<Operands> {

    private List<String> labels;
    private List<String> semanticErrors;


    @Override
    public Operands visitTemporalVariable(PatternParser.TemporalVariableContext ctx) {

     if(ctx.children.size()==1) {

         String varName= ctx.getChild(0).getText();
         return new TemporalVariables(new Variable(varName));
     }

     else if(ctx.children.size()==3){
         String varName= ctx.getChild(0).getText();
         String timeUnit= ctx.getChild(2).getText();

         return new TemporalVariables(true,new Variable(varName), Float.parseFloat(timeUnit));
     }


     else if (ctx.children.size()==4){
         String varName= ctx.getChild(0).getText();
         String timeUnit= ctx.getChild(3).getText();
         return new TemporalVariables(true,true, new Variable(varName), Float.parseFloat(timeUnit));
     }

    else{
         String varName= ctx.getChild(0).getText();
         return new TemporalVariables(new Variable(varName));

     }

    }

    @Override
    public Operands visitLabel(PatternParser.LabelContext ctx) {
       String labelName= ctx.getChild(0).getText();

        if(labels.contains(labelName)){
            semanticErrors.add("Error: Label "+labelName+ "already declared");

        }
        else{
            labels.add(labelName);
        }


        return new Variable(labelName);

    }

    @Override
    public Operands visitValue(PatternParser.ValueContext ctx) {
        String labelVal= ctx.getChild(1).getText();
        return new Value(Integer.parseInt(labelVal));
    }
}
