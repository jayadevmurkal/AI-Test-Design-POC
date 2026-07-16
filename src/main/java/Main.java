import prompt.PromptBuilder;
import service.FileReaderService;
import service.PromptFileWriter;
import export.ExcelExporter;
import service.AIResponseReader;
import model.TestDesignData;
import ai.GeminiService;
import service.AIResponseWriter;
import generator.PageObjectGenerator;
import generator.SeleniumCodeGenerator;
import builder.TestCaseBuilder;
import model.TestCase;
import generator.TestNGXmlGenerator;

import java.util.List;

public class Main {

        public static void main(String[] args)
                        throws Exception {

                String requirement = FileReaderService.readFile(
                                "src/main/resources/requirement.txt");

                String prompt = PromptBuilder.buildPrompt(requirement);

                System.out.println(prompt);

                PromptFileWriter.savePrompt(prompt);

                System.out.println(
                                "\nPrompt saved successfully!");

                String aiResponse = GeminiService.generateResponse(prompt);

                System.out.println(
                                "\n===== AI RESPONSE =====\n");

                System.out.println(aiResponse);

                AIResponseWriter.saveAIResponse(aiResponse);

                System.out.println(
                                "\nAI response saved successfully!");
                // System.out.println(
                // "Using local ai-response.txt file");

                TestDesignData data = AIResponseReader.readAIResponse();

                System.out.println("\n===== TEST DATA =====");

                for (int i = 0; i < data.getTestData().size(); i++) {
                        System.out.println(i + " -> " + data.getTestData().get(i));
                }

                System.out.println(
                                "Positive Cases: "
                                                + data.getPositiveCases().size());

                System.out.println(
                                "Negative Cases: "
                                                + data.getNegativeCases().size());

                System.out.println(
                                "Edge Cases: "
                                                + data.getEdgeCases().size());

                List<TestCase> testCases = TestCaseBuilder.build(data);

                System.out.println("Scenarios: "
                                + data.getScenarios().size());

                System.out.println("Automation: "
                                + data.getAutomationCandidates().size());

                System.out.println("Test Data: "
                                + data.getTestData().size());

                System.out.println(
                                "Expected Results: "
                                                + data.getExpectedResults().size());

                ExcelExporter.export(data);
                ExcelExporter.exportTestCases(testCases);
                SeleniumCodeGenerator.generate(data);
                PageObjectGenerator.generate("Registration", data);

                TestNGXmlGenerator.generate();

                System.out.println(
                                "Automation code generated successfully!");

                System.out.println(
                                "TestNG XML generated successfully!");

                System.out.println(
                                "Excel file generated successfully.");
        }
}