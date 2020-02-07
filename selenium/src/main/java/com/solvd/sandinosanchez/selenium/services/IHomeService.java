package com.solvd.sandinosanchez.selenium.services;

import com.solvd.sandinosanchez.selenium.pages.HomePage;
import com.solvd.sandinosanchez.selenium.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public interface IHomeService {
    default HomePage login(WebDriver driver, String email, String password) {
        return new LoginPage(driver).login(email, password);
    }
}
