package com.mvolpe.test.selenium.newtours;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.YearMonth;
import java.util.Date;

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
    //private static final String DESTINO = "input[class='input-tag sbox-main-focus sbox-bind-reference-flight-roundtrip-" + "destination-input " + "sbox-secondary sbox-places-second places-inline'][placeholder='Ingresá hacia dónde viajas']";
    @FindBy(css = "sbox-bind-event-click-start-date")
    private WebElement fechaIda;
    @FindBy(css = "sbox-bind-event-click-start-date")
    private WebElement fechaVuelta;
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


    public void cargaCiudad(String origenDestino, String ciudad, String ciudadLiteral) {
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

//    public void cargaFecha(String anoMes, String dia){
//        String mesActivo;
//        fechaIda.click();
//        mesActivo = activeMonth.getAttribute("data-month");
//        //WebElement currentMonth = driver.findElement(By.cssSelector("._dpmg2--show ._dpmg2--month-active"));
//        //String currentDataMonth = currentMonth.getAttribute("data-month");
//        YearMonth date1 = YearMonth.parse(anoMes);
//        //es el mes de parametro el activo? entonces click en siguiente
//        if (mesActivo.equals(anoMes)){
//            driver.findElements(By.cssSelector("._dpmg2--month-active ._dpmg2--dates ._dpmg2--date")).get(dia).click();
//        }
//    }
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
        Thread.sleep(500);
        driver.findElements(By.cssSelector("._pnlpk-select-minor-age")).get(35).click();
        Thread.sleep(500);
        driver.findElements(By.cssSelector("._pnlpk-select-minor-age .select-tag option[value='6']")).get(35).click();
        Thread.sleep(500);
        //Selecciono edad del menor
        driver.findElement(By.cssSelector("._pnlpk-panel--show ._pnlpk-minor-age-select-last-item ._pnlpk-select-minor-age")).click();
        Thread.sleep(100);
        driver.findElement(By.cssSelector("._pnlpk-panel--show ._pnlpk-minor-age-select-last-item ._pnlpk-select-minor-age .select-tag option[value='4']")).click();


    }


}

