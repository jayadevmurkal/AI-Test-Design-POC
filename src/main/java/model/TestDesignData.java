package model;

import java.util.ArrayList;
import java.util.List;

public class TestDesignData {

    private List<String> scenarios = new ArrayList<>();

    private List<String> positiveCases = new ArrayList<>();

    private List<String> negativeCases = new ArrayList<>();

    private List<String> edgeCases = new ArrayList<>();

    private List<String> automationCandidates = new ArrayList<>();

    private List<String> testData = new ArrayList<>();

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

    public List<String> getTestData() {
        return testData;
    }
}