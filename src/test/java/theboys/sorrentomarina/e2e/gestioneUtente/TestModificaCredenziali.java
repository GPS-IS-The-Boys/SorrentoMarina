package theboys.sorrentomarina.e2e.gestioneUtente;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import theboys.sorrentomarina.e2e.SystemTestCase;

public class TestModificaCredenziali extends SystemTestCase {

  private static WebDriver driver;

  @Before
  public void setup(){
    driver = SystemTestCase.driver;
  }

  @Test
  public void testModificaCredenzialiOk(){
    driver.get("http://localhost:8080/SorrentoMarina/login");
    WebElement userField = driver.findElement(By.name("username"));
    userField.sendKeys("andreapirlo");
    WebElement passwordField = driver.findElement(By.name("password"));
    passwordField.sendKeys("Andreapirlo1");
    WebElement formLogin = driver.findElement(By.name("LoginForm"));
    formLogin.submit();
    driver.get("http://localhost:8080/SorrentoMarina/profilo");
    WebElement oldPasswordField = driver.findElement(By.name("oldPassword"));
    oldPasswordField.sendKeys("Andreapirlo1");
    WebElement newPasswordField = driver.findElement(By.name("newPassword"));
    newPasswordField.sendKeys("Andreapirlo1");
    WebElement form = driver.findElement(By.name("modificaCredenzialiForm"));
    form.submit();
    String url = driver.getCurrentUrl();
    Assert.assertEquals(url,"http://localhost:8080/SorrentoMarina/login");
  }

  @Test
  public void testModificaCredenzialiOldNotOk(){
    driver.get("http://localhost:8080/SorrentoMarina/login");
    WebElement userField = driver.findElement(By.name("username"));
    userField.sendKeys("andreapirlo");
    WebElement passwordField = driver.findElement(By.name("password"));
    passwordField.sendKeys("Andreapirlo1");
    WebElement formLogin = driver.findElement(By.name("LoginForm"));
    formLogin.submit();
    driver.get("http://localhost:8080/SorrentoMarina/profilo");
    WebElement oldPasswordField = driver.findElement(By.name("oldPassword"));
    oldPasswordField.sendKeys("11111");
    WebElement newPasswordField = driver.findElement(By.name("newPassword"));
    newPasswordField.sendKeys("Andreapirlo1");
    WebElement form = driver.findElement(By.name("modificaCredenzialiForm"));
    form.submit();
    Boolean isModificaOk = driver.getPageSource().contains("Password Attuale non valida");
    Assert.assertTrue(isModificaOk);
  }

  @Test
  public void testModificaCredenzialiNewNotOk(){
    driver.get("http://localhost:8080/SorrentoMarina/login");
    WebElement userField = driver.findElement(By.name("username"));
    userField.sendKeys("andreapirlo");
    WebElement passwordField = driver.findElement(By.name("password"));
    passwordField.sendKeys("Andreapirlo1");
    WebElement formLogin = driver.findElement(By.name("LoginForm"));
    formLogin.submit();
    driver.get("http://localhost:8080/SorrentoMarina/profilo");
    WebElement oldPasswordField = driver.findElement(By.name("oldPassword"));
    oldPasswordField.sendKeys("Andreapirlo1");
    WebElement newPasswordField = driver.findElement(By.name("newPassword"));
    newPasswordField.sendKeys("00000");
    WebElement form = driver.findElement(By.name("modificaCredenzialiForm"));
    form.submit();
    Boolean isModificaOk = driver.getPageSource().contains("Nuova password non valida");
    Assert.assertTrue(isModificaOk);
  }

  @Test
  public void testModificaCredenzialiOldNotEquals(){
    driver.get("http://localhost:8080/SorrentoMarina/login");
    WebElement userField = driver.findElement(By.name("username"));
    userField.sendKeys("andreapirlo");
    WebElement passwordField = driver.findElement(By.name("password"));
    passwordField.sendKeys("Andreapirlo1");
    WebElement formLogin = driver.findElement(By.name("LoginForm"));
    formLogin.submit();
    driver.get("http://localhost:8080/SorrentoMarina/profilo");
    WebElement oldPasswordField = driver.findElement(By.name("oldPassword"));
    oldPasswordField.sendKeys("Andreapirlo2");
    WebElement newPasswordField = driver.findElement(By.name("newPassword"));
    newPasswordField.sendKeys("Andreapirlo1");
    WebElement form = driver.findElement(By.name("modificaCredenzialiForm"));
    form.submit();
    String url = driver.getCurrentUrl();
    Assert.assertEquals(url,"http://localhost:8080/SorrentoMarina/profilo");
  }



}
