package financialinstitutes.models;



import financialinstitutes.enums.Country;
import financialinstitutes.enums.Permissions;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseEmployee extends Person {
    private int idCompanyNumber;
    protected List<Permissions> permissions;

    public BaseEmployee() {}

    public BaseEmployee(String firstName, String lastName, int idNumber, int idCompanyNumber, Country country) {
        super(firstName, lastName, idNumber, country);
        this.idCompanyNumber = idCompanyNumber;
        this.permissions = new ArrayList<>();
    }

    public int getIdCompanyNumber() {
        return idCompanyNumber;
    }

    public void setIdCompanyNumber(int idCompanyNumber) {
        this.idCompanyNumber = idCompanyNumber;
    }

    public List<Permissions> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permissions> permissions) {
        this.permissions = permissions;
    }
}
