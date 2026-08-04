package ai.framework.generator.framework;

import ai.framework.generator.Generator;
import ai.framework.model.FrameworkProject;
import ai.framework.model.GeneratedFile;

public class PomGeneratorV3 implements Generator {

    private GeneratedFile generatedFile;

    @Override
    public void generate(FrameworkProject project) throws Exception {

        StringBuilder code = new StringBuilder();

        buildXmlStart(code);
        buildProject(code);
        buildProperties(code);
        buildDependencies(code);
        buildBuildPlugins(code);
        buildXmlEnd(code);

        generatedFile = new GeneratedFile(
                "",
                "pom.xml",
                code.toString());

    }

    public GeneratedFile getGeneratedFile() {
        return generatedFile;
    }

    private void buildXmlStart(StringBuilder code) {

        code.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");

        code.append("<project xmlns=\"http://maven.apache.org/POM/4.0.0\"\n");

        code.append("         xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n");

        code.append("         xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 ");

        code.append("https://maven.apache.org/xsd/maven-4.0.0.xsd\">\n\n");

    }

    private void buildProject(StringBuilder code) {

        code.append("    <modelVersion>4.0.0</modelVersion>\n\n");

        code.append("    <groupId>automation.framework</groupId>\n");

        code.append("    <artifactId>generated-framework</artifactId>\n");

        code.append("    <version>1.0.0</version>\n\n");

    }

    private void buildProperties(StringBuilder code) {

        code.append("    <properties>\n");

        code.append("        <maven.compiler.source>17</maven.compiler.source>\n");

        code.append("        <maven.compiler.target>17</maven.compiler.target>\n");

        code.append("        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>\n");

        code.append("    </properties>\n\n");

    }

    private void buildDependencies(StringBuilder code) {

        code.append("    <dependencies>\n\n");

        code.append("        <dependency>\n");
        code.append("            <groupId>org.seleniumhq.selenium</groupId>\n");
        code.append("            <artifactId>selenium-java</artifactId>\n");
        code.append("            <version>4.25.0</version>\n");
        code.append("        </dependency>\n\n");

        code.append("        <dependency>\n");
        code.append("            <groupId>org.testng</groupId>\n");
        code.append("            <artifactId>testng</artifactId>\n");
        code.append("            <version>7.10.2</version>\n");
        code.append("            <scope>test</scope>\n");
        code.append("        </dependency>\n\n");

        code.append("        <dependency>\n");
        code.append("            <groupId>io.github.bonigarcia</groupId>\n");
        code.append("            <artifactId>webdrivermanager</artifactId>\n");
        code.append("            <version>5.9.2</version>\n");
        code.append("        </dependency>\n\n");

        code.append("        <dependency>\n");
        code.append("            <groupId>com.aventstack</groupId>\n");
        code.append("            <artifactId>extentreports</artifactId>\n");
        code.append("            <version>5.1.2</version>\n");
        code.append("        </dependency>\n\n");

        code.append("        <dependency>\n");
        code.append("            <groupId>commons-io</groupId>\n");
        code.append("            <artifactId>commons-io</artifactId>\n");
        code.append("            <version>2.17.0</version>\n");
        code.append("        </dependency>\n\n");

        code.append("    </dependencies>\n\n");

    }

    private void buildBuildPlugins(StringBuilder code) {

        code.append("    <build>\n");

        code.append("        <plugins>\n\n");

        code.append("            <plugin>\n");
        code.append("                <groupId>org.apache.maven.plugins</groupId>\n");
        code.append("                <artifactId>maven-surefire-plugin</artifactId>\n");
        code.append("                <version>3.2.5</version>\n");
        code.append("            </plugin>\n\n");

        code.append("        </plugins>\n");

        code.append("    </build>\n\n");

    }

    private void buildXmlEnd(StringBuilder code) {

        code.append("</project>\n");

    }

}