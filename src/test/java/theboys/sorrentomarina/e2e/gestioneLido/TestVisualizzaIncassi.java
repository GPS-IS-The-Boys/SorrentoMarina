package theboys.sorrentomarina.e2e.gestioneLido;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import theboys.sorrentomarina.e2e.SystemTestCase;

public class TestVisualizzaIncassi extends SystemTestCase{
  private static WebDriver driver;

  @Before
  public void setup(){
    driver = SystemTestCase.driver;
  }

  @Test
  public void testVisualizzaIncassi(){
    driver.get("http://localhost:8080/SorrentoMarina/login");
    WebElement userField = driver.findElement(By.name("username"));
    userField.sendKeys("rootLido");
    WebElement passwordField = driver.findElement(By.name("password"));
    passwordField.sendKeys("Password3");
    WebElement form = driver.findElement(By.name("LoginForm"));
    form.submit();

    driver.get("http://localhost:8080/SorrentoMarina/dashboard");

    boolean Ok = driver.getPageSource().contains("Guadagni (Mensili)");
    Assert.assertTrue(Ok);
  }
}
