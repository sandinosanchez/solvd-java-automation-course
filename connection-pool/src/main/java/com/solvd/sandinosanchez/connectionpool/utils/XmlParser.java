package com.solvd.sandinosanchez.connectionpool.utils;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.solvd.sandinosanchez.connectionpool.models.BaseModel;
import org.apache.log4j.Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class XmlParser {
    private static final Logger LOGGER = Logger.getLogger(XmlParser.class);
    private static XmlMapper mapper = new XmlMapper();
    private static final String PATH_TO_XML_OUTPUT = "src/main/resources/xmlOutput.xml";

    public static void serialize(List<? extends BaseModel> modelToSerialize) {
        try(FileWriter xmlOutputFile = new FileWriter(PATH_TO_XML_OUTPUT)) {
            mapper.writeValue(xmlOutputFile, modelToSerialize);
        } catch (IOException e) {
            LOGGER.error(e);
        }
    }
}
