package ai.framework.generator.framework;

import ai.framework.generator.Generator;
import ai.framework.model.FrameworkProject;
import ai.framework.model.GeneratedFile;

public class LoggerGeneratorV3 implements Generator {

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
                "framework",
                "LoggerUtil.java",
                code.toString());

        project.addFile(file);
    }

    private void buildPackage(StringBuilder code) {

        code.append("package framework;\n\n");

    }

    private void buildImports(StringBuilder code) {

        code.append("import java.time.LocalDateTime;\n");
        code.append("import java.time.format.DateTimeFormatter;\n\n");

    }

    private void buildClassStart(StringBuilder code) {

        code.append("public class LoggerUtil {\n\n");

    }

    private void buildFields(StringBuilder code) {

        code.append("    private static final DateTimeFormatter FORMATTER =\n");
        code.append("            DateTimeFormatter.ofPattern(\"yyyy-MM-dd HH:mm:ss\");\n\n");

    }

    private void buildMethods(StringBuilder code) {

        buildLogMethod(code);
        buildInfoMethod(code);
        buildWarningMethod(code);
        buildErrorMethod(code);

    }

    private void buildLogMethod(StringBuilder code) {

        code.append("    private static void log(String level, String message) {\n\n");

        code.append("        String time = LocalDateTime.now().format(FORMATTER);\n\n");

        code.append("        System.out.println(\"[\" + time + \"] [\" + level + \"] \" + message);\n\n");

        code.append("    }\n\n");

    }

    private void buildInfoMethod(StringBuilder code) {

        code.append("    public static void info(String message) {\n");

        code.append("        log(\"INFO\", message);\n");

        code.append("    }\n\n");

    }

    private void buildWarningMethod(StringBuilder code) {

        code.append("    public static void warning(String message) {\n");

        code.append("        log(\"WARNING\", message);\n");

        code.append("    }\n\n");

    }

    private void buildErrorMethod(StringBuilder code) {

        code.append("    public static void error(String message) {\n");

        code.append("        log(\"ERROR\", message);\n");

        code.append("    }\n\n");

    }

    private void buildClassEnd(StringBuilder code) {

        code.append("}\n");

    }

}