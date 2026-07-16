package generator;

import model.TestDesignData;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.LinkedHashSet;
import java.util.Set;
import config.FrameworkConstants;

public class SeleniumCodeGenerator {

        private static List<String> removeDuplicates(
                        List<String> scenarios) {

                Set<String> uniqueScenarios = new LinkedHashSet<>();

                for (String scenario : scenarios) {

                        uniqueScenarios.add(
                                        scenario.toLowerCase().trim());
                }

                return uniqueScenarios.stream().toList();
        }

        private static String toCamelCaseMethodName(String scenario) {

                // Remove special characters
                scenario = scenario.replaceAll("[^a-zA-Z0-9 ]", "");

                String[] words = scenario.trim().split("\\s+");

                if (words.length == 0) {
                        return "generatedTest";
                }

                StringBuilder methodName = new StringBuilder();

                // First word in lowercase
                methodName.append(words[0].toLowerCase());

                // Remaining words start with uppercase
                for (int i = 1; i < words.length; i++) {

                        methodName.append(
                                        Character.toUpperCase(words[i].charAt(0)));

                        methodName.append(
                                        words[i].substring(1).toLowerCase());
                }

                return methodName.toString();
        }

        public static void generate(
                        TestDesignData data)
                        throws Exception {

                StringBuilder code = new StringBuilder();

                System.out.println("BEFORE GENERATE TESTS");
                System.out.println("SCENARIOS COUNT = " + data.getScenarios().size());
                System.out.println("POSITIVE COUNT = " + data.getPositiveCases().size());
                System.out.println("NEGATIVE COUNT = " + data.getNegativeCases().size());
                System.out.println("EDGE COUNT = " + data.getEdgeCases().size());
                System.out.println("AFTER GENERATE TESTS");

                logGenerationSummary(data);

                generatePackage(code);

                generateImports(code);

                generateClassHeader(code);

                generateAllTests(code, data);

                generateClassFooter(code);

                System.out.println("===== GENERATED CODE =====");
                System.out.println(code.toString());
                System.out.println("===== END GENERATED CODE =====");

                writeGeneratedFile(code);
        }

        private static void logGenerationSummary(TestDesignData data) {
                System.out.println("POSITIVE LIST = " + data.getPositiveCases());
                System.out.println("NEGATIVE LIST = " + data.getNegativeCases());
                System.out.println("EDGE LIST = " + data.getEdgeCases());
        }

        private static void generateAllTests(
                        StringBuilder code,
                        TestDesignData data) {

                generateTests(
                                code,
                                removeDuplicates(
                                                data.getAutomationCandidates()),
                                data);
        }

        private static void generatePackage(StringBuilder code) {

                code.append("package tests;\n\n");

        }

        private static void generateImports(StringBuilder code) {

                code.append("import org.testng.annotations.Test;\n");
                code.append("import org.testng.Assert;\n");
                code.append("import pages.RegistrationPage;\n\n");
                code.append("import base.BaseTest;\n\n");
                code.append("import config.FrameworkConstants;\n");

        }

        private static void generateClassHeader(StringBuilder code) {

                code.append(
                                "public class GeneratedTests extends BaseTest {\n\n");

        }

        private static void generateClassFooter(StringBuilder code) {

                code.append("}");

        }

        private static void writeGeneratedFile(StringBuilder code)
                        throws Exception {

                Files.writeString(

                                Path.of("src/test/java/tests/GeneratedTests.java"),

                                code.toString());

        }

        private static String capitalize(String text) {

                return Character.toUpperCase(text.charAt(0))
                                + text.substring(1);
        }

        private static String getParameterName(String locator) {

                String lower = locator.toLowerCase();

                if (lower.contains("email"))
                        return "email";

                if (lower.contains("confirmpassword"))
                        return "confirmPassword";

                if (lower.contains("password"))
                        return "password";

                return "value";
        }

        private static void generateTests(
                        StringBuilder code,
                        List<String> scenarios,
                        TestDesignData data) {

                System.out.println("generateTests() called");
                System.out.println("Scenario count = " + scenarios.size());

                for (model.ScenarioData sd : data.getScenarioData()) {

                        String scenario = sd.getScenario();

                        String expectedResult = sd.getExpectedResult();

                        System.out.println("GENERATING TEST FOR: " + scenario);

                        String methodName = toCamelCaseMethodName(scenario);

                        code.append(
                                        "    /**\n");

                        code.append(
                                        "     * Test Scenario:\n");

                        code.append(
                                        "     * "
                                                        + scenario
                                                        + "\n");

                        code.append(
                                        "     */\n");

                        code.append("    @Test\n");

                        code.append(
                                        "    public void "
                                                        + methodName
                                                        + "() {\n\n");

                        code.append(
                                        "        driver.get(FrameworkConstants.BASE_URL);\n\n");

                        code.append(
                                        "        RegistrationPage page =\n" +
                                                        "                new RegistrationPage(driver);\n\n");

                        code.append(
                                        getSeleniumSteps(sd, data));

                        code.append(
                                        getAssertion(
                                                        scenario,
                                                        expectedResult));

                        code.append("\n");

                        code.append(
                                        "    }\n\n");
                }
        }

        private static String getSeleniumSteps(
                        model.ScenarioData sd,
                        TestDesignData data) {

                StringBuilder steps = new StringBuilder();

                String scenario = sd.getScenario();

                String email = sd.getEmail();

                String password = sd.getPassword();

                String confirmPassword = sd.getConfirmPassword();

                System.out.println("Scenario = " + scenario);
                System.out.println("Email = " + email);
                System.out.println("Password = " + password);
                System.out.println("Confirm = " + confirmPassword);

                steps.append("        String email = \"" + email + "\";\n");
                steps.append("        String password = \"" + password + "\";\n");
                steps.append("        String confirmPassword = \"" + confirmPassword + "\";\n\n");

                for (String field : data.getLocators().keySet()) {

                        String fieldLower = field.toLowerCase();

                        if (fieldLower.contains("button")) {

                                steps.append("        page.click")
                                                .append(capitalize(field))
                                                .append("();\n\n");

                        } else if (fieldLower.contains("message")
                                        || fieldLower.contains("error")) {

                                continue;

                        } else {

                                String variable = getParameterName(field);

                                steps.append("        page.enter")
                                                .append(capitalize(field))
                                                .append("(")
                                                .append(variable)
                                                .append(");\n\n");
                        }
                }

                return steps.toString();
        }

        private static String getAssertion(String scenario, String expectedResult) {

                if ("Registration Successful".equalsIgnoreCase(expectedResult)) {

                        return """
                                        Assert.assertEquals(
                                                page.getSuccessMessage(),
                                                "Registration Successful");
                                        """;
                }

                String getter = findGetterFromExpectedResult(expectedResult);

                return "        Assert.assertEquals(\n" +
                                "                page." + getter + "(),\n" +
                                "                \"" + expectedResult + "\");\n";
        }

        private static String findGetterFromExpectedResult(String expectedResult) {

                String lower = expectedResult.toLowerCase();

                if (lower.contains("already exists"))
                        return "getEmailExistsErrorMessage";

                if (lower.contains("at least 8")
                                || lower.contains("minimum 8"))
                        return "getPasswordLengthErrorMessage";

                if (lower.contains("uppercase"))
                        return "getPasswordUppercaseErrorMessage";

                if (lower.contains("lowercase"))
                        return "getPasswordLowercaseErrorMessage";

                if (lower.contains("special character"))
                        return "getPasswordSpecialCharErrorMessage";

                if (lower.contains("invalid email"))
                        return "getInvalidEmailFormatErrorMessage";

                if (lower.contains("email cannot")
                                || lower.contains("email field cannot")
                                || lower.contains("empty email"))
                        return "getEmptyEmailErrorMessage";

                if (lower.contains("password cannot")
                                || lower.contains("password field cannot")
                                || lower.contains("empty password"))
                        return "getEmptyPasswordErrorMessage";

                if (lower.contains("do not match")
                                || lower.contains("passwords do not match"))
                        return "getPasswordMismatchErrorMessage";

                return "getErrorMessage";
        }
}