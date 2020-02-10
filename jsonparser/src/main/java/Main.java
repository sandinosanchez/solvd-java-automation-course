import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class);
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        try (InputStream is = new FileInputStream("src/main/resources/JsonInput.json")){
            List<User> user = mapper.readValue(is, mapper.getTypeFactory().constructCollectionType(List.class, User.class));
            String indented = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);
            LOGGER.info(indented);
        } catch (IOException e) {
            LOGGER.info(e.getMessage());
        }
    }
}
