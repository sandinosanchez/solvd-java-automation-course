package com.solvd.sandinosanchez.utils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
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
    private static final String PATH_TO_JSON_INPUT = "src/main/resources/jsonInput.json";
    private static ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

    public static List<BaseModel> deSerialize(Class<? extends BaseModel> classType) {
        try (InputStream is = new FileInputStream(PATH_TO_JSON_INPUT)){
            return mapper.readValue(is, mapper.getTypeFactory().constructCollectionType(List.class, classType));
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
