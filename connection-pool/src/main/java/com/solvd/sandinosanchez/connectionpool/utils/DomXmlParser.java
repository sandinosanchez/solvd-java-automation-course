package com.solvd.sandinosanchez.connectionpool.utils;

import com.solvd.sandinosanchez.connectionpool.models.BaseModel;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DomXmlParser {
    private static final Logger LOGGER = Logger.getLogger(DomXmlParser.class);
    private static final String XML_INPUT_PATH = "src/main/resources/xmlOutput.xml";

    public static List<? extends BaseModel> parseXML(Class<? extends BaseModel> classType) {
        try {
            Document document = DocumentBuilderFactory
                    .newInstance()
                    .newDocumentBuilder()
                    .parse(new File(XML_INPUT_PATH));

            document.getDocumentElement().normalize();

            List<BaseModel> models = new ArrayList<>();

            NodeList nodes = document.getElementsByTagName(classType.getName());

            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element)node;
                    Object model = Class.forName(classType.getName()).newInstance();

                }
            }
        } catch (ParserConfigurationException | SAXException | IOException |
                ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            LOGGER.error(e);
        }
        return null;
    }
}
