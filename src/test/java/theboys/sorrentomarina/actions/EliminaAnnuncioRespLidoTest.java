package theboys.sorrentomarina.actions;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import theboys.sorrentomarina.managers.AnnuncioManager;
import theboys.sorrentomarina.managers.TableAnnuncioManager;
import theboys.sorrentomarina.models.Annuncio;

import javax.servlet.ServletContext;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class EliminaAnnuncioRespLidoTest extends ActionSetupDB {

  private EliminaAnnuncioRespLido action;

  /**
   * Test nel caso viene eliminato l'annuncio
   */
  @Test
  public void eliminaAnnuncioTestExecuteSuccess(){
    Mockito.when(mockReq.getParameter("id")).thenReturn("1");
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);
    action = new EliminaAnnuncioRespLido();
    String page = this.action.execute(mockReq, mockRes);

    AnnuncioManager am = new TableAnnuncioManager(mockConnection);
    Annuncio a = null;
    try {
      a = am.retriveById(1);
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    assertNull(a);
    assertEquals("redirect:/SorrentoMarina/dashboard", page);
  }

  /**
   * Test nel caso l'annuncio non viene eliminato
   */
  @Test
  public void eliminaAnnuncioTestFailureSuccess(){
    Mockito.when(mockReq.getParameter("id")).thenReturn("50");
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);
    action = new EliminaAnnuncioRespLido();
    String page = this.action.execute(mockReq, mockRes);
    AnnuncioManager am = new TableAnnuncioManager(mockConnection);
    Annuncio a = null;
    try {
      a = am.retriveById(50);
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }

    assertNull(a);
    assertEquals("redirect:/SorrentoMarina/dashboard", page);
  }

}
