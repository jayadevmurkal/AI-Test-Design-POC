package service;

import model.TestDesignData;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import config.FrameworkConstants;

public class AIResponseReader {

    private static final String SCENARIO = "SCENARIO";
    private static final String POSITIVE = "POSITIVE";
    private static final String NEGATIVE = "NEGATIVE";
    private static final String EDGE = "EDGE";
    private static final String AUTOMATION = "AUTOMATION";
    private static final String LOCATORS = "LOCATORS";
    private static final String EXPECTED = "EXPECTED";
    private static final String DATA = "DATA";

    public static TestDesignData readAIResponse() throws Exception {

        List<String> lines = Files.readAllLines(
                Paths.get(FrameworkConstants.AI_RESPONSE_FILE));

        TestDesignData data = new TestDesignData();

        String currentSection = "";

        model.ScenarioData currentScenarioData = null;

        for (String line : lines) {

            line = line.trim();
            line = line.replace("**", "").trim();

            if (line.isEmpty() && !currentSection.equals(DATA)) {
                continue;
            }

            if (line.equals("[TEST_SCENARIO]")) {
                currentSection = SCENARIO;
                continue;
            }

            if (line.equals("[POSITIVE]")) {
                currentSection = POSITIVE;
                continue;
            }

            if (line.equals("[NEGATIVE]")) {
                currentSection = NEGATIVE;
                continue;
            }

            if (line.equals("[EDGE]")) {
                currentSection = EDGE;
                continue;
            }

            if (line.equals("[AUTOMATION]")) {
                currentSection = AUTOMATION;
                continue;
            }

            if (line.equals("[LOCATORS]")) {
                currentSection = LOCATORS;
                continue;
            }

            if (line.equals("[EXPECTED_RESULTS]")) {
                currentSection = EXPECTED;
                continue;
            }

            if (line.equals("[TEST_DATA]")) {
                currentSection = DATA;
                continue;
            }

            switch (currentSection) {

                case SCENARIO:
                    data.getScenarios().add(line);
                    break;

                case POSITIVE:
                    data.getPositiveCases().add(line);
                    break;

                case NEGATIVE:
                    data.getNegativeCases().add(line);
                    break;

                case EDGE:
                    data.getEdgeCases().add(line);
                    break;

                case AUTOMATION:
                    data.getAutomationCandidates().add(line);
                    break;

                case LOCATORS:

                    String[] parts = line.split("=", 3);

                    if (parts.length == 3) {

                        data.getLocators().put(
                                parts[0].trim(),
                                parts[1].trim() + "=" + parts[2].trim());

                    }

                    break;

                case EXPECTED:
                    data.getExpectedResults().add(line);
                    break;

                case DATA:

                    if (line.isBlank()) {

                        if (currentScenarioData != null) {
                            data.getScenarioData().add(currentScenarioData);
                            currentScenarioData = null;
                        }

                        break;
                    }

                    if (line.startsWith("Scenario=")) {

                        if (currentScenarioData != null) {
                            data.getScenarioData().add(currentScenarioData);
                        }

                        currentScenarioData = new model.ScenarioData();

                        currentScenarioData.setScenario(
                                line.substring("Scenario=".length()).trim());

                        break;
                    }

                    if (line.startsWith("Email=")) {

                        currentScenarioData.setEmail(
                                line.substring("Email=".length()).trim());

                        break;
                    }

                    if (line.startsWith("Password=")) {

                        currentScenarioData.setPassword(
                                line.substring("Password=".length()).trim());

                        break;
                    }

                    if (line.startsWith("ConfirmPassword=")) {

                        currentScenarioData.setConfirmPassword(
                                line.substring("ConfirmPassword=".length()).trim());

                        break;
                    }

                    break;
            }
        }

        // buildScenarioData(data);
        if (currentScenarioData != null) {
            data.getScenarioData().add(currentScenarioData);
        }

        for (int i = 0; i < data.getScenarioData().size()
                && i < data.getExpectedResults().size(); i++) {

            data.getScenarioData()
                    .get(i)
                    .setExpectedResult(
                            data.getExpectedResults().get(i));
        }

        System.out.println("\n===== SCENARIO DATA =====");

        for (model.ScenarioData sd : data.getScenarioData()) {

            System.out.println("--------------------------------");

            System.out.println("Scenario : " + sd.getScenario());
            System.out.println("Email    : " + sd.getEmail());
            System.out.println("Password : " + sd.getPassword());
            System.out.println("Confirm  : " + sd.getConfirmPassword());
            System.out.println("Expected : " + sd.getExpectedResult());
        }

        System.out.println("LOCATORS = " + data.getLocators());

        return data;
    }

    private static void buildScenarioData(TestDesignData data) {

        for (int i = 0; i < data.getAutomationCandidates().size(); i++) {

            model.ScenarioData sd = new model.ScenarioData();

            sd.setScenario(data.getAutomationCandidates().get(i));

            if (i < data.getExpectedResults().size()) {
                sd.setExpectedResult(data.getExpectedResults().get(i));
            }

            data.getScenarioData().add(sd);
        }
    }
}