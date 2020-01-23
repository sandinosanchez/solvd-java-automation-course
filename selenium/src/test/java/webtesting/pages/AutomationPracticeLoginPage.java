package webtesting.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AutomationPracticeLoginPage extends AbstractPage {

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

    public AutomationPracticeLoginPage(WebDriver driver) {
        super(driver);
    }

    public AutomationPracticeRegistrationPage register(String email) {
        emailRegister.sendKeys(email);
        submitRegister.click();
        return new AutomationPracticeRegistrationPage(driver);
    }

    public void login(String email, String password) {
        this.emailLogin.sendKeys(email);
        this.password.sendKeys(password);
        submitLogin.click();
    }
}
