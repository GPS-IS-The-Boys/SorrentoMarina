package theboys.sorrentomarina.actions;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import theboys.sorrentomarina.actions.actionsRecensione.MostraRecensioniRespLidoAction;
import theboys.sorrentomarina.actions.actionsUtils.Action;
import theboys.sorrentomarina.models.modelsUtente.ResponsabileLido;

import javax.servlet.ServletContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * @author theBoys
 */
public class MostraRecensioniRespLidoTest extends ActionSetupDB{
  /**
   * Test mostra le recensioni al responsabile lido
   */
  @Test
  public void textView() {
    Action ac = Mockito.mock(MostraRecensioniRespLidoAction.class, Mockito.CALLS_REAL_METHODS);
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);
    Mockito.when(mockReq.getSession().getAttribute("adminLido")).thenReturn(new ResponsabileLido("Nome1", "Cognome1", "Email1", "Username1","e38ad214943daad1d64c102faec29de4afe9da3d",1,1));
    String result = ac.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/respLidoRecensioni.jsp", result,
        "It should return the view path");
  }

  /**
   * mostra la view 500
   */

  @Test
  public void textView500() {
    Action ac = Mockito.mock(MostraRecensioniRespLidoAction.class, Mockito.CALLS_REAL_METHODS);
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(null);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);
    Mockito.when(mockReq.getSession().getAttribute("adminLido")).thenReturn(new ResponsabileLido("Nome1", "Cognome1", "Email1", "Username1","e38ad214943daad1d64c102faec29de4afe9da3d",1, 1));
    String result = ac.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/500.jsp", result,
        "It should return the view path");
  }
}
