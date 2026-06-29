package builder;

import model.TestCase;
import model.TestDesignData;

import java.util.ArrayList;
import java.util.List;

public class TestCaseBuilder {

    public static List<TestCase> build(
            TestDesignData data) {

        List<TestCase> testCases =
                new ArrayList<>();

        int positiveCounter = 1;
        int negativeCounter = 1;
        int edgeCounter = 1;

        // Positive Cases
        for (String scenario : data.getPositiveCases()) {

            testCases.add(
                    new TestCase(
                            String.format(
                                    "POS-%03d",
                                    positiveCounter++),
                            scenario,
                            "High",
                            getExpectedResult(scenario),
                            getTestSteps(scenario)
                    )
            );
        }

        // Negative Cases
        for (String scenario : data.getNegativeCases()) {

            testCases.add(
                    new TestCase(
                            String.format(
                                    "NEG-%03d",
                                    negativeCounter++),
                            scenario,
                            "Medium",
                            getExpectedResult(scenario),
                            getTestSteps(scenario)
                    )
            );
        }

        // Edge Cases
        for (String scenario : data.getEdgeCases()) {

            testCases.add(
                    new TestCase(
                            String.format(
                                    "EDGE-%03d",
                                    edgeCounter++),
                            scenario,
                            "Low",
                            getExpectedResult(scenario),
                            getTestSteps(scenario)
                    )
            );
        }

        return testCases;
    }

    private static String getExpectedResult(
            String scenario) {

        scenario = scenario.toLowerCase();

        if (scenario.contains("successful registration")) {
            return "Registration success message should be displayed";
        }

        if (scenario.contains("email already exists")) {
            return "Existing email error message should be displayed";
        }

        if (scenario.contains("password validation")) {
            return "Password validation message should be displayed";
        }

        if (scenario.contains("exactly 8")) {
            return "Registration should be successful with 8-character password";
        }

        return "System should behave as expected";
    }

    private static String getTestSteps(
            String scenario) {

        scenario = scenario.toLowerCase();

        if (scenario.contains("email already exists")) {

            return "1. Open Registration Page\n"
                    + "2. Enter existing email\n"
                    + "3. Enter valid password\n"
                    + "4. Click Register button\n"
                    + "5. Verify error message";
        }

        if (scenario.contains("password validation")) {

            return "1. Open Registration Page\n"
                    + "2. Enter valid email\n"
                    + "3. Enter password less than 8 characters\n"
                    + "4. Click Register button\n"
                    + "5. Verify validation message";
        }

        if (scenario.contains("successful registration")) {

            return "1. Open Registration Page\n"
                    + "2. Enter valid email\n"
                    + "3. Enter valid password\n"
                    + "4. Click Register button\n"
                    + "5. Verify success message";
        }

        return "1. Open Registration Page\n"
                + "2. Enter required data\n"
                + "3. Click Submit button";
    }
}