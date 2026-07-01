package service;

import config.FrameworkConstants;

import java.io.FileWriter;

public class AIResponseWriter {

        public static void saveAIResponse(String response) throws Exception {

                try (FileWriter writer = new FileWriter(FrameworkConstants.AI_RESPONSE_FILE)) {

                        writer.write(response);
                }
        }
}