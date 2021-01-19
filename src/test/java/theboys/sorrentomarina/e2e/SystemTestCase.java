package theboys.sorrentomarina.e2e;


import io.github.bonigarcia.wdm.config.DriverManagerType;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import theboys.sorrentomarina.actions.ActionSetupDB;
import theboys.sorrentomarina.utils.MockConnection;

import java.io.FileNotFoundException;
import java.sql.SQLException;

/**
 *@author theboys
 */
public class SystemTestCase  {

  protected static WebDriver driver;

  /**
   * Setup  della classe di testing
   *
   * @throws FileNotFoundException
   * @throws SQLException
   */
  @BeforeClass
  public static void setupClass() throws FileNotFoundException, SQLException {
    ChromeOptions chromeOptions = new ChromeOptions();
    //chromeOptions.addArguments("--headless"); // per non lanciare gui
    ChromeDriverManager .getInstance(DriverManagerType.CHROME).setup();
    driver = new ChromeDriver(chromeOptions);
  }

  /*
  @AfterAll
  public static void tearDown() {
    driver.close();
  }

   */
}
