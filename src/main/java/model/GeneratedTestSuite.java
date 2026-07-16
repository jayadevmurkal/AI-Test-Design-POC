package model;

import java.util.ArrayList;
import java.util.List;

public class GeneratedTestSuite {

    private String featureName;

    private String requirement;

    private List<GeneratedTestCase> testCases = new ArrayList<>();

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public List<GeneratedTestCase> getTestCases() {
        return testCases;
    }

    public void setTestCases(List<GeneratedTestCase> testCases) {
        this.testCases = testCases;
    }

    public void addTestCase(GeneratedTestCase testCase) {
        this.testCases.add(testCase);
    }
}