package theboys.sorrentomarina.e2e.gestioneAnnuncio;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import theboys.sorrentomarina.e2e.SystemTestCase;

public class TestModificaAnnuncio extends SystemTestCase {

  private static WebDriver driver;

  @Before
  public void setup(){
    driver = SystemTestCase.driver;
  }

  @Test
  public void testModificaAnnuncio(){

    driver.get("http://localhost:8080/SorrentoMarina/login");
    WebElement userField = driver.findElement(By.name("username"));
    userField.sendKeys("rootLido");
    WebElement passwordField = driver.findElement(By.name("password"));
    passwordField.sendKeys("Password3");
    WebElement form = driver.findElement(By.name("LoginForm"));
    form.submit();

    driver.get("http://localhost:8080/SorrentoMarina/annunciRespLido");

    WebElement button = driver.findElement(By.name("modifica14"));
    button.click();
    WebElement contenuto = driver.findElement(By.name("contenuto"));
    contenuto.sendKeys("Il direttore dice:");

    WebElement formModifica = driver.findElement(By.name("ModificaAnnuncio"));
    formModifica.submit();

    boolean Ok = driver.getPageSource().contains("Dashboard");
    Assert.assertTrue(Ok);
  }
}
