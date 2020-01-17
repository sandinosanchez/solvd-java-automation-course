package financialinstitutes.enums;

public enum CreditRestrictions {
    MIN_DOLLARS(5600, "DOLLARS"),
    MEDIUM_DOLLARS(7500, "DOLLARS");

    private int value;
    private String currencyType;

    private CreditRestrictions(int value, String currencyType) {
        this.value = value;
        this.currencyType = currencyType;
    }

    public int getValue() {
        return value;
    }

    public String getCurrencyType() {
        return currencyType;
    }
}
