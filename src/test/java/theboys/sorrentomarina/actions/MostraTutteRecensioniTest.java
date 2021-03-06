package theboys.sorrentomarina.actions;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import theboys.sorrentomarina.actions.actionsRecensione.MostraTutteRecensioni;
import theboys.sorrentomarina.actions.actionsUtils.Action;

import javax.servlet.ServletContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * @author theBoys
 */
public class MostraTutteRecensioniTest extends ActionSetupDB {
  /**
   *Test  mostra tutte le recensioni al responsabile ente
   */
  @Test
  public void textView() {
    Action ac = Mockito.mock(MostraTutteRecensioni.class, Mockito.CALLS_REAL_METHODS);
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);
    String result = ac.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/respEnteRecensioni.jsp", result,
        "It should return the view path");
  }

  /**
   * Test mmostra la view 500
   */
  @Test
  public void textView500() {
    Action ac = Mockito.mock(MostraTutteRecensioni.class, Mockito.CALLS_REAL_METHODS);
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(null);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);
    String result = ac.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/500.jsp", result,
        "It should return the view path");
  }
}
