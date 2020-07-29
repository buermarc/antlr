package compiler;

import java.nio.file.Paths;
import java.nio.file.Path;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileWriter;

import java.util.List;

import org.parser.StubLexer;
import org.parser.StubParser;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;


public class Main {

    public static void main(String[] args) throws Exception {
        System.err.println("entry");
        Path path;
        if (args.length == 1) {
            path = Paths.get(args[0]);
        } else {
            throw new Exception("No input file given");
        }

        Path tmpDirPath = Utils.createTmpDir();
        try {
            System.err.println(tmpDirPath.toString());

            String generatedIrString = Main.generateIrString(path);
            System.err.println(generatedIrString);

            Path irPath = Main.writeStringToIrFile(path.getFileName().toString(), tmpDirPath, generatedIrString);
            irPath = Main.runOpt(irPath);
            Path bytePath = Main.runLLC(irPath);

            String outputPath = Paths.get(path.toAbsolutePath().getParent().toString(),
                                          path.getFileName()
                                              .toString()
                                              .replace(".st","")).toString();

            Main.runClang(outputPath, bytePath);
        } catch (Exception e) {
            compiler.Utils.delete(tmpDirPath.toFile());
            throw e;
        }
        compiler.Utils.delete(tmpDirPath.toFile());

    }

    public static String generateIrString(Path path) throws Exception {
        CharStream input = CharStreams.fromPath(path);
        StubLexer lexer= new StubLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        StubParser parser = new StubParser(tokens);

        parser.removeErrorListeners();
        parser.addErrorListener(new VerboseListener());
        ParseTree tree = parser.file();

        FunctionVisitor functionVisitor = new FunctionVisitor();
        functionVisitor.visit(tree);

        String staticDefinitions =  functionVisitor.getStaticDefinitions();
        List<Function> functionList = functionVisitor.getFunctionList();

        MyVisitor myVisitor = new MyVisitor(staticDefinitions, functionList);
        return myVisitor.visit(tree);
    }

    public static Path writeStringToIrFile(String name, Path tmpDirPath, String generatedIrString) throws Exception {
        if (name.endsWith(".st")) {
            name = name.replace(".st", ".ll");
        } else {
            throw new Exception("Input File is no stub file, has to to end with '.st', i.e. MyProgram.st");
        }
        File irFile = new File(tmpDirPath.toString(), name);
        FileWriter writer = new FileWriter(irFile);
        writer.write(generatedIrString);
        writer.close();
        return irFile.toPath();

    }


    /**
     * run llc on the created ir code
     * @ param path the path to the ir code
     * @returns     the path to the byte code
     * */
    public static Path runLLC(Path irPath) throws Exception {
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("llc", irPath.toAbsolutePath().toString());
        Pair<Integer, String> pair = Main.executeCommand(processBuilder);

        if (pair.getKey() != 0) {
            throw new Exception(String
                    .format("llc command failed :%s\nreturncode is:%d",
                            pair.getValue(), pair.getKey()));
        }
        
        return Paths.get(irPath.toString().replace(".ll", ".s"));
    }

    /**
     * run opt on the created ir code
     * @ param path the path to the ir code
     * @returns     the path to the byte code
     * */
    public static Path runOpt(Path irPath) throws Exception {
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("opt", "-S", "-mem2reg", "-instnamer", irPath.toAbsolutePath().toString(), "-o", irPath.toString());
        Pair<Integer, String> pair = Main.executeCommand(processBuilder);

        if (pair.getKey() != 0) {
            throw new Exception(String
                    .format("opt command failed :%s\nreturncode is:%d",
                            pair.getValue(), pair.getKey()));
        }
        
        return Paths.get(irPath.toString());
    }

    /**
     * Help function to read the input given from the executed command stdout and stderr
     * */
    public static Pair<Integer, String> executeCommand(ProcessBuilder processBuilder) {
        String output = "";
        Integer exitCode = -1;

        try {
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                output += line+"\n";
            }

            reader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            while ((line = reader.readLine()) != null) {
                output += line+"\n";
            }

            exitCode = process.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Pair<Integer, String>(exitCode, output);
    }
    
    /**
     * run clang on the created byte code
     * flags given to clang:
     *  -no-pie
     * */
    public static void runClang(String outputPath, Path bytePath) throws Exception {
        ProcessBuilder processBuilder = new ProcessBuilder();


        System.err.println(outputPath);
        processBuilder.command("clang", "-no-pie",
                               bytePath.toAbsolutePath().toString(),
                               "-o", outputPath);
        Pair<Integer, String> pair = Main.executeCommand(processBuilder);

        if (pair.getKey() != 0) {
            throw new Exception(String
                    .format("clang command failed :%s\nreturncode is:%d",
                            pair.getValue(), pair.getKey()));
        }
    }
}
