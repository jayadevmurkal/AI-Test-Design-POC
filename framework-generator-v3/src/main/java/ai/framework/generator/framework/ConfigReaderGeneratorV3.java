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

        code.append("import java.io.InputStream;\n");
        code.append("import java.util.Properties;\n\n");

    }

    private void buildClassStart(StringBuilder code) {

        code.append("public final class ConfigReader {\n\n");

    }

    private void buildFields(StringBuilder code) {

        code.append("    private static final Properties properties = new Properties();\n\n");

        code.append("    static {\n\n");

        code.append("        try {\n\n");

        code.append("            InputStream file = ConfigReader.class\n");
        code.append("                    .getClassLoader()\n");
        code.append("                    .getResourceAsStream(\"config.properties\");\n\n");

        code.append("            if (file == null) {\n");
        code.append("                throw new RuntimeException(\"config.properties not found\");\n");
        code.append("            }\n\n");

        code.append("            properties.load(file);\n\n");

        code.append("        } catch (Exception e) {\n\n");

        code.append("            throw new RuntimeException(\n");
        code.append("                    \"Unable to load config.properties\",\n");
        code.append("                    e);\n\n");

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