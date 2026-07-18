package generator.v2;

import java.io.File;
import java.io.FileWriter;
import config.FrameworkConstants;
import model.v2.GeneratedTestCase;
import model.v2.GeneratedTestSuite;

public class SeleniumCodeGeneratorV2 {

    public static void generate(GeneratedTestSuite suite) throws Exception {

        StringBuilder code = new StringBuilder();

        code.append("import org.testng.Assert;\n");
        code.append("import org.testng.annotations.Test;\n");
        code.append("import framework.BaseTest;\n");
        code.append("import pages.RegistrationPage;\n\n");

        code.append("public class RegistrationTests extends BaseTest {\n\n");

        for (GeneratedTestCase tc : suite.getTestCases()) {

            generateTestMethod(code, tc);

        }

        code.append("}\n");

        File outputFolder = new File(
                FrameworkConstants.GENERATED_OUTPUT_FOLDER);

        if (!outputFolder.exists()) {
            outputFolder.mkdirs();
        }

        FileWriter writer = new FileWriter(
                FrameworkConstants.GENERATED_TEST_OUTPUT);

        writer.write(code.toString());

        writer.close();

        System.out.println("RegistrationTests.java generated successfully.");

    }

    private static void generateTestMethod(
            StringBuilder code,
            GeneratedTestCase tc) {

        String methodName = toMethodName(tc.getScenario());

        code.append("    @Test\n");

        code.append("    public void ")
                .append(methodName)
                .append("() {\n");
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

        code.append("        RegistrationPage page = new RegistrationPage(driver);\n\n");

        code.append("        page.enterEmailInput(email);\n");
        code.append("        page.enterPasswordInput(password);\n");
        code.append("        page.enterConfirmPasswordInput(confirmPassword);\n");
        code.append("        page.clickRegisterButton();\n\n");
    }

    private static String toMethodName(String scenario) {

        String cleaned = scenario
                .replaceAll("[^a-zA-Z0-9 ]", "")
                .trim();

        String[] words = cleaned.split("\\s+");

        StringBuilder method = new StringBuilder();

        for (int i = 0; i < words.length; i++) {

            String word = words[i];

            if (i == 0) {

                method.append(word.substring(0, 1).toLowerCase())
                        .append(word.substring(1));

            } else {

                method.append(word.substring(0, 1).toUpperCase())
                        .append(word.substring(1));

            }

        }

        return method.toString();

    }

    private static void generateAssertion(
            StringBuilder code,
            GeneratedTestCase tc) {

        String expected = tc.getExpectedResult();

        if (expected.equalsIgnoreCase("Registration Successful")) {

            code.append("        Assert.assertEquals(\n");
            code.append("                page.getSuccessMessage(),\n");
            code.append("                \"Registration Successful\");\n\n");

        } else {

            code.append("        // TODO: Assertion generation not implemented\n\n");

        }
    }

}