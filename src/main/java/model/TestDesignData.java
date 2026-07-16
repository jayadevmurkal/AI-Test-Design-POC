package model;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class TestDesignData {

    private List<String> scenarios = new ArrayList<>();
    private List<String> positiveCases = new ArrayList<>();
    private List<String> negativeCases = new ArrayList<>();
    private List<String> edgeCases = new ArrayList<>();
    private List<String> automationCandidates = new ArrayList<>();
    private Map<String, String> locators = new LinkedHashMap<>();
    private List<String> expectedResults = new ArrayList<>();
    private List<String> testData = new ArrayList<>();
    private List<ScenarioData> scenarioData = new ArrayList<>();
    private List<GeneratedTestCase> generatedTestCases = new ArrayList<>();

    public List<GeneratedTestCase> getGeneratedTestCases() {
        return generatedTestCases;
    }

    public void setGeneratedTestCases(List<GeneratedTestCase> generatedTestCases) {
        this.generatedTestCases = generatedTestCases;
    }

    public List<ScenarioData> getScenarioData() {
        return scenarioData;
    }

    public List<String> getScenarios() {
        return scenarios;
    }

    public List<String> getPositiveCases() {
        return positiveCases;
    }

    public List<String> getNegativeCases() {
        return negativeCases;
    }

    public List<String> getEdgeCases() {
        return edgeCases;
    }

    public List<String> getAutomationCandidates() {
        return automationCandidates;
    }

    public Map<String, String> getLocators() {
        return locators;
    }

    public List<String> getTestData() {
        return testData;
    }

    public List<String> getExpectedResults() {
        return expectedResults;
    }

    public void setExpectedResults(List<String> expectedResults) {
        this.expectedResults = expectedResults;
    }
}