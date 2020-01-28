package financialinstitutes.models;

import financialinstitutes.exceptions.IncorrectPermissionsException;
import financialinstitutes.interfaces.Consumer;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static financialinstitutes.enums.Country.*;
import static financialinstitutes.enums.DepartmentNames.HR;
import static financialinstitutes.enums.Permissions.*;
import static financialinstitutes.enums.Reputation.GOOD;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Bank.class);

    public static List<BaseEmployee> loadEmployees(List<BaseEmployee> employees) {
        employees.add(new HumanResources("Sandino", "Sanchez", 1387566,211 ,ARG));
        employees.add(new HumanResources("Eduardo", "Lopez", 37458977, 224, ARG));
        employees.add(new Manager("Jose", "Perez", 36525699, 221, ARG));
        employees.add(new HumanResources("Lucia", "Lopez", 5698547, 226, ARG));

        return employees;
    }

    public static List<Client> loadClients(List<Client> clients) {
        clients.add(new Client("Jose", "Lopez", 1238455, ARG, 158500.50));
        clients.add(new Client("Jose", "Perez", 1099988, ARG, 10000.00));
        clients.add(new Client("Edgardo", "Gomez", 123498766, ENG, 1569.33));
        clients.add(new Client("Sabrina", "Wick", 8798766, RU, 120.33));

        return clients;
    }

    public static List<Department> loadDepartments(List<Department> departments, List<BaseEmployee> employees) {
        departments.add(new Department(HR, employees));
        return departments;
    }

    public static Bank loadBank() {
        return new Bank(loadDepartments(new ArrayList<>(), loadEmployees(new ArrayList<>())), loadClients(new ArrayList<>()));
    }

//    public static Consumer<BaseEmployee> wrapperClientConstrains(Consumer<BaseEmployee> consumer) {
//        return c -> {
//            try {
//                consumer.supply(c);
//            } catch (IncorrectPermissionsException ex) {
//                LOGGER.info(ex.getMessage());
//            }
//        }
//    }

    public static void main(String[] args) {
        Bank bank = loadBank();

        bank.addPermissions(bank.getEmployees(), e -> {
            if (e instanceof HumanResources)
                e.permissions.add(CREATE_CREDIT);
            else if (e instanceof Manager){
                e.permissions.add(MODIFY_CREDIT);
                e.permissions.add(DELETE_CREDIT);
            }
        });

        bank.addCredits(bank.getClients(), c -> {
            try {
                bank.generateCredit(bank.getEmployee(), c);
            } catch (IncorrectPermissionsException e) {
                e.printStackTrace();
            }
        });

//        bank.addCredits(bank.getClients(), wrapperClientConstrains(c-> bank.generateCredit(bank.getEmployee(), c)));

        bank.getClients().stream()
                .distinct()
                .filter(c -> GOOD.equals(c.getReputation()))
                .filter(c -> !c.getCredits().isEmpty())
                .forEach(LOGGER::info);

        Map<Integer, Client> clientMap =  bank.getClients().stream()
                .distinct()
                .filter(c -> c.getIncome() > 1000)
                .filter((c -> ARG.equals(c.getCountry())))
                .collect(Collectors.toMap(Client::getIdNumber, c -> c));

        clientMap.entrySet().forEach(LOGGER::info);

        bank.getDepartment().getEmployees().stream()
                .distinct()
                .filter(e -> e.getFirstName().startsWith(("s").toUpperCase()))
                .filter(e -> e.getLastName().endsWith(("z").toLowerCase()))
                .forEach(LOGGER::info);

        Map<Integer, BaseEmployee> emp =  bank.getDepartment().getEmployees().stream()
                .distinct()
                .collect(Collectors.toMap(BaseEmployee::getIdCompanyNumber, e -> e));

        emp.entrySet().forEach(LOGGER::info);

    }
}

