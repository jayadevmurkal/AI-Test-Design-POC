package model;

import java.util.LinkedHashMap;
import java.util.Map;

public class GeneratedTestCase {

    private String scenario;

    private String priority;

    private String expectedResult;

    private String testCaseId;

    private String category;

    private boolean automationCandidate;

    private Map<String, String> testData = new LinkedHashMap<>();

    private Map<String, String> locators = new LinkedHashMap<>();

    public String getScenario() {
        return scenario;
    }

    public void setScenario(String scenario) {
        this.scenario = scenario;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public void setExpectedResult(String expectedResult) {
        this.expectedResult = expectedResult;
    }

    public Map<String, String> getTestData() {
        return testData;
    }

    public void setTestData(Map<String, String> testData) {
        this.testData = testData;
    }

    public Map<String, String> getLocators() {
        return locators;
    }

    public void setLocators(Map<String, String> locators) {
        this.locators = locators;
    }
}