package com.solvd.sandinosanchez.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static com.solvd.sandinosanchez.selenium.utils.SeleniumUtils.waitUntilVisibilityOfElement;

public class BrowseProductsPage extends AbstractPage {

    @FindBy(xpath = "//a[@title='Add to cart']")
    private WebElement addToCartButton;

    @FindBy(xpath = "(//h2)[1]")
    private WebElement confirmationText;

    public BrowseProductsPage(WebDriver driver) {
        super(driver);
    }

    public void addTshirtToCart() {
        waitUntilVisibilityOfElement(driver, addToCartButton);
        addToCartButton.click();
    }

    public String getConfirmationText() {
        waitUntilVisibilityOfElement(driver, confirmationText);
        return confirmationText.getText();
    }

}
