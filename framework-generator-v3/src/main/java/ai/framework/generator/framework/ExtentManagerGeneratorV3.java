package ai.framework.generator.framework;

import ai.framework.generator.Generator;
import ai.framework.model.FrameworkProject;
import ai.framework.model.GeneratedFile;

public class ExtentManagerGeneratorV3 implements Generator {

    @Override
    public void generate(FrameworkProject project) throws Exception {

        StringBuilder code = new StringBuilder();

        buildPackage(code);
        buildImports(code);
        buildClassStart(code);
        buildMethods(code);
        buildClassEnd(code);

        GeneratedFile file = new GeneratedFile(
                "framework",
                "ExtentManager.java",
                code.toString());

        project.addFile(file);

    }

    private void buildPackage(StringBuilder code) {

        code.append("package framework;\n\n");

    }

    private void buildImports(StringBuilder code) {

        code.append("import com.aventstack.extentreports.ExtentReports;\n");
        code.append("import com.aventstack.extentreports.reporter.ExtentSparkReporter;\n\n");

        code.append("import java.time.LocalDateTime;\n");
        code.append("import java.time.format.DateTimeFormatter;\n\n");

    }

    private void buildClassStart(StringBuilder code) {

        code.append("public class ExtentManager {\n\n");

        code.append("    private static ExtentReports extent;\n\n");

    }

    private void buildMethods(StringBuilder code) {

        buildGetInstance(code);

    }

    private void buildGetInstance(StringBuilder code) {

        code.append("    public static ExtentReports getInstance() {\n\n");

        buildSingletonCheck(code);
        buildCreateReporter(code);
        buildConfigureReport(code);
        buildAttachReporter(code);
        buildReturnExtent(code);

        code.append("    }\n\n");

    }

    private void buildSingletonCheck(StringBuilder code) {

        code.append("        if (extent == null) {\n\n");

    }

    private void buildCreateReporter(StringBuilder code) {

        code.append("            String timestamp = LocalDateTime.now()\n");
        code.append("                    .format(DateTimeFormatter.ofPattern(\"yyyyMMdd_HHmmss\"));\n\n");

        code.append("            String reportPath = \"reports/ExtentReport_\" + timestamp + \".html\";\n\n");

        code.append("            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);\n\n");

    }

    private void buildConfigureReport(StringBuilder code) {

        code.append("            spark.config().setDocumentTitle(\"Automation Execution Report\");\n");

        code.append("            spark.config().setReportName(\"Selenium Automation Report\");\n\n");

    }

    private void buildAttachReporter(StringBuilder code) {

        code.append("            extent = new ExtentReports();\n");

        code.append("            extent.attachReporter(spark);\n\n");

        code.append("            extent.setSystemInfo(\"Framework\", \"Selenium V3\");\n");

        code.append("            extent.setSystemInfo(\"Language\", \"Java\");\n");

        code.append("            extent.setSystemInfo(\"Generator\", \"Framework Generator V3\");\n\n");

    }

    private void buildReturnExtent(StringBuilder code) {

        code.append("        }\n\n");

        code.append("        return extent;\n");

    }

    private void buildClassEnd(StringBuilder code) {

        code.append("}\n");

    }

}