import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.time.LocalDateTime;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class);
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            InputStream is = new FileInputStream("src/main/resources/JsonInput.json");
            User user = objectMapper.enable(SerializationFeature.INDENT_OUTPUT).readValue(is, User.class);
            LOGGER.info(user.toString());
        } catch (IOException e) {
            LOGGER.info(e.getMessage());
        }
    }
}
