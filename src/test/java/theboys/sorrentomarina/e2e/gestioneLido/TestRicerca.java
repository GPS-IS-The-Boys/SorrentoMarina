package theboys.sorrentomarina.e2e.gestioneLido;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import theboys.sorrentomarina.e2e.SystemTestCase;

public class TestRicerca extends SystemTestCase {

  private static WebDriver driver;

  @Before
  public void setup(){
    driver = SystemTestCase.driver;
  }

  @Test
  public void testRicercaSoloNome(){
    driver.get("http://localhost:8080/SorrentoMarina/");
    WebElement userField = driver.findElement(By.name("nomeRicerca"));
    userField.sendKeys("Al chicco d'oro");

    WebElement form = driver.findElement(By.name("RicercaForm"));
    form.submit();
    boolean Ok = driver.getPageSource().contains("Al Chicco d'Oro");
    Assert.assertTrue(Ok);
  }
}
