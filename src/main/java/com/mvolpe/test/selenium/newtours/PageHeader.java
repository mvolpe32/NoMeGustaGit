package com.mvolpe.test.selenium.newtours;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageHeader extends PageObject{
    @FindBy(css = ".FLIGHTS")
    private WebElement flightsTab;
    @FindBy(css = ".HOTELS")
    private WebElement hotelsTab;

    public PageHeader(WebDriver driver) {
        super(driver);
    }

    public PageObject selectTab(String tab){
        switch(tab){
            case "flights":
                flightsTab.click();
                return new FlightsHomePage(driver);
            case "hotels":
                hotelsTab.click();
                return new HotelsHomePage(driver);
            default: return new FlightsHomePage(driver);
        }


        /*if (tab.equals("flights")){
            flightsTab.click();
            return new FlightsHomePage(driver);
        }else{
            return new HotelsHomePage(driver);
        }*/
    }
}
