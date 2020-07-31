package compiler;

import org.parser.StubBaseVisitor;
import org.parser.StubParser.FormalParametersContext;
import org.parser.StubParser.BlockContext;
import org.parser.StubParser.FormalParameterContext;
import org.parser.StubParser.FunctionDeclContext;
import org.parser.StubParser.TypeContext;
import org.parser.StubParser.StringContext;
import org.parser.StubParser.FunctionCallContext;
import org.parser.StubParser.ExprListContext;
import org.parser.StubParser.ArrayDeclarationContext;
import org.parser.StubParser.IdentifierContext;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class FunctionVisitor extends StubBaseVisitor<String> {

    String staticDefinitions = "";
    Function currentFunction = null;
    List<Function> functionList = new ArrayList<>();
    HashMap<String, ArrayType> arrayTypeMap = new HashMap<>();
    String currentFunctionName;
    boolean mainFunctionFound = false;

    public boolean mainFunctionFound() {
        return mainFunctionFound;
    }

    public List<Function> getFunctionList() {
        return functionList;
    }

    public String getStaticDefinitions() {
        return staticDefinitions;
    }

    public HashMap<String, ArrayType> getArrayMap() {
        return arrayTypeMap;
    }

    @Override
    public String visitFunctionCall(FunctionCallContext ctx) {
        if (ctx.expressions != null && 
                ctx.expressions.getChild(0).getClass() == StringContext.class &&
                ctx.id.getText().equals("println")) {
            functionList.add(new Function(Type.INT, "println"));

            if (!staticDefinitions.contains("printf"))
                staticDefinitions += "declare i32 @printf(i8*, ...)\n";
                }

        // Ugly remembering what size an array has when used as a function parameter
        // very likely to cause unwanten behaviour later
        currentFunctionName = ctx.id.getText();
        try {
            visit(ctx.expressions);
        } catch (Exception e) {}
        currentFunctionName = "";
        return "";

    }

    @Override 
    public String visitExprList(ExprListContext ctx) {

        int count = ctx.getChildCount();
        String ret = "";
        for (int i = 0; i < count; i=i+2) {
            ret = visit(ctx.getChild(i));
            if (ret != null && ret != "") {
                ArrayType arrayType = arrayTypeMap.get(ret);    
                arrayTypeMap.put(currentFunctionName + i, arrayType);
            }
        }
        return "";
    }

    @Override
    public String visitArrayDeclaration(ArrayDeclarationContext ctx) {
        int count = Integer.valueOf(ctx.count.getText());
        String name = ctx.identifier.getText();
        ArrayType arrayType = ArrayType.INT_ARRAY;
        arrayType.setCount(count);
        arrayTypeMap.put(name, arrayType);
        return "";
    }

        
    @Override
    public String visitIdentifier(IdentifierContext ctx) {
        return (ctx.id.getText());
    }


    @Override 
    public String visitFunctionDecl(FunctionDeclContext ctx) {
        // add name and paramlist to function map
        TypeInterface type = Type.fromString(visit(ctx.fnType));
        String name = ctx.id.getText();
        currentFunction = new Function(type, name);

        if (name.equals("main")) 
            mainFunctionFound = true;

        // visiting the params should fill the Function Instance with params
        // we should not need a stack as the definition of functions should not
        // be able to encapsulate the definition of an other function

        try {
            visit(ctx.params);
        } catch (Exception e) {
        }
        functionList.add(currentFunction);
        visit(ctx.bl);
        return "";
    }
    
    @Override
    public String visitBlock(BlockContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitFormalParameters(FormalParametersContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitFormalParameter(FormalParameterContext ctx) {
        //create Pair<Type, String> then add it to the currentFunction
        Pair<TypeInterface, String> paramPair = 
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
            case "float[]":
                return "float[]";
            case "int[]":
                return "i32[]";
            default:
                throw new RuntimeException("<"+ctx.getText()+">"+"Type is not implemented yet");
        }
    }
}
