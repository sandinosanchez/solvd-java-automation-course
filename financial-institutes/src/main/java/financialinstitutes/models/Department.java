package financialinstitutes.models;



import financialinstitutes.enums.DepartmentNames;

import java.util.List;

public class Department {
    private DepartmentNames name;
    private List<BaseEmployee> employees;
    private BaseEmployee director;

    public Department() {}

    public Department(DepartmentNames name, List<BaseEmployee> employees, BaseEmployee director) {
        this.name = name;
        this.employees = employees;
        this.director = director;
    }

    public Department(DepartmentNames name, List<BaseEmployee> employees) {
        this.name = name;
        this.employees = employees;
    }

    public DepartmentNames getName() { return name; }

    public void setName(DepartmentNames name) { this.name = name; }

    public List<BaseEmployee> getEmployees() { return employees; }

    public void setEmployees(List<BaseEmployee> employees) { this.employees = employees; }

    public BaseEmployee getDirector() { return director; }

    public void setDirector(BaseEmployee director) { this.director = director; }

}
