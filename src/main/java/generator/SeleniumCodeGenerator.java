package generator;

import model.TestDesignData;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.LinkedHashSet;
import java.util.Set;

public class SeleniumCodeGenerator {

        private static String getEmail(String scenario) {

                scenario = scenario.toLowerCase();

                if (scenario.contains("already exists")) {
                        return "existinguser@gmail.com";
                }

                return "validuser@gmail.com";
        }

        private static String getPassword(String scenario) {

                scenario = scenario.toLowerCase();

                if (scenario.contains("less than 8")) {
                        return "pass123";
                }

                return "Pass@123";
        }

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

        private static String generateDataProviders(
                        TestDesignData data) {

                String uniqueEmail = "uniqueuser@example.com";
                String validPassword = "Password123!";
                String existingEmail = "existinguser@example.com";
                String invalidPassword = "pass12!";

                List<String> testData = data.getTestData();

                System.out.println("TEST DATA LIST = " + testData);

                if (testData.size() >= 4) {

                        uniqueEmail = "testuser@gmail.com";
                        validPassword = "Testpass1!";
                        existingEmail = "existinguser@gmail.com";
                        invalidPassword = "Pass1!";
                }

                return

                "    @DataProvider(name=\"validRegistrationData\")\n" +
                                "    public Object[][] validRegistrationData() {\n" +
                                "        return new Object[][] {\n" +
                                "            {\"" + uniqueEmail + "\", \"" + validPassword + "\"}\n" +
                                "        };\n" +
                                "    }\n\n" +

                                "    @DataProvider(name=\"duplicateEmailData\")\n" +
                                "    public Object[][] duplicateEmailData() {\n" +
                                "        return new Object[][] {\n" +
                                "            {\"" + existingEmail + "\", \"" + validPassword + "\"}\n" +
                                "        };\n" +
                                "    }\n\n" +

                                "    @DataProvider(name=\"invalidPasswordData\")\n" +
                                "    public Object[][] invalidPasswordData() {\n" +
                                "        return new Object[][] {\n" +
                                "            {\"" + uniqueEmail + "\", \"" + invalidPassword + "\"}\n" +
                                "        };\n" +
                                "    }\n\n" +

                                "    @DataProvider(name=\"exactPasswordData\")\n" +
                                "    public Object[][] exactPasswordData() {\n" +
                                "        return new Object[][] {\n" +
                                "            {\"exact8@example.com\", \"Abcdef1!\"}\n" +
                                "        };\n" +
                                "    }\n\n";
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

                code.append(generateDataProviders(data));

                generateClassFooter(code);

                generateAllTests(code, data);

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
                                removeDuplicates(data.getPositiveCases()));

                generateTests(
                                code,
                                removeDuplicates(data.getNegativeCases()));

                generateTests(
                                code,
                                removeDuplicates(data.getEdgeCases()));
        }

        private static void generatePackage(StringBuilder code) {

                code.append("package tests;\n\n");

        }

        private static void generateImports(StringBuilder code) {

                code.append("import org.testng.annotations.Test;\n");
                code.append("import org.testng.annotations.DataProvider;\n");
                code.append("import org.testng.Assert;\n");

                code.append("import pages.RegistrationPage;\n\n");

                code.append("import base.BaseTest;\n\n");

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

        private static void generateTests(
                        StringBuilder code,
                        List<String> scenarios) {

                System.out.println("generateTests() called");
                System.out.println("Scenario count = " + scenarios.size());

                for (String scenario : scenarios) {

                        System.out.println("GENERATING TEST FOR: " + scenario);

                        String methodName = toCamelCaseMethodName(scenario);

                        String provider = getDataProviderName(scenario);

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

                        code.append(
                                        "    @Test(dataProvider=\""
                                                        + provider +
                                                        "\")\n");

                        code.append(
                                        "    public void "
                                                        + methodName
                                                        + "(String email, String password) {\n\n");

                        code.append(
                                        "        driver.get(\"https://sample-app.com/register\");\n\n");

                        code.append(
                                        "        RegistrationPage page =\n" +
                                                        "                new RegistrationPage(driver);\n\n");

                        code.append(
                                        getSeleniumSteps(scenario));

                        code.append(
                                        getAssertion(scenario));

                        code.append("\n");

                        code.append(
                                        "    }\n\n");
                }
        }

        private static String getSeleniumSteps(
                        String scenario) {

                return "        page.enterEmail(email);\n\n" +

                                "        page.enterPassword(password);\n\n" +

                                "        page.clickRegister();\n\n";
        }

        private static String getAssertion(
                        String scenario) {

                scenario = scenario.toLowerCase();

                if (scenario.contains("successful")) {

                        return "        Assert.assertEquals(\n" +
                                        "                page.getSuccessMessage(),\n" +
                                        "                \"Registration Successful\");\n";
                }

                if (scenario.contains("exactly 8")) {

                        return "        Assert.assertEquals(\n" +
                                        "                page.getSuccessMessage(),\n" +
                                        "                \"Registration Successful\");\n";
                }

                if (scenario.contains("email already exists")) {

                        return "        Assert.assertEquals(\n" +
                                        "                page.getErrorMessage(),\n" +
                                        "                \"Email already exists\");\n";
                }

                if (scenario.contains("password")) {

                        return "        Assert.assertEquals(\n" +
                                        "                page.getErrorMessage(),\n" +
                                        "                \"Invalid Password\");\n";
                }

                return "        Assert.assertTrue(true);\n";
        }

        private static String getDataProviderName(String scenario) {

                scenario = scenario.toLowerCase();

                if (scenario.contains("successful")) {
                        return "validRegistrationData";
                }

                if (scenario.contains("already exists")
                                || scenario.contains("existing email")) {
                        return "duplicateEmailData";
                }

                if (scenario.contains("less than 8")) {
                        return "invalidPasswordData";
                }

                if (scenario.contains("exactly 8")) {
                        return "exactPasswordData";
                }

                return "validRegistrationData";
        }

}
