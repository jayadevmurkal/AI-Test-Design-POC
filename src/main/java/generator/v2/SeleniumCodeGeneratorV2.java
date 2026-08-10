package generator.v2;

import config.FrameworkConstants;
import model.v2.GeneratedTestCase;
import model.v2.GeneratedTestSuite;

public class SeleniumCodeGeneratorV2 {

    public static void generate(GeneratedTestSuite suite) throws Exception {

        StringBuilder code = new StringBuilder();
        code.append("package ")
                .append(FrameworkConstants.TEST_PACKAGE)
                .append(";\n\n");

        code.append("import org.testng.Assert;\n");
        code.append("import org.testng.annotations.BeforeMethod;\n");
        code.append("import org.testng.annotations.Test;\n\n");

        code.append("import framework.BaseTest;\n");
        code.append("import framework.LoggerUtil;\n");

        code.append("import ")
                .append(FrameworkConstants.PAGE_PACKAGE)
                .append(".")
                .append(FrameworkConstants.PAGE_CLASS)
                .append(";\n\n");

        code.append("public class ")
                .append(FrameworkConstants.TEST_CLASS)
                .append(" extends BaseTest {\n\n");

        // Page Object
        code.append("    private ")
                .append(FrameworkConstants.PAGE_CLASS)
                .append(" page;\n\n");

        // BeforeMethod
        code.append("    @BeforeMethod\n");
        code.append("    public void initialize() {\n");
        code.append("        page = new ")
                .append(FrameworkConstants.PAGE_CLASS)
                .append("(getDriver());\n");
        code.append("    }\n\n");

        // Generate all test methods
        for (GeneratedTestCase tc : suite.getTestCases()) {

            generateTestMethod(code, tc);

        }

        code.append("}\n");

        GeneratorFileUtil.writeTestFile(
                FrameworkConstants.TEST_PACKAGE,
                FrameworkConstants.TEST_CLASS + ".java",
                code.toString());
    }

    private static void generateTestMethod(
            StringBuilder code,
            GeneratedTestCase tc) {

        String methodName = GeneratorStringUtil.toMethodName(tc.getScenario());

        code.append("    @Test\n");

        code.append("    public void ")
                .append(methodName)
                .append("() {\n\n");

        // Logger
        code.append("        LoggerUtil.info(\"Executing Scenario : ")
                .append(tc.getScenario())
                .append("\");\n\n");

        generateTestData(code, tc);

        generatePageActions(code);

        generateAssertion(code, tc);

        code.append("\n");
        code.append("    }\n\n");
    }

    private static void generateTestData(
            StringBuilder code,
            GeneratedTestCase tc) {

        code.append("        String email = \"")
                .append(tc.getTestData().getEmail())
                .append("\";\n");

        code.append("        String password = \"")
                .append(tc.getTestData().getPassword())
                .append("\";\n");

        code.append("        String confirmPassword = \"")
                .append(tc.getTestData().getConfirmPassword())
                .append("\";\n\n");
    }

    private static void generatePageActions(StringBuilder code) {

        code.append("        page.enterEmailInput(email);\n");
        code.append("        page.enterPasswordInput(password);\n");
        code.append("        page.enterConfirmPasswordInput(confirmPassword);\n");
        code.append("        page.clickRegisterButton();\n\n");
    }

    private static void generateAssertion(
            StringBuilder code,
            GeneratedTestCase tc) {

        String assertionMethod = getAssertionMethod(tc);

        code.append("        Assert.assertEquals(\n");

        code.append("                page.")
                .append(assertionMethod)
                .append("(),\n");

        code.append("                \"")
                .append(tc.getExpectedResult())
                .append("\");\n\n");

    }

    private static String getAssertionMethod(GeneratedTestCase tc) {

        String expected = tc.getExpectedResult().toLowerCase();

        if (expected.contains("successful")) {
            return "getSuccessMessage";
        }

        if (expected.contains("already exists")) {
            return "getEmailExistsErrorMessage";
        }

        if (expected.contains("invalid email")) {
            return "getInvalidEmailFormatErrorMessage";
        }

        if (expected.contains("minimum 8")) {
            return "getPasswordLengthErrorMessage";
        }

        if (expected.contains("uppercase")) {
            return "getPasswordUppercaseErrorMessage";
        }

        if (expected.contains("lowercase")) {
            return "getPasswordLowercaseErrorMessage";
        }

        if (expected.contains("special")) {
            return "getPasswordSpecialCharErrorMessage";
        }

        if (expected.contains("match")) {
            return "getPasswordMismatchErrorMessage";
        }

        return "getSuccessMessage";
    }

}