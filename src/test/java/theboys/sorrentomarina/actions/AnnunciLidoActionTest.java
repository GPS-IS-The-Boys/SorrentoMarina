package theboys.sorrentomarina.actions;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import theboys.sorrentomarina.models.Lido;

import javax.servlet.ServletContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnnunciLidoActionTest extends ActionSetupDB{

  private AnnunciLidoAction action;

  /**
   * Testa nel caso il lido sia presente nel db
   */
  @Test
  public void successTest(){

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    Mockito.when(mockReq.getSession().getAttribute("lido")).thenReturn(new Lido(1, "nome", "indirizzo", "telefono", "email", "logo", 5.1F, 2, 2, 1));

    action = new AnnunciLidoAction();

    String page = this.action.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/annunciLido.jsp", page);
  }

  /**
   * Testa nel caso di lido non presente nel db
   */
  @Test
  public void failureTest() {

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    Mockito.when(mockReq.getSession().getAttribute("lido")).thenReturn(new Lido());

    action = new AnnunciLidoAction();

    String page = this.action.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/500.jsp", page);
  }


}
