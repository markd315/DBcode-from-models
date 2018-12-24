package markd315.dbGen;

public class MongoConst {
    public static String getClassRepository() {
        return classRepository;
    }

    public static String getImplMethodLoop() {
        return implMethodLoop;
    }

    public static String getResourceServiceImpl() {
        return resourceServiceImpl;
    }

    public static String getModelImportLoop() {
        return modelImportLoop;
    }

    public static String getInterfaceMethodLoop() {
        return interfaceMethodLoop;
    }

    public static String getResourceService() {
        return resourceService;
    }

    public static String getConstructorParamLoop() {
        return constructorParamLoop;
    }

    public static String getConstructorFieldLoop() {
        return constructorFieldLoop;
    }

    public static String getModelOnlyImportLoop() {
        return modelOnlyImportLoop;
    }

    private static String constructorParamLoop = "{{Class}}Repository {{class}}Repository, ";

    private static String constructorFieldLoop = "        this.{{class}}Repository = {{class}}Repository;\n";

    private static String classRepository = "package io.swagger.repository;\n" +
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

    private static String implMethodLoop = "private {{Class}}Repository {{class}}Repository;\n" +
            "\n" +
            "    @Override\n" +
            "    public {{Class}} find{{Class}}ById(int id) throws DataAccessException {\n" +
            "        {{Class}} {{class}}= {{class}}Repository.findById(id);\n" +
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
            "        {{class}}Repository.save({{class}});\n" +
            "    }\n" +
            "\n" +
            "    @Override\n" +
            "    public void delete{{Class}}({{Class}} {{class}}) throws DataAccessException {\n" +
            "        {{class}}Repository.delete({{class}});\n" +
            "    }\n\n";
    private static String resourceServiceImpl = "package io.swagger.service;\n" +
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
            "    @Autowired\n" +
            "    public ResourceServiceImpl(\n" +
            "      {{constructorParamLoop}}\n" +
            "){\n"+
            "    {{constructorFieldLoop}}\n"+
            "    }\n\n" +
            "    {{implMethodLoop}}\n" +
            "}\n";

    private static String modelImportLoop = "import io.swagger.model.{{Class}};\n" +
            "import io.swagger.repository.{{Class}}Repository;\n";
    private static String modelOnlyImportLoop = "import io.swagger.model.{{Class}};\n";
    private static String interfaceMethodLoop = "void save{{Class}}({{Class}} {{class}});\n" +
            "    {{Class}} find{{Class}}ById(int Id);\n" +
            "    void delete{{Class}}({{Class}} {{class}});\n" +
            "    Collection<{{Class}}> findAll{{Class}}s();";
    private static String resourceService = "package io.swagger.service;\n" +
            "\n" +
            "{{modelImportLoop}}\n" +
            "\n" +
            "import java.util.Collection;\n" +
            "\n" +
            "public interface ResourceService {\n" +
            "\n" +
            "    {{interfaceMethodLoop}}\n" +
            "\n" +
            "}\n";
    private static String pom = "<project xmlns=\"http://maven.apache.org/POM/4.0.0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd\">\n" +
            "    <modelVersion>4.0.0</modelVersion>\n" +
            "    <groupId>io.swagger</groupId>\n" +
            "    <artifactId>swagger-spring</artifactId>\n" +
            "    <packaging>jar</packaging>\n" +
            "    <name>swagger-spring</name>\n" +
            "    <version>1.0.0</version>\n" +
            "    <properties>\n" +
            "        <java.version>1.7</java.version>\n" +
            "        <maven.compiler.source>${java.version}</maven.compiler.source>\n" +
            "        <maven.compiler.target>${java.version}</maven.compiler.target>\n" +
            "        <spring-data-jdbc.version>1.2.1.RELEASE</spring-data-jdbc.version>\n" +
            "        <springfox-version>2.7.0</springfox-version>\n" +
            "    </properties>\n" +
            "    <parent>\n" +
            "        <groupId>org.springframework.boot</groupId>\n" +
            "        <artifactId>spring-boot-starter-parent</artifactId>\n" +
            "        <version>1.5.9.RELEASE</version>\n" +
            "    </parent>\n" +
            "    <build>\n" +
            "        <sourceDirectory>src/main/java</sourceDirectory>\n" +
            "        <plugins>\n" +
            "            <plugin>\n" +
            "                <groupId>org.springframework.boot</groupId>\n" +
            "                <artifactId>spring-boot-maven-plugin</artifactId>\n" +
            "                <executions>\n" +
            "                    <execution>\n" +
            "                        <goals>\n" +
            "                            <goal>repackage</goal>\n" +
            "                        </goals>\n" +
            "                    </execution>\n" +
            "                </executions>\n" +
            "            </plugin>\n" +
            "            <plugin>\n" +
            "                <groupId>org.apache.maven.plugins</groupId>\n" +
            "                <artifactId>maven-jar-plugin</artifactId>\n" +
            "                <version>2.4</version>\n" +
            "                <configuration>\n" +
            "                    <archive>\n" +
            "                        <manifest>\n" +
            "                            <addClasspath>true</addClasspath>\n" +
            "                            <mainClass>markd315.dbGen.Main</mainClass>\n" +
            "                            <classpathPrefix>lib/</classpathPrefix>\n" +
            "                        </manifest>\n" +
            "                    </archive>\n" +
            "                </configuration>\n" +
            "            </plugin>\n" +
            "            <plugin>\n" +
            "                <groupId>org.apache.maven.plugins</groupId>\n" +
            "                <artifactId>maven-dependency-plugin</artifactId>\n" +
            "                <version>2.8</version>\n" +
            "                <executions>\n" +
            "                    <execution>\n" +
            "                        <id>copy-dependencies</id>\n" +
            "                        <phase>package</phase>\n" +
            "                        <goals>\n" +
            "                            <goal>copy-dependencies</goal>\n" +
            "                        </goals>\n" +
            "                        <configuration>\n" +
            "                            <outputDirectory>\n" +
            "                                ${project.build.directory}/lib/\n" +
            "                            </outputDirectory>\n" +
            "                        </configuration>\n" +
            "                    </execution>\n" +
            "                </executions>\n" +
            "            </plugin>\n"+
            "        </plugins>\n" +
            "    </build>\n" +
            "    <dependencies>\n" +
            "        <dependency>\n" +
            "            <groupId>org.springframework.boot</groupId>\n" +
            "            <artifactId>spring-boot-starter-web</artifactId>\n" +
            "        </dependency>\n" +
            "        <dependency>\n" +
            "            <groupId>org.springframework.boot</groupId>\n" +
            "            <artifactId>spring-boot-starter-tomcat</artifactId>\n" +
            "        </dependency>\n" +
            "        <dependency>\n" +
            "            <groupId>org.springframework.boot</groupId>\n" +
            "            <artifactId>spring-boot-starter-data-mongodb</artifactId>\n" +
            "        </dependency>\n" +
            "        <!--SpringFox dependencies -->\n" +
            "        <dependency>\n" +
            "            <groupId>io.springfox</groupId>\n" +
            "            <artifactId>springfox-swagger2</artifactId>\n" +
            "            <version>${springfox-version}</version>\n" +
            "        </dependency>\n" +
            "        <dependency>\n" +
            "            <groupId>io.springfox</groupId>\n" +
            "            <artifactId>springfox-swagger-ui</artifactId>\n" +
            "            <version>${springfox-version}</version>\n" +
            "        </dependency>\n" +
            "        <dependency>\n" +
            "            <groupId>com.beust</groupId>\n" +
            "            <artifactId>jcommander</artifactId>\n" +
            "            <version>1.72</version>\n" +
            "        </dependency>\n"+
            "        <dependency>\n" +
            "            <groupId>org.springframework.data</groupId>\n" +
            "            <artifactId>spring-data-jdbc-core</artifactId>\n" +
            "            <version>${spring-data-jdbc.version}</version>\n" +
            "            <exclusions>\n" +
            "                <exclusion>\n" +
            "                    <groupId>org.springframework</groupId>\n" +
            "                    <artifactId>*</artifactId>\n" +
            "                </exclusion>\n" +
            "            </exclusions>\n" +
            "        </dependency>\n" +
            "        <dependency>\n" +
            "            <groupId>com.github.joschi.jackson</groupId>\n" +
            "            <artifactId>jackson-datatype-threetenbp</artifactId>\n" +
            "            <version>2.6.4</version>\n" +
            "        </dependency>\n" +
            "    <!-- Bean Validation API support -->\n" +
            "        <dependency>\n" +
            "            <groupId>javax.validation</groupId>\n" +
            "            <artifactId>validation-api</artifactId>\n" +
            "        </dependency>\n" +
            "    </dependencies>\n" +
            "</project>\n";

    public static String getPOM() {
        return pom;
    }
}
