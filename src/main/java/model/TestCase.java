package model;

public class TestCase {

    private String testCaseId;
    private String scenario;
    private String priority;
    private String expectedResult;
    private String testSteps;

    public TestCase(
        String testCaseId,
        String scenario,
        String priority,
        String expectedResult,
        String testSteps) {

    this.testCaseId = testCaseId;
    this.scenario = scenario;
    this.priority = priority;
    this.expectedResult = expectedResult;
    this.testSteps = testSteps;
}

        public String getTestCaseId() {
            return testCaseId;
        }

        public String getScenario() {
            return scenario;
        }

        public String getPriority() {
            return priority;
        }

        public String getExpectedResult() {
            return expectedResult;
        }

        public String getTestSteps() {
        return testSteps;
    }
}