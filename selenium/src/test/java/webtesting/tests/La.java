package webtesting.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import webtesting.AbstractUiTest;
import webtesting.dao.AnonymousUser;
import webtesting.pages.AutomationPracticeLoginPage;
import webtesting.pages.AutomationPracticeRegistrationPage;
import webtesting.utils.CsvUtils;

import java.util.List;
import java.util.Map;

import static webtesting.utils.CsvUtils.getData;


public class La extends AbstractUiTest {

    @Override
    protected String getBaseUrl() {
        return "http://automationpractice.com/index.php?controller=authentication&back=my-account";
    }

    @DataProvider(name = "AnonymousUsers")
    public Object[] AnonymousUsers() {
        List<Map<String, String>> rawData = CsvUtils.getData("clientes.csv");
        int index = 0;
        Object[] result = new Object[rawData.size()];
        for (Map<String, String> record: rawData) {
            AnonymousUser user = new AnonymousUser();
            user.setFirstName(record.get("firstName"));
            user.setLastName(record.get("lastName"));
            user.setPassword(record.get("password"));
            user.setAddress(record.get("address"));
            user.setAlias(record.get("alias"));
            user.setCity(record.get("city"));
            user.setDays(record.get("days"));
            user.setMonths(record.get("months"));
            user.setYears(record.get("years"));
            user.setEmail(record.get("email"));
            user.setCountry(record.get("country"));
            user.setZipCode(record.get("zipCode"));
            user.setPhoneMobile(record.get("phoneMobile"));
            user.setState(record.get("state"));
            result[index++] = user;
        }
        return result;
    }

    @Test(dataProvider = "AnonymousUsers")
    public void t(AnonymousUser user) throws InterruptedException {
        AutomationPracticeRegistrationPage register = new AutomationPracticeLoginPage(getDriver())
                .register("sadll@gmail.com");
        register.register(user);
    }
}
