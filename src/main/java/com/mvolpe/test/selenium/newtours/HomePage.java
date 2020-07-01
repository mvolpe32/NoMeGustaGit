package com.mvolpe.test.selenium.newtours;

import org.openqa.selenium.WebDriver;

public class HomePage extends PageObject{
    public final PageHeader header;

    public HomePage(WebDriver driver){
        super(driver);
        header = new PageHeader(driver);
    }

}
