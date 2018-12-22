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
        Set<String> classNames = new HashSet<>();
        classNames.add("Pet");
        classNames.add("User");
        //TODO load model names for real

        //TODO something similar with the pom.xml
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
            implClass = implClass.replaceAll("\\{\\{constructorParamLoop\\}\\}", MongoConst.getModelImportLoop() + "\\{\\{constructorParamLoop\\}\\}");
            implClass = implClass.replaceAll("\\{\\{constructorFieldLoop\\}\\}", MongoConst.getModelImportLoop() + "\\{\\{constructorFieldLoop\\}\\}");
            serviceInterface = serviceInterface.replaceAll("\\{\\{interfaceMethodLoop\\}\\}", MongoConst.getInterfaceMethodLoop() + "\\{\\{interfaceMethodLoop\\}\\}\n");

            //Replace class names for these two files as well.
            implClass = implClass.replaceAll("\\{\\{Class\\}\\}", classname).replaceAll("\\{\\{class\\}\\}",classname.toLowerCase());
            serviceInterface = serviceInterface.replaceAll("\\{\\{Class\\}\\}", classname).replaceAll("\\{\\{class\\}\\}",classname.toLowerCase());

        }
        implClass = implClass.replaceAll("\\{\\{implMethodLoop\\}\\}\n", "");
        implClass = implClass.replaceAll("\\{\\{modelImportLoop\\}\\}\n", "");
        serviceInterface = serviceInterface.replaceAll("\\{\\{interfaceMethodLoop\\}\\}\n", "");
        //Destruct the loop labels in the service classes once all model code blocks are loaded.
        System.out.println(implClass);
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
