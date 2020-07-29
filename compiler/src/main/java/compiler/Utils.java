package compiler;

import java.io.IOException;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.FileNotFoundException;

//delete recursively https://stackoverflow.com/questions/779519/delete-directories-recursively-in-java
public class Utils {
    public static void delete(File f) throws IOException {
        if (f.isDirectory()) {
            for (File c : f.listFiles())
                delete(c);
        }
        if (!f.delete()) {
            throw new FileNotFoundException("Failed to delete file: " + f);
        }
    }

    /**
     * Create a temp directory to 
     * */
    public static Path createTmpDir() throws IOException {
        try {
            Path path = Files.createTempDirectory("stub-java-compile-");
            return path;
        } catch (IOException ex) {
            throw ex;
        }
    }
}
