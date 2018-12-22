package markd315.dbGen;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        //traverse folder: src/main/java/io/swagger/model and read class names into
        Set<String> classNames = new HashSet<>();
        classNames.add("Pet");
        //TODO

        //read, replace, and write the following files:
        //mongo/pom.xml -> pom.xml
        for(String classname : classNames){
            //Write a Repository file for every single class.
            String fileContents = MongoConst.getClassRepository().replaceAll("\\{\\{Class\\}\\}", classname).replaceAll("\\{\\{class\\}\\}",classname.toLowerCase());
            //System.out.println(fileContents);
            fileWrite(fileContents, "src/main/java/io/swagger/repository/"+classname+"Repository.java");

            //Collect all three of the service code blocks for this Model class.
            String implMethodClass = MongoConst.getImplMethodLoop().replaceAll("\\{\\{Class\\}\\}", classname).replaceAll("\\{\\{class\\}\\}",classname.toLowerCase());
            String interfaceMethodClass = MongoConst.getInterfaceMethodLoop().replaceAll("\\{\\{Class\\}\\}", classname).replaceAll("\\{\\{class\\}\\}",classname.toLowerCase());
            String modelImportClass = MongoConst.getModelImportLoop().replaceAll("\\{\\{Class\\}\\}", classname);

            //Inject the service code blocks without destroying the loop label
        }
        //Destruct the loop labels in the service classes once all model code blocks are loaded.

        //Write a single Service Interface and Service Impl with parts from every model class.
    }

    private static void fileWrite(String contents, String path){
        try {
            FileWriter fileWriter = new FileWriter(new File(path));
            fileWriter.write(contents);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
