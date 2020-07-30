package compiler;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import org.parser.StubBaseVisitor;
import org.parser.StubParser.MultDivContext;
import org.parser.StubParser.AddSubContext;
import org.parser.StubParser.NumberContext;
import org.parser.StubParser.FunctionDeclContext;
import org.parser.StubParser.TypeContext;
import org.parser.StubParser.FormalParametersContext;
import org.parser.StubParser.FormalParameterContext;
import org.parser.StubParser.BlockContext;
import org.parser.StubParser.ExpressionContext;
import org.parser.StubParser.FileContext;
import org.parser.StubParser.FloatContext;
import org.parser.StubParser.ReturnContext;
import org.parser.StubParser.StringContext;
import org.parser.StubParser.AssignExprContext;
import org.parser.StubParser.VarDeclarationContext;
import org.parser.StubParser.FunctionCallContext;
import org.parser.StubParser.ExprListContext;
import org.parser.StubParser.IdentifierContext;
import org.parser.StubParser.IfElseContext;
import org.parser.StubParser.ArrayDeclarationContext;
import org.parser.StubParser.IndexEContext;

import compiler.exceptions.*;

public class MyVisitor extends StubBaseVisitor<String> {

    // what is scope specific?, 
    // functions, variables
    //
    // when is a new block created?
    // when entering a new block
    //
    // what not:
    // static strings

    String staticDeclaration = "";
    String definedFunctions = "";
    String outputFile = "";

    Stack<Boolean> returnBoolFound = new Stack<>();
    Stack<String> blockStack = new Stack<>();
    String block = "";

    Stack<Integer> pseudoRegisters = new Stack<>();
    Stack<Integer> arrayPseudoRegisters = new Stack<>();
    Stack<Integer> ifElse = new Stack<>();
    Stack<HashMap<String, Type>> pseudoToTypeMapStack = new Stack<>();

    HashMap<String, compiler.Type> pseudoToTypeMap = new HashMap<>();
    HashMap<String, Object> stubVarToPseudoMap = new HashMap<>();

    HashMap<String, StringWrapper> staticStringMap = new HashMap<>();

    int staticStringReferencePart = 1;

    List<Function> functionList;
    Function currentCalledFunction;

    public MyVisitor(String staticDefinitions, List<Function> functionList) {
        super();
        this.staticDeclaration +=  staticDefinitions;
        this.functionList = functionList;
    }


    @Override
    public String visitFile(FileContext ctx) {

        visitChildren(ctx);
        System.err.println("last out hopefully");

        if (staticDeclaration.equals("")) {
            return block;
        } else {
            return staticDeclaration + "\n" + block;
        }
    }

    @Override
    public String visitMultDiv(MultDivContext ctx) {
        System.err.println("into addition");

        String leftCxt = visit(ctx.left);
        String rightCxt = visit(ctx.right);
        String localPseudoRegisters = "%" + pseudoRegisters.peek();
        pseudoRegisters.push(pseudoRegisters.pop() + 1);

        Type leftType = pseudoToTypeMap.get(leftCxt);
        Type rightType = pseudoToTypeMap.get(rightCxt);

        if (leftType == rightType) {
            pseudoToTypeMap.put(localPseudoRegisters, leftType);
        } else { 
            throw new AdditionException(leftType.name(), rightType.name(),
                    ctx.right.start);
        }

        String mathNameLLVM = "";
        
        String s = ctx.mathChar.getText();

        System.err.println("THIS IS NEW "+s);
        switch (s) {
            case "*":
                mathNameLLVM = "mul";
                System.err.println("*");
                break;
            case "/":
                mathNameLLVM = "udiv";
                System.err.println("/");
                break;
        }
        if (leftType == Type.FLOAT && !mathNameLLVM.equals("udiv")) 
            mathNameLLVM += "f"+mathNameLLVM;

        String output = 
            localPseudoRegisters + " = " + mathNameLLVM + " " + 
            leftType.typeName() + " " + 
            leftCxt + ", " + rightCxt + "\n";

        block += output;
        return localPseudoRegisters; 
    }

    @Override
    public String visitAddSub(AddSubContext ctx) {
        System.err.println("into addition");

        String leftCxt = visit(ctx.left);
        String rightCxt = visit(ctx.right);
        String localPseudoRegisters = "%" + pseudoRegisters.peek();
        pseudoRegisters.push(pseudoRegisters.pop() + 1);

        Type leftType = pseudoToTypeMap.get(leftCxt);
        Type rightType = pseudoToTypeMap.get(rightCxt);

        if (leftType == rightType) {
            pseudoToTypeMap.put(localPseudoRegisters, leftType);
        } else { 
            throw new AdditionException(leftType.name(), rightType.name(),
                    ctx.right.start);
        }

        String mathNameLLVM = "";
        
        String s = ctx.mathChar.getText();

        System.err.println("THIS IS NEW "+s);
        switch (s) {
            case "+": 
                mathNameLLVM = "add";
                System.err.println("+");
                break;
            case "-":
                mathNameLLVM = "sub";
                System.err.println("-");
                break;
        }
        if (leftType == Type.FLOAT) 
            mathNameLLVM += "f"+mathNameLLVM;

        String output = 
            localPseudoRegisters + " = " + mathNameLLVM + " " + 
            leftType.typeName() + " " + 
            leftCxt + ", " + rightCxt + "\n";

        block += output;
        return localPseudoRegisters; 
    }

    @Override
    public String visitFunctionDecl(FunctionDeclContext ctx) {
        System.err.println("into function decl");

        pseudoRegisters.push(0);
        arrayPseudoRegisters.push(0);
        String params = "";
        try { 
            params = visit(ctx.params);
        } catch(Exception e) {}
        pseudoRegisters.pop();
        arrayPseudoRegisters.pop();
        String type = visit(ctx.fnType);

        returnBoolFound.push(false);

        block += "define " + type + " @" + ctx.id.getText() +
            "(" + params + ") " + "{\n";

        //Either check or give params other pseudo name convention
        //if (pseudoRegisters.peek() == 0) {
        pseudoRegisters.push(1);
        arrayPseudoRegisters.push(1);
        //}

        ifElse.push(1);

        String blockRet = visit(ctx.bl);

        ifElse.pop();
        pseudoRegisters.pop();
        arrayPseudoRegisters.pop();
        //block += blockRet;


        if (type == "void") {
            block += "ret void\n";
            returnBoolFound.pop();
            returnBoolFound.push(true);
        }

        if (!returnBoolFound.pop()) {
            throw new NoReturnException(ctx.id);
        }

        block +=  "}\n";
        return "";
    }

    @Override
    public String visitReturn(ReturnContext ctx) {
        if (returnBoolFound.peek())
            throw new MultipleReturnException(ctx.ret);

        returnBoolFound.pop();
        returnBoolFound.push(true);

        String retVar = visit(ctx.returnE);
        Type returnType = pseudoToTypeMap.get(retVar);
        block += "ret " + returnType.typeName() + " " + retVar + "\n";
        return "";
    }

    @Override
    public String visitFormalParameters(FormalParametersContext ctx) {
        System.err.println("into params");
        int count = ctx.getChildCount();

        String params = "";
        for (int i = 0; i < count; i=i+2) {
            params += visit(ctx.getChild(i));

            if (i < count-1)
                params += ",";
        }
        return params;
    }

    @Override
    public String visitFormalParameter(FormalParameterContext ctx) {
        System.err.println("into param");
        String id = ctx.id.getText();
        Type type = Type.fromString(visit(ctx.paramType));

        String localPseudoRegisters = "%tmp" + pseudoRegisters.peek();
        pseudoRegisters.push(pseudoRegisters.pop() + 1);

        pseudoToTypeMap.put(localPseudoRegisters, type);
        stubVarToPseudoMap.put(id, (Object) new VarWrapper(localPseudoRegisters, type));
        return type.typeName() + " " + localPseudoRegisters;
    }

    @Override
    public String visitNumber(NumberContext ctx) {
        System.err.println("into number");
        pseudoToTypeMap.put(ctx.number.getText(), compiler.Type.INT);
        return ctx.number.getText();
    }

    @Override
    public String visitFloat(FloatContext ctx) {
        System.err.println("into float");
        long bits = Double.doubleToLongBits(Double.valueOf(ctx.number.getText()));
        String binary = Long.toBinaryString(bits);
        int decimal = Integer.parseInt(binary, 2);
        String returnString = Integer.toString(decimal, 16);
        returnString = "0x" + returnString;
        
        //String returnString = Integer.toString(Float.valueOf(ctx.number.getText()), 16);
        //String returnString = String.valueOf(Float.floatToRawIntBits(Float.valueOf(ctx.number.getText())));
        /*
        String returnString = ctx.number.getText();
        StringBuffer strBuf = new StringBuffer(returnString);
        int i = returnString.indexOf(".");
        System.err.println(i);
        if (i != 1) {
            strBuf.insert(1, ".");
        }
        System.err.println(i);
        String end = "e+0"+(--i);
        System.err.println(end);
        strBuf.insert(strBuf.length(), end);
        returnString = strBuf.toString();
        */

        System.err.println(returnString);
        pseudoToTypeMap.put(returnString, compiler.Type.FLOAT);
        return returnString;
    }

    @Override
    public String visitBlock (BlockContext ctx) {
        System.err.println("into block");
        blockStack.push(block);
        block = "";

        HashMap<String, Object>  oldMap = (HashMap<String, Object>) stubVarToPseudoMap.clone();
        stubVarToPseudoMap = new HashMap<>();
        System.err.println("New Map before block before put all : "+stubVarToPseudoMap);
        stubVarToPseudoMap.putAll(oldMap);
        System.err.println("New Map before block after put all : "+stubVarToPseudoMap);

        String ret = visitChildren(ctx);

        System.err.println("Old Map After block should have b: "+stubVarToPseudoMap);
        stubVarToPseudoMap = oldMap;
        System.err.println("Old Map After block: "+stubVarToPseudoMap);
        System.err.println("Old Map After block: "+oldMap);
        
        String retBlock =  block;
        block = blockStack.pop();
        block += retBlock;
        return "";
    }

    @Override
    public String visitExpression (ExpressionContext ctx) {
        //get each expression
        System.err.println("into stat");
        return visitChildren(ctx);
    }

    /*
    @Override 
    public String visitPrintNewline(PrintNewlineContext ctx) {
        System.err.println("into visitPrintNewline");
        String localPseudoRegisters = "%" + pseudoRegisters.peek();
        pseudoRegisters.push(pseudoRegisters.pop() + 1);
        // TODO set type of pseudoRegister
        String expressions = visit(ctx.expressions);
        System.err.println(expressions);
        /*
        StringWrapper stringVarValue = staticStringMap.get(expressions);
        System.err.println(stringVarValue.getString());
        int len = stringVarValue.getLength();
        */

    /*
        block += localPseudoRegisters+" = call  i32 (i8*, ...) "+
            "@printf(" + expressions + ")\n";

        return localPseudoRegisters;
    }
    */

    @Override
    public String visitString(StringContext ctx) {
        System.err.println("into visitString");
        String stringRegister = "@.str_"+staticStringReferencePart++;
        String string = ctx.chars.getText().replaceAll("\"", "");

        int len = string.length();
        string = string.replace("\\n", "\\0A");
        len -= (string.length() - len);
        len += 2;

        staticStringMap.put(stringRegister, new StringWrapper(string, len));
        staticDeclaration += stringRegister + " = private unnamed_addr constant [" + 
            len + " x i8] c\"" + string + "\\0A\\00\"\n";
        System.err.println(staticDeclaration);
        
        String expr = "i8* getelementptr inbounds"+
            " (["+len+" x i8], ["+len+" x i8]* "+
            stringRegister+", i64 0, i64 0)";
        return expr;
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
                return "";
        }
    }

    @Override
    public String visitVarDeclaration(VarDeclarationContext ctx) {

        String declarationVar = null;
        Type declarationType = null;
        try {
            declarationVar = visit(ctx.expression);
            declarationType = pseudoToTypeMap.get(declarationVar);
        } catch(Exception e) {}


        String id = ctx.identifier.getText();
        Type type = Type.fromString(visit(ctx.varType));

        String localPseudoRegisters = "%" + pseudoRegisters.peek();
        pseudoRegisters.push(pseudoRegisters.pop() + 1);

        pseudoToTypeMap.put(localPseudoRegisters, type);
        stubVarToPseudoMap.put(id, (Object) new VarWrapper(localPseudoRegisters, type));
        System.err.println("Put "+id+" into stubVarToPseudoMap, resulting in: "+stubVarToPseudoMap);
        //HashMap which maps varName to pseudoRegister but also rembers type, maybe create VarWrapper
        //Initalize a varibel through allocating and if declaration then store 

        String initialize = localPseudoRegisters + " = alloca " + type.typeName() + ", align 4\n";
        block += initialize;
        if (declarationVar != null) {
            if (!type.name().equals(declarationType.name())) {
                throw new AssignmentException(declarationType.name(),
                        type.name(),
                        ctx.expression.start);
            }
            String declaration = "store " + type.typeName() + " " 
                + declarationVar + ", " + type.typeName() + 
                "* " + localPseudoRegisters + ", align 4\n";
            block += declaration;
        }

        return id;
    }

    @Override 
    public String visitAssignExpr(AssignExprContext ctx) {
        String left = visit(ctx.left);
        String right = visit(ctx.right);

        Type leftType = pseudoToTypeMap.get(left);
        Type rightType = pseudoToTypeMap.get(right);

        System.err.println("EQUALS: " + leftType.name() + " || " + rightType.name());
        if (!leftType.name().equals(rightType.name())) {
            throw new AssignmentException(leftType.name(),
                    rightType.name(),
                    ctx.right.start);
        }
        block += "store " + leftType.typeName() + " " + right + ", " +  
            rightType.typeName() + "* " + left + ", align 4\n";

        return "";
    }


    @Override
    public String visitFunctionCall(FunctionCallContext ctx) {
        System.err.println("In MyVisitor into visitFunctionCall");
        // Check if called Function is in generated functionList

        Function oldFunction = currentCalledFunction;
        currentCalledFunction = new Function(ctx.id.getText());
        // We have the name but we also need the all parmaters in order to look up id the function is in the list
        // their may are no parameters if the function call after all
        String llvmParameters = "";
        try {
            llvmParameters = visit(ctx.expressions);
        } catch (UndeclaredVariableException e) { 
            throw e;
        } catch (UnknownFunctionException e) {
            throw e;
        } catch (Exception e) {
            System.err.println(e);
        }

        boolean found = false;
        Function fn = null;
        for (Function function : functionList) {
            if (Function.compare(currentCalledFunction, function)) {
                fn = function;
                found = true;
                break;
            }
        }
        if (!found) {
            throw new UnknownFunctionException(ctx.id);
        }
        currentCalledFunction = oldFunction;

        String functionName = fn.getName();
        String returnString = fn.getRetType().typeName();

        if (functionName.equals("println")) {
            functionName = "printf";
            returnString += " (i8*, ...)";
        }

        String functionCall = 
            "call " + returnString + " @" + 
            functionName + "(" + llvmParameters + ")\n";

        String localPseudoRegisters = "";

        if (fn.getRetType() != Type.VOID) {
            localPseudoRegisters = "%" + pseudoRegisters.peek();
            pseudoRegisters.push(pseudoRegisters.pop() + 1);
            pseudoToTypeMap.put(localPseudoRegisters, fn.getRetType());

            functionCall = localPseudoRegisters + " = " + functionCall;
        }

        block += functionCall;
        return localPseudoRegisters; 
    }

    @Override
    public String visitExprList(ExprListContext ctx) {
        boolean printf = 
            ((FunctionCallContext) ctx.getParent()).id.getText() 
                == "println" ? false : true;

        // get each child what it returns
        int count = ctx.getChildCount();
        String expressionList = "";
        for (int i = 0; i < count; i=i+2) {
           String variable = visit(ctx.getChild(i)); 
           // get variable from return, if it is in 

           Type type;
           try { 
               type = pseudoToTypeMap.get(variable);
           } catch (NullPointerException e) {
               type = null;
           }
            
           //Ugly check for printf because we use libc's printf
           if (printf && type == Type.FLOAT) {
                String oldVariable = variable;

                variable = "%" + pseudoRegisters.peek();
                pseudoRegisters.push(pseudoRegisters.pop() + 1);

                block += variable + " = fpext float" + 
                    oldVariable + " to double\n";

                pseudoToTypeMap.put(variable, compiler.Type.DOUBLE);
                type = Type.DOUBLE;
           }

           // special case when println returns getpointer
           if (type != null) {
               expressionList += type.typeName() + " " + variable;
               currentCalledFunction.addParameter(new Pair<Type, String>(type, ""));
           } else {
               expressionList += variable;
           }


           if (i < count-1)
               expressionList += ",";
        }
        return expressionList;
    }

    @Override
    public String visitIdentifier(IdentifierContext ctx) {
        //get identifier name, check if it is in stubVarToPseudoMap if yes return the pseudoRegister
        System.err.println("into visitIdentifier");
        String variable = ctx.id.getText();

        // TODO load from the pseudo pointer to a new pseudo and return this one
         
        VarWrapper varWrapper = (VarWrapper) stubVarToPseudoMap.get(variable);
        if (varWrapper == null) {
            throw new UndeclaredVariableException(ctx.id);
        }
        String pointerPseudo = varWrapper.getPseudo();
        Type type = varWrapper.getType();
        //Type type = pseudoToTypeMap.get(pointerPseudo);


        // Check if the parent node in the tree will want a pointer or the real value
        if (ctx.getParent().getClass() != AssignExprContext.class) {

            // if variable comes from formal parameters of a function declaration
            if (pointerPseudo.contains("tmp"))
                    return pointerPseudo;

            String localPseudoRegisters = "%" + pseudoRegisters.peek();
            pseudoRegisters.push(pseudoRegisters.pop() + 1);

            pseudoToTypeMap.put(localPseudoRegisters, type);

            block += localPseudoRegisters + " = load " + 
                type.typeName() + ", " + type.typeName() + "* " + 
                pointerPseudo + ", align 4\n";

            return localPseudoRegisters;
        }

        return pointerPseudo;
    }

    @Override
    public String visitIfElse(IfElseContext ctx) {
        String exprPseudo = visit(ctx.expression);
        Type type = pseudoToTypeMap.get(exprPseudo);
        Pair<String, String> returnPair = Type.trunc(exprPseudo, type, Type.INT1,
                                  pseudoRegisters, block);
        block = returnPair.getValue();
        exprPseudo = returnPair.getKey();
        pseudoToTypeMap.put(exprPseudo, Type.INT1);
        int ifElseNumber = ifElse.peek();
        ifElse.push(ifElse.pop()+1);

        String ifTrue = "if"+ifElseNumber+"true";
        String ifFalse = "if"+ifElseNumber+"false";
        String ifEnd = "if"+ifElseNumber+"end";

        block += "br i1 "+exprPseudo+", label %"+ifTrue+","+
            " label %"+ifFalse+"\n";

        // Before visiting the blocks save the old block and create a new one
        String oldBlock = block;
        block = "\n";

        boolean returnBoolFinallyFound = false;
        returnBoolFound.push(returnBoolFound.peek());

        block += ifTrue+":\n";
        visit(ctx.thenBlock); 
        block += "br label %"+ifEnd+"\n";

        boolean thenBlockReturn = returnBoolFound.pop();

        if (ctx.elseBlock != null) {
            try {
                returnBoolFound.push(false);

                String secondOldBlock = block;
                block = "\n";
                block += ifFalse+":\n";
                visit(ctx.elseBlock);
                block += "br label %"+ifEnd+"\n";
                secondOldBlock += block;
                block = secondOldBlock;

                boolean elseBlockFound = returnBoolFound.pop();
                returnBoolFinallyFound = (thenBlockReturn && elseBlockFound);
            } catch (Exception e) {}
        } else {
            returnBoolFinallyFound = thenBlockReturn;
        }

        if (returnBoolFinallyFound) {
            // returnBoolFound.pop();
            // returnBoolFound.push(returnBoolFinallyFound);
            // do nothing llvm still needs a return maybe solve with flag 
        }

        block += "\n"+ifEnd+":\n";
        oldBlock += block;
        block = oldBlock;
        return ""; 
    }

    @Override 
    public String visitArrayDeclaration(ArrayDeclarationContext ctx) {
        Type type = Type.fromString(visit(ctx.varType));
        String identifier = ctx.identifier.getText();
        int count = Integer.valueOf(ctx.count.getText());

        String localPseudoRegisters = "%array" + arrayPseudoRegisters.peek();
        arrayPseudoRegisters.push(arrayPseudoRegisters.pop() + 1);
        pseudoToTypeMap.put(localPseudoRegisters, type);

        stubVarToPseudoMap.put(identifier,
                (Object) new ArrayWrapper(localPseudoRegisters, count, type));

        block += localPseudoRegisters+" = alloca ["+
            count+" x "+type.typeName()+"]\n";

        return localPseudoRegisters;
    }

    @Override
    public String visitIndexE(IndexEContext ctx) {
        String index = visit(ctx.index);
        String arrayIdentifier = ctx.array.getText();

        ArrayWrapper stubVar;
        try {
            stubVar = (ArrayWrapper) stubVarToPseudoMap.get(arrayIdentifier);
        } catch (ClassCastException e) {
            throw new ValueIsNoArrayException(ctx.array.start);
        } catch (Exception e) {
            throw e;
        }

        String pseudoName = stubVar.getPseudo();
        Type type = stubVar.getType();
        int count = stubVar.getCount();


        String localPseudoRegisters = "%array" + arrayPseudoRegisters.peek();
        arrayPseudoRegisters.push(arrayPseudoRegisters.pop() + 1);
        pseudoToTypeMap.put(localPseudoRegisters, type);
        
        block += localPseudoRegisters+" = getelementptr ["+count+" x "+
            type.typeName()+"], ["+count+" x "+type.typeName()+"]* "+
            pseudoName+", i64 0, i64 "+index+"\n";    

        if (ctx.getParent().getClass() != AssignExprContext.class) {
            // if variable comes from formal parameters of a function declaration
            // TODO check if arrays in functionDeclaration work
            if (pseudoName.contains("tmp"))
                    return pseudoName;

            String newlocalPseudoRegisters = "%" + pseudoRegisters.peek();
            pseudoRegisters.push(pseudoRegisters.pop() + 1);

            pseudoToTypeMap.put(newlocalPseudoRegisters, type);

            block += newlocalPseudoRegisters + " = load " + 
                type.typeName() + ", " + type.typeName() + "* " + 
                localPseudoRegisters + "\n";

            return newlocalPseudoRegisters;
        }
        return localPseudoRegisters; 
    }

    @Override
    protected String aggregateResult(String aggregate, String nextResult) {
        if (aggregate == null) {
            return nextResult;
        } 
        if (nextResult == null) {
            return aggregate;
        }
        return aggregate + "\n" + nextResult;
    }
}
