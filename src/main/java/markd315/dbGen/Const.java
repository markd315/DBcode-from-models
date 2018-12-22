package markd315.dbGen;

public class Const {
    public String getClassRepository() {
        return classRepository;
    }

    public String getImplMethodLoop() {
        return implMethodLoop;
    }

    public String getResourceServiceImpl() {
        return resourceServiceImpl;
    }

    public String getInterfaceMethodLoop() {
        return interfaceMethodLoop;
    }

    public String getResourceService() {
        return resourceService;
    }

    private String classRepository = "package io.swagger.repository;\n" +
            "\n" +
            "import io.swagger.model.{{Class}};\n" +
            "import org.springframework.dao.DataAccessException;\n" +
            "import org.springframework.data.mongodb.repository.MongoRepository;\n" +
            "\n" +
            "import java.util.List;\n" +
            "\n" +
            "public interface {{Class}}Repository extends MongoRepository<{{Class}}, Integer> {\n" +
            "    List<{{Class}}> findAll() throws DataAccessException;\n" +
            "\n" +
            "    {{Class}} findById(int id) throws DataAccessException;\n" +
            "\n" +
            "    {{Class}} save({{Class}} {{class}}) throws DataAccessException;\n" +
            "\n" +
            "    void delete({{Class}} {{class}}) throws DataAccessException;\n" +
            "}\n";

    private String implMethodLoop = "private {{Class}}Repository {{class}}Repository;\n" +
            "\n" +
            "    @Autowired\n" +
            "    public ResourceServiceImpl(\n" +
            "                {{Class}}Repository {{class}}Repository) {\n" +
            "        this.{{class}}Repository = {{class}}Repository;\n" +
            "    }\n" +
            "\n" +
            "    @Override\n" +
            "    public {{Class}} find{{Class}}ById(int id) throws DataAccessException {\n" +
            "            {{Class}} {{class}}= {{class}}Repository.findById(id);\n" +
            "        return {{class}};\n" +
            "    }\n" +
            "\n" +
            "    @Override\n" +
            "    public Collection<{{Class}}> findAll{{Class}}s() throws DataAccessException {\n" +
            "        return {{class}}Repository.findAll();\n" +
            "    }\n" +
            "\n" +
            "    @Override\n" +
            "    public void save{{Class}}({{Class}} {{class}}) throws DataAccessException {\n" +
            "                                {{class}}Repository.save({{class}});\n" +
            "    }\n" +
            "\n" +
            "    @Override\n" +
            "    public void delete{{Class}}({{Class}} {{class}}) throws DataAccessException {\n" +
            "                                    {{class}}Repository.delete({{class}});\n" +
            "    }";
    private String resourceServiceImpl = "package io.swagger.service;\n" +
            "\n" +
            "{{modelImportLoop}}\n" +
            "import org.springframework.beans.factory.annotation.Autowired;\n" +
            "import org.springframework.dao.DataAccessException;\n" +
            "import org.springframework.stereotype.Service;\n" +
            "\n" +
            "import java.util.Collection;\n" +
            "\n" +
            "@Service\n" +
            "public class ResourceServiceImpl implements ResourceService {\n" +
            "    {{implMethodLoop}}\n" +
            "}\n";
    private String interfaceMethodLoop = "void save{{Class}}({{Class}} {{class}});\n" +
            "    {{Class}} find{{Class}}ById(int Id);\n" +
            "    void delete{{Class}}({{Class}} {{class}});\n" +
            "    Collection<{{Class}}> findAll{{Class}}s();";
    private String resourceService = "package io.swagger.service;\n" +
            "\n" +
            "import io.swagger.model.{{Class}};\n" +
            "\n" +
            "import java.util.Collection;\n" +
            "\n" +
            "public interface ResourceService {\n" +
            "\n" +
            "    {{interfaceMethodLoop}}\n" +
            "\n" +
            "}\n";
}