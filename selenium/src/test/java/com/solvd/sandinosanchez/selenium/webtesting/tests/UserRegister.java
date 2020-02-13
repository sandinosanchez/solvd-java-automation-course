package com.solvd.sandinosanchez.selenium.webtesting.tests;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.solvd.sandinosanchez.selenium.webtesting.AbstractUiTest;
import com.solvd.sandinosanchez.selenium.dao.AnonymousUserDao;
import com.solvd.sandinosanchez.selenium.pages.HomePage;
import com.solvd.sandinosanchez.selenium.pages.LoginPage;
import com.solvd.sandinosanchez.selenium.utils.CsvUtils;

import java.util.List;
import java.util.Map;


public class UserRegister extends AbstractUiTest {

    @Override
    protected String getBaseUrl() {
        return "http://automationpractice.com/index.php?controller=authentication&back=my-account";
    }

    @DataProvider(name = "AnonymousUsers")
    public Object[] AnonymousUsers() {
        List<Map<String, String>> rawData = CsvUtils.getData("user-info.csv");
        int index = 0;
        Object[] result = new Object[rawData.size()];
        for (Map<String, String> record: rawData) {
            AnonymousUserDao user = new AnonymousUserDao();
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
    public void registerAccount(AnonymousUserDao user) throws InterruptedException {
        HomePage homePage = new LoginPage(getDriver())
                .register("llllkkkkk@gmail.com").register(user);

        assertEquals(homePage.getSubTitle(), "CREATE AN ACCOUNT");
    }
}
