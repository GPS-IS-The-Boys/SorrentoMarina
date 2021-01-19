package theboys.sorrentomarina.e2e.gestioneUtente;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import theboys.sorrentomarina.e2e.SystemTestCase;

public class TestLoginTurista extends SystemTestCase {

  private static  WebDriver driver;

  @Before
  public void setup(){
    driver = SystemTestCase.driver;
  }

  /**
   * Test - testa la login del turista in caso di credenziali corrette
   */
  @Test
  public void testLoginTuristaOk(){
    driver.get("http://localhost:8080/SorrentoMarina/login");
    WebElement userField = driver.findElement(By.name("username"));
    userField.sendKeys("turista");
    WebElement passwordField = driver.findElement(By.name("password"));
    passwordField.sendKeys("Password2");
    WebElement form = driver.findElement(By.name("LoginForm"));
    form.submit();
    Boolean isLoginOk = driver.getPageSource().contains("Benvenuto " + "turista");
    Assert.assertTrue(isLoginOk);

  }

  /**
   * Test - testa la login del turista in caso di credenziali non corrette
   */
  @Test
  public void testLoginTuristaUsernameNotOk(){
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
   * Test - testa la login del turista in caso di credenziali non corrette
   * username ok - password ko
   */
  @Test
  public void testLoginTuristaPasswordNotOk(){
    driver.get("http://localhost:8080/SorrentoMarina/login");
    WebElement userField = driver.findElement(By.name("username"));
    userField.sendKeys("turista");
    WebElement passwordField = driver.findElement(By.name("password"));
    passwordField.sendKeys("456");
    WebElement form = driver.findElement(By.name("LoginForm"));
    form.submit();
    Boolean isLoginNotOk = driver.getPageSource().contains("Credenziali non corrette! Riprova.");
    Assert.assertTrue(isLoginNotOk);

  }

  /**
   * Test - testa la login del turista in caso di credenziali non corrette
   * username e password vuote
   */
  @Test
  public void testLoginTuristaEmptyFields(){
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
