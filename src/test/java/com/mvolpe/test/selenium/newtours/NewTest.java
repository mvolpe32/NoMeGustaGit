package com.mvolpe.test.selenium.newtours;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sonatype.inject.Parameters;

import java.text.ParseException;
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

    public void test1() throws InterruptedException, ParseException {

        HomePage homePage = new HomePage(driver);
        //SELECCIONO TAB
        FlightsHomePage flightsHome = (FlightsHomePage)homePage.header.selectTab("flights");
        //HotelsHomePage hotelsHome = (HotelsHomePage)homePage.header.selectTab("hotels");

        //CARGO ORIGEN - DESTINO
        //flightsHome.searchForm.cargaCiudad("origen","Brasil","Brasilia, Distrito Federal, Brasil");
        //flightsHome.searchForm.cargaCiudad("destino","Londres","Londres, Inglaterra, Reino Unido");

        //FECHAS - CALENDARIO
        //flightsHome.searchForm.cargaFecha("2020-10","16","2020-11","26");
        //flightsHome.searchForm.cargaFechaRelativa();
        //flightsHome.searchForm.selectDateRange("2020-12-10","2020-12-30",10,18);

        //CARGO ADULTOS - MENORES
        flightsHome.searchForm.selectAdultsMinors();
        Thread.sleep(2000);
    }

    @After
    public void tearDown() throws InterruptedException {
        driver.close();
    }
}
