package theboys.sorrentomarina.actions;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import theboys.sorrentomarina.models.ResponsabileEnte;
import theboys.sorrentomarina.models.ResponsabileLido;
import theboys.sorrentomarina.models.Turista;

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
    Mockito.when(mockReq.getSession().getAttribute("utente")).thenReturn(new Turista());
    Mockito.when(mockReq.getSession().getAttribute("adminLido")).thenReturn(new ResponsabileLido());
    Mockito.when(mockReq.getSession().getAttribute("adminEnte")).thenReturn(new ResponsabileEnte());

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
    Mockito.when(mockReq.getSession().getAttribute("utente")).thenReturn(new Turista(1,"Nome1", "Cognome1", "Email1", "Username1", "password1"));
    Mockito.when(mockReq.getSession().getAttribute("adminLido")).thenReturn(new ResponsabileLido());
    Mockito.when(mockReq.getSession().getAttribute("adminEnte")).thenReturn(new ResponsabileEnte());

    mca = new ModificaCredenzialiAction();
    String page = this.mca.execute(mockReq, mockRes);
    assertEquals("redirect:/SorrentoMarina/login", page);
  }
}
