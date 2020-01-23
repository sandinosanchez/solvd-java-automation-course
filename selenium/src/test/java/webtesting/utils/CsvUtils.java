package webtesting.utils;

import org.testng.log4testng.Logger;

import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;
import java.util.*;

public class CsvUtils {
    private static final Logger LOGGER = Logger.getLogger(CsvUtils.class);

    public static List<Map<String, String>> getData(String filePath) {
        List<Map<String, String>> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream(filePath)))) {
            String line = br.readLine();
            String[] titles = line.split(";");
            line = br.readLine();

            while (Objects.nonNull(line)) {
                String[] values = line.split(";");
                Map<String, String> record = new HashMap<>();
                for (int i = 0; i < values.length; i++) {
                    record.put(titles[i], values[i]);
                }
                data.add(record);
                line = br.readLine();
            }
        } catch (IOException e) {
            LOGGER.info(e.getMessage());
        }
        return data;
    }
}
