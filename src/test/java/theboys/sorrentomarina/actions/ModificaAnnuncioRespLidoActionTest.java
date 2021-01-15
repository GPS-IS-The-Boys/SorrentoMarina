package theboys.sorrentomarina.actions;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import theboys.sorrentomarina.actions.actionsAnnuncio.ModificaAnnuncioRespLidoAction;
import theboys.sorrentomarina.models.modelsUtente.ResponsabileLido;

import javax.servlet.ServletContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ModificaAnnuncioRespLidoActionTest extends ActionSetupDB {

  private ModificaAnnuncioRespLidoAction action;

  @Test
  public void executeSuccess(){
    Mockito.when(mockReq.getParameter("titolo")).thenReturn("Prova titolo");
    Mockito.when(mockReq.getParameter("foto")).thenReturn("foto");
    Mockito.when(mockReq.getParameter("contenuto")).thenReturn("contenuto dell'annuncio");
    Mockito.when(mockReq.getParameter("id")).thenReturn("1");

    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    Mockito.when(mockReq.getSession().getAttribute("adminLido")).thenReturn(new ResponsabileLido(1,"", "a", "", "", "",1));

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);

    action = new ModificaAnnuncioRespLidoAction();
    String page = this.action.execute(mockReq, mockRes);

    assertEquals("redirect:/SorrentoMarina/dashboard", page);
  }


}
