package theboys.sorrentomarina.actions;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.servlet.ServletContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LidoActionTest extends ActionSetupDB {

  private LidoAction action;

  /**
   * Testa nel caso il lido sia presente nel db
   */
  @Test
  public void successTest(){
    Mockito.when(mockReq.getParameter("id")).thenReturn("1");

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    action = new LidoAction();

    String page = this.action.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/lido.jsp", page);
  }

  /**
   * Testa nel caso di lido non presente nel db
   */
  @Test
  public void failureTest() {
    Mockito.when(mockReq.getParameter("id")).thenReturn("10");

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    action = new LidoAction();

    String page = this.action.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/500.jsp", page);
  }

}
