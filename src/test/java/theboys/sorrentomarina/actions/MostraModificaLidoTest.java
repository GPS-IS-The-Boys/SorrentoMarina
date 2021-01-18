package theboys.sorrentomarina.actions;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import theboys.sorrentomarina.actions.actionsLido.MostraModificaLido;
import theboys.sorrentomarina.models.modelsUtente.ResponsabileLido;

import javax.servlet.ServletContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * @author theBoys
 */
public class MostraModificaLidoTest extends ActionSetupDB {

  private MostraModificaLido action;

  /**
   * Test nel caso di successo
   * mostra il form di modifica lido
   */
  @Test
  public void SuccessTest(){
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    Mockito.when(mockReq.getSession().getAttribute("adminLido")).thenReturn(new ResponsabileLido(1,"", "", "", "","",2,1));

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);

    action = new MostraModificaLido();
    String page = this.action.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/respLidoModifica.jsp", page);
  }

  /**
   * Test nel caso di insuccesso
   * mostra l'homepage
   */
  @Test
  public void FailureTest(){
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    Mockito.when(mockReq.getSession().getAttribute("adminLido")).thenReturn(null);

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);

    action = new MostraModificaLido();
    String page = this.action.execute(mockReq, mockRes);
    assertEquals("redirect:/SorrentoMarina/dashboard", page);
  }
}
