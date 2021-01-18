package theboys.sorrentomarina.actions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import theboys.sorrentomarina.actions.actionsUtente.LogoutAction;
import theboys.sorrentomarina.actions.actionsUtils.Action;

import javax.servlet.ServletContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * @author theBoys
 */
public class LogoutActionTest extends ActionSetup {
  @Override
  @BeforeEach
  public void setup(){
    super.setup();
  }

  /**
   * Testa se il logout viene effettuato correttamente
   */
  @Test
  public void testAction() {
    Action ac = Mockito.mock(LogoutAction.class, Mockito.CALLS_REAL_METHODS);

    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);

    String result = ac.execute(mockReq, mockRes);
    assertEquals("redirect:/SorrentoMarina/", result, "It should return the homepage path");
  }

}