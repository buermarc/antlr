package compiler;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

import compiler.exceptions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StubTests {
    static Path tmpDirPath;

    @BeforeAll
    static public void setUp() throws Exception {
        tmpDirPath = compiler.Utils.createTmpDir();
    }
    
    @AfterAll
    static public void cleanUp() throws Exception {
        compiler.Utils.delete(tmpDirPath.toFile());
    }

    static private String generateIrStringForTest(String name) throws Exception {
        Path path = Paths.get("src/test/resources/"+name);
        return Main.generateIrString(path);
    }

    static private String getAssertIrString(String name) throws Exception {
        Path path = Paths.get("src/test/resources/"+name);
        return new String(Files.readAllBytes(path));
    }

    static private compiler.Pair<Integer, String> executeIr(String name) throws Exception {
        String irString = StubTests.generateIrStringForTest(name);
        Path irPath = Main.writeStringToIrFile(name, tmpDirPath, irString);
        irPath = Main.runOpt(irPath);
        Path bytePath = Main.runLLC(irPath);
        String outputPath = Paths.get(tmpDirPath.toAbsolutePath().toString(),
                                      name.replace(".st","")).toString();
        Main.runClang(outputPath, bytePath);

        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command(outputPath);
        return Main.executeCommand(processBuilder);
    }

    static private Pair<Integer, String> assertBase(String name) throws Exception {
        assertEquals(getAssertIrString(name+".ll"),
                     generateIrStringForTest(name+".st"));
        return executeIr(name+".st");
    }

    @Test
    void testAddition_1() throws Exception {
        String name = "addition_test1";

        Pair<Integer, String> retPair = StubTests.assertBase(name);

        assertEquals(Integer.valueOf(56), retPair.getKey());
    }

    @Test
    void testPrintln_1() throws Exception {
        String name = "println_test1";
        Pair<Integer, String> retPair = StubTests.assertBase(name);

        assertEquals(Integer.valueOf(0), retPair.getKey());
        assertEquals("Hello World\nHello World\n\nHello\n World\n\n",
                     retPair.getValue());
    }

    @Test
    void testPrintln_2() throws Exception {
        String name = "println_test2";
        Pair<Integer, String> retPair = StubTests.assertBase(name);

        assertEquals("The Number is 4\nHI\n",
                     retPair.getValue());
    }

    @Test
    void testFunctionCall_1() throws Exception {
        String name = "function_call_test1";
        Pair<Integer, String> retPair = StubTests.assertBase(name);

        assertEquals(Integer.valueOf(2), retPair.getKey());
        assertEquals("HI\n",
                     retPair.getValue());
    }

    @Test
    void testFunctionCall_2() throws Exception {
        String name = "function_call_test2";
        Pair<Integer, String> retPair = StubTests.assertBase(name);

        assertEquals(Integer.valueOf(0), retPair.getKey());
        assertEquals("HI\n5\n",
                     retPair.getValue());
    }

    @Test
    void testFunctionCall_3() throws Exception {
        String name = "function_call_test3";
        Pair<Integer, String> retPair = StubTests.assertBase(name);

        assertEquals(Integer.valueOf(0), retPair.getKey());
        assertEquals("HI\n5\n",
                     retPair.getValue());
    }

    @Test
    void testVariable_1() throws Exception {
        String name = "variable_test1";
        Pair<Integer, String> retPair = StubTests.assertBase(name);

        assertEquals(Integer.valueOf(0), retPair.getKey());
        assertEquals("a is 3 and b is 4\n",
                     retPair.getValue());
    }

    @Test
    void testUndeclaredVariable() throws Exception {
        String name = "undeclared_variable_test_exc";
        UndeclaredVariableException e = Assertions.assertThrows(UndeclaredVariableException.class, () -> {
            generateIrStringForTest(name+".st"); 
        });
        assertEquals("\n2:11 undeclared variable <a>:\n>    return a;\n            ^", e.getMessage());
    }

    @Test
    void testAssignmentEx_1() throws Exception {
        String name = "assignment_test1_exc";
        AssignmentException e = Assertions.assertThrows(AssignmentException.class, () -> {
            generateIrStringForTest(name+".st"); 
        });
        assertEquals("\n" +
                     "3:14 Tried to assign INT to FLOAT\n"+
                     ">    float f = i;\n"+
                     "               ^",
                     e.getMessage());
    }

    @Test
    void testUndefinedFunction_1() throws Exception {
        String name = "unknown_function_test1_exc";
        UnknownFunctionException e = Assertions.assertThrows(UnknownFunctionException.class, () -> {
            generateIrStringForTest(name+".st"); 
        });
        assertEquals("\n" +
                     "2:4 Unknown Function call_unknown_function called\n"+
                     ">    call_unknown_function(1, 2, 3);\n"+
                     "     ^^^^^^^^^^^^^^^^^^^^^",
                     e.getMessage());
    }

    @Test
    void testAdditionException_1() throws Exception {
        String name = "addition_exception_test1";
        AdditionException e = Assertions.assertThrows(AdditionException.class, () -> {
            generateIrStringForTest(name+".st"); 
        });
        assertEquals("\n" +
                     "4:15 Tried to add FLOAT to INT\n"+
                     ">    return a + b;\n"+
                     "                ^", 
                     e.getMessage());
    }

    @Test
    void testIfElse_1() throws Exception {
        String name = "if_else_test1";
        Pair<Integer, String> retPair = StubTests.assertBase(name);

        assertEquals(Integer.valueOf(0), retPair.getKey());
        assertEquals("TRUE\nALWAYS\n",
                     retPair.getValue());
    }

    @Test
    void testIfElse_2() throws Exception {
        String name = "if_else_test2";
        Pair<Integer, String> retPair = StubTests.assertBase(name);

        assertEquals(Integer.valueOf(0), retPair.getKey());
        assertEquals("ALWAYS\n",
                     retPair.getValue());
    }

    @Test
    void testIfElse_3() throws Exception {
        String name = "if_else_test3";
        Pair<Integer, String> retPair = StubTests.assertBase(name);

        assertEquals(Integer.valueOf(0), retPair.getKey());
        assertEquals("TRUE\nALWAYS\n",
                     retPair.getValue());
    }

    @Test
    void testDivision_1() throws Exception {
        String name = "div_test1";
        Pair<Integer, String> retPair = StubTests.assertBase(name);

        assertEquals(Integer.valueOf(0), retPair.getKey());
        assertEquals("5\n3\n2\n",
                     retPair.getValue());
    }

    @Test
    void testMultiplication_1() throws Exception {
        String name = "mult_test1";
        Pair<Integer, String> retPair = StubTests.assertBase(name);

        assertEquals(Integer.valueOf(0), retPair.getKey());
        assertEquals("96\n",
                     retPair.getValue());
    }

    @Test
    void testSubstraction_1() throws Exception {
        String name = "sub_test1";
        Pair<Integer, String> retPair = StubTests.assertBase(name);

        assertEquals(Integer.valueOf(0), retPair.getKey());
        assertEquals("-50\n",
                     retPair.getValue());
    }

    @Test
    void testMath_1() throws Exception {
        String name = "math_test1";
        Pair<Integer, String> retPair = StubTests.assertBase(name);

        assertEquals(Integer.valueOf(0), retPair.getKey());
        assertEquals("22\n",
                     retPair.getValue());
    }

    @Test
    void testMath_2() throws Exception {
        String name = "math_test2";
        Pair<Integer, String> retPair = StubTests.assertBase(name);

        assertEquals("-35\n-35\n",
                     retPair.getValue());
    }

    @Test
    void testNoReturnException_1() throws Exception {
        String name = "no_return_test1_exc";
        NoReturnException e = Assertions.assertThrows(NoReturnException.class, () -> {
            generateIrStringForTest(name+".st"); 
        });
        assertEquals("\n"+
                     "1:4 No return statement in function <main>\n" +
                     ">int main() {\n" +
                     "     ^^^^",
                     e.getMessage());
    }

    @Test
    void testNoReturnException_2() throws Exception {
        String name = "no_return_test2_exc";
        NoReturnException e = Assertions.assertThrows(NoReturnException.class, () -> {
            generateIrStringForTest(name+".st"); 
        });
        assertEquals("\n"+
                     "1:4 No return statement in function <main>\n" +
                     ">int main() {\n" +
                     "     ^^^^",
                     e.getMessage());
    }

    @Test
    void testMultipleReturns_1() throws Exception {
        String name = "multiple_return_test1";
        Pair<Integer, String> retPair = StubTests.assertBase(name);

        assertEquals(Integer.valueOf(1), retPair.getKey());
        assertEquals("this\n",
                     retPair.getValue());
    }

    @Test
    void testMultipleReturnException_1() throws Exception {
        String name = "multiple_return_test2_exc";
        MultipleReturnException e = Assertions.assertThrows(MultipleReturnException.class, () -> {
            generateIrStringForTest(name+".st"); 
        });
        assertEquals("\n"+
                     "12:4 Multiple return statements\n" +
                     ">    return 8;\n" +
                     "     ^^^^^^",
                     e.getMessage());
    }

    @Test
    void testArray_1() throws Exception {
        String name = "array_test1";
        Pair<Integer, String> retPair = StubTests.assertBase(name);

        assertEquals(Integer.valueOf(0), retPair.getKey());
        assertEquals("1\n",
                     retPair.getValue());
    }

    @Test
    void testArray_2() throws Exception {
        String name = "array_test2_exc";
        ValueIsNoArrayException e = Assertions.assertThrows(ValueIsNoArrayException.class, () -> {
            generateIrStringForTest(name+".st"); 
        });
        assertEquals("\n"+
                    "3:4 Value is not an array <i>\n"+
                    ">    i[0];\n"+
                    "     ^",
                    e.getMessage());
    }
}
