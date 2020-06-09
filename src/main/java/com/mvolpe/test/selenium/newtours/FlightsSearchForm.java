package com.mvolpe.test.selenium.newtours;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FlightsSearchForm {
    private static final String ORIGEN = ".sbox-mobile-body .sbox-row .-mb4-s .sbox-input-container .sbox-3-validation " + ".sbox-bind-reference-flight-roundtrip-origin-input";
    private static final String DESTINO = "input[class='input-tag sbox-main-focus sbox-bind-reference-flight-roundtrip-" + "destination-input " + "sbox-secondary sbox-places-second places-inline'][placeholder='Ingresá hacia dónde viajas']";
    private WebDriver driver;
    public FlightsSearchForm (WebDriver driver){
        this.driver = driver;
    }
    public void cargaCiudad(String sugerencia, String ciudadAeropuerto) {

        //Ingreso sugerencia
        driver.findElement(By.cssSelector(selector)).sendKeys(sugerencia);

        //Espero a que el menu de sugerencias se termine de cargar
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(3000L));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(.,'Ciudades')]")));

        //Clickeo en la opcion del origen
        driver.findElement(By.xpath("//span[contains(.,'" + ciudadAeropuerto + "')]")).click();
    }
}
