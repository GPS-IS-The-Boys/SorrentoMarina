package theboys.sorrentomarina.actions;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import theboys.sorrentomarina.actions.actionsUtente.MostraDisponibilitaRespLidoAction;
import theboys.sorrentomarina.models.modelsUtente.ResponsabileLido;

import javax.servlet.ServletContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * @author theBoys
 */
public class MostraDisponibilitaRespLidoActionTest extends ActionSetupDB {

  private MostraDisponibilitaRespLidoAction action;

  /**
   * test mostra con successo la disponiibilità al responsabile lido
   *
   * ()
   */
  @Test
  public void successTest(){
    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);

    Mockito.when(mockReq.getParameter("dataInizio")).thenReturn("2021-01-01");
    Mockito.when(mockReq.getParameter("dataFine")).thenReturn("2021-01-01");
    Mockito.when(mockReq.getSession().getAttribute("adminLido")).thenReturn(new ResponsabileLido(1, "nome", "indirizzo", "telefono", "email", "logo", 1,1));

    action = new MostraDisponibilitaRespLidoAction();

    String result = action.execute(mockReq, mockRes);
    assertEquals(result, "/WEB-INF/views/respLidoDisponibilita.jsp");
  }

  /**
   *test mostra senza successo la disponiibilità al responsabile lido
   * ()
   */
  @Test
  public void failureTest(){
    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    Mockito.when(mockReq.getParameter("dataInizio")).thenReturn(null);

    action = new MostraDisponibilitaRespLidoAction();

    String result = action.execute(mockReq, mockRes);
    assertEquals(result, "/WEB-INF/views/respLidoDisponibilita.jsp");
  }
}
