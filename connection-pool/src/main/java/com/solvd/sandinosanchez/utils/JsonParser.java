package com.solvd.sandinosanchez.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.solvd.sandinosanchez.dao.AbstractDao;
import com.solvd.sandinosanchez.model.BaseModel;
import org.apache.log4j.Logger;
import java.io.*;
import java.util.List;

public class JsonParser {
    private static final Logger LOGGER = Logger.getLogger(JsonParser.class);
    private static final String PATH_TO_JSON_OUTPUT = "src/main/resources/jsonOutput.json";
    private static ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

    public static String deSerialize(Class<? extends BaseModel> classType, String pathToJson) {
        try (InputStream inputJson = new FileInputStream(pathToJson)) {
            List<? extends BaseModel> classList = mapper.readValue(inputJson, mapper.getTypeFactory().constructCollectionType(List.class, classType));
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(classList);
        } catch (IOException e) {
            LOGGER.info(e.getMessage());
        }
        return null;
    }

    public static void serialize(List<? extends BaseModel> listToSerialize) {
        try(FileWriter outputJsonFile = new FileWriter(PATH_TO_JSON_OUTPUT)) {
            outputJsonFile.write(mapper.writeValueAsString(listToSerialize));
        } catch (IOException e) {
            LOGGER.info(e.getMessage());
        }
    }


}
