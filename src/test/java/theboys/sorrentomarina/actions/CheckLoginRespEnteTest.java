package theboys.sorrentomarina.actions;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.servlet.ServletContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * @author theBoys
 */
public class CheckLoginRespEnteTest extends ActionSetupDB{

  private CheckLoginRespEnte cre;

  /**
   * Test nel caso fallisce la ricerca nel db del responsabile ente
   */
  @Test
  public void textExecuteFailure() {
    Mockito.when(mockReq.getParameter("username")).thenReturn("Userna1");
    Mockito.when(mockReq.getParameter("password")).thenReturn("pasrd1");
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);

    cre = new CheckLoginRespEnte();

    String result = cre.execute(mockReq, mockRes);

    assertEquals("/WEB-INF/views/login.jsp", result, "It should return the login page");
  }

  /**
   * Test nel caso va buon fine la ricerca nel db del responsabile ente
   */
  @Test
  public void testExecuteSuccess() {
    Mockito.when(mockReq.getParameter("username")).thenReturn("Username1");
    Mockito.when(mockReq.getParameter("password")).thenReturn("password1");
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);

    cre = new CheckLoginRespEnte();

    String result = cre.execute(mockReq, mockRes);

    assertEquals("redirect:/SorrentoMarina/", result, "It should return the index page");
  }

}
