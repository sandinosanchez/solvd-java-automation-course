package financialinstitutes.models;

import static financialinstitutes.enums.DollarExchangeRate.ARG_RATE;
import static financialinstitutes.enums.DollarExchangeRate.RU_RATE;

import financialinstitutes.enums.Country;
import financialinstitutes.enums.CreditRestrictions;
import financialinstitutes.enums.CreditState;
import financialinstitutes.exceptions.ClientNotFoundException;
import financialinstitutes.exceptions.IncorrectPermissionsException;

import org.apache.log4j.Logger;
import java.util.ArrayList;
import java.util.List;

public abstract class FinancialInstitute {
    private static final Logger Log = Logger.getLogger(FinancialInstitute.class);

    private String name;
    private String address;
    private Country county;
    private BaseEmployee ceo;
    private List<Department> departments;
    private CreditRestrictions creditRestriction;
    protected List<Client> clients;

    public FinancialInstitute(List<Department> departments, List<Client> clients) {
        this.departments = departments;
        this.clients = clients;
    }

    public FinancialInstitute(String name, String address, Country country,
                              List<Department> employees, BaseEmployee ceo,
                              CreditRestrictions creditRestriction) {
        this.name = name;
        this.address = address;
        this.county = country;
        this.departments = employees;
        this.ceo = ceo;
        this.creditRestriction = creditRestriction;
        this.clients = new ArrayList<>();
    }

    public FinancialInstitute(String name, String address, Country country,
                              List<Department> employees,
                              CreditRestrictions creditRestriction) {
        this.name = name;
        this.address = address;
        this.county = country;
        this.departments = employees;
        this.creditRestriction = creditRestriction;
    }

    public FinancialInstitute(String name, String address, Country country,
                              List<Department> employees) {
        this.name = name;
        this.address = address;
        this.county = country;
        this.departments = employees;
        this.clients = new ArrayList<>();
    }

    public abstract void generateCredit(BaseEmployee employee, Client client) throws IncorrectPermissionsException, ClientNotFoundException, IncorrectPermissionsException, ClientNotFoundException;

    public abstract void modifyCredit(BaseEmployee employee, Credit credit, CreditState state) throws IncorrectPermissionsException;

    public abstract void updateCreditState(Credit credit);

    public abstract void addClient(Client client);

    public Client getClient(Client client) {
        return clients.contains(client) ? client : null;
    }

    public double dollarAmount(double amount, Country country) {
        double returnAmount = 0;
        switch (country) {
            case ARG:
                returnAmount = amount * ARG_RATE.getRate();
                break;
            case RU:
                returnAmount = amount * RU_RATE.getRate();
        }
        return returnAmount;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public Country getCounty() { return county; }

    public void setCounty(Country county) { this.county = county; }

    public List<Department> getDepartments() { return departments; }

    public void setDepartments(List<Department> departments) { this.departments = departments; }

    public BaseEmployee getCeo() { return ceo; }

    public void setCeo(BaseEmployee ceo) { this.ceo = ceo; }

    public CreditRestrictions getCreditRestriction() {
        return creditRestriction;
    }

    public void setCreditRestriction(CreditRestrictions creditRestriction) {
        this.creditRestriction = creditRestriction;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}

