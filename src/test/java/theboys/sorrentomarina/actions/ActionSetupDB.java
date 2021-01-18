package theboys.sorrentomarina.actions;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.mockito.Mockito;
import theboys.sorrentomarina.utils.MockConnection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileNotFoundException;
import java.sql.SQLException;
/**
 * @author theBoys
 */
public class ActionSetupDB {

  protected static HttpServletRequest mockReq;
  protected static HttpServletResponse mockRes;
  protected static HttpSession mockSession;
  protected static MockConnection mockConnection = MockConnection.getInstance();

  /**
   * setta e nizializza un action
   *
   * @throws FileNotFoundException
   * @throws SQLException
   */
  @BeforeAll
  public static void setup() throws FileNotFoundException, SQLException {
    mockReq = Mockito.mock(HttpServletRequest.class);
    mockRes = Mockito.mock(HttpServletResponse.class);
    mockSession = Mockito.mock(HttpSession.class);
    mockConnection.initeDb();
  }

  /**
   * cancella un action
   * @throws SQLException
   */
  @AfterAll
  public static void clearDown() throws SQLException {
    mockConnection.clearDb();
  }

}
