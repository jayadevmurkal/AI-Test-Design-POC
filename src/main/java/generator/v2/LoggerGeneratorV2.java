package generator.v2;

import config.FrameworkConstants;

public class LoggerGeneratorV2 {

    public static void generate() throws Exception {

        StringBuilder code = new StringBuilder();

        buildPackage(code);
        buildImports(code);
        buildClassStart(code);
        buildLoggerField(code);
        buildInfoMethod(code);
        buildWarningMethod(code);
        buildErrorMethod(code);
        buildClassEnd(code);

        writeFile(code);

        System.out.println("LoggerUtil.java generated successfully.");
    }

    private static void buildPackage(StringBuilder code) {

        code.append("package framework;\n\n");

    }

    private static void buildImports(StringBuilder code) {

        code.append("import java.util.logging.Logger;\n");
        code.append("import java.util.logging.Level;\n\n");

    }

    private static void buildClassStart(StringBuilder code) {

        code.append("public class LoggerUtil {\n\n");

    }

    private static void buildLoggerField(StringBuilder code) {

        code.append("    private static final Logger logger = Logger.getLogger(LoggerUtil.class.getName());\n\n");

    }

    private static void buildInfoMethod(StringBuilder code) {

        code.append("    public static void info(String message) {\n");
        code.append("        logger.info(message);\n");
        code.append("    }\n\n");

    }

    private static void buildWarningMethod(StringBuilder code) {

        code.append("    public static void warning(String message) {\n");
        code.append("        logger.warning(message);\n");
        code.append("    }\n\n");

    }

    private static void buildErrorMethod(StringBuilder code) {

        code.append("    public static void error(String message) {\n");
        code.append("        logger.log(Level.SEVERE, message);\n");
        code.append("    }\n\n");

    }

    private static void buildClassEnd(StringBuilder code) {

        code.append("}\n");

    }

    private static void writeFile(StringBuilder code) throws Exception {

        GeneratorFileUtil.writeFile(
                "framework",
                "LoggerUtil.java",
                code.toString());

    }

}