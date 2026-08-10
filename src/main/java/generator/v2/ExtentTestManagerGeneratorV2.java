package generator.v2;

import config.FrameworkConstants;

import java.io.File;

public class ExtentTestManagerGeneratorV2 {

    public static void generate() throws Exception {

        StringBuilder code = new StringBuilder();

        buildPackage(code);
        buildImports(code);
        buildClassStart(code);
        buildField(code);
        buildStartMethod(code);
        buildGetMethod(code);
        buildClassEnd(code);

        writeFile(code);
    }

    private static void buildPackage(StringBuilder code) {

        code.append("package framework;\n\n");

    }

    private static void buildImports(StringBuilder code) {

        code.append("import com.aventstack.extentreports.ExtentTest;\n\n");

    }

    private static void buildClassStart(StringBuilder code) {

        code.append("public class ExtentTestManager {\n\n");

    }

    private static void buildField(StringBuilder code) {

        code.append("    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();\n\n");

    }

    private static void buildStartMethod(StringBuilder code) {

        code.append("    public static void startTest(String testName) {\n\n");

        code.append("        ExtentTest extentTest =\n");
        code.append("                ExtentManager.getInstance().createTest(testName);\n\n");

        code.append("        test.set(extentTest);\n");

        code.append("    }\n\n");

    }

    private static void buildGetMethod(StringBuilder code) {

        code.append("    public static ExtentTest getTest() {\n\n");

        code.append("        return test.get();\n");

        code.append("    }\n\n");

    }

    private static void buildClassEnd(StringBuilder code) {

        code.append("}\n");

    }

    private static void writeFile(StringBuilder code) throws Exception {

        GeneratorFileUtil.writeFile(
                "src/main/java/framework",
                "ExtentTestManager.java",
                code.toString());
    }

}