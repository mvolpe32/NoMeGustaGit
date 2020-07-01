package com.mvolpe.test.selenium.newtours;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HotelsSearchForm {
    @FindBy(css = ".sbox-places-origin .input-container .input-tag")
    private WebElement destino;

    public HotelsSearchForm(WebDriver driver) {
        super(driver);
    }

    public void cargaDestino(String destinoElegido){
        destino.sendKeys("Brasil");

        Thread.sleep(2000);
    }

}
