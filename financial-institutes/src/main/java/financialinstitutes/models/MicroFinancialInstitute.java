package financialinstitutes.models;


import financialinstitutes.enums.Country;
import financialinstitutes.enums.CreditRestrictions;
import financialinstitutes.enums.CreditState;
import financialinstitutes.exceptions.IncorrectPermissionsException;

import java.util.List;

public class MicroFinancialInstitute extends FinancialInstitute{

    public MicroFinancialInstitute(String name, String address, Country country, List<Department> employees, BaseEmployee ceo, CreditRestrictions creditRestriction) {
        super(name, address, country, employees, ceo, creditRestriction);
    }

    @Override
    public void generateCredit(BaseEmployee employee, Client client) throws IncorrectPermissionsException {
        System.out.println("Generating credit from MicroFinancial Institute");
    }

    @Override
    public void modifyCredit(BaseEmployee employee, Credit credit, CreditState state) throws IncorrectPermissionsException {
        System.out.println("Modifying credit from MicroFinancial Institute");
    }

    @Override
    public void updateCreditState(Credit credit) {
        System.out.println("Updating credit from MicroFinancial Institute");
    }

    @Override
    public void addClient(Client client) {

    }
}
