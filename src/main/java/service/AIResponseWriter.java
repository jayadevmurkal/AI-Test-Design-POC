package service;

import java.io.FileWriter;

public class AIResponseWriter {

        public static void saveResponse(String response)
                        throws Exception {

                FileWriter writer = new FileWriter(
                                "src/main/resources/ai-response.txt");

                writer.write(response);

                writer.close();
        }
}