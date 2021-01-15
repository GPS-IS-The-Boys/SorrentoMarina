package theboys.sorrentomarina.actions;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import theboys.sorrentomarina.actions.actionsUtente.CheckLoginRespLido;
import theboys.sorrentomarina.actions.actionsUtente.CheckLoginTurista;

import javax.servlet.ServletContext;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckLoginTuristaTest extends ActionSetupDB{

  private CheckLoginTurista clt;

  @Test
  public void textExecuteFailure() {
    Mockito.when(mockReq.getParameter("username")).thenReturn("Userna1");
    Mockito.when(mockReq.getParameter("password")).thenReturn("passwo1");
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);

    clt = new CheckLoginTurista();
    clt.setNext(new CheckLoginRespLido());

    String result = clt.execute(mockReq, mockRes);

    assertEquals("/WEB-INF/views/login.jsp", result, "It should return the login page");
  }

  @Test
  public void testExecuteSuccess() {
    clt = new CheckLoginTurista();
    Mockito.when(mockReq.getParameter("username")).thenReturn("Username1");
    Mockito.when(mockReq.getParameter("password")).thenReturn("password1");
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);

    String result = clt.execute(mockReq, mockRes);

    assertEquals("redirect:/SorrentoMarina/", result, "It should return the index page");
  }

}
