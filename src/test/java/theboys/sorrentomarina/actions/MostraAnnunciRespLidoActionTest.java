package theboys.sorrentomarina.actions;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import theboys.sorrentomarina.models.ResponsabileLido;

import javax.servlet.ServletContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * @author theBoys
 */
public class MostraAnnunciRespLidoActionTest extends ActionSetupDB {

  private MostraAnnunciRespLidoAction action;

  /**
   * test cerca annunci nel db con successo
   */
  @Test
  public void testSuccess(){
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    Mockito.when(mockReq.getSession().getAttribute("adminLido")).thenReturn(new ResponsabileLido(1, "", "", "", "","", 1));
    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);

    action = new MostraAnnunciRespLidoAction();
    String page = this.action.execute(mockReq, mockRes);

    assertEquals("/WEB-INF/views/respLidoAnnunci.jsp", page);
  }

  /**
   * test cerca annunci nel db senza successo
   */
  @Test
  public void testFailure(){
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    Mockito.when(mockReq.getSession().getAttribute("adminLido")).thenReturn(null);

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);

    action = new MostraAnnunciRespLidoAction();
    String page = this.action.execute(mockReq, mockRes);

    assertEquals("/WEB-INF/views/500.jsp", page);
  }
}