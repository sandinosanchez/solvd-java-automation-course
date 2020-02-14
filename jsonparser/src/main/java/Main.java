import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class);
    public static void main(String[] args) throws  TransformerException {
        Document doc = null;
        String filename = "name.xml";

        Source source = new DOMSource(doc);

        File file = new File(filename);
        Result result = new StreamResult(file);

        Transformer xformer = TransformerFactory.newInstance().newTransformer();
        xformer.transform(source, result);

    }
}
