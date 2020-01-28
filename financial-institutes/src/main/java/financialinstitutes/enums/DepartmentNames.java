package financialinstitutes.enums;

public enum DepartmentNames {
    HR("Human Resources"),
    MG("Management");

    private String name;

    private DepartmentNames(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
