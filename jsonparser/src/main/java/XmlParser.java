import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class XmlParser {
    private static final Logger LOGGER = Logger.getLogger(XmlParser.class);
    private static XmlMapper mapper = new XmlMapper();
    private static final String PATH_TO_XML_OUTPUT = "src/main/resources/xmlOutput.xml";
    private static final String PATH_TO_XML_INPUT = "src/main/resources/xmlInput.xml";

    public static void serialize(List<User> modelToSerialize) {
        try(FileWriter xmlOutputFile = new FileWriter(PATH_TO_XML_OUTPUT)) {
            mapper.writeValue(xmlOutputFile, modelToSerialize);
        } catch (IOException e) {
            LOGGER.error(e);
        }
    }

    public static List<User> deSerialize(Class<User> classType) {
        try (InputStream is = new FileInputStream(PATH_TO_XML_INPUT)){
            return mapper.readValue(is, mapper.getTypeFactory().constructCollectionType(List.class, classType));
        } catch (IOException e) {
            LOGGER.error(e);
        }
        return null;
    }
}
