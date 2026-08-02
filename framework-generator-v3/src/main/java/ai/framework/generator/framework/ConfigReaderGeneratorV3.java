package ai.framework.generator.framework;

import ai.framework.generator.Generator;
import ai.framework.model.FrameworkProject;
import ai.framework.model.GeneratedFile;

public class ConfigReaderGeneratorV3 implements Generator {

    @Override
    public void generate(FrameworkProject project) throws Exception {

        StringBuilder code = new StringBuilder();

        buildPackage(code);
        buildImports(code);
        buildClassStart(code);
        buildFields(code);
        buildMethods(code);
        buildClassEnd(code);

        GeneratedFile file = new GeneratedFile(
                "config",
                "ConfigReader.java",
                code.toString());

        project.addFile(file);
    }

    private void buildPackage(StringBuilder code) {

        code.append("package config;\n\n");

    }

    private void buildImports(StringBuilder code) {

        code.append("import java.io.FileInputStream;\n");
        code.append("import java.io.IOException;\n");
        code.append("import java.util.Properties;\n\n");

    }

    private void buildClassStart(StringBuilder code) {

        code.append("public final class ConfigReader {\n\n");

    }

    private void buildFields(StringBuilder code) {

        code.append("    private static final Properties properties = new Properties();\n\n");

        code.append("    static {\n\n");

        code.append("        try {\n\n");

        code.append(
                "            FileInputStream file = new FileInputStream(\"src/main/resources/config.properties\");\n");

        code.append("            properties.load(file);\n");

        code.append("        }\n");

        code.append("        catch (IOException e) {\n");

        code.append("            throw new RuntimeException(\"Unable to load config.properties\", e);\n");

        code.append("        }\n\n");

        code.append("    }\n\n");

    }

    private void buildMethods(StringBuilder code) {

        buildPrivateConstructor(code);
        buildGetMethod(code);

    }

    private void buildPrivateConstructor(StringBuilder code) {

        code.append("    private ConfigReader() {\n");
        code.append("    }\n\n");

    }

    private void buildGetMethod(StringBuilder code) {

        code.append("    public static String get(String key) {\n\n");

        code.append("        return properties.getProperty(key);\n\n");

        code.append("    }\n\n");

    }

    private void buildClassEnd(StringBuilder code) {

        code.append("}\n");

    }

}