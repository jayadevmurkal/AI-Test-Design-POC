package service;

import model.TestDesignData;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class AIResponseReader {

    public static TestDesignData readResponses()
            throws Exception {

        List<String> lines = Files.readAllLines(
                Paths.get(
                        "src/main/resources/ai-response.txt"));

        TestDesignData data = new TestDesignData();

        String currentSection = "";

        for (String line : lines) {

            System.out.println("READ LINE: " + line);

            line = line.trim();

            line = line.replace("**", "").trim();

            if (line.isEmpty()) {
                continue;
            }

            if (line.equals("[TEST_SCENARIO]")) {
                currentSection = "SCENARIO";
                continue;
            }

            if (line.equals("[POSITIVE]")) {
                currentSection = "POSITIVE";
                continue;
            }

            if (line.equals("[NEGATIVE]")) {
                currentSection = "NEGATIVE";
                continue;
            }

            if (line.equals("[EDGE]")) {
                currentSection = "EDGE";
                continue;
            }

            if (line.equals("[AUTOMATION]")) {
                currentSection = "AUTOMATION";
                continue;
            }

            if (line.equals("[TEST_DATA]")) {
                currentSection = "DATA";
                continue;
            }

            switch (currentSection) {

                case "SCENARIO":
                    data.getScenarios().add(line);
                    break;

                case "POSITIVE":
                    System.out.println("ADDING POSITIVE: " + line);
                    data.getPositiveCases().add(line);
                    break;

                case "NEGATIVE":
                    System.out.println("ADDING NEGATIVE: " + line);
                    data.getNegativeCases().add(line);
                    break;

                case "EDGE":
                    System.out.println("ADDING EDGE: " + line);
                    data.getEdgeCases().add(line);
                    break;

                case "AUTOMATION":
                    data.getAutomationCandidates().add(line);
                    break;

                case "DATA":
                    data.getTestData().add(line);
                    System.out.println("ADDING TEST DATA: " + line);
                    break;
            }
        }
        return data;
    }
}