package financialinstitutes.enums;

public enum Reputation {
    GOOD("GOOD"),
    MEDIUM("MEDIUM"),
    BAD("BAD");

    private String value;

    private Reputation(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
