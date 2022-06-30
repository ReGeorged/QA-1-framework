package utils;
import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtils {

    public static boolean isEmpty(String pathString)  {
        Log4jUtil.log4J.info("Check if "+pathString +" is empty");
        Path path = Paths.get(pathString);
        if (Files.isDirectory(path)) {
            try (DirectoryStream<Path> directory = Files.newDirectoryStream(path)) {
                return !directory.iterator().hasNext();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }


    public static void deleteIfNotEmpty(String path) {
        Log4jUtil.log4J.info("Delete all files in "+path+" if not empty");
        try {
            if (isEmpty(path) == false) {
                File directory = new File(path);
                org.apache.commons.io.FileUtils.cleanDirectory(directory);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static String getAbsolutePath(String relativePath){
        Log4jUtil.log4J.info("get absolute path from relative path: "+ relativePath);
        String absolute = null;
        try {
            absolute = new File(relativePath).getCanonicalPath();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return absolute;
    }

}
