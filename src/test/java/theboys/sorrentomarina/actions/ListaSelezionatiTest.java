package theboys.sorrentomarina.actions;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import theboys.sorrentomarina.actions.actionsPrenotazione.ListaSelezionati;
import theboys.sorrentomarina.actions.actionsUtils.Action;

import javax.servlet.ServletContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * @author theBoys
 */
public class ListaSelezionatiTest extends ActionSetupDB{
  /**
   * ()
   */
  @Test
  public void testListaSelezionati(){
    Action ac = Mockito.mock(ListaSelezionati.class, Mockito.CALLS_REAL_METHODS);
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    Mockito.when(mockReq.getParameter("lista")).thenReturn("[2_2,3_3]");
    Mockito.when(mockReq.getParameter("giorni")).thenReturn("2");
    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);
    String result = ac.execute(mockReq, mockRes);
    assertEquals("ajax", result,
        "It should return the view path");
  }
}
