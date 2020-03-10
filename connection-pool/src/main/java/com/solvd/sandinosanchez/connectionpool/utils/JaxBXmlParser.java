package com.solvd.sandinosanchez.connectionpool.utils;

import com.solvd.sandinosanchez.connectionpool.models.BaseModel;
import com.solvd.sandinosanchez.connectionpool.models.User;
import org.apache.log4j.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

public class JaxBXmlParser {
    private static final Logger LOGGER = Logger.getLogger(JaxBXmlParser.class);
    private static final String PATH_TO_XML_OUTPUT = "src/main/resources/xmlOutput.xml";
    private static final String PATH_TO_XML_INPUT = "src/main/resources/xmlInput.xml";

    public static void serialize(JaxBList<? extends BaseModel> models, Class<? extends BaseModel> classType) {
        try {
            Marshaller marshaller = JAXBContext.newInstance(classType).createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(models, new File(PATH_TO_XML_OUTPUT));
        } catch (JAXBException e) {
            LOGGER.error(e);
        }
    }

    public static <T>Object deSerialize(Class<T> classType) {
        try {
            Unmarshaller unmarshaller = JAXBContext
                    .newInstance(classType)
                    .createUnmarshaller();
            return classType.cast(unmarshaller.unmarshal(new FileInputStream(PATH_TO_XML_OUTPUT)));
        } catch (JAXBException | FileNotFoundException e) {
            LOGGER.error(e);
        }
        return null;
    }
}
