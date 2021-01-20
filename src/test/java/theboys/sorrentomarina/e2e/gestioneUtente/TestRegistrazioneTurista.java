package theboys.sorrentomarina.e2e.gestioneUtente;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import theboys.sorrentomarina.e2e.SystemTestCase;

public class TestRegistrazioneTurista extends SystemTestCase {

  private static WebDriver driver;

  @Before
  public void setup(){
    driver = SystemTestCase.driver;
  }

  @Test
  public void testRegistrazioneOk(){
    driver.get("http://localhost:8080/SorrentoMarina/registrazione");
    WebElement nomeField = driver.findElement(By.name("nome"));
    nomeField.sendKeys("Matteo");
    WebElement cognomeField = driver.findElement(By.name("cognome"));
    cognomeField.sendKeys("Mattei");
    WebElement emailField = driver.findElement(By.name("email"));
    emailField.sendKeys("Matteomattei@gmail.com");
    WebElement usernameField = driver.findElement(By.name("username"));
    usernameField.sendKeys("matteomattei");
    WebElement passwordField = driver.findElement(By.name("password"));
    passwordField.sendKeys("Matteomattei1");
    WebElement confermaField = driver.findElement(By.name("passwordConferma"));
    confermaField.sendKeys("Matteomattei1");
    WebElement form = driver.findElement(By.name("registrazioneForm"));
    form.submit();
    Boolean isRegistrazioneOk = driver.getPageSource().contains("Benvenuto " + "matteomattei");
    Assert.assertTrue(isRegistrazioneOk);
    driver.manage().deleteAllCookies();
  }

  @Test
  public void testRegistrazioneUsernameNotOk(){
    driver.get("http://localhost:8080/SorrentoMarina/registrazione");
    WebElement nomeField = driver.findElement(By.name("nome"));
    nomeField.sendKeys("Matteo");
    WebElement cognomeField = driver.findElement(By.name("cognome"));
    cognomeField.sendKeys("Mattei");
    WebElement emailField = driver.findElement(By.name("email"));
    emailField.sendKeys("Matteomattei@gmail.com");
    WebElement usernameField = driver.findElement(By.name("username"));
    usernameField.sendKeys("matt");
    WebElement passwordField = driver.findElement(By.name("password"));
    passwordField.sendKeys("Matteomattei1");
    WebElement confermaField = driver.findElement(By.name("passwordConferma"));
    confermaField.sendKeys("Matteomattei1");
    WebElement form = driver.findElement(By.name("registrazioneForm"));
    form.submit();
    Boolean isRegistrazioneOk = driver.getPageSource().contains("Campo Username non valido");
    Assert.assertTrue(isRegistrazioneOk);
  }

  @Test
  public void testRegistrazionePasswrdNotOk(){
    driver.get("http://localhost:8080/SorrentoMarina/registrazione");
    WebElement nomeField = driver.findElement(By.name("nome"));
    nomeField.sendKeys("Matteo");
    WebElement cognomeField = driver.findElement(By.name("cognome"));
    cognomeField.sendKeys("Mattei");
    WebElement emailField = driver.findElement(By.name("email"));
    emailField.sendKeys("Matteomattei@gmail.com");
    WebElement usernameField = driver.findElement(By.name("username"));
    usernameField.sendKeys("matteomattei");
    WebElement passwordField = driver.findElement(By.name("password"));
    passwordField.sendKeys("matt");
    WebElement confermaField = driver.findElement(By.name("passwordConferma"));
    confermaField.sendKeys("matt");
    WebElement form = driver.findElement(By.name("registrazioneForm"));
    form.submit();
    Boolean isRegistrazioneOk = driver.getPageSource().contains("Campo Password non valido");
    Assert.assertTrue(isRegistrazioneOk);
  }

  @Test
  public void testRegistrazionePasswrdNotEquals(){
    driver.get("http://localhost:8080/SorrentoMarina/registrazione");
    WebElement nomeField = driver.findElement(By.name("nome"));
    nomeField.sendKeys("Matteo");
    WebElement cognomeField = driver.findElement(By.name("cognome"));
    cognomeField.sendKeys("Mattei");
    WebElement emailField = driver.findElement(By.name("email"));
    emailField.sendKeys("Matteomattei@gmail.com");
    WebElement usernameField = driver.findElement(By.name("username"));
    usernameField.sendKeys("matteomattei");
    WebElement passwordField = driver.findElement(By.name("password"));
    passwordField.sendKeys("Matteomattei1");
    WebElement confermaField = driver.findElement(By.name("passwordConferma"));
    confermaField.sendKeys("Matteomattei2");
    WebElement form = driver.findElement(By.name("registrazioneForm"));
    form.submit();
    Boolean isRegistrazioneOk = driver.getPageSource().contains("Password e Conferma non coincidono");
    Assert.assertTrue(isRegistrazioneOk);
  }

  @Test
  public void testRegistrazioneNameNotOk(){
    driver.get("http://localhost:8080/SorrentoMarina/registrazione");
    WebElement nomeField = driver.findElement(By.name("nome"));
    nomeField.sendKeys("00000");
    WebElement cognomeField = driver.findElement(By.name("cognome"));
    cognomeField.sendKeys("Mattei");
    WebElement emailField = driver.findElement(By.name("email"));
    emailField.sendKeys("Matteomattei@gmail.com");
    WebElement usernameField = driver.findElement(By.name("username"));
    usernameField.sendKeys("matteomattei");
    WebElement passwordField = driver.findElement(By.name("password"));
    passwordField.sendKeys("Matteomattei1");
    WebElement confermaField = driver.findElement(By.name("passwordConferma"));
    confermaField.sendKeys("Matteomattei1");
    WebElement form = driver.findElement(By.name("registrazioneForm"));
    form.submit();
    Boolean isRegistrazioneOk = driver.getPageSource().contains("Campo Nome non valido");
    Assert.assertTrue(isRegistrazioneOk);
  }
  @Test
  public void testRegistrazioneMailNotOk(){
    driver.get("http://localhost:8080/SorrentoMarina/registrazione");
    WebElement nomeField = driver.findElement(By.name("nome"));
    nomeField.sendKeys("matteo");
    WebElement cognomeField = driver.findElement(By.name("cognome"));
    cognomeField.sendKeys("Mattei");
    WebElement emailField = driver.findElement(By.name("email"));
    emailField.sendKeys("12345");
    WebElement usernameField = driver.findElement(By.name("username"));
    usernameField.sendKeys("matteomattei");
    WebElement passwordField = driver.findElement(By.name("password"));
    passwordField.sendKeys("Matteomattei1");
    WebElement confermaField = driver.findElement(By.name("passwordConferma"));
    confermaField.sendKeys("Matteomattei1");
    WebElement form = driver.findElement(By.name("registrazioneForm"));
    form.submit();
    Boolean isRegistrazioneOk = driver.getPageSource().contains("Campo Email non valido");
    Assert.assertTrue(isRegistrazioneOk);
  }

}
