package theboys.sorrentomarina.actions;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import theboys.sorrentomarina.actions.actionsAnnuncio.MostraAnnunciRespLidoAction;
import theboys.sorrentomarina.models.modelsUtente.ResponsabileLido;

import javax.servlet.ServletContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MostraAnnunciRespLidoActionTest extends ActionSetupDB {

  private MostraAnnunciRespLidoAction action;

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