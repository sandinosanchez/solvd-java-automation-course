package financialinstitutes.models;

import financialinstitutes.enums.Country;
import financialinstitutes.interfaces.IWork;

import java.util.ArrayList;
import java.util.List;

public class Manager extends BaseEmployee implements IWork {
    private List<HumanResources> subordinates;

    public Manager(String firstName, String lastName, int idNumber, int idCompanyNumber, Country country) {
        super(firstName, lastName, idNumber, idCompanyNumber, country);
        this.permissions = new ArrayList<>();
        this.subordinates = new ArrayList<>();
    }

    public List<HumanResources> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(List<HumanResources> subordinates) {
        this.subordinates = subordinates;
    }

    @Override
    public void work(Client client) {
        System.out.println("Working from the Manager class with: " + client.getFirstName());
    }

    @Override
    public String toString() {
        return "Manager{" +
                "subordinates=" + subordinates +
                ", permissions=" + permissions +
                ", country=" + country +
                '}';
    }
}

