package financialinstitutes.models;


import financialinstitutes.enums.Country;
import financialinstitutes.interfaces.IWork;

public class HumanResources extends BaseEmployee implements IWork {
    private int idCompanyNumber;

    public HumanResources(String firstName, String lastName, int idNumber, int idCompanyNumber, Country country) {
        super(firstName, lastName, idNumber, idCompanyNumber, country);
        this.idCompanyNumber = idCompanyNumber;
    }

    public int getIdCompanyNumber() {
        return idCompanyNumber;
    }

    public void setIdCompanyNumber(int idCompanyNumber) {
        this.idCompanyNumber = idCompanyNumber;
    }

    @Override
    public void work(Client client) {
        System.out.println("Working from the HR department, with; " + client.getFirstName());
    }

    @Override
    public String toString() {
        return "HumanResources{" +
                "idCompanyNumber=" + idCompanyNumber +
                ", permissions=" + permissions +
                ", country=" + country +
                '}';
    }
}
