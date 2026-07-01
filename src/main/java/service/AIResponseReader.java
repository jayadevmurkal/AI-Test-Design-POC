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
    private static final String DATA = "DATA";

    public static TestDesignData readAIResponse() throws Exception {

        List<String> lines = Files.readAllLines(
                Paths.get(FrameworkConstants.AI_RESPONSE_FILE));

        TestDesignData data = new TestDesignData();

        String currentSection = "";

        for (String line : lines) {

            line = line.trim();
            line = line.replace("**", "").trim();

            if (line.isEmpty()) {
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

                case DATA:
                    data.getTestData().add(line);
                    break;
            }
        }

        return data;
    }
}