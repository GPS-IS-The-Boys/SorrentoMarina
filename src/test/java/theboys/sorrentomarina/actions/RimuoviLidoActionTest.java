package theboys.sorrentomarina.actions;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import theboys.sorrentomarina.managers.LidoManager;
import theboys.sorrentomarina.managers.TableLidoManager;
import theboys.sorrentomarina.models.Lido;

import javax.servlet.ServletContext;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
/**
 * @author theBoys
 */
public class RimuoviLidoActionTest extends ActionSetupDB{

  private RimuoviLidoAction rla;

  /**
   * Test- rimuove il lido
   */
  @Test
  public void SuccessTest(){
    Mockito.when(mockReq.getParameter("id")).thenReturn("1");

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);

    rla = new RimuoviLidoAction();
    String page = this.rla.execute(mockReq, mockRes);
    LidoManager lm = new TableLidoManager(mockConnection);
    Lido l = null;
    try{
      l = lm.retriveById(1);
    } catch (SQLException e){ }
    assertNull(l);
    assertEquals("redirect:/SorrentoMarina/dashboardEnte", page, "Should return dashboard redirect");
  }

  @Test
  public void FailureTest(){
    Mockito.when(mockReq.getParameter("id")).thenReturn(String.valueOf(10));

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);

    rla = new RimuoviLidoAction();
    String page = this.rla.execute(mockReq, mockRes);
    LidoManager lm = new TableLidoManager(mockConnection);
    Lido l = null;
    try{
      l = lm.retriveById(10);
    } catch (SQLException e){ }
    assertNull(l);
    assertEquals("/WEB-INF/views/500.jsp", page, "Should return 500 jsp");
  }
}