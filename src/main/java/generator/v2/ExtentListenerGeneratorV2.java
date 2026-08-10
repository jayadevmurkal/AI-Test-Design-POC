package generator.v2;

public class ExtentListenerGeneratorV2 {

    public static void generate() throws Exception {

        StringBuilder code = new StringBuilder();

        buildPackage(code);
        buildImports(code);
        buildClassStart(code);
        buildMethods(code);
        buildClassEnd(code);

        writeFile(code);

        System.out.println("ExtentListener.java generated successfully.");
    }

    private static void buildPackage(StringBuilder code) {

        code.append("package framework;\n\n");

    }

    private static void buildImports(StringBuilder code) {

        code.append("import org.testng.ITestContext;\n");
        code.append("import org.testng.ITestListener;\n");
        code.append("import org.testng.ITestResult;\n\n");
        code.append("import org.openqa.selenium.WebDriver;\n");
        code.append("import framework.BaseTest;\n");

    }

    private static void buildClassStart(StringBuilder code) {

        code.append("public class ExtentListener implements ITestListener {\n\n");

    }

    private static void buildMethods(StringBuilder code) {

        buildOnStart(code);
        buildOnTestStart(code);
        buildOnTestSuccess(code);
        buildOnTestFailure(code);
        buildOnTestSkipped(code);
        buildOnFinish(code);

    }

    private static void buildOnStart(StringBuilder code) {

        code.append("    @Override\n");
        code.append("    public void onStart(ITestContext context) {\n");
        code.append("        ExtentManager.getInstance();\n");
        code.append("    }\n\n");

    }

    private static void buildOnTestStart(StringBuilder code) {

        code.append("    @Override\n");
        code.append("    public void onTestStart(ITestResult result) {\n\n");

        code.append("        ExtentTestManager.startTest(result.getMethod().getMethodName());\n");

        code.append("        LoggerUtil.info(\"Starting Test : \" + result.getMethod().getMethodName());\n");

        code.append("    }\n\n");

    }

    private static void buildOnTestSuccess(StringBuilder code) {

        code.append("    @Override\n");
        code.append("    public void onTestSuccess(ITestResult result) {\n\n");

        code.append("        ExtentTestManager.getTest().pass(\"Test Passed\");\n");

        code.append("        LoggerUtil.info(\"Test Passed : \" + result.getMethod().getMethodName());\n");

        code.append("    }\n\n");

    }

    private static void buildOnTestFailure(StringBuilder code) {

        code.append("    @Override\n");
        code.append("    public void onTestFailure(ITestResult result) {\n\n");

        code.append("        LoggerUtil.error(\"Test Failed : \" + result.getMethod().getMethodName());\n\n");

        code.append("        ExtentTestManager.getTest().fail(result.getThrowable());\n\n");

        code.append("        try {\n");

        code.append("            Object currentClass = result.getInstance();\n");

        code.append("            WebDriver driver = ((BaseTest) currentClass).getDriver();\n\n");

        code.append("            String screenshot = ScreenshotUtil.capture(\n");
        code.append("                    driver,\n");
        code.append("                    result.getMethod().getMethodName());\n\n");

        code.append("            if (screenshot != null) {\n");

        code.append("                ExtentTestManager.getTest().addScreenCaptureFromPath(screenshot);\n");

        code.append("            }\n");

        code.append("        }\n");

        code.append("        catch (Exception e) {\n");

        code.append("            LoggerUtil.error(\"Unable to capture screenshot\");\n");

        code.append("        }\n\n");

        code.append("    }\n\n");

    }

    private static void buildOnTestSkipped(StringBuilder code) {

        code.append("    @Override\n");
        code.append("    public void onTestSkipped(ITestResult result) {\n\n");

        code.append("        ExtentTestManager.getTest().skip(\"Test Skipped\");\n");

        code.append("        LoggerUtil.warning(\"Test Skipped : \" + result.getMethod().getMethodName());\n");

        code.append("    }\n\n");

    }

    private static void buildOnFinish(StringBuilder code) {

        code.append("    @Override\n");
        code.append("    public void onFinish(ITestContext context) {\n\n");

        code.append("        ExtentManager.getInstance().flush();\n");

        code.append("    }\n\n");

    }

    private static void buildClassEnd(StringBuilder code) {

        code.append("}\n");

    }

    private static void writeFile(StringBuilder code) throws Exception {

        GeneratorFileUtil.writeFile(
                "src/main/java/framework",
                "ExtentListener.java",
                code.toString());
    }

}