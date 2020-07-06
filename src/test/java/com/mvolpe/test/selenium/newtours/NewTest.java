package com.mvolpe.test.selenium.newtours;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.YearMonth;

public class NewTest {

    private WebDriver driver;
    @Before
    public void setUp() {
        driver = DriverFactory.get("chrome");
        driver.get("http://www.despegar.com.ar/");
        driver.manage().window().maximize();
    }

    @Test
    public void test1() throws InterruptedException {


        HomePage homePage = new HomePage(driver);
        FlightsHomePage flightsHome = (FlightsHomePage)homePage.header.selectTab("flights");
        //HotelsHomePage hotelsHome = (HotelsHomePage)homePage.header.selectTab("hotels");
        flightsHome.searchForm.cargaCiudad("origen","Brasil","Brasilia, Distrito Federal, Brasil");
        flightsHome.searchForm.cargaCiudad("destino","Londres","Londres, Inglaterra, Reino Unido");
        Thread.sleep(2000);

        //FECHAS - CALENDARIO
        flightsHome.searchForm.cargaFecha("2020-10","16","2020-11","20");
        Thread.sleep(2000);
        flightsHome.searchForm.adultosMenores();
        Thread.sleep(2000);

    }

    @After
    public void tearDown() throws InterruptedException {
        driver.close();
    }
}
