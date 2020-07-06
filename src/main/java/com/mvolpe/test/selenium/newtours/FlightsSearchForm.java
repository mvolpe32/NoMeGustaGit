package com.mvolpe.test.selenium.newtours;

import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriverException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.YearMonth;
import java.util.Date;

import static java.lang.Thread.*;

public class FlightsSearchForm extends PageObject{
    public FlightsSearchForm(WebDriver driver){
        super(driver);
    }
    private String origenDestino;

    //private static final searchBox;
    @FindBy(css = ".sbox-mobile-body .sbox-row .-mb4-s .sbox-input-container .sbox-3-validation .sbox-bind-reference-flight-roundtrip-origin-input")
    private WebElement ORIGEN;
    @FindBy(css = ".sbox-destination-container .input-container .input-tag")
    private WebElement DESTINO;
    @FindBy(css = ".sbox-dates-row .sbox-datein-container .sbox-bind-event-click-start-date")
    private WebElement fechaIda;
    @FindBy(css = "._dpmg2--month-active")
    private WebElement activeMonth;
    @FindBy(css = "._dpmg2--controls-next")
    private WebElement nextArrow;


    String[] listaCiudades = {"Brasilia, Distrito Federal, Brasil","Rio de Janeiro, Rio de Janeiro, Brasil","Londres, " +
            "Inglaterra, Reino Unido","Mánchester, Inglaterra, Reino Unido"};
    String[] listaAeropuertos = {"Aeropuerto Santos Dumont, Rio de Janeiro, Brasil", "Aeropuerto Internacional Galeão Antonio Carlos Jobim" +
            ", Rio de Janeiro, Brasil", "Aeropuerto London Heathrow, Londres, Reino Unido", "Aeropuerto London Gatwick, Londres, Reino Unido"};
    String[] sugerencia = {"Brasil","Inglaterra","Buenos Aires"};
    String ciudadAeropuerto;


    public void cargaCiudad (String origenDestino, String ciudad, String ciudadLiteral) {
        //Ingreso sugerencia
        if (origenDestino.equals("origen")) {
            ORIGEN.clear();
            ORIGEN.sendKeys(ciudad);

            //Espero a que el menu de sugerencias se termine de cargar
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(3000L));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(.,'Ciudades')]")));

            //Clickeo en la opcion del origen
            driver.findElement(By.xpath("//span[contains(.,'" + ciudadLiteral + "')]")).click();
        } else {
            DESTINO.sendKeys(ciudad);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(3000L));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(.,'Ciudades')]")));
            driver.findElement(By.xpath("//span[contains(.,'" + ciudadLiteral + "')]")).click();

        }
    }

    public void cargaFechaRelativa(){

    }


    public void cargaFecha(String anoMesIda, String diaIda, String anoMesVuelta, String diaVuelta){
        fechaIda.click();
        String dataMonthActiveMonth = activeMonth.getAttribute("data-month");
        while(!dataMonthActiveMonth.equals(anoMesIda)){
            nextArrow.click();
            dataMonthActiveMonth = activeMonth.getAttribute("data-month");
        }
        WebElement diaElegidoIda = driver.findElement(By.xpath("//div[contains(@class, '_dpmg2--month-active')]//span[contains(text(),'"+ diaIda + "')][contains(@class,'_dpmg2--date-number')]"));
        diaElegidoIda.click();
       // driver.findElement(By.xpath("//div[contains(@class, '_dpmg2--month-active')]//span[contains(text(),'" + diaVuelta + "')]")).click();

        while(!dataMonthActiveMonth.equals(anoMesVuelta)){
            nextArrow.click();
           dataMonthActiveMonth = activeMonth.getAttribute("data-month");
       }
       WebElement diaElegidoVuelta = driver.findElement(By.xpath("//div[contains(@class, '_dpmg2--month-active')]//span[contains(text(),'"+ diaVuelta + "')][contains(@class,'_dpmg2--date-number')]"));
        System.out.println(dataMonthActiveMonth);
        System.out.println(diaElegidoVuelta.getText());
       diaElegidoVuelta.click();
        }

    //estructura ._dpmg2--month-active ._dpmg2--dates
    //formato YYYY-MM-DD          clase yearmonth;

    public void adultosMenores() throws InterruptedException {
        WebElement panel = driver.findElements(By.cssSelector("._pnlpk-panel-scroll")).get(2);
        //Despliego panel para agregar personas
        driver.findElements(By.cssSelector(".sbox-3-input .input-container .-rooms")).get(0).click();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOf(panel));
        //Agrego 2 adultos
        //driver.findElements(By.cssSelector(("._pnlpk-minor-age-select").));
        driver.findElement(By.cssSelector("._pnlpk-panel--show ._pnlpk-itemRow:first-of-type .sbox-3-icon-plus")).click();
        driver.findElement(By.cssSelector("._pnlpk-panel--show ._pnlpk-itemRow:first-of-type .sbox-3-icon-plus")).click();
        //Agrego 2 menores
        driver.findElement(By.cssSelector("._pnlpk-panel--show ._pnlpk-itemRow:nth-of-type(2) .sbox-3-icon-plus")).click();
        driver.findElement(By.cssSelector("._pnlpk-panel--show ._pnlpk-itemRow:nth-of-type(2) .sbox-3-icon-plus")).click();
        sleep(500);
        driver.findElements(By.cssSelector("._pnlpk-select-minor-age")).get(35).click();
        sleep(500);
        driver.findElements(By.cssSelector("._pnlpk-select-minor-age .select-tag option[value='6']")).get(35).click();
        sleep(500);
        //Selecciono edad del menor
        driver.findElement(By.cssSelector("._pnlpk-panel--show ._pnlpk-minor-age-select-last-item ._pnlpk-select-minor-age")).click();
        sleep(100);
        driver.findElement(By.cssSelector("._pnlpk-panel--show ._pnlpk-minor-age-select-last-item ._pnlpk-select-minor-age .select-tag option[value='4']")).click();


    }


}
