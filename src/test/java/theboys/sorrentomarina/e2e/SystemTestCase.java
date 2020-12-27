package theboys.sorrentomarina.e2e;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * @author Diequ
 */
public class SystemTestCase {

  protected static WebDriver driver;

  @BeforeAll
  public static void setupClass() {
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("--headless"); // per non lanciare gui
    driver = new ChromeDriver(chromeOptions);
  }

  @AfterAll
  public static void tearDown() {
    driver.close();
  }
}
