package theboys.sorrentomarina.utils;

import org.apache.commons.dbcp2.BasicDataSource;
import org.h2.tools.RunScript;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;

public class MockConnection extends BasicDataSource {
  private static  MockConnection mockConnection = null;

  /**
   * Costruttore
   */
  private MockConnection(){
    super();
  }

  /**
   * Istanziazione database
   *
   * @return una connessione al database
   */
  public static MockConnection getInstance(){
    if(mockConnection == null){
      mockConnection = new MockConnection();
      mockConnection.setDriverClassName("org.h2.Driver");
      mockConnection.setUrl("jdbc:h2:./sorrentoTest;MODE=MYSQL;DATABASE_TO_UPPER=false;");
      mockConnection.setUsername("root");
      mockConnection.setPassword("root");
      mockConnection.setMaxTotal(512);
      mockConnection.setMaxIdle(512);
    }
    return mockConnection;
  }

  /**
   * Inizializzazione database
   *
   * @throws SQLException
   * @throws FileNotFoundException
   */
  public void initeDb() throws SQLException, FileNotFoundException {
    mockConnection.getConnection().createStatement().execute("drop all objects delete files");
    Path path = Paths.get("src", "test", "resources", "backup.sql");
    String absolutePath = String.valueOf(path.toAbsolutePath());
    File file = new File(absolutePath);
    RunScript.execute(mockConnection.getConnection(), new FileReader(file));
  }

  /**
   * Cancellazione database
   *
   * @throws SQLException
   */
  public void clearDb() throws SQLException {
    mockConnection.getConnection().createStatement().execute("drop all objects delete files");
  }

}
