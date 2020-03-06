package com.solvd.sandinosanchez.connectionpool.utils;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.solvd.sandinosanchez.connectionpool.models.BaseModel;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XmlDomParser {
    private static final Logger LOGGER = Logger.getLogger(XmlDomParser.class);
    private static XmlMapper mapper = new XmlMapper();
    private static final String PATH_TO_XML_OUTPUT = "src/main/resources/xmlOutput.xml";

    public static void serialize(List<? extends BaseModel> modelToSerialize) {
        try(FileWriter xmlOutputFile = new FileWriter(PATH_TO_XML_OUTPUT)) {
            mapper.writeValue(xmlOutputFile, modelToSerialize);
        } catch (IOException e) {
            LOGGER.error(e);
        }
    }

    private static File initializeFile(String path) {
        return new File(path);
    }

    public static List<? extends BaseModel> deSerialize(Class<? extends BaseModel> classType) {
        List<? extends  BaseModel> models = new ArrayList<>();
        try {
            Document document = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder()
                    .parse(new File(PATH_TO_XML_OUTPUT));
            document.getDocumentElement().normalize();
            NodeList nodes = document.getElementsByTagName(classType.getName());
            for (int i = 0; i < nodes.getLength() ; i++) {
                
            }
        } catch (SAXException | IOException | ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

}
