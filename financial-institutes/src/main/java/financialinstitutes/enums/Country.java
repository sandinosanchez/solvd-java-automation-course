package financialinstitutes.enums;

public enum Country {
    ARG("Argentina"),
    USA("Unites States of America"),
    RU("Russia"),
    ENG("England");

    private String name;

    private Country(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
