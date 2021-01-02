package theboys.sorrentomarina.actions;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.servlet.ServletContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModificaCredenzialiActionTest extends ActionSetupDB {

  private ModificaCredenzialiAction mca;

  /**
   * Testa la classe in caso di credenziali errate
   */
  @Test
  public void testModificaCredenzialiFailure(){
    Mockito.when(mockReq.getParameter("oldPassword")).thenReturn("pass1");
    Mockito.when(mockReq.getParameter("newPassword")).thenReturn("pass2");

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    mca = new ModificaCredenzialiAction();

    String page = this.mca.execute(mockReq, mockRes);
    assertEquals("redirect:/SorrentoMarina/profilo", page);
  }

  /**
   * Testa la classe in caso di credenziali corrette
   */
  @Test
  public void testModificaCredenzialiSuccess(){
    Mockito.when(mockReq.getParameter("oldPassword")).thenReturn("password1");
    Mockito.when(mockReq.getParameter("newPassword")).thenReturn("password21");

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    mca = new ModificaCredenzialiAction();

    String page = this.mca.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/login.jsp", page);
  }
}
