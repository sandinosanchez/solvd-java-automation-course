package com.solvd.sandinosanchez.connectionpool.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.solvd.sandinosanchez.connectionpool.models.BaseModel;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.List;

public class JsonParser {
    private static final Logger LOGGER = Logger.getLogger(JsonParser.class);
    private static final String PATH_TO_JSON_OUTPUT = "src/main/resources/jsonOutput.json";
    private static final String PATH_TO_JSON_INPUT = "src/main/resources/jsonInput.json";
    private static final String PATH_TO_XML_OUTPUT = "src/main/resources/xmlOutput.xml";
    private static ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

    public static List<BaseModel> deSerializeJson(Class<? extends BaseModel> classType) {
        try (InputStream is = new FileInputStream(PATH_TO_JSON_INPUT)){
            return mapper.readValue(is, mapper.getTypeFactory().constructCollectionType(List.class, classType));
        } catch (IOException e) {
            LOGGER.error(e);
        }
        return null;
    }

    public static void serializeJson(List<? extends BaseModel> listToSerialize) {
        try(FileWriter outputJsonFile = new FileWriter(PATH_TO_JSON_OUTPUT)) {
            outputJsonFile.write(mapper.writeValueAsString(listToSerialize));
        } catch (IOException e) {
            LOGGER.error(e);
        }
    }
}

