package com.mvolpe.test.selenium.newtours;

import org.openqa.selenium.WebDriver;

public class FlightsPage {
    public final FlightsSearchForm searchForm;
    private WebDriver driver;
    public FlightsPage (WebDriver driver) {
        this.driver = driver;
        searchForm = new FlightsSearchForm(driver);
    }

}
