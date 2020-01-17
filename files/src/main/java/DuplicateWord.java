import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

import static enums.EncodingType.UTF8;
import static enums.FilePath.INPUT;
import static enums.FilePath.OUTPUT;
import static enums.Constrains.generateRegEx;

public class DuplicateWord {
    private static final Logger LOGGER = Logger.getLogger(DuplicateWord.class);

    public static File openFile(String path) {
        return new File(path);
    }

    public static String filterLineBreak(String input) {
        return input.replaceAll("\\n", " ");
    }

    public static String filterConstrains(String input) {
        return filterLineBreak(input)
                .toLowerCase()
                .replaceAll(generateRegEx(), "");
    }

    public static String[] fileContentToArrayString(File file, String encoding) throws IOException {
        return filterConstrains(FileUtils.readFileToString(file, encoding)).split(" ");
    }

    public static Map<String, Integer> countDuplicateWords(String[] stringIterable, Map<String, Integer> duplicateWords) {
//        stringIterable.forEach(s -> {
//            if (duplicateWords.containsKey(s)) duplicateWords.put(s, duplicateWords.get(s) + 1);
//            duplicateWords.put(s, 1);
//        });

        for (String word: stringIterable) {
            if (duplicateWords.containsKey(word)) duplicateWords.put(word, duplicateWords.get(word) + 1);
            duplicateWords.put(word, 1);
        }
        return duplicateWords;
    }

    public static String generateOutputString(String key, Integer value) {
        return String.format("%s: %x; ", key, value);
    }

    public static void writeStringToFile(Map<String, Integer> data, File outputFile) {
        data.forEach((k, v) -> {
            try {
                FileUtils.writeStringToFile(outputFile, generateOutputString(k, v), "utf-8", true);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        });
    }

    public static void main(String[] args) {
        try {
            File fileWithDuplicatedWords = openFile(INPUT.contentRootPath);
            writeStringToFile(countDuplicateWords(
                    fileContentToArrayString(fileWithDuplicatedWords, UTF8.encodingType),
                    new HashMap<>()),
                    new File(OUTPUT.contentRootPath));
        } catch (IOException e) {
            LOGGER.info(e.getMessage());
        }
    }
}
