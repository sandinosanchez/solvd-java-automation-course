package webtesting.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import webtesting.dao.AnonymousUser;

public class AutomationPracticeRegistrationPage extends AbstractPage {

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


    public AutomationPracticeRegistrationPage(WebDriver driver) {
        super(driver);
    }


    public void register(AnonymousUser user) throws InterruptedException {
        Thread.sleep(5000);
        firstName.sendKeys(user.getFirstName());
        lastName.sendKeys(user.getLastName());
        email.sendKeys(user.getEmail());
        Select days = new Select(this.days);
        Select months = new Select(this.months);
        Select years = new Select(this.years);
        password.sendKeys(user.getPassword());
        days.selectByValue(user.getDays());
        months.selectByVisibleText(user.getMonths());
        years.selectByValue(user.getYears());
        userFirstName.sendKeys(user.getFirstName());
        userLastName.sendKeys(user.getLastName());
        address.sendKeys(user.getAddress());
        city.sendKeys(user.getCity());
        Select state = new Select(this.state);
        Select country = new Select(this.country);
        state.selectByVisibleText(user.getState());
        zipCode.sendKeys(user.getZipCode());
        country.selectByVisibleText(user.getCountry());
        phoneMobile.sendKeys(user.getPhoneMobile());
        alias.sendKeys(user.getAddress());
        gender.click();
        submit.click();


    }

}
