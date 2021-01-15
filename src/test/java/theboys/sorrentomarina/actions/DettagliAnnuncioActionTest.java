package theboys.sorrentomarina.actions;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import theboys.sorrentomarina.actions.actionsAnnuncio.DettagliAnnuncioAction;

import javax.servlet.ServletContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DettagliAnnuncioActionTest extends ActionSetupDB {

  private DettagliAnnuncioAction action;

  /**
   * Test nel caso vengono mostrati i dettagli dell'annuncio
   */
  @Test
  public void dettagliAnnuncioTestExecuteSuccess(){
    Mockito.when(mockReq.getParameter("idAnnuncio")).thenReturn("1");
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);

    action = new DettagliAnnuncioAction();
    String page = this.action.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/dettagliAnnuncio.jsp", page);
  }

  /**
   * Test nel caso non vengono mostrati i dettagli dell'annuncio
   */
  @Test
  public void dettagliAnnuncioTestFailureSuccess(){
    Mockito.when(mockReq.getParameter("idAnnuncio")).thenReturn("prova");
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);

    action = new DettagliAnnuncioAction();
    String page = this.action.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/500.jsp", page);
  }

}
