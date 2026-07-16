package service;

import java.nio.file.Files;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.ObjectMapper;

import config.FrameworkConstants;
import model.v2.GeneratedTestSuite;

public class AIResponseReaderV2 {

    public static GeneratedTestSuite read() throws Exception {

        String json = Files.readString(
                Paths.get(FrameworkConstants.AI_RESPONSE_JSON));

        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(json, GeneratedTestSuite.class);
    }
}