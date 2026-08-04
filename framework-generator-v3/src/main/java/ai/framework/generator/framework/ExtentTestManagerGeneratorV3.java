package ai.framework.generator.framework;

import ai.framework.generator.Generator;
import ai.framework.model.FrameworkProject;
import ai.framework.model.GeneratedFile;

public class ExtentTestManagerGeneratorV3 implements Generator {

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
                "ExtentTestManager.java",
                code.toString());

        project.addFile(file);

    }

    private void buildPackage(StringBuilder code) {

        code.append("package framework;\n\n");

    }

    private void buildImports(StringBuilder code) {

        code.append("import com.aventstack.extentreports.ExtentTest;\n\n");

    }

    private void buildClassStart(StringBuilder code) {

        code.append("public class ExtentTestManager {\n\n");

        code.append("    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();\n\n");

    }

    private void buildMethods(StringBuilder code) {

        buildStartTest(code);
        buildGetTest(code);
        buildUnload(code);

    }

    private void buildStartTest(StringBuilder code) {

        code.append("    public static void startTest(String testName) {\n\n");

        code.append("        ExtentTest test = ExtentManager.getInstance().createTest(testName);\n");

        code.append("        extentTest.set(test);\n\n");

        code.append("    }\n\n");

    }

    private void buildGetTest(StringBuilder code) {

        code.append("    public static ExtentTest getTest() {\n\n");

        code.append("        return extentTest.get();\n\n");

        code.append("    }\n\n");

    }

    private void buildUnload(StringBuilder code) {

        code.append("    public static void unload() {\n\n");

        code.append("        extentTest.remove();\n\n");

        code.append("    }\n\n");

    }

    private void buildClassEnd(StringBuilder code) {

        code.append("}\n");

    }

}