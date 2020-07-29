package compiler;

import org.parser.StubBaseVisitor;
import org.parser.StubParser.FormalParametersContext;
import org.parser.StubParser.BlockContext;
import org.parser.StubParser.FormalParameterContext;
import org.parser.StubParser.FunctionDeclContext;
import org.parser.StubParser.TypeContext;
import org.parser.StubParser.StringContext;
import org.parser.StubParser.FunctionCallContext;

import java.util.List;
import java.util.ArrayList;

public class FunctionVisitor extends StubBaseVisitor<String> {

    // hashmap is a bad idea because it can't handled overloaded functions
    // only could if we use name with all specific info for function
    String staticDefinitions = "";
    Function currentFunction = null;
    List<Function> functionList = new ArrayList<>();

    public List<Function> getFunctionList() {
        return functionList;
    }

    public String getStaticDefinitions() {
        return staticDefinitions;
    }

    @Override
    public String visitFunctionCall(FunctionCallContext ctx) {
        System.err.println("into visitFunctionCall");
        if (ctx.expressions != null && 
                ctx.expressions.getChild(0).getClass() == StringContext.class &&
                ctx.id.getText().equals("println")) {
            functionList.add(new Function(Type.INT, "println"));
            System.err.println("STAT"+staticDefinitions);
            if (!staticDefinitions.contains("printf"))
                staticDefinitions += "declare i32 @printf(i8*, ...)\n";
            System.err.println("STAT"+staticDefinitions);
                }
        return "";
    }

    @Override 
    public String visitFunctionDecl(FunctionDeclContext ctx) {
        // add name and paramlist to function map
        Type type = Type.fromString(visit(ctx.fnType));
        String name = ctx.id.getText();
        currentFunction = new Function(type, name);

        // visiting the params should fill the Function Instance with params
        // we should not need a stack as the definition of functions should not
        // be able to encapsulate the definition of an other function

        try {
            visit(ctx.params);
        } catch (Exception e) {
            System.err.println(e);
        }
        functionList.add(currentFunction);
        visit(ctx.bl);
        return "";
    }
    
    @Override
    public String visitBlock(BlockContext ctx) {
        System.err.println("...");
        System.err.println("Into Block worked");
        return visitChildren(ctx);
    }

    @Override
    public String visitFormalParameters(FormalParametersContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitFormalParameter(FormalParameterContext ctx) {
        //create Pair<Type, String> then add it to the currentFunction
        Pair<Type, String> paramPair = 
            new Pair<>(Type.fromString(visit(ctx.paramType)),
                       ctx.id.getText());

        currentFunction.addParameter(paramPair);
        return "";
    }

    @Override
    public String visitType(TypeContext ctx) {
        switch (ctx.getText()) {
            case "float":
                return "float";
            case "int":
                return "i32";
            case "void":
                return "void";
            default:
                return null;
        }
    }
}
