package theboys.sorrentomarina.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

/**
 * @author theBoys
 */
public class ActionSetup {

  protected HttpServletRequest mockReq;
  protected HttpServletResponse mockRes;
  protected HttpSession mockSession;

  /**
   * setta un action
   */
  @BeforeEach
  public void setup(){
    mockReq = Mockito.mock(HttpServletRequest.class);
    mockRes = Mockito.mock(HttpServletResponse.class);
    mockSession = Mockito.mock(HttpSession.class);
  }

}
