package theboys.sorrentomarina.managers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.h2.tools.RunScript;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

/**
 * @author theboys
 */
public class IntegrationTestCase {

  protected static BasicDataSource mockDb;

  @BeforeAll
  public static void setup() throws SQLException, FileNotFoundException {
    mockDb = new BasicDataSource();
    mockDb.setDriverClassName("org.h2.Driver");
    mockDb.setUrl("jdbc:h2:./sorrentoTest;MODE=MYSQL;DATABASE_TO_UPPER=false;");
    mockDb.setUsername("root");
    mockDb.setPassword("root");
    mockDb.getConnection().createStatement().execute("drop all objects delete files");
    RunScript.execute(mockDb.getConnection(), new FileReader(
        new File(IntegrationTestCase.class.getResource("/backup.sql")
            .getFile())));
  }

  @AfterAll
  public static void tearDown() throws SQLException {
    mockDb.getConnection().createStatement().execute("drop all objects delete files");
  }
}
