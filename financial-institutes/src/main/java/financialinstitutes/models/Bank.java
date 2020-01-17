package financialinstitutes.models;

import financialinstitutes.enums.Country;
import financialinstitutes.enums.CreditRestrictions;
import financialinstitutes.enums.CreditState;
import financialinstitutes.enums.Reputation;
import financialinstitutes.exceptions.ClientNotFoundException;
import financialinstitutes.exceptions.IncorrectPermissionsException;

import financialinstitutes.interfaces.BiConsumer;
import financialinstitutes.interfaces.Consumer;
import financialinstitutes.interfaces.Predicate;
import org.apache.log4j.Logger;
import java.util.List;
import java.util.Objects;

import static financialinstitutes.enums.CreditRestrictions.MEDIUM_DOLLARS;
import static financialinstitutes.enums.CreditRestrictions.MIN_DOLLARS;
import static financialinstitutes.enums.CreditState.*;
import static financialinstitutes.enums.Permissions.CREATE_CREDIT;
import static financialinstitutes.enums.Permissions.MODIFY_CREDIT;
import static financialinstitutes.enums.Reputation.*;
import static java.time.LocalDateTime.now;

public class Bank extends FinancialInstitute {
    private static final Logger LOGGER = Logger.getLogger(Bank.class);

    public Bank(String name, String address, Country country,
                List<Department> departments, BaseEmployee ceo,
                CreditRestrictions creditRestrictions) {
        super(name, address, country, departments, ceo, creditRestrictions);
    }

    public Bank(String name, String address, Country country,
                List<Department> employees) {
        super(name, address, country, employees);
    }

    public Bank(List<Department> departments, List<Client> clients) {
        super(departments, clients);

    }

    public void addPermissions(List<BaseEmployee> employees, Consumer<BaseEmployee> consumer) {
        employees.forEach(consumer::supply);
    }

    public void addCredits(List<Client> clients, Consumer<Client> consumer) {
        clients.forEach(consumer::supply);
    }

    public boolean checkConstrainsEmployee(Predicate<BaseEmployee> predicate, BaseEmployee employee) {
        return predicate.test(employee);
    }

    public boolean checkConstrainsClient(Predicate<Client> predicate, Client client) {
        return predicate.test(client);
    }

    public boolean checkConstrainsClient(Predicate<Client> p1, Predicate<Client> p2, Client client) {
        return p1.test(client) && p2.test(client);
    }

//    public Predicate<BaseEmployee> wrapperCheckConstrainsEmployee(Predicate<BaseEmployee> predicate) {
//        return e -> {
//            try {
//                predicate.test(e);
//            } catch (IncorrectPermissionsException ex) {
//                LOGGER.info(ex.getMessage());
//            }
//        };
//    }

    @Override
    public void generateCredit(BaseEmployee employee, Client client) throws IncorrectPermissionsException {
        boolean constrainsEmployee = checkConstrainsEmployee(e -> e.getPermissions().contains(CREATE_CREDIT), employee);
        boolean constrainsClient = checkConstrainsClient(
                c -> GOOD.equals(c.getReputation()),
                c -> dollarAmount(c.getIncome(), c.getCountry()) >= MIN_DOLLARS.getValue(),
                client);

        if (constrainsClient && constrainsEmployee) {
            client.addCredit(new Credit(client, employee, client.getIncome() * 3));
        } else if (!constrainsEmployee) {
            throw new IncorrectPermissionsException();
        }
    }


    @Override
    public void modifyCredit(BaseEmployee employee, Credit credit, CreditState creditState) throws IncorrectPermissionsException {
        if (employee.permissions.contains(MODIFY_CREDIT)) {
            if (BAD.equals(credit.getClient().getReputation())) {
                credit.setState(creditState);
            }
        } else {
            throw new IncorrectPermissionsException();
        }
    }

    @Override
    public void updateCreditState(Credit credit) {
        if (BAD.equals(credit.getClient().getReputation()) && ACTIVE.equals(credit.getState())) {
            credit.setState(BLOCKED);
        } else if (credit.getSecondDueDate().isBefore(now())) {
            credit.setState(FINISHED);
        }
    }

    @Override
    public void addClient(Client client) {
        clients.add(client);
    }

    public Department getDepartment() {
        return this.getDepartments().get(0);
    }

    public List<BaseEmployee> getEmployees() {
        return this.getDepartment().getEmployees();
    }

    public BaseEmployee getEmployee() {
        return this.getDepartment().getEmployees().get(0);
    }

}
