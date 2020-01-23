package webtesting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import webtesting.enums.Driver;

import java.util.Objects;

public abstract class AbstractUiTest {
    private WebDriver driver;

    @BeforeMethod
    @Parameters(value = "browser")
    public void initializeBrowser(@Optional(value = "CHROME") String browser) {
        driver = Driver.valueOf(browser).build();
        driver.get(getBaseUrl());
    }

    @AfterMethod
    public void closeBrowser() { if (Objects.nonNull(driver)) driver.quit(); }

    protected abstract String getBaseUrl();

    protected WebDriver getDriver() {
        return driver;
    }
}
