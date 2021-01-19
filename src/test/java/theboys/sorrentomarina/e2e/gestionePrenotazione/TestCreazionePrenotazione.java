package theboys.sorrentomarina.e2e.gestionePrenotazione;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import theboys.sorrentomarina.e2e.SystemTestCase;

public class TestCreazionePrenotazione extends SystemTestCase {

  private static WebDriver driver;

  @Before
  public void setup(){
    driver = SystemTestCase.driver;
  }

  @Test
  public void testRicercaSoloNome(){
    /**
    driver.get("http://localhost:8080/SorrentoMarina/");

    WebElement buttonLido = driver.findElement(By.id("Nettuno"));
    buttonLido.click();

    WebElement buttonPre = driver.findElement(By.name("prenotazione"));
    buttonPre.click();

    WebElement dataInizio = driver.findElement(By.name("dataInizio"));
    dataInizio.sendKeys("2021-02-01");
    WebElement dataFine = driver.findElement(By.name("dataFine"));
    dataFine.sendKeys("2021-02-05");
    WebElement posti = driver.findElement(By.name("numPosti"));
    posti.sendKeys("2");

    WebElement next = driver.findElement(By.id("next"));
    next.click();

    //WebElement giorni = driver.findElement(By.name("giorni"));
    //giorni.sendKeys("5");
    String[] array = {"1_1"};
    WebElement postiSelezionati = driver.findElement(By.name("postiSelezionati"));
    postiSelezionati.sendKeys(array);

    WebElement next3 = driver.findElement(By.id("next3"));
    next3.click();

    WebElement nome = driver.findElement(By.name("nome"));
    nome.sendKeys("Cosimo");
    WebElement cognome = driver.findElement(By.name("cognome"));
    cognome.sendKeys("Taralli");
    WebElement email = driver.findElement(By.name("email"));
    email.sendKeys("taralli@tiscali.it");

    WebElement next4 = driver.findElement(By.id("next4"));
    next4.click();

    WebElement next5 = driver.findElement(By.id("next5"));
    next5.click();

    boolean Ok = driver.getPageSource().contains("PRENOTAZIONE CONFERMATA");
    Assert.assertTrue(Ok);
     */
  }
}
