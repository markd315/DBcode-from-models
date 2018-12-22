package markd315.dbGen;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        //traverse folder: src/main/java/io/swagger/model and read class names into
        Set<String> classNames;
        //TODO

        //read, replace, and write the following files:
        //mongo/pom.xml -> pom.xml

    }

    private static String readFileSingleString(String path){
        String fileContents;
        try {
            Scanner sc = new Scanner(new File(path));
            fileContents = sc.useDelimiter("\\Z").next();
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "err";
        }
        return fileContents;
    }
}
