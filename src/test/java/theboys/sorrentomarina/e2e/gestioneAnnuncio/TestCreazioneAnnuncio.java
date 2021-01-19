package theboys.sorrentomarina.e2e.gestioneAnnuncio;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import theboys.sorrentomarina.e2e.SystemTestCase;

public class TestCreazioneAnnuncio extends SystemTestCase {

  private static WebDriver driver;

  @Before
  public void setup(){
    driver = SystemTestCase.driver;
  }

  @Test
  public void testCreazioneAnnuncio(){

    driver.get("http://localhost:8080/SorrentoMarina/login");
    WebElement userField = driver.findElement(By.name("username"));
    userField.sendKeys("rootLido");
    WebElement passwordField = driver.findElement(By.name("password"));
    passwordField.sendKeys("Password3");
    WebElement form = driver.findElement(By.name("LoginForm"));
    form.submit();

    driver.get("http://localhost:8080/SorrentoMarina/dashboard");
    WebElement titolo = driver.findElement(By.name("titolo"));
    titolo.sendKeys("Apertura 2021");
    WebElement contenuto = driver.findElement(By.name("contenuto"));
    contenuto.sendKeys("Sta per aprire la nuova stagione estiva per l'anno 2021!");
    WebElement foto = driver.findElement(By.name("foto"));
    foto.sendKeys("/images/logoLido1.jpg");

    WebElement formCreazione = driver.findElement(By.name("CreazioneAnnuncioForm"));
    formCreazione.submit();

    boolean Ok = driver.getPageSource().contains("Dashboard Responsabile Lido");
    Assert.assertTrue(Ok);
  }
}