package shared.antlr4.visitor;


import shared.antlr4.pattern.PatternBaseVisitor;
import shared.antlr4.pattern.PatternParser;
import shared.variables.Operands;
import shared.variables.TemporalVariables;
import shared.variables.Value;
import shared.variables.Variable;
import java.util.List;

public class TemporalVariableVisitor extends PatternBaseVisitor<Operands> {

    private List<String> labels;
    private List<String> semanticErrors;


    @Override
    public Operands visitTemporalVariable(PatternParser.TemporalVariableContext ctx) {

     if(ctx.children.size()==2) {

         String varName= ctx.getChild(1).getText();
         return new TemporalVariables(new Variable(varName));
     }

     else if(ctx.children.size()==4){
         String varName= ctx.getChild(1).getText();
         String timeUnit= ctx.getChild(3).getText();

         return new TemporalVariables(true,new Variable(varName), Float.parseFloat(timeUnit));
     }


     else if (ctx.children.size()==5){
         String varName= ctx.getChild(1).getText();
         String timeUnit= ctx.getChild(4).getText();
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


    @Override
    public Operands visitOperands(PatternParser.OperandsContext ctx) {

        if(ctx.children.size()==1) {  //label
            String labelName= ctx.getChild(0).getText();
            return new Variable(labelName);
        }

        else if(ctx.children.size()==2){ //temporal variable, variable
            String varName= ctx.getChild(1).getText();
            return new TemporalVariables(new Variable(varName));
        }

        else if(ctx.children.size()==3){ //value
            String valName= ctx.getChild(1).getText();
            return new Value(Integer.parseInt(valName));
        }

        else if (ctx.children.size()==4){ //temporal variable, variable with ago
            String varName= ctx.getChild(1).getText();
            String timeUnit= ctx.getChild(3).getText();

            return new TemporalVariables(true,new Variable(varName), Float.parseFloat(timeUnit));
        }



        else if (ctx.children.size()==5){ //temporal variable with every and within
            String varName= ctx.getChild(1).getText();
            String timeUnit= ctx.getChild(4).getText();
            return new TemporalVariables(true,true, new Variable(varName), Float.parseFloat(timeUnit));
        }

        else{
            String varName= ctx.getChild(0).getText();
            return new TemporalVariables(new Variable(varName));

        }

    }
}
