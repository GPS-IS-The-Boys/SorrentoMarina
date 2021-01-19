package theboys.sorrentomarina.e2e.gestioneLido;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import theboys.sorrentomarina.e2e.SystemTestCase;

public class TestModificaLido extends SystemTestCase {

  private static WebDriver driver;

  @Before
  public void setup(){
    driver = SystemTestCase.driver;
  }

  /**
   * Testa una corretta modifica del lido
   */
  @Test
  public void testModificaOk(){
    driver.get("http://localhost:8080/SorrentoMarina/login");
    WebElement userField = driver.findElement(By.name("username"));
    userField.sendKeys("alfio");
    WebElement passwordField = driver.findElement(By.name("password"));
    passwordField.sendKeys("Forzajuve1");
    WebElement form = driver.findElement(By.name("LoginForm"));
    form.submit();
    driver.get("http://localhost:8080/SorrentoMarina/mostraModificaLido");
    WebElement addressField = driver.findElement(By.name("indirizzoLido"));
    addressField.clear();
    addressField.sendKeys("Via Logoreti");
    WebElement formModifica = driver.findElement(By.name("modificaLido"));
    formModifica.submit();
    String url = driver.getCurrentUrl();
    Assert.assertEquals(url,"http://localhost:8080/SorrentoMarina/dashboard");
  }

  /**
   * Testa che il nome del lido non sia vuoto
   */
  @Test
  public void testModificaNomeNotOk(){
    driver.get("http://localhost:8080/SorrentoMarina/login");
    WebElement userField = driver.findElement(By.name("username"));
    userField.sendKeys("alfio");
    WebElement passwordField = driver.findElement(By.name("password"));
    passwordField.sendKeys("Forzajuve1");
    WebElement form = driver.findElement(By.name("LoginForm"));
    form.submit();
    driver.get("http://localhost:8080/SorrentoMarina/mostraModificaLido");
    WebElement nomeField = driver.findElement(By.name("nomeLido"));
    nomeField.clear();
    nomeField.sendKeys("   ");
    WebElement formModifica = driver.findElement(By.name("modificaLido"));
    formModifica.submit();
    Boolean isModificaOk = driver.getPageSource().contains("Nome del Lido non valido");
    Assert.assertTrue(isModificaOk);
  }

  /**
   * Testa che l'indirizzo del lido non sia vuoto
   */
  @Test
  public void testModificaIndirizzoNotOk(){
    driver.get("http://localhost:8080/SorrentoMarina/login");
    WebElement userField = driver.findElement(By.name("username"));
    userField.sendKeys("alfio");
    WebElement passwordField = driver.findElement(By.name("password"));
    passwordField.sendKeys("Forzajuve1");
    WebElement form = driver.findElement(By.name("LoginForm"));
    form.submit();
    driver.get("http://localhost:8080/SorrentoMarina/mostraModificaLido");
    WebElement indirizzoField = driver.findElement(By.name("indirizzoLido"));
    indirizzoField.clear();
    indirizzoField.sendKeys("   ");
    WebElement formModifica = driver.findElement(By.name("modificaLido"));
    formModifica.submit();
    Boolean isModificaOk = driver.getPageSource().contains("Indirizzo del Lido non valido");
    Assert.assertTrue(isModificaOk);
  }

  /**
   * Testa che il numero di telefono non sia valido
   */
  @Test
  public void testModificaTelNotOk(){
    driver.get("http://localhost:8080/SorrentoMarina/login");
    WebElement userField = driver.findElement(By.name("username"));
    userField.sendKeys("alfio");
    WebElement passwordField = driver.findElement(By.name("password"));
    passwordField.sendKeys("Forzajuve1");
    WebElement form = driver.findElement(By.name("LoginForm"));
    form.submit();
    driver.get("http://localhost:8080/SorrentoMarina/mostraModificaLido");
    WebElement telefonoField = driver.findElement(By.name("telefonoLido"));
    telefonoField.clear();
    telefonoField.sendKeys("123");
    WebElement formModifica = driver.findElement(By.name("modificaLido"));
    formModifica.submit();
    Boolean isModificaOk = driver.getPageSource().contains("Telefono del Lido non valido");
    Assert.assertTrue(isModificaOk);
  }

  /**
   * Testa che la path del logo del sito sia valida
   */
  @Test
  public void testModificaPathNotOk(){
    driver.get("http://localhost:8080/SorrentoMarina/login");
    WebElement userField = driver.findElement(By.name("username"));
    userField.sendKeys("alfio");
    WebElement passwordField = driver.findElement(By.name("password"));
    passwordField.sendKeys("Forzajuve1");
    WebElement form = driver.findElement(By.name("LoginForm"));
    form.submit();
    driver.get("http://localhost:8080/SorrentoMarina/mostraModificaLido");
    WebElement pathField = driver.findElement(By.name("logoLido"));
    pathField.clear();
    pathField.sendKeys("123");
    WebElement formModifica = driver.findElement(By.name("modificaLido"));
    formModifica.submit();
    Boolean isModificaOk = driver.getPageSource().contains("Path logo del Lido non valido");
    Assert.assertTrue(isModificaOk);
  }
}
