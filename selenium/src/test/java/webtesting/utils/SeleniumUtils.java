package webtesting.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtils {
    public static boolean waitUntilVisibilityOfElement(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        return wait
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.visibilityOf(element)) != null;
    }

    public static WebElement waitUntilVisibilityOfElement(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        return wait
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
