package com.solvd.sandinosanchez.selenium.pages;

import org.openqa.selenium.WebDriver;
import static org.openqa.selenium.support.PageFactory.initElements;

public class AbstractPage {
    protected WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        initElements(driver, this);
    }

    public AbstractPage(){}
}
