package ai;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import config.ConfigKeys;
import config.ConfigLoader;
import okhttp3.*;
import config.ConfigLoader;
import config.ConfigKeys;
import java.io.IOException;
import java.time.Duration;

public class GeminiService {

        public static String generateResponse(String prompt)
                        throws Exception {

                String apiKey = ConfigLoader.getProperty(ConfigKeys.GEMINI_API_KEY);

                System.out.println("API Key Loaded Successfully");

                String baseUrl = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent";

                String url = baseUrl + "?key=" + apiKey;

                JsonObject textPart = new JsonObject();
                textPart.addProperty("text", prompt);

                JsonArray parts = new JsonArray();
                parts.add(textPart);

                JsonObject content = new JsonObject();
                content.add("parts", parts);

                JsonArray contents = new JsonArray();
                contents.add(content);

                JsonObject requestBody = new JsonObject();
                requestBody.add("contents", contents);

                OkHttpClient client = new OkHttpClient.Builder()
                                .connectTimeout(java.time.Duration.ofSeconds(60))
                                .readTimeout(java.time.Duration.ofSeconds(120))
                                .writeTimeout(java.time.Duration.ofSeconds(60))
                                .build();

                System.out.println(
                                "Prompt Length = "
                                                + prompt.length());

                RequestBody body = RequestBody.create(
                                requestBody.toString(),
                                MediaType.parse(
                                                "application/json"));

                Request request = new Request.Builder()
                                .url(url)
                                .post(body)
                                .build();

                System.out.println("Calling Gemini API...");

                Response response = null;

                int maxRetries = 5;

                for (int attempt = 1; attempt <= maxRetries; attempt++) {

                        response = client.newCall(request).execute();

                        System.out.println(
                                        "Gemini Response Code = " + response.code());

                        if (response.isSuccessful()) {
                                break;
                        }

                        if (response.code() == 503) {

                                System.out.println(
                                                "Gemini overloaded. Retry "
                                                                + attempt
                                                                + " of "
                                                                + maxRetries);

                                Thread.sleep(attempt * 10000);

                                continue;
                        }

                        String errorBody = response.body() != null
                                        ? response.body().string()
                                        : "No error body";

                        throw new IOException(
                                        "Gemini API Error: "
                                                        + response.code()
                                                        + "\n"
                                                        + errorBody);
                }

                if (response == null || !response.isSuccessful()) {

                        String errorBody = response != null && response.body() != null
                                        ? response.body().string()
                                        : "No error body";

                        throw new IOException(
                                        "Gemini API Error after retries\n"
                                                        + errorBody);
                }

                String responseBody = response.body().string();

                JsonObject json = JsonParser.parseString(responseBody)
                                .getAsJsonObject();

                return json
                                .getAsJsonArray("candidates")
                                .get(0)
                                .getAsJsonObject()
                                .getAsJsonObject("content")
                                .getAsJsonArray("parts")
                                .get(0)
                                .getAsJsonObject()
                                .get("text")
                                .getAsString();
        }
}