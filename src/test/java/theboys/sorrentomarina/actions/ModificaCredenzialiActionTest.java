package theboys.sorrentomarina.actions;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import theboys.sorrentomarina.actions.actionsUtente.ModificaCredenzialiAction;
import theboys.sorrentomarina.models.modelsUtente.ResponsabileEnte;
import theboys.sorrentomarina.models.modelsUtente.ResponsabileLido;
import theboys.sorrentomarina.models.modelsUtente.Turista;

import javax.servlet.ServletContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModificaCredenzialiActionTest extends ActionSetupDB {

  private ModificaCredenzialiAction mca;

  /**
   * Testa la classe in caso di credenziali errate
   */
  @Test
  public void testTuristaModificaCredenzialiFailure(){
    Mockito.when(mockReq.getParameter("oldPassword")).thenReturn("Password1");
    Mockito.when(mockReq.getParameter("newPassword")).thenReturn("Password2");
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
  public void testTuristaModificaCredenzialiSuccess(){
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

  /**
   * Testa la classe in caso di credenziali giuste per il responsabile lido
   */
  @Test
  public void testRespLidoModificaCredenzialiSuccess(){
    Mockito.when(mockReq.getParameter("oldPassword")).thenReturn("password1");
    Mockito.when(mockReq.getParameter("newPassword")).thenReturn("password22");

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);

    mca = new ModificaCredenzialiAction();

    Mockito.when(mockReq.getSession().getAttribute("utente")).thenReturn(null);
    Mockito.when(mockReq.getSession().getAttribute("adminLido")).thenReturn(new ResponsabileLido(1, "Nome1", "Cognome1", "Email1","Username1","password1",1));
    Mockito.when(mockReq.getSession().getAttribute("adminEnte")).thenReturn(new ResponsabileEnte());

    String page = this.mca.execute(mockReq, mockRes);
    assertEquals("redirect:/SorrentoMarina/login", page);
  }

  /**
   * Testa la classe in caso di credenziali errate per il responsabile lido
   */
  @Test
  public void testRespLidoModificaCredenzialiFailure(){
    Mockito.when(mockReq.getParameter("oldPassword")).thenReturn("pass1");
    Mockito.when(mockReq.getParameter("newPassword")).thenReturn("pass2");
    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    mca = new ModificaCredenzialiAction();
    Mockito.when(mockReq.getSession().getAttribute("utente")).thenReturn(new Turista());
    Mockito.when(mockReq.getSession().getAttribute("adminLido")).thenReturn(new ResponsabileLido(1, "Nome1", "Cognome1", "Email1","Username1","password1",1));
    Mockito.when(mockReq.getSession().getAttribute("adminEnte")).thenReturn(new ResponsabileEnte());

    String page = this.mca.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/profilo.jsp", page);
  }

  /**
   * Testa la classe in caso di credenziali giuste per il responsabile ente
   */
  @Test
  public void testRespEnteModificaCredenzialiSuccess(){
    Mockito.when(mockReq.getParameter("oldPassword")).thenReturn("password1");
    Mockito.when(mockReq.getParameter("newPassword")).thenReturn("password22");

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);

    mca = new ModificaCredenzialiAction();

    Mockito.when(mockReq.getSession().getAttribute("utente")).thenReturn(null);
    Mockito.when(mockReq.getSession().getAttribute("adminLido")).thenReturn(null);
    Mockito.when(mockReq.getSession().getAttribute("adminEnte")).thenReturn(new ResponsabileEnte(1, "Nome1", "Cognome1", "Email1","Username1","password1"));

    String page = this.mca.execute(mockReq, mockRes);
    assertEquals("redirect:/SorrentoMarina/login", page);
  }

  /**
   * Testa la classe in caso di credenziali errate per il responsabile ente
   */
  @Test
  public void testRespEnteModificaCredenzialiFailure(){
    Mockito.when(mockReq.getParameter("oldPassword")).thenReturn("pass1");
    Mockito.when(mockReq.getParameter("newPassword")).thenReturn("pass2");
    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    mca = new ModificaCredenzialiAction();
    Mockito.when(mockReq.getSession().getAttribute("utente")).thenReturn(new Turista());
    Mockito.when(mockReq.getSession().getAttribute("adminLido")).thenReturn(new ResponsabileLido());
    Mockito.when(mockReq.getSession().getAttribute("adminEnte")).thenReturn(new ResponsabileEnte(1, "Nome1", "Cognome1", "Email1","Username1","password1"));

    String page = this.mca.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/profilo.jsp", page);
  }

  /**
   * Testa la classe in caso di credenziali scorrette
   */
  @Test
  public void ModificaCredenzialiBadOldPassword(){
    Mockito.when(mockReq.getParameter("oldPassword")).thenReturn(null);
    Mockito.when(mockReq.getParameter("newPassword")).thenReturn("Password21");

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    Mockito.when(mockReq.getSession().getAttribute("utente")).thenReturn(new Turista(1,"Nome1", "Cognome1", "Email1", "Username1", "password1"));
    Mockito.when(mockReq.getSession().getAttribute("adminLido")).thenReturn(new ResponsabileLido());
    Mockito.when(mockReq.getSession().getAttribute("adminEnte")).thenReturn(new ResponsabileEnte());

    mca = new ModificaCredenzialiAction();
    String page = this.mca.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/profilo.jsp", page);
  }

  /**
   * Testa la classe in caso di credenziali scorrette
   */
  @Test
  public void ModificaCredenzialiBadNewPassword(){
    Mockito.when(mockReq.getParameter("oldPassword")).thenReturn("Password1");
    Mockito.when(mockReq.getParameter("newPassword")).thenReturn(null);

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    Mockito.when(mockReq.getSession().getAttribute("utente")).thenReturn(new Turista(1,"Nome1", "Cognome1", "Email1", "Username1", "password1"));
    Mockito.when(mockReq.getSession().getAttribute("adminLido")).thenReturn(new ResponsabileLido());
    Mockito.when(mockReq.getSession().getAttribute("adminEnte")).thenReturn(new ResponsabileEnte());

    mca = new ModificaCredenzialiAction();
    String page = this.mca.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/profilo.jsp", page);
  }

  @Test
  public void ModificaCredenzialiLenghtOldPassword(){
    Mockito.when(mockReq.getParameter("oldPassword")).thenReturn("");
    Mockito.when(mockReq.getParameter("newPassword")).thenReturn("Password21");

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    Mockito.when(mockReq.getSession().getAttribute("utente")).thenReturn(new Turista(1,"Nome1", "Cognome1", "Email1", "Username1", "password1"));
    Mockito.when(mockReq.getSession().getAttribute("adminLido")).thenReturn(new ResponsabileLido());
    Mockito.when(mockReq.getSession().getAttribute("adminEnte")).thenReturn(new ResponsabileEnte());

    mca = new ModificaCredenzialiAction();
    String page = this.mca.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/profilo.jsp", page);
  }

  /**
   * Testa la classe in caso di credenziali scorrette
   */
  @Test
  public void ModificaCredenzialiLenghtNewPassword(){
    Mockito.when(mockReq.getParameter("oldPassword")).thenReturn("Password1");
    Mockito.when(mockReq.getParameter("newPassword")).thenReturn("");

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    Mockito.when(mockReq.getSession().getAttribute("utente")).thenReturn(new Turista(1,"Nome1", "Cognome1", "Email1", "Username1", "password1"));
    Mockito.when(mockReq.getSession().getAttribute("adminLido")).thenReturn(new ResponsabileLido());
    Mockito.when(mockReq.getSession().getAttribute("adminEnte")).thenReturn(new ResponsabileEnte());

    mca = new ModificaCredenzialiAction();
    String page = this.mca.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/profilo.jsp", page);
  }

  @Test
  public void ModificaCredenzialiFormatOldPassword(){
    Mockito.when(mockReq.getParameter("oldPassword")).thenReturn("pass");
    Mockito.when(mockReq.getParameter("newPassword")).thenReturn("Password21");

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    Mockito.when(mockReq.getSession().getAttribute("utente")).thenReturn(new Turista(1,"Nome1", "Cognome1", "Email1", "Username1", "password1"));
    Mockito.when(mockReq.getSession().getAttribute("adminLido")).thenReturn(new ResponsabileLido());
    Mockito.when(mockReq.getSession().getAttribute("adminEnte")).thenReturn(new ResponsabileEnte());

    mca = new ModificaCredenzialiAction();
    String page = this.mca.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/profilo.jsp", page);
  }

  /**
   * Testa la classe in caso di credenziali scorrette
   */
  @Test
  public void ModificaCredenzialiFormatNewPassword(){
    Mockito.when(mockReq.getParameter("oldPassword")).thenReturn("password1");
    Mockito.when(mockReq.getParameter("newPassword")).thenReturn("pass");

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    Mockito.when(mockReq.getSession().getAttribute("utente")).thenReturn(new Turista(1,"Nome1", "Cognome1", "Email1", "Username1", "password1"));
    Mockito.when(mockReq.getSession().getAttribute("adminLido")).thenReturn(new ResponsabileLido());
    Mockito.when(mockReq.getSession().getAttribute("adminEnte")).thenReturn(new ResponsabileEnte());

    mca = new ModificaCredenzialiAction();
    String page = this.mca.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/profilo.jsp", page);
  }

  @Test
  public void ModificaCredenzialiRespLidoPasswordNonCoincidono(){
    Mockito.when(mockReq.getParameter("oldPassword")).thenReturn("pa1");
    Mockito.when(mockReq.getParameter("newPassword")).thenReturn("Password2");

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    Mockito.when(mockReq.getSession().getAttribute("utente")).thenReturn(new Turista());
    Mockito.when(mockReq.getSession().getAttribute("adminLido")).thenReturn(new ResponsabileLido(1, "", "", "", "", "",1));
    Mockito.when(mockReq.getSession().getAttribute("adminEnte")).thenReturn(new ResponsabileEnte());

    mca = new ModificaCredenzialiAction();
    String page = this.mca.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/profilo.jsp", page);
  }

  @Test
  public void ModificaCredenzialiRespEntePasswordNonCoincidono(){
    Mockito.when(mockReq.getParameter("oldPassword")).thenReturn("pa1");
    Mockito.when(mockReq.getParameter("newPassword")).thenReturn("Password2");

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    Mockito.when(mockReq.getSession().getAttribute("utente")).thenReturn(new Turista());
    Mockito.when(mockReq.getSession().getAttribute("adminLido")).thenReturn(new ResponsabileLido());
    Mockito.when(mockReq.getSession().getAttribute("adminEnte")).thenReturn(new ResponsabileEnte(1, "", "", "", "", ""));

    mca = new ModificaCredenzialiAction();
    String page = this.mca.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/profilo.jsp", page);
  }
}
