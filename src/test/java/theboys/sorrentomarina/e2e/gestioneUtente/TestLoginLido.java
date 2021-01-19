package theboys.sorrentomarina.e2e.gestioneUtente;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import theboys.sorrentomarina.e2e.SystemTestCase;

public class TestLoginLido extends SystemTestCase {

  private static WebDriver driver;

  @Before
  public void setup(){
    driver = SystemTestCase.driver;
  }

  /**
   * Test - testa la login del responsabile lido in caso di credenziali corrette
   */
  @Test
  public void testLoginLidoOk(){
    driver.get("http://localhost:8080/SorrentoMarina/login");
    WebElement userField = driver.findElement(By.name("username"));
    userField.sendKeys("rootLido");
    WebElement passwordField = driver.findElement(By.name("password"));
    passwordField.sendKeys("Password3");
    WebElement form = driver.findElement(By.name("LoginForm"));
    form.submit();
    driver.get("http://localhost:8080/SorrentoMarina/dashboard");
    Boolean isLoginOk = driver.getPageSource().contains("Dashboard Responsabile Lido:");
    Assert.assertTrue(isLoginOk);

  }

  /**
   * Test - testa la login del responsabile lido in caso di credenziali non corrette
   */
  @Test
  public void testLoginLidoUsernameNotOk(){
    driver.get("http://localhost:8080/SorrentoMarina/login");
    WebElement userField = driver.findElement(By.name("username"));
    userField.sendKeys("123");
    WebElement passwordField = driver.findElement(By.name("password"));
    passwordField.sendKeys("456");
    WebElement form = driver.findElement(By.name("LoginForm"));
    form.submit();
    Boolean isLoginNotOk = driver.getPageSource().contains("Credenziali non corrette! Riprova.");
    Assert.assertTrue(isLoginNotOk);

  }

  /**
   * Test - testa la login del responsabile lido in caso di credenziali non corrette
   * username ok - password ko
   */
  @Test
  public void testLoginLidoPasswordNotOk(){
    driver.get("http://localhost:8080/SorrentoMarina/login");
    WebElement userField = driver.findElement(By.name("username"));
    userField.sendKeys("rootLido");
    WebElement passwordField = driver.findElement(By.name("password"));
    passwordField.sendKeys("456");
    WebElement form = driver.findElement(By.name("LoginForm"));
    form.submit();
    Boolean isLoginNotOk = driver.getPageSource().contains("Credenziali non corrette! Riprova.");
    Assert.assertTrue(isLoginNotOk);

  }

  /**
   * Test - testa la login del responsabile lido in caso di credenziali non corrette
   * username e password vuote
   */
  @Test
  public void testLoginLidoEmptyFields(){
    driver.get("http://localhost:8080/SorrentoMarina/login");
    WebElement userField = driver.findElement(By.name("username"));
    userField.sendKeys("");
    WebElement passwordField = driver.findElement(By.name("password"));
    passwordField.sendKeys("");
    WebElement form = driver.findElement(By.name("LoginForm"));
    form.submit();
    Boolean isLoginNotOk = driver.getPageSource().contains("Credenziali non corrette! Riprova.");
    Assert.assertTrue(isLoginNotOk);

  }
}
