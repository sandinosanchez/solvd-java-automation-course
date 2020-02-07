package com.solvd.sandinosanchez.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import com.solvd.sandinosanchez.selenium.dao.AnonymousUserDao;
import static com.solvd.sandinosanchez.selenium.utils.SeleniumUtils.waitUntilVisibilityOfElement;

import java.util.*;


public class RegistrationPage extends AbstractPage {

    @FindBy(xpath = "//input[@id='id_gender1']")
    private WebElement gender;

    @FindBy(xpath = "//input[@id='customer_firstname']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@id='customer_lastname']")
    private WebElement lastName;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement email;

    @FindBy(css = "input[data-validate=isPasswd]")
    private WebElement password;

    @FindBy(css = "select[id=days]")
    private WebElement days;

    @FindBy(xpath = "//select[@id='months']")
    private WebElement months;

    @FindBy(xpath = "//select[@id='years']")
    private WebElement years;

    @FindBy(xpath = "//input[@id='firstname']")
    private WebElement userFirstName;

    @FindBy(xpath = "//input[@id='lastname']")
    private WebElement userLastName;

    @FindBy(xpath = "//input[@id='address1']")
    private WebElement address;

    @FindBy(xpath = "//input[@id='city']")
    private WebElement city;

    @FindBy(id = "id_state")
    private WebElement state;

    @FindBy(id = "postcode")
    private WebElement zipCode;

    @FindBy(id = "id_country")
    private WebElement country;

    @FindBy(id = "phone_mobile")
    private WebElement phoneMobile;

    @FindBy(id = "alias")
    private WebElement alias;

    @FindBy(id = "submitAccount")
    private WebElement submit;

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    private static Select getSelectObject(WebElement element) {
        return new Select(element);
    }

    private  Map<String, WebElement> initializeMapOfElements(AnonymousUserDao user) {
        return new HashMap<String, WebElement>(){{
            put(user.getFirstName(), firstName);
            put(user.getLastName(), lastName);
            put(user.getPassword(), password);
            put(user.getFirstName(), userFirstName);
            put(user.getLastName(), userLastName);
            put(user.getAddress(), address);
            put(user.getCity(), city);
            put(user.getAlias(), alias);
        }};
    }

    private Map<String, Select> initializeMapOfSelectByValue(AnonymousUserDao user) {
        return new HashMap<String, Select>(){{
            put(user.getDays(), new Select(days));
            put(user.getYears(), new Select(years));
        }};
    }

    private Map<String, Select> initializeMapOfSelectByVisibleText(AnonymousUserDao user) {
        return new HashMap<String, Select>(){{
            put(user.getMonths(), new Select(months));
            put(user.getCountry(), new Select(country));
        }};
    }

    private void loadData(AnonymousUserDao user) {
        Map<String, WebElement> elements = initializeMapOfElements(user);
        Map<String, Select> selectByValue = initializeMapOfSelectByValue(user);
        Map<String, Select> selectByVisibleText = initializeMapOfSelectByVisibleText(user);

        selectByValue.forEach((value, select) -> select.selectByValue(value));
        selectByVisibleText.forEach((value, select) -> select.selectByVisibleText(value));
        elements.forEach((k,v) -> v.sendKeys(k));

        gender.click();
    }

    public HomePage register(AnonymousUserDao user) {
        waitUntilVisibilityOfElement(driver, gender);
        loadData(user);
        submit.click();
        return new HomePage(driver);
    }

}
