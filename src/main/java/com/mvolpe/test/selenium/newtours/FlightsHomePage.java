package com.mvolpe.test.selenium.newtours;

import org.openqa.selenium.WebDriver;

public class FlightsHomePage extends PageObject {

    public final FlightsSearchForm searchForm;

    public FlightsHomePage(WebDriver driver) {
        super(driver);
        searchForm = new FlightsSearchForm(driver);
    }
}
