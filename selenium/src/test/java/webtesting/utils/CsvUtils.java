package webtesting.utils;

import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;
import java.util.*;

public class CsvUtils {

    public static List<Map<String, String>> getData(String filePath) {
        List<Map<String, String>> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream(filePath)))) {
            String line = br.readLine();
            String[] titles = line.split(";");
            line = br.readLine();

            while (Objects.nonNull(line)) {
                String[] values = line.split(";");
                Map<String, String> record = new HashMap<>();
                //Arrays.stream(values).forEach(l -> record.put(titles[1], l));
                for (int i = 0; i < values.length; i++) {
                    record.put(titles[i], values[i]);
                }
                data.add(record);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
