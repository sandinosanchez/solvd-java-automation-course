package com.solvd.sandinosanchez.selenium.webtesting.enums;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public enum Driver {

    CHROME {
        @Override
        public WebDriver build() {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions().setHeadless(true);
            return new ChromeDriver(options);
        }
    },
    FIREFOX {
        @Override
        public WebDriver build() {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions().setHeadless(true);
            return new FirefoxDriver(options);
        }
    };

    public abstract WebDriver build();
}
