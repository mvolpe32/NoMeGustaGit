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

        Thread.sleep(2000);

        HomePage homePage = new HomePage(driver);
        FlightsHomePage vuelosHome = homePage.header.selectTab("flights");

        vuelosHome.searchForm.cargaCiudad("origen","Brasil","Brasilia, Distrito Federal, Brasil");
        vuelosHome.searchForm.cargaCiudad("destino","Londres","Londres, Inglaterra, Reino Unido");
        Thread.sleep(3000);

        //FECHAS - CALENDARIO

        vuelosHome.searchForm.adultosMenores();
        Thread.sleep(2000);

    }

    @After
    public void tearDown() throws InterruptedException {
        driver.close();
    }
}