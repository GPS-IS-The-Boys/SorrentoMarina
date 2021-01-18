package theboys.sorrentomarina.actions;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import theboys.sorrentomarina.actions.actionsLido.ModificaLidoAction;
import theboys.sorrentomarina.managers.managersLido.LidoManager;
import theboys.sorrentomarina.managers.managersLido.ServizioManager;
import theboys.sorrentomarina.managers.managersLido.TableLidoManager;
import theboys.sorrentomarina.managers.managersLido.TableServizioManager;
import theboys.sorrentomarina.models.modelsLido.Lido;
import theboys.sorrentomarina.models.modelsUtente.ResponsabileLido;
import theboys.sorrentomarina.models.modelsLido.Servizio;

import javax.servlet.ServletContext;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * @author theBoys
 */
public class ModificaLidoActionTest extends ActionSetupDB {

  private ModificaLidoAction action;


  /**
   * Test nel caso il lido viene correttamente modificato
   */
  @Test
  public void ModificaLidoTestSuccess(){
    //parametri del lido
    Mockito.when(mockReq.getParameter("nomeLido")).thenReturn("modificaNome");
    Mockito.when(mockReq.getParameter("indirizzoLido")).thenReturn("indirizzo");
    Mockito.when(mockReq.getParameter("emailLido")).thenReturn("em@gmail.com");
    Mockito.when(mockReq.getParameter("telefonoLido")).thenReturn("123456789");
    Mockito.when(mockReq.getParameter("logoLido")).thenReturn("/images/foto.png");
    Mockito.when(mockReq.getParameter("prezzoLido")).thenReturn("10.5");
    Mockito.when(mockReq.getParameter("righeLido")).thenReturn("1");
    Mockito.when(mockReq.getParameter("colonneLido")).thenReturn("1");
    //parametri del servizio
    Mockito.when(mockReq.getParameter("servizio1")).thenReturn("false");
    Mockito.when(mockReq.getParameter("servizio2")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio3")).thenReturn("false");
    Mockito.when(mockReq.getParameter("servizio4")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio5")).thenReturn("false");
    Mockito.when(mockReq.getParameter("servizio6")).thenReturn("false");
    Mockito.when(mockReq.getParameter("servizio7")).thenReturn("false");

    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    Mockito.when(mockReq.getSession().getAttribute("adminLido")).thenReturn(new ResponsabileLido(1,"", "a", "", "", "",1,1));

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);

    action = new ModificaLidoAction();

    String page = this.action.execute(mockReq, mockRes);

    LidoManager lm = new TableLidoManager(mockConnection);
    ServizioManager sm = new TableServizioManager(mockConnection);

    Lido l = null;
    Servizio s = null;
    try {
      l = lm.retriveById(1);
      s = sm.retriveById(l.getId_servizi());
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }

    assert l != null;
    assertEquals(l.getNome(), "modificaNome", "Devo risultare il nome modificato");
    assert s != null;
    assertEquals(s.isBar(), Boolean.TRUE, "Devo risultare il servizio modificato");

    assertEquals("redirect:/SorrentoMarina/dashboard", page);
  }

  /**
   * Test nel caso il lido viene correttamente modificato
   */
  @Test
  public void ModificaLidoTestSuccess2(){
    //parametri del lido
    Mockito.when(mockReq.getParameter("nomeLido")).thenReturn("modificaNome");
    Mockito.when(mockReq.getParameter("indirizzoLido")).thenReturn("indirizzo");
    Mockito.when(mockReq.getParameter("emailLido")).thenReturn("em@gmail.com");
    Mockito.when(mockReq.getParameter("telefonoLido")).thenReturn("123456789");
    Mockito.when(mockReq.getParameter("logoLido")).thenReturn("/images/foto.png");
    Mockito.when(mockReq.getParameter("prezzoLido")).thenReturn("10.5");
    Mockito.when(mockReq.getParameter("righeLido")).thenReturn("1");
    Mockito.when(mockReq.getParameter("colonneLido")).thenReturn("1");
    //parametri del servizio
    Mockito.when(mockReq.getParameter("servizio1")).thenReturn(null);
    Mockito.when(mockReq.getParameter("servizio2")).thenReturn(null);
    Mockito.when(mockReq.getParameter("servizio3")).thenReturn(null);
    Mockito.when(mockReq.getParameter("servizio4")).thenReturn(null);
    Mockito.when(mockReq.getParameter("servizio5")).thenReturn(null);
    Mockito.when(mockReq.getParameter("servizio6")).thenReturn(null);
    Mockito.when(mockReq.getParameter("servizio7")).thenReturn(null);

    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    Mockito.when(mockReq.getSession().getAttribute("adminLido")).thenReturn(new ResponsabileLido(1,"", "a", "", "", "",1,1));

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);

    action = new ModificaLidoAction();

    String page = this.action.execute(mockReq, mockRes);

    LidoManager lm = new TableLidoManager(mockConnection);
    ServizioManager sm = new TableServizioManager(mockConnection);

    Lido l = null;
    Servizio s = null;
    try {
      l = lm.retriveById(1);
      s = sm.retriveById(l.getId_servizi());
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }

    assert l != null;
    assertEquals(l.getNome(), "modificaNome", "Devo risultare il nome modificato");
    assert s != null;
    assertEquals(s.isBar(), Boolean.FALSE, "Devo risultare il servizio modificato");

    assertEquals("redirect:/SorrentoMarina/dashboard", page);
  }


  @Test
  public void ModificaLidoTestNomeLidoNull(){
    //parametri del lido
    Mockito.when(mockReq.getParameter("nomeLido")).thenReturn(null);
    Mockito.when(mockReq.getParameter("indirizzoLido")).thenReturn("indirizzo");
    Mockito.when(mockReq.getParameter("emailLido")).thenReturn("em@gmail.com");
    Mockito.when(mockReq.getParameter("telefonoLido")).thenReturn("123456789");
    Mockito.when(mockReq.getParameter("logoLido")).thenReturn("/images/foto.png");
    Mockito.when(mockReq.getParameter("prezzoLido")).thenReturn("10.5");
    Mockito.when(mockReq.getParameter("righeLido")).thenReturn("1");
    Mockito.when(mockReq.getParameter("colonneLido")).thenReturn("1");
    //parametri del servizio
    Mockito.when(mockReq.getParameter("servizio1")).thenReturn("false");
    Mockito.when(mockReq.getParameter("servizio2")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio3")).thenReturn("false");
    Mockito.when(mockReq.getParameter("servizio4")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio5")).thenReturn("false");
    Mockito.when(mockReq.getParameter("servizio6")).thenReturn("false");
    Mockito.when(mockReq.getParameter("servizio7")).thenReturn("false");

    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    Mockito.when(mockReq.getSession().getAttribute("adminLido")).thenReturn(new ResponsabileLido(1,"", "a", "", "", "",1,1));

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);

    action = new ModificaLidoAction();

    String page = this.action.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/respLidoModifica.jsp", page);
  }

  @Test
  public void ModificaLidoTestIndirizzoLidoNull(){
    //parametri del lido
    Mockito.when(mockReq.getParameter("nomeLido")).thenReturn("nome lido");
    Mockito.when(mockReq.getParameter("indirizzoLido")).thenReturn(null);
    Mockito.when(mockReq.getParameter("emailLido")).thenReturn("em@gmail.com");
    Mockito.when(mockReq.getParameter("telefonoLido")).thenReturn("123456789");
    Mockito.when(mockReq.getParameter("logoLido")).thenReturn("/images/foto.png");
    Mockito.when(mockReq.getParameter("prezzoLido")).thenReturn("10.5");
    Mockito.when(mockReq.getParameter("righeLido")).thenReturn("1");
    Mockito.when(mockReq.getParameter("colonneLido")).thenReturn("1");
    //parametri del servizio
    Mockito.when(mockReq.getParameter("servizio1")).thenReturn("false");
    Mockito.when(mockReq.getParameter("servizio2")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio3")).thenReturn("false");
    Mockito.when(mockReq.getParameter("servizio4")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio5")).thenReturn("false");
    Mockito.when(mockReq.getParameter("servizio6")).thenReturn("false");
    Mockito.when(mockReq.getParameter("servizio7")).thenReturn("false");

    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    Mockito.when(mockReq.getSession().getAttribute("adminLido")).thenReturn(new ResponsabileLido(1,"", "a", "", "", "",1,1));

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);

    action = new ModificaLidoAction();

    String page = this.action.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/respLidoModifica.jsp", page);
  }

  @Test
  public void ModificaLidoTestEmailNull(){
    //parametri del lido
    Mockito.when(mockReq.getParameter("nomeLido")).thenReturn("nome lido");
    Mockito.when(mockReq.getParameter("indirizzoLido")).thenReturn("indirizzo");
    Mockito.when(mockReq.getParameter("emailLido")).thenReturn(null);
    Mockito.when(mockReq.getParameter("telefonoLido")).thenReturn("123456789");
    Mockito.when(mockReq.getParameter("logoLido")).thenReturn("/images/foto.png");
    Mockito.when(mockReq.getParameter("prezzoLido")).thenReturn("10.5");
    Mockito.when(mockReq.getParameter("righeLido")).thenReturn("1");
    Mockito.when(mockReq.getParameter("colonneLido")).thenReturn("1");
    //parametri del servizio
    Mockito.when(mockReq.getParameter("servizio1")).thenReturn("false");
    Mockito.when(mockReq.getParameter("servizio2")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio3")).thenReturn("false");
    Mockito.when(mockReq.getParameter("servizio4")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio5")).thenReturn("false");
    Mockito.when(mockReq.getParameter("servizio6")).thenReturn("false");
    Mockito.when(mockReq.getParameter("servizio7")).thenReturn("false");

    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    Mockito.when(mockReq.getSession().getAttribute("adminLido")).thenReturn(new ResponsabileLido(1,"", "a", "", "", "",1,1));

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);

    action = new ModificaLidoAction();

    String page = this.action.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/respLidoModifica.jsp", page);
  }

  @Test
  public void ModificaLidoTestTelefonoNull(){
    //parametri del lido
    Mockito.when(mockReq.getParameter("nomeLido")).thenReturn("nome lido");
    Mockito.when(mockReq.getParameter("indirizzoLido")).thenReturn("indirizzo");
    Mockito.when(mockReq.getParameter("emailLido")).thenReturn("em@gmail.com");
    Mockito.when(mockReq.getParameter("telefonoLido")).thenReturn(null);
    Mockito.when(mockReq.getParameter("logoLido")).thenReturn("/images/foto.png");
    Mockito.when(mockReq.getParameter("prezzoLido")).thenReturn("10.5");
    Mockito.when(mockReq.getParameter("righeLido")).thenReturn("1");
    Mockito.when(mockReq.getParameter("colonneLido")).thenReturn("1");
    //parametri del servizio
    Mockito.when(mockReq.getParameter("servizio1")).thenReturn("false");
    Mockito.when(mockReq.getParameter("servizio2")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio3")).thenReturn("false");
    Mockito.when(mockReq.getParameter("servizio4")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio5")).thenReturn("false");
    Mockito.when(mockReq.getParameter("servizio6")).thenReturn("false");
    Mockito.when(mockReq.getParameter("servizio7")).thenReturn("false");

    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    Mockito.when(mockReq.getSession().getAttribute("adminLido")).thenReturn(new ResponsabileLido(1,"", "a", "", "", "",1,1));

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);

    action = new ModificaLidoAction();

    String page = this.action.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/respLidoModifica.jsp", page);
  }

  @Test
  public void ModificaLidoTestLogoNull(){
    //parametri del lido
    Mockito.when(mockReq.getParameter("nomeLido")).thenReturn("nome lido");
    Mockito.when(mockReq.getParameter("indirizzoLido")).thenReturn("indirizzo");
    Mockito.when(mockReq.getParameter("emailLido")).thenReturn("em@gmail.com");
    Mockito.when(mockReq.getParameter("telefonoLido")).thenReturn("123456789");
    Mockito.when(mockReq.getParameter("logoLido")).thenReturn("/image");
    Mockito.when(mockReq.getParameter("prezzoLido")).thenReturn("10.5");
    Mockito.when(mockReq.getParameter("righeLido")).thenReturn("1");
    Mockito.when(mockReq.getParameter("colonneLido")).thenReturn("1");
    //parametri del servizio
    Mockito.when(mockReq.getParameter("servizio1")).thenReturn("false");
    Mockito.when(mockReq.getParameter("servizio2")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio3")).thenReturn("false");
    Mockito.when(mockReq.getParameter("servizio4")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio5")).thenReturn("false");
    Mockito.when(mockReq.getParameter("servizio6")).thenReturn("false");
    Mockito.when(mockReq.getParameter("servizio7")).thenReturn("false");

    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    Mockito.when(mockReq.getSession().getAttribute("adminLido")).thenReturn(new ResponsabileLido(1,"", "a", "", "", "",1,1));

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);

    action = new ModificaLidoAction();

    String page = this.action.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/respLidoModifica.jsp", page);
  }

  @Test
  public void ModificaLidoTestPrezzoNull(){
    //parametri del lido
    Mockito.when(mockReq.getParameter("nomeLido")).thenReturn("nome lido");
    Mockito.when(mockReq.getParameter("indirizzoLido")).thenReturn("indirizzo");
    Mockito.when(mockReq.getParameter("emailLido")).thenReturn("em@gmail.com");
    Mockito.when(mockReq.getParameter("telefonoLido")).thenReturn("123456789");
    Mockito.when(mockReq.getParameter("logoLido")).thenReturn("/images/foto.png");
    Mockito.when(mockReq.getParameter("prezzoLido")).thenReturn(null);
    Mockito.when(mockReq.getParameter("righeLido")).thenReturn("1");
    Mockito.when(mockReq.getParameter("colonneLido")).thenReturn("1");
    //parametri del servizio
    Mockito.when(mockReq.getParameter("servizio1")).thenReturn("false");
    Mockito.when(mockReq.getParameter("servizio2")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio3")).thenReturn("false");
    Mockito.when(mockReq.getParameter("servizio4")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio5")).thenReturn("false");
    Mockito.when(mockReq.getParameter("servizio6")).thenReturn("false");
    Mockito.when(mockReq.getParameter("servizio7")).thenReturn("false");

    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    Mockito.when(mockReq.getSession().getAttribute("adminLido")).thenReturn(new ResponsabileLido(1,"", "a", "", "", "",1,1));

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);

    action = new ModificaLidoAction();

    String page = this.action.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/respLidoModifica.jsp", page);
  }

  @Test
  public void ModificaLidoTestRigheNull(){
    //parametri del lido
    Mockito.when(mockReq.getParameter("nomeLido")).thenReturn("nome lido");
    Mockito.when(mockReq.getParameter("indirizzoLido")).thenReturn("indirizzo");
    Mockito.when(mockReq.getParameter("emailLido")).thenReturn("em@gmail.com");
    Mockito.when(mockReq.getParameter("telefonoLido")).thenReturn("123456789");
    Mockito.when(mockReq.getParameter("logoLido")).thenReturn("/images/foto.png");
    Mockito.when(mockReq.getParameter("prezzoLido")).thenReturn("10.5");
    Mockito.when(mockReq.getParameter("righeLido")).thenReturn(null);
    Mockito.when(mockReq.getParameter("colonneLido")).thenReturn("1");
    //parametri del servizio
    Mockito.when(mockReq.getParameter("servizio1")).thenReturn("false");
    Mockito.when(mockReq.getParameter("servizio2")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio3")).thenReturn("false");
    Mockito.when(mockReq.getParameter("servizio4")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio5")).thenReturn("false");
    Mockito.when(mockReq.getParameter("servizio6")).thenReturn("false");
    Mockito.when(mockReq.getParameter("servizio7")).thenReturn("false");

    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    Mockito.when(mockReq.getSession().getAttribute("adminLido")).thenReturn(new ResponsabileLido(1,"", "a", "", "", "",1,1));

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);

    action = new ModificaLidoAction();

    String page = this.action.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/respLidoModifica.jsp", page);
  }

  @Test
  public void ModificaLidoTestColonneNull(){
    //parametri del lido
    Mockito.when(mockReq.getParameter("nomeLido")).thenReturn("nome lido");
    Mockito.when(mockReq.getParameter("indirizzoLido")).thenReturn("indirizzo");
    Mockito.when(mockReq.getParameter("emailLido")).thenReturn("em@gmail.com");
    Mockito.when(mockReq.getParameter("telefonoLido")).thenReturn("123456789");
    Mockito.when(mockReq.getParameter("logoLido")).thenReturn("/images/foto.png");
    Mockito.when(mockReq.getParameter("prezzoLido")).thenReturn("10.5");
    Mockito.when(mockReq.getParameter("righeLido")).thenReturn("1");
    Mockito.when(mockReq.getParameter("colonneLido")).thenReturn(null);
    //parametri del servizio
    Mockito.when(mockReq.getParameter("servizio1")).thenReturn("false");
    Mockito.when(mockReq.getParameter("servizio2")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio3")).thenReturn("false");
    Mockito.when(mockReq.getParameter("servizio4")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio5")).thenReturn("false");
    Mockito.when(mockReq.getParameter("servizio6")).thenReturn("false");
    Mockito.when(mockReq.getParameter("servizio7")).thenReturn("false");

    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    Mockito.when(mockReq.getSession().getAttribute("adminLido")).thenReturn(new ResponsabileLido(1,"", "a", "", "", "",1,1));

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);

    action = new ModificaLidoAction();

    String page = this.action.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/respLidoModifica.jsp", page);
  }

  @Test
  public void ModificaLidoTestNomeLidoLenght(){
    //parametri del lido
    Mockito.when(mockReq.getParameter("nomeLido")).thenReturn("");
    Mockito.when(mockReq.getParameter("indirizzoLido")).thenReturn("indirizzo");
    Mockito.when(mockReq.getParameter("emailLido")).thenReturn("em@gmail.com");
    Mockito.when(mockReq.getParameter("telefonoLido")).thenReturn("123456789");
    Mockito.when(mockReq.getParameter("logoLido")).thenReturn("/images/foto.png");
    Mockito.when(mockReq.getParameter("prezzoLido")).thenReturn("10.5");
    Mockito.when(mockReq.getParameter("righeLido")).thenReturn("1");
    Mockito.when(mockReq.getParameter("colonneLido")).thenReturn("1");
    //parametri del servizio
    Mockito.when(mockReq.getParameter("servizio1")).thenReturn("false");
    Mockito.when(mockReq.getParameter("servizio2")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio3")).thenReturn("false");
    Mockito.when(mockReq.getParameter("servizio4")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio5")).thenReturn("false");
    Mockito.when(mockReq.getParameter("servizio6")).thenReturn("false");
    Mockito.when(mockReq.getParameter("servizio7")).thenReturn("false");

    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    Mockito.when(mockReq.getSession().getAttribute("adminLido")).thenReturn(new ResponsabileLido(1,"", "a", "", "", "",1,1));

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);

    action = new ModificaLidoAction();

    String page = this.action.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/respLidoModifica.jsp", page);
  }

  @Test
  public void ModificaLidoTestIndirizzoLidoLenght(){
    //parametri del lido
    Mockito.when(mockReq.getParameter("nomeLido")).thenReturn("nome lido");
    Mockito.when(mockReq.getParameter("indirizzoLido")).thenReturn("");
    Mockito.when(mockReq.getParameter("emailLido")).thenReturn("em@gmail.com");
    Mockito.when(mockReq.getParameter("telefonoLido")).thenReturn("123456789");
    Mockito.when(mockReq.getParameter("logoLido")).thenReturn("/images/foto.png");
    Mockito.when(mockReq.getParameter("prezzoLido")).thenReturn("10.5");
    Mockito.when(mockReq.getParameter("righeLido")).thenReturn("1");
    Mockito.when(mockReq.getParameter("colonneLido")).thenReturn("1");
    //parametri del servizio
    Mockito.when(mockReq.getParameter("servizio1")).thenReturn("false");
    Mockito.when(mockReq.getParameter("servizio2")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio3")).thenReturn("false");
    Mockito.when(mockReq.getParameter("servizio4")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio5")).thenReturn("false");
    Mockito.when(mockReq.getParameter("servizio6")).thenReturn("false");
    Mockito.when(mockReq.getParameter("servizio7")).thenReturn("false");

    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    Mockito.when(mockReq.getSession().getAttribute("adminLido")).thenReturn(new ResponsabileLido(1,"", "a", "", "", "",1,1));

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);

    action = new ModificaLidoAction();

    String page = this.action.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/respLidoModifica.jsp", page);
  }

  @Test
  public void ModificaLidoTestEmailFormat(){
    //parametri del lido
    Mockito.when(mockReq.getParameter("nomeLido")).thenReturn("nome lido");
    Mockito.when(mockReq.getParameter("indirizzoLido")).thenReturn("indirizzo");
    Mockito.when(mockReq.getParameter("emailLido")).thenReturn("em@a");
    Mockito.when(mockReq.getParameter("telefonoLido")).thenReturn("123456789");
    Mockito.when(mockReq.getParameter("logoLido")).thenReturn("/images/foto.png");
    Mockito.when(mockReq.getParameter("prezzoLido")).thenReturn("10.5");
    Mockito.when(mockReq.getParameter("righeLido")).thenReturn("1");
    Mockito.when(mockReq.getParameter("colonneLido")).thenReturn("1");
    //parametri del servizio
    Mockito.when(mockReq.getParameter("servizio1")).thenReturn("false");
    Mockito.when(mockReq.getParameter("servizio2")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio3")).thenReturn("false");
    Mockito.when(mockReq.getParameter("servizio4")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio5")).thenReturn("false");
    Mockito.when(mockReq.getParameter("servizio6")).thenReturn("false");
    Mockito.when(mockReq.getParameter("servizio7")).thenReturn("false");

    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    Mockito.when(mockReq.getSession().getAttribute("adminLido")).thenReturn(new ResponsabileLido(1,"", "a", "", "", "",1,1));

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);

    action = new ModificaLidoAction();

    String page = this.action.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/respLidoModifica.jsp", page);
  }

  @Test
  public void ModificaLidoTestTelefonoLenght(){
    //parametri del lido
    Mockito.when(mockReq.getParameter("nomeLido")).thenReturn("nome lido");
    Mockito.when(mockReq.getParameter("indirizzoLido")).thenReturn("indirizzo");
    Mockito.when(mockReq.getParameter("emailLido")).thenReturn("em@gmail.com");
    Mockito.when(mockReq.getParameter("telefonoLido")).thenReturn("");
    Mockito.when(mockReq.getParameter("logoLido")).thenReturn("/images/foto.png");
    Mockito.when(mockReq.getParameter("prezzoLido")).thenReturn("10.5");
    Mockito.when(mockReq.getParameter("righeLido")).thenReturn("1");
    Mockito.when(mockReq.getParameter("colonneLido")).thenReturn("1");
    //parametri del servizio
    Mockito.when(mockReq.getParameter("servizio1")).thenReturn("false");
    Mockito.when(mockReq.getParameter("servizio2")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio3")).thenReturn("false");
    Mockito.when(mockReq.getParameter("servizio4")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio5")).thenReturn("false");
    Mockito.when(mockReq.getParameter("servizio6")).thenReturn("false");
    Mockito.when(mockReq.getParameter("servizio7")).thenReturn("false");

    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    Mockito.when(mockReq.getSession().getAttribute("adminLido")).thenReturn(new ResponsabileLido(1,"", "a", "", "", "",1,1));

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);

    action = new ModificaLidoAction();

    String page = this.action.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/respLidoModifica.jsp", page);
  }

  @Test
  public void ModificaLidoTestLogoLenght(){
    //parametri del lido
    Mockito.when(mockReq.getParameter("nomeLido")).thenReturn("nome lido");
    Mockito.when(mockReq.getParameter("indirizzoLido")).thenReturn("indirizzo");
    Mockito.when(mockReq.getParameter("emailLido")).thenReturn("em@gmail.com");
    Mockito.when(mockReq.getParameter("telefonoLido")).thenReturn("123456789");
    Mockito.when(mockReq.getParameter("logoLido")).thenReturn("");
    Mockito.when(mockReq.getParameter("prezzoLido")).thenReturn("10.5");
    Mockito.when(mockReq.getParameter("righeLido")).thenReturn("1");
    Mockito.when(mockReq.getParameter("colonneLido")).thenReturn("1");
    //parametri del servizio
    Mockito.when(mockReq.getParameter("servizio1")).thenReturn("false");
    Mockito.when(mockReq.getParameter("servizio2")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio3")).thenReturn("false");
    Mockito.when(mockReq.getParameter("servizio4")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio5")).thenReturn("false");
    Mockito.when(mockReq.getParameter("servizio6")).thenReturn("false");
    Mockito.when(mockReq.getParameter("servizio7")).thenReturn("false");

    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    Mockito.when(mockReq.getSession().getAttribute("adminLido")).thenReturn(new ResponsabileLido(1,"", "a", "", "", "",1,1));

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);

    action = new ModificaLidoAction();

    String page = this.action.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/respLidoModifica.jsp", page);
  }
}
