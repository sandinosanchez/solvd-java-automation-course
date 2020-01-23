package webtesting.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static webtesting.utils.SeleniumUtils.waitUntilVisibilityOfElement;

public class LoginPage extends AbstractPage {

    @FindBy(id = "email_create")
    private WebElement emailRegister;

    @FindBy(id = "passwd")
    private WebElement password;

    @FindBy(id = "email")
    private WebElement emailLogin;

    @FindBy(id = "SubmitLogin")
    private WebElement submitLogin;

    @FindBy(id = "SubmitCreate")
    private WebElement submitRegister;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public RegistrationPage register(String email) {
        waitUntilVisibilityOfElement(driver, emailRegister);
        emailRegister.sendKeys(email);
        submitRegister.click();
        return new RegistrationPage(driver);
    }

    public HomePage login(String email, String password) {
        waitUntilVisibilityOfElement(driver, emailLogin);
        this.emailLogin.sendKeys(email);
        this.password.sendKeys(password);
        submitLogin.click();
        return new HomePage(driver);
    }
}
