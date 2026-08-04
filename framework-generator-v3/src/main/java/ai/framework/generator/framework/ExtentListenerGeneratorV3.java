package ai.framework.generator.framework;

import ai.framework.generator.Generator;
import ai.framework.model.FrameworkProject;
import ai.framework.model.GeneratedFile;

public class ExtentListenerGeneratorV3 implements Generator {

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
                "ExtentListener.java",
                code.toString());

        project.addFile(file);

    }

    private void buildPackage(StringBuilder code) {

        code.append("package framework;\n\n");

    }

    private void buildImports(StringBuilder code) {

        code.append("import org.testng.ITestContext;\n");
        code.append("import org.testng.ITestListener;\n");
        code.append("import org.testng.ITestResult;\n\n");

        code.append("import com.aventstack.extentreports.Status;\n\n");

    }

    private void buildClassStart(StringBuilder code) {

        code.append("public class ExtentListener implements ITestListener {\n\n");

    }

    private void buildMethods(StringBuilder code) {

        buildOnStart(code);
        buildOnSuccess(code);
        buildOnFailure(code);
        buildOnSkipped(code);
        buildOnFinish(code);

    }

    private void buildOnStart(StringBuilder code) {

        code.append("    @Override\n");

        code.append("    public void onTestStart(ITestResult result) {\n\n");

        code.append("        ExtentTestManager.startTest(result.getMethod().getMethodName());\n\n");

        code.append("        LoggerUtil.info(\"Starting Test : \" + result.getMethod().getMethodName());\n\n");

        code.append("    }\n\n");

    }

    private void buildOnSuccess(StringBuilder code) {

        code.append("    @Override\n");

        code.append("    public void onTestSuccess(ITestResult result) {\n\n");

        code.append("        ExtentTestManager.getTest().log(Status.PASS, \"Test Passed\");\n\n");

        code.append("        LoggerUtil.info(\"Test Passed : \" + result.getMethod().getMethodName());\n\n");

        code.append("    }\n\n");

    }

    private void buildOnFailure(StringBuilder code) {

        code.append("    @Override\n");

        code.append("    public void onTestFailure(ITestResult result) {\n\n");

        code.append("        ExtentTestManager.getTest().log(Status.FAIL, result.getThrowable());\n\n");

        code.append("        LoggerUtil.error(\"Test Failed : \" + result.getMethod().getMethodName());\n\n");

        code.append("        try {\n\n");

        code.append("            String screenshot = ScreenshotUtil.capture(\n");
        code.append("                    DriverFactory.getDriver(),\n");
        code.append("                    result.getMethod().getMethodName());\n\n");

        code.append("            ExtentTestManager.getTest().addScreenCaptureFromPath(screenshot);\n\n");

        code.append("        } catch (Exception e) {\n\n");

        code.append("            LoggerUtil.error(\"Unable to attach screenshot : \" + e.getMessage());\n\n");

        code.append("        }\n\n");

        code.append("    }\n\n");

    }

    private void buildOnSkipped(StringBuilder code) {

        code.append("    @Override\n");

        code.append("    public void onTestSkipped(ITestResult result) {\n\n");

        code.append("        ExtentTestManager.getTest().log(Status.SKIP, \"Test Skipped\");\n\n");

        code.append("        LoggerUtil.info(\"Test Skipped : \" + result.getMethod().getMethodName());\n\n");

        code.append("    }\n\n");

    }

    private void buildOnFinish(StringBuilder code) {

        code.append("    @Override\n");

        code.append("    public void onFinish(ITestContext context) {\n\n");

        code.append("        ExtentManager.getInstance().flush();\n");

        code.append("        ExtentTestManager.unload();\n\n");

        code.append("        LoggerUtil.info(\"Execution Completed\");\n\n");

        code.append("    }\n\n");

    }

    private void buildClassEnd(StringBuilder code) {

        code.append("}\n");

    }

}