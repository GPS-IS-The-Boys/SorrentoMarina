package theboys.sorrentomarina.actions;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import theboys.sorrentomarina.actions.actionsLido.ControllaDisponibilitaAction;
import theboys.sorrentomarina.models.modelsUtente.ResponsabileLido;

import javax.servlet.ServletContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ControllaDisponibilitaActionTest extends ActionSetupDB {

  private ControllaDisponibilitaAction action;

  @Test
  public void successTest(){
    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);

    Mockito.when(mockReq.getParameter("dataInizio")).thenReturn("2021-01-01");
    Mockito.when(mockReq.getParameter("dataFine")).thenReturn("2021-01-01");
    Mockito.when(mockReq.getSession().getAttribute("adminLido")).thenReturn(new ResponsabileLido(1, "nome", "indirizzo", "telefono", "email", "logo", 1,1));

    action = new ControllaDisponibilitaAction();

    String page = this.action.execute(mockReq, mockRes);
    assertEquals("redirect:/SorrentoMarina/mostraDisponibilita", page);
  }

}
