package theboys.sorrentomarina.actions;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import theboys.sorrentomarina.actions.actionsRecensione.RimuoviRecensioneAction;
import theboys.sorrentomarina.managers.managersRecensione.RecensioneManager;
import theboys.sorrentomarina.managers.managersRecensione.TableRecensioneManager;
import theboys.sorrentomarina.models.modelsRecensione.Recensione;

import javax.servlet.ServletContext;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class RimuoviRecensioneActionTest extends ActionSetupDB {
  private RimuoviRecensioneAction rra;

  @Test
  public void SuccessTest(){
    Mockito.when(mockReq.getParameter("id")).thenReturn("1");

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);

    rra = new RimuoviRecensioneAction();
    String page = this.rra.execute(mockReq, mockRes);
    RecensioneManager rm = new TableRecensioneManager(mockConnection);
    Recensione r = null;
    try{
      r = rm.retriveById(1);
    } catch (SQLException e){ }
    assertNull(r);
    assertEquals("redirect:/SorrentoMarina/dashboard", page, "Should return dashboard redirect");
  }

  @Test
  public void FailureTest(){
    Mockito.when(mockReq.getParameter("id")).thenReturn("10");

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);

    rra = new RimuoviRecensioneAction();
    String page = this.rra.execute(mockReq, mockRes);
    RecensioneManager rm = new TableRecensioneManager(mockConnection);
    Recensione r = null;
    try{
      r = rm.retriveById(10);
    } catch (SQLException e){ }
    assertNull(r);
    assertEquals("redirect:/SorrentoMarina/dashboard", page, "Should return dashboard redirect");
  }
}
