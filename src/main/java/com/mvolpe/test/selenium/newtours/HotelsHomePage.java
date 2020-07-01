package com.mvolpe.test.selenium.newtours;

import org.openqa.selenium.WebDriver;

public class HotelsHomePage extends PageObject{

    public final HotelsSearchForm searchForm;

public HotelsHomePage(WebDriver driver){
        super(driver);
        searchForm = new HotelsSearchForm(driver);
    }
}
