package enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Constrains {
    COMMA(",", true),
    DOT(".", true),
    COLON(":", true),
    SEMICOLON(";", true);

    private String value;
    private boolean isActive;

    Constrains(String value, boolean isActive) {
        this.value = value;
        this.isActive = isActive;
    }

    public static String generateRegEx() {
        return String.format("[%s|%s|%s|%s]",
                COMMA.value,
                SEMICOLON.value,
                COLON.value,
                DOT.value);
    }

    public static String generateRegExIncomplete() {
        List<Constrains> outputList = new ArrayList<>();
        Arrays.asList(Constrains.values()).forEach(constrain -> {if (constrain.isActive()) outputList.add(constrain);});
        return formatRegExIncomplete(outputList);
    }

    public static String formatRegExIncomplete(List<Constrains> constrains) {
        StringBuilder formatString = new StringBuilder();
        StringBuilder stringValues = new StringBuilder();
        formatString.append("[%s");
        for (Constrains constrain: constrains) {
            formatString.append(constrain.getValue());
            formatString.append("|%s");
            stringValues.append(constrain.getValue());
        }
        formatString.append("]+");
        return String.format(String.valueOf(formatString), stringValues);
    }

    public String getValue() {
        return value;
    }

    public boolean isActive() {
        return isActive;
    }
}
