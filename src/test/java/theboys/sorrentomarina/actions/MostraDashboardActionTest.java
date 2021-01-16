package theboys.sorrentomarina.actions;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import theboys.sorrentomarina.actions.actionsPrenotazione.MostraDashboardAction;
import theboys.sorrentomarina.actions.actionsUtils.Action;
import theboys.sorrentomarina.models.modelsUtente.ResponsabileLido;

import javax.servlet.ServletContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MostraDashboardActionTest extends ActionSetupDB{

  /**
   * Controlla che la view ritornata è quella corretta, ossia la dashboard
   *
   */
  @Test
  public void executeTest() {
    Action ac = Mockito.mock(MostraDashboardAction.class, Mockito.CALLS_REAL_METHODS);
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);
    Mockito.when(mockReq.getSession().getAttribute("adminLido")).thenReturn(new ResponsabileLido(1, "", "", "", "","",1,1));
    String result = ac.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/respLidoDashboard.jsp", result,
        "It should return the view path");
  }

  @Test
  public void executeTest500() {
    Action ac = Mockito.mock(MostraDashboardAction.class, Mockito.CALLS_REAL_METHODS);
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(null);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);
    Mockito.when(mockReq.getSession().getAttribute("adminLido")).thenReturn(new ResponsabileLido(1, "", "", "", "","",1,1));
    String result = ac.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/500.jsp", result,
        "It should return the view path");
  }

  @Test
  public void executeTest403() {
    Action ac = Mockito.mock(MostraDashboardAction.class, Mockito.CALLS_REAL_METHODS);
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);
    Mockito.when(mockReq.getSession().getAttribute("adminLido")).thenReturn(null);
    String result = ac.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/403.jsp", result,
        "It should return the view path");
  }
}