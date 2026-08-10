package generator.v2;

public class ConfigReaderGeneratorV2 {

    public static void generate() throws Exception {

        StringBuilder code = new StringBuilder();

        code.append("package config;\n\n");

        code.append("import java.io.InputStream;\n");
        code.append("import java.util.Properties;\n\n");
        code.append("public class ConfigReader {\n\n");

        code.append("    private static Properties properties = new Properties();\n\n");

        code.append("    static {\n");

        code.append("        try {\n");

        code.append("            InputStream input = ConfigReader.class.getClassLoader()\n");
        code.append("                    .getResourceAsStream(\"config.properties\");\n\n");

        code.append("            if (input == null) {\n");
        code.append("                throw new RuntimeException(\"config.properties not found\");\n");
        code.append("            }\n\n");

        code.append("            properties.load(input);\n");

        code.append("        } catch (Exception e) {\n");

        code.append("            throw new RuntimeException(\"Unable to load config.properties\", e);\n");

        code.append("        }\n");

        code.append("    }\n\n");

        code.append("    public static String get(String key) {\n");

        code.append("        return properties.getProperty(key);\n");

        code.append("    }\n");

        code.append("}\n");

        GeneratorFileUtil.writeJavaFile(
                "framework",
                "ConfigReader.java",
                code.toString());
    }
}