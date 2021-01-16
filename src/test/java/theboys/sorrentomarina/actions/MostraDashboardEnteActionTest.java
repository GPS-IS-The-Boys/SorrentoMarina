package theboys.sorrentomarina.actions;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import theboys.sorrentomarina.actions.actionsPrenotazione.MostraDashboardEnteAction;
import theboys.sorrentomarina.models.modelsUtente.ResponsabileEnte;

import javax.servlet.ServletContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MostraDashboardEnteActionTest extends ActionSetupDB{

  private MostraDashboardEnteAction action;

  @Test
  public void successExecute(){
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    Mockito.when(mockReq.getSession().getAttribute("adminEnte")).thenReturn(new ResponsabileEnte(1, "", "", "", "", ""));

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);

    action = new MostraDashboardEnteAction();
    String result = action.execute(mockReq, mockRes);
    assertEquals(result, "/WEB-INF/views/respEnteDashboard.jsp");
  }

  @Test
  public void failureAccessExecute(){
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    Mockito.when(mockReq.getSession().getAttribute("adminEnte")).thenReturn(null);
    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);

    action = new MostraDashboardEnteAction();
    String result = action.execute(mockReq, mockRes);
    assertEquals(result, "/WEB-INF/views/403.jsp");
  }
}
