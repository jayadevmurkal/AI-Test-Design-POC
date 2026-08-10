package generator.v2;

import config.FrameworkConstants;

public class ExtentReportGeneratorV2 {

    public static void generate() throws Exception {

        StringBuilder code = new StringBuilder();

        buildPackage(code);
        buildImports(code);
        buildClass(code);
        buildMethods(code);
        buildClassEnd(code);

        writeFile(code);

        System.out.println("ExtentManager.java generated successfully.");
    }

    private static void buildPackage(StringBuilder code) {

        code.append("package framework;\n\n");

    }

    private static void buildImports(StringBuilder code) {

        code.append("import com.aventstack.extentreports.ExtentReports;\n");
        code.append("import com.aventstack.extentreports.reporter.ExtentSparkReporter;\n\n");

    }

    private static void buildClass(StringBuilder code) {

        code.append("public class ExtentManager {\n\n");

        code.append("    private static ExtentReports extent;\n\n");

    }

    private static void buildMethods(StringBuilder code) {

        code.append("    public static ExtentReports getInstance() {\n\n");

        code.append("        if (extent == null) {\n\n");

        code.append("            ExtentSparkReporter spark =\n");
        code.append("                    new ExtentSparkReporter(\"")
                .append(FrameworkConstants.EXTENT_REPORT)
                .append("\");\n\n");

        code.append("            extent = new ExtentReports();\n");
        code.append("            extent.attachReporter(spark);\n\n");

        code.append("            extent.setSystemInfo(\"Framework\", \"AI Automation Framework Generator\");\n");
        code.append("            extent.setSystemInfo(\"Author\", \"Jayadev\");\n");
        code.append("        }\n\n");

        code.append("        return extent;\n");

        code.append("    }\n\n");

    }

    private static void buildClassEnd(StringBuilder code) {

        code.append("}\n");

    }

    private static void writeFile(StringBuilder code) throws Exception {

        GeneratorFileUtil.writeFile(
                "src/main/java/framework",
                "ExtentManager.java",
                code.toString());

    }

}