package theboys.sorrentomarina.actions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.FileNotFoundException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * @author theBoys
 */
public class MostraFormLoginActionTest extends ActionSetup{

  @Override
  @BeforeEach
  public void setup(){
    super.setup();
  }

  /**
   * Controlla che la view ritornata è quella corretta, ossia la pagina di Login
   *
   */
  @Test
  public void textView() {
    Action ac = Mockito.mock(MostraFormLoginAction.class, Mockito.CALLS_REAL_METHODS);
    String result = ac.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/login.jsp", result,
        "It should return the view path");
  }
}
