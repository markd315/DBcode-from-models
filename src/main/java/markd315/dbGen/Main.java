package markd315.dbGen;

import com.mongodb.Mongo;

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
        File folder = new File("src/main/java/io/swagger/model");
        File[] filenames = folder.listFiles();
        Set<String> classNames = new HashSet<>();
        for(File file : filenames){
            classNames.add(file.getName().replaceAll(".java", ""));
        }
        mongoScaffold(classNames);
    }


    private static void mongoScaffold(Set<String> classNames){
        String implClass = MongoConst.getResourceServiceImpl();
        String serviceInterface = MongoConst.getResourceService();

        for(String classname : classNames){
            //Write a Repository file for every single class.
            String fileContents = MongoConst.getClassRepository().replaceAll("\\{\\{Class\\}\\}", classname).replaceAll("\\{\\{class\\}\\}",classname.toLowerCase());
            //System.out.println(fileContents);
            fileWrite(fileContents, "src/main/java/io/swagger/repository/"+classname+"Repository.java");

            //Inject the service code blocks without destroying the loop label
            implClass = implClass.replaceAll("\\{\\{implMethodLoop\\}\\}", MongoConst.getImplMethodLoop() + "\\{\\{implMethodLoop\\}\\}\n");
            implClass = implClass.replaceAll("\\{\\{modelImportLoop\\}\\}", MongoConst.getModelImportLoop() + "\\{\\{modelImportLoop\\}\\}");
            implClass = implClass.replaceAll("\\{\\{constructorParamLoop\\}\\}", MongoConst.getConstructorParamLoop()+ "\\{\\{constructorParamLoop\\}\\}");
            implClass = implClass.replaceAll("\\{\\{constructorFieldLoop\\}\\}", MongoConst.getConstructorFieldLoop() + "\\{\\{constructorFieldLoop\\}\\}");
            serviceInterface = serviceInterface.replaceAll("\\{\\{interfaceMethodLoop\\}\\}", MongoConst.getInterfaceMethodLoop() + "\\{\\{interfaceMethodLoop\\}\\}\n");
            serviceInterface = serviceInterface.replaceAll("\\{\\{modelImportLoop\\}\\}", MongoConst.getModelOnlyImportLoop() + "\\{\\{modelImportLoop\\}\\}");

            //Replace class names for these two files as well.
            implClass = implClass.replaceAll("\\{\\{Class\\}\\}", classname).replaceAll("\\{\\{class\\}\\}",classname.toLowerCase());
            serviceInterface = serviceInterface.replaceAll("\\{\\{Class\\}\\}", classname).replaceAll("\\{\\{class\\}\\}",classname.toLowerCase());

        }

        //Destruct the loop labels in the service classes once all model code blocks are loaded.
        implClass = implClass.replaceAll("\\{\\{implMethodLoop\\}\\}\n\n\n", "");
        implClass = implClass.replaceAll("\\{\\{modelImportLoop\\}\\}\n", "");
        implClass = implClass.replaceAll("\\{\\{constructorFieldLoop\\}\\}\n", "");
        implClass = implClass.replaceAll(", \\{\\{constructorParamLoop\\}\\}\n", "");
        serviceInterface = serviceInterface.replaceAll("\\{\\{interfaceMethodLoop\\}\\}\n\n", "");
        serviceInterface = serviceInterface.replaceAll("\\{\\{modelImportLoop\\}\\}\n\n", "");
        //Write a single Service Interface and Service Impl with parts from every model class.
        fileWrite(implClass, "src/main/java/io/swagger/service/ResourceServiceImpl.java");
        fileWrite(serviceInterface, "src/main/java/io/swagger/service/ResourceService.java");
        fileWrite(MongoConst.getPOM(), "pom.xml");
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
