package webtesting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.Objects;

public abstract class AbstractUiTest {
    private WebDriver driver;

    @BeforeMethod
    public void initializeBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        driver = new ChromeDriver(options);
        driver.get(getBaseUrl());
    }

    @AfterMethod
    public void closeBrowser() { if (Objects.nonNull(driver)) driver.quit(); }

    protected abstract String getBaseUrl();

    protected WebDriver getDriver() {
        return driver;
    }
}
