package theboys.sorrentomarina.e2e.gestioneRecensione;


import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import theboys.sorrentomarina.e2e.SystemTestCase;

public class TestCreazioneRecensione extends SystemTestCase {
  private static WebDriver driver;

  @Before
  public void setup(){
    driver = SystemTestCase.driver;
  }

  @Test
  public void testCreazioneAnnuncio(){
/**
    driver.get("http://localhost:8080/SorrentoMarina/login");
    WebElement userField = driver.findElement(By.name("username"));
    userField.sendKeys("turista");
    WebElement passwordField = driver.findElement(By.name("password"));
    passwordField.sendKeys("Password1");
    WebElement form = driver.findElement(By.name("LoginForm"));
    form.submit();

    driver.get("http://localhost:8080/SorrentoMarina/lido?id=8");
    WebElement buttonRecensioni = driver.findElement(By.name("recensioniLido"));
    buttonRecensioni.click();
    WebElement buttonAggiunta = driver.findElement(By.name("AggiungiRecensione"));
    buttonAggiunta.click();

    driver.get("http://localhost:8080/SorrentoMarina/formRecensione");
    WebElement contenuto = driver.findElement(By.name("contenutoRecensione"));
    contenuto.sendKeys("Ottima esperienza, condita da salsa tonnata.");
    WebElement giudizio = driver.findElement(By.name("giudizioRecensione"));
    giudizio.sendKeys("4");

    WebElement formAggiunta = driver.findElement(By.name("addRecensione"));
    formAggiunta.submit();

    boolean Ok = driver.getPageSource().contains("RECENSIONI");
    Assert.assertTrue(Ok);
 */
  }
}