package prompt;

import config.FrameworkConstants;

import java.nio.file.Files;
import java.nio.file.Paths;

public class PromptBuilder {

    public static String buildPrompt(String requirement) throws Exception {

        String promptTemplate = Files.readString(
                Paths.get(FrameworkConstants.TEST_DESIGN_PROMPT));

        return promptTemplate.replace(
                "{REQUIREMENT}",
                requirement);

    }
}