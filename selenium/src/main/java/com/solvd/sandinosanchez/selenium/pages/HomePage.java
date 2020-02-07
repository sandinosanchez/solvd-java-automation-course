package com.solvd.sandinosanchez.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static com.solvd.sandinosanchez.selenium.utils.SeleniumUtils.waitUntilVisibilityOfElement;

public class HomePage extends AbstractPage {

    @FindBy(css = ".page-heading")
    private WebElement subTitle;

    @FindBy(xpath = "(//a[@title='T-shirts'])[2]")
    private WebElement tShirtsButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getSubTitle() {
        return subTitle.getText();
    }

    public BrowseProductsPage tShirtSearch() {
        waitUntilVisibilityOfElement(driver, tShirtsButton);
        tShirtsButton.click();
        return new BrowseProductsPage(driver);
    }

}
