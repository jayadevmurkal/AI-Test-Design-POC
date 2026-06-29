package service;

import java.nio.file.Files;
import java.nio.file.Path;

public class PromptFileWriter {

    public static void savePrompt(String prompt)
            throws Exception {

        Files.writeString(
                Path.of("generated-prompt.txt"),
                prompt);
    }
}