package com.mvolpe.test.selenium.newtours;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    public static WebDriver get(String browser) {
        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
            return new ChromeDriver();
        } else {
            throw new RuntimeException("Invalid Driver " + browser);
        }
    }
}