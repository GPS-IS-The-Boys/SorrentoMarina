package theboys.sorrentomarina.actions;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import theboys.sorrentomarina.actions.actionsLido.CreaLidoAction;
import theboys.sorrentomarina.managers.managersLido.LidoManager;
import theboys.sorrentomarina.managers.managersLido.ServizioManager;
import theboys.sorrentomarina.managers.managersLido.TableLidoManager;
import theboys.sorrentomarina.managers.managersLido.TableServizioManager;
import theboys.sorrentomarina.managers.managersUtente.ResponsabileLidoManager;
import theboys.sorrentomarina.managers.managersUtente.TableResponsabileLidoManager;
import theboys.sorrentomarina.models.modelsLido.Lido;
import theboys.sorrentomarina.models.modelsUtente.ResponsabileLido;
import theboys.sorrentomarina.models.modelsLido.Servizio;

import javax.servlet.ServletContext;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * @author theBoys
 */
public class CreaLidoActionTest extends ActionSetupDB {
  private CreaLidoAction action;

  /**
   * Test nel caso i dati siano inseriti correttamente e non vengono aggiunti
   * un nuovo lido con responsabile lido e servizi
   */
  @Test
  public void CreaLidotestExecuteSuccess1() {
    //parametri del lido
    Mockito.when(mockReq.getParameter("nomeLido")).thenReturn("nom");
    Mockito.when(mockReq.getParameter("indirizzoLido")).thenReturn("ind");
    Mockito.when(mockReq.getParameter("emailLido")).thenReturn("em@gmail.com");
    Mockito.when(mockReq.getParameter("telefonoLido")).thenReturn("123456789");
    Mockito.when(mockReq.getParameter("logoLido")).thenReturn("/images/foto,jpg");
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
    //parametri del responsabile lido
    Mockito.when(mockReq.getParameter("nomeResp")).thenReturn("mimmo");
    Mockito.when(mockReq.getParameter("cognomeResp")).thenReturn("foto");
    Mockito.when(mockReq.getParameter("emailResp")).thenReturn("em@gmail.com");
    Mockito.when(mockReq.getParameter("usernameResp")).thenReturn("mimmo123");
    Mockito.when(mockReq.getParameter("passwordResp")).thenReturn("Fotomimmo1");

    Mockito.when(mockReq.getSession()).thenReturn(mockSession);

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);

    action = new CreaLidoAction();

    String page = this.action.execute(mockReq, mockRes);

    LidoManager lm = new TableLidoManager(mockConnection);
    ResponsabileLidoManager rlm = new TableResponsabileLidoManager(mockConnection);
    ServizioManager sm = new TableServizioManager(mockConnection);

    ResponsabileLido rl = null;
    Lido l = null;
    Servizio s = null;
    try {
      l = lm.retriveById(5);
      rl = rlm.retriveById(5);
      s = sm.retriveById(5);
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }

    assertNotNull(l);
    assertNotNull(rl);
    assertNotNull(s);
    assertEquals("redirect:/SorrentoMarina/dashboardEnte", page);
  }

  /**
   * Test - crea lido senza parametri di servizio
   *
   */
  @Test
  public void CreaLidotestExecuteSuccess2() {
    //parametri del lido
    Mockito.when(mockReq.getParameter("nomeLido")).thenReturn("nom");
    Mockito.when(mockReq.getParameter("indirizzoLido")).thenReturn("ind");
    Mockito.when(mockReq.getParameter("emailLido")).thenReturn("em@gmail.com");
    Mockito.when(mockReq.getParameter("telefonoLido")).thenReturn("123456789");
    Mockito.when(mockReq.getParameter("logoLido")).thenReturn("/images/foto,jpg");
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
    //parametri del responsabile lido
    Mockito.when(mockReq.getParameter("nomeResp")).thenReturn("mimmo");
    Mockito.when(mockReq.getParameter("cognomeResp")).thenReturn("foto");
    Mockito.when(mockReq.getParameter("emailResp")).thenReturn("em@gmail.com");
    Mockito.when(mockReq.getParameter("usernameResp")).thenReturn("mimmo123");
    Mockito.when(mockReq.getParameter("passwordResp")).thenReturn("Fotomimmo1");

    Mockito.when(mockReq.getSession()).thenReturn(mockSession);

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);

    action = new CreaLidoAction();

    String page = this.action.execute(mockReq, mockRes);

    LidoManager lm = new TableLidoManager(mockConnection);
    ResponsabileLidoManager rlm = new TableResponsabileLidoManager(mockConnection);
    ServizioManager sm = new TableServizioManager(mockConnection);

    ResponsabileLido rl = null;
    Lido l = null;
    Servizio s = null;
    try {
      l = lm.retriveById(5);
      rl = rlm.retriveById(5);
      s = sm.retriveById(5);
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }

    assertNotNull(l);
    assertNotNull(rl);
    assertNotNull(s);
    assertEquals("redirect:/SorrentoMarina/dashboardEnte", page);
  }

  /**
   * Test - crea lido senza parametro nome
   */
  @Test
  public void CreaLidotestExecuteNomeNull() {
    //parametri del lido
    Mockito.when(mockReq.getParameter("nomeLido")).thenReturn(null);
    Mockito.when(mockReq.getParameter("indirizzoLido")).thenReturn("ind");
    Mockito.when(mockReq.getParameter("emailLido")).thenReturn("em@gmail.com");
    Mockito.when(mockReq.getParameter("telefonoLido")).thenReturn("123456789");
    Mockito.when(mockReq.getParameter("logoLido")).thenReturn("/images/foto,jpg");
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
    //parametri del responsabile lido
    Mockito.when(mockReq.getParameter("nomeResp")).thenReturn("mimmo");
    Mockito.when(mockReq.getParameter("cognomeResp")).thenReturn("foto");
    Mockito.when(mockReq.getParameter("emailResp")).thenReturn("em@gmail.com");
    Mockito.when(mockReq.getParameter("usernameResp")).thenReturn("mimmo123");
    Mockito.when(mockReq.getParameter("passwordResp")).thenReturn("Fotomimmo1");

    Mockito.when(mockReq.getSession()).thenReturn(mockSession);

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);

    action = new CreaLidoAction();

    String page = this.action.execute(mockReq, mockRes);

    assertEquals("/WEB-INF/views/creaLido.jsp", page);
  }
  /**
   * Test - crea lido senza parametro indirizzoLido
   */
  @Test
  public void CreaLidotestExecuteIndirizzoNull() {
    //parametri del lido
    Mockito.when(mockReq.getParameter("nomeLido")).thenReturn("nome");
    Mockito.when(mockReq.getParameter("indirizzoLido")).thenReturn(null);
    Mockito.when(mockReq.getParameter("emailLido")).thenReturn("em@gmail.com");
    Mockito.when(mockReq.getParameter("telefonoLido")).thenReturn("123456789");
    Mockito.when(mockReq.getParameter("logoLido")).thenReturn("/images/foto,jpg");
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
    //parametri del responsabile lido
    Mockito.when(mockReq.getParameter("nomeResp")).thenReturn("mimmo");
    Mockito.when(mockReq.getParameter("cognomeResp")).thenReturn("foto");
    Mockito.when(mockReq.getParameter("emailResp")).thenReturn("em@gmail.com");
    Mockito.when(mockReq.getParameter("usernameResp")).thenReturn("mimmo123");
    Mockito.when(mockReq.getParameter("passwordResp")).thenReturn("Fotomimmo1");

    Mockito.when(mockReq.getSession()).thenReturn(mockSession);

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);

    action = new CreaLidoAction();

    String page = this.action.execute(mockReq, mockRes);

    assertEquals("/WEB-INF/views/creaLido.jsp", page);
  }
  /**
   * Test - crea lido senza parametro emailLido
   */
  @Test
  public void CreaLidotestExecuteEmailNull() {
    //parametri del lido
    Mockito.when(mockReq.getParameter("nomeLido")).thenReturn("nome");
    Mockito.when(mockReq.getParameter("indirizzoLido")).thenReturn("ind");
    Mockito.when(mockReq.getParameter("emailLido")).thenReturn(null);
    Mockito.when(mockReq.getParameter("telefonoLido")).thenReturn("123456789");
    Mockito.when(mockReq.getParameter("logoLido")).thenReturn("/images/foto,jpg");
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
    //parametri del responsabile lido
    Mockito.when(mockReq.getParameter("nomeResp")).thenReturn("mimmo");
    Mockito.when(mockReq.getParameter("cognomeResp")).thenReturn("foto");
    Mockito.when(mockReq.getParameter("emailResp")).thenReturn("em@gmail.com");
    Mockito.when(mockReq.getParameter("usernameResp")).thenReturn("mimmo123");
    Mockito.when(mockReq.getParameter("passwordResp")).thenReturn("Fotomimmo1");

    Mockito.when(mockReq.getSession()).thenReturn(mockSession);

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);

    action = new CreaLidoAction();

    String page = this.action.execute(mockReq, mockRes);

    assertEquals("/WEB-INF/views/creaLido.jsp", page);
  }
  /**
   * Test - crea lido con parametro TelefonoLido nullo
   */
  @Test
  public void CreaLidotestExecuteTelefonoNull() {
    //parametri del lido
    Mockito.when(mockReq.getParameter("nomeLido")).thenReturn("nome");
    Mockito.when(mockReq.getParameter("indirizzoLido")).thenReturn("ind");
    Mockito.when(mockReq.getParameter("emailLido")).thenReturn("em@gmail.com");
    Mockito.when(mockReq.getParameter("telefonoLido")).thenReturn(null);
    Mockito.when(mockReq.getParameter("logoLido")).thenReturn("/images/foto,jpg");
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
    //parametri del responsabile lido
    Mockito.when(mockReq.getParameter("nomeResp")).thenReturn("mimmo");
    Mockito.when(mockReq.getParameter("cognomeResp")).thenReturn("foto");
    Mockito.when(mockReq.getParameter("emailResp")).thenReturn("em@gmail.com");
    Mockito.when(mockReq.getParameter("usernameResp")).thenReturn("mimmo123");
    Mockito.when(mockReq.getParameter("passwordResp")).thenReturn("Fotomimmo1");

    Mockito.when(mockReq.getSession()).thenReturn(mockSession);

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);

    action = new CreaLidoAction();

    String page = this.action.execute(mockReq, mockRes);

    assertEquals("/WEB-INF/views/creaLido.jsp", page);
  }
  /**
   * Test - crea lido con il parametro logoLido nullo
   */
  @Test
  public void CreaLidotestExecuteLogoNull() {
    //parametri del lido
    Mockito.when(mockReq.getParameter("nomeLido")).thenReturn("nome");
    Mockito.when(mockReq.getParameter("indirizzoLido")).thenReturn("ind");
    Mockito.when(mockReq.getParameter("emailLido")).thenReturn("em@gmail.com");
    Mockito.when(mockReq.getParameter("telefonoLido")).thenReturn("123456789");
    Mockito.when(mockReq.getParameter("logoLido")).thenReturn(null);
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
    //parametri del responsabile lido
    Mockito.when(mockReq.getParameter("nomeResp")).thenReturn("mimmo");
    Mockito.when(mockReq.getParameter("cognomeResp")).thenReturn("foto");
    Mockito.when(mockReq.getParameter("emailResp")).thenReturn("em@gmail.com");
    Mockito.when(mockReq.getParameter("usernameResp")).thenReturn("mimmo123");
    Mockito.when(mockReq.getParameter("passwordResp")).thenReturn("Fotomimmo1");

    Mockito.when(mockReq.getSession()).thenReturn(mockSession);

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);

    action = new CreaLidoAction();

    String page = this.action.execute(mockReq, mockRes);

    assertEquals("redirect:/SorrentoMarina/dashboardEnte", page);
  }

  /**
   * Test - crea lido parametro nome errato
   */
  @Test
  public void CreaLidotestExecuteNomeLenght() {
    //parametri del lido
    Mockito.when(mockReq.getParameter("nomeLido")).thenReturn("");
    Mockito.when(mockReq.getParameter("indirizzoLido")).thenReturn("ind");
    Mockito.when(mockReq.getParameter("emailLido")).thenReturn("em@gmail.com");
    Mockito.when(mockReq.getParameter("telefonoLido")).thenReturn("123456789");
    Mockito.when(mockReq.getParameter("logoLido")).thenReturn("/images/foto,jpg");
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
    //parametri del responsabile lido
    Mockito.when(mockReq.getParameter("nomeResp")).thenReturn("mimmo");
    Mockito.when(mockReq.getParameter("cognomeResp")).thenReturn("foto");
    Mockito.when(mockReq.getParameter("emailResp")).thenReturn("em@gmail.com");
    Mockito.when(mockReq.getParameter("usernameResp")).thenReturn("mimmo123");
    Mockito.when(mockReq.getParameter("passwordResp")).thenReturn("Fotomimmo1");

    Mockito.when(mockReq.getSession()).thenReturn(mockSession);

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);

    action = new CreaLidoAction();

    String page = this.action.execute(mockReq, mockRes);

    assertEquals("/WEB-INF/views/creaLido.jsp", page);
  }

  /**
   * Test - crea lido con parametro indirizzoLido nullo
   */
  @Test
  public void CreaLidotestExecuteIndirizzoLength() {
    //parametri del lido
    Mockito.when(mockReq.getParameter("nomeLido")).thenReturn("nome");
    Mockito.when(mockReq.getParameter("indirizzoLido")).thenReturn(null);
    Mockito.when(mockReq.getParameter("emailLido")).thenReturn("em@gmail.com");
    Mockito.when(mockReq.getParameter("telefonoLido")).thenReturn("123456789");
    Mockito.when(mockReq.getParameter("logoLido")).thenReturn("/images/foto,jpg");
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
    //parametri del responsabile lido
    Mockito.when(mockReq.getParameter("nomeResp")).thenReturn("mimmo");
    Mockito.when(mockReq.getParameter("cognomeResp")).thenReturn("foto");
    Mockito.when(mockReq.getParameter("emailResp")).thenReturn("em@gmail.com");
    Mockito.when(mockReq.getParameter("usernameResp")).thenReturn("mimmo123");
    Mockito.when(mockReq.getParameter("passwordResp")).thenReturn("Fotomimmo1");

    Mockito.when(mockReq.getSession()).thenReturn(mockSession);

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);

    action = new CreaLidoAction();

    String page = this.action.execute(mockReq, mockRes);

    assertEquals("/WEB-INF/views/creaLido.jsp", page);
  }
  /**
   * Test - crea lido con parametro emailLido errato
   */
  @Test
  public void CreaLidotestExecuteEmailNullFormat() {
    //parametri del lido
    Mockito.when(mockReq.getParameter("nomeLido")).thenReturn("nome");
    Mockito.when(mockReq.getParameter("indirizzoLido")).thenReturn("ind");
    Mockito.when(mockReq.getParameter("emailLido")).thenReturn("em");
    Mockito.when(mockReq.getParameter("telefonoLido")).thenReturn("123456789");
    Mockito.when(mockReq.getParameter("logoLido")).thenReturn("/images/foto,jpg");
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
    //parametri del responsabile lido
    Mockito.when(mockReq.getParameter("nomeResp")).thenReturn("mimmo");
    Mockito.when(mockReq.getParameter("cognomeResp")).thenReturn("foto");
    Mockito.when(mockReq.getParameter("emailResp")).thenReturn("em@gmail.com");
    Mockito.when(mockReq.getParameter("usernameResp")).thenReturn("mimmo123");
    Mockito.when(mockReq.getParameter("passwordResp")).thenReturn("Fotomimmo1");

    Mockito.when(mockReq.getSession()).thenReturn(mockSession);

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);

    action = new CreaLidoAction();

    String page = this.action.execute(mockReq, mockRes);

    assertEquals("/WEB-INF/views/creaLido.jsp", page);
  }
  /**
   * Test - crea lido con parametro telefonoLido errato
   */
  @Test
  public void CreaLidotestExecuteTelefonoLenght() {
    //parametri del lido
    Mockito.when(mockReq.getParameter("nomeLido")).thenReturn("nome");
    Mockito.when(mockReq.getParameter("indirizzoLido")).thenReturn("ind");
    Mockito.when(mockReq.getParameter("emailLido")).thenReturn("em@gmail.com");
    Mockito.when(mockReq.getParameter("telefonoLido")).thenReturn("1234");
    Mockito.when(mockReq.getParameter("logoLido")).thenReturn("/images/foto,jpg");
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
    //parametri del responsabile lido
    Mockito.when(mockReq.getParameter("nomeResp")).thenReturn("mimmo");
    Mockito.when(mockReq.getParameter("cognomeResp")).thenReturn("foto");
    Mockito.when(mockReq.getParameter("emailResp")).thenReturn("em@gmail.com");
    Mockito.when(mockReq.getParameter("usernameResp")).thenReturn("mimmo123");
    Mockito.when(mockReq.getParameter("passwordResp")).thenReturn("Fotomimmo1");

    Mockito.when(mockReq.getSession()).thenReturn(mockSession);

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);

    action = new CreaLidoAction();

    String page = this.action.execute(mockReq, mockRes);

    assertEquals("/WEB-INF/views/creaLido.jsp", page);
  }
  /**
   * Test - crea lido con parametro logoLido è errato
   */
  @Test
  public void CreaLidotestExecuteLogoFormat() {
    //parametri del lido
    Mockito.when(mockReq.getParameter("nomeLido")).thenReturn("nome");
    Mockito.when(mockReq.getParameter("indirizzoLido")).thenReturn("ind");
    Mockito.when(mockReq.getParameter("emailLido")).thenReturn("em@gmail.com");
    Mockito.when(mockReq.getParameter("telefonoLido")).thenReturn("123456789");
    Mockito.when(mockReq.getParameter("logoLido")).thenReturn("/ima");
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
    //parametri del responsabile lido
    Mockito.when(mockReq.getParameter("nomeResp")).thenReturn("mimmo");
    Mockito.when(mockReq.getParameter("cognomeResp")).thenReturn("foto");
    Mockito.when(mockReq.getParameter("emailResp")).thenReturn("em@gmail.com");
    Mockito.when(mockReq.getParameter("usernameResp")).thenReturn("mimmo123");
    Mockito.when(mockReq.getParameter("passwordResp")).thenReturn("Fotomimmo1");

    Mockito.when(mockReq.getSession()).thenReturn(mockSession);

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);

    action = new CreaLidoAction();

    String page = this.action.execute(mockReq, mockRes);

    assertEquals("redirect:/SorrentoMarina/dashboardEnte", page);
  }
  /**
   * Test - crea lido con parametro prezzo Nullo
   */
  @Test
  public void CreaLidotestExecutePrezzoNull() {
    //parametri del lido
    Mockito.when(mockReq.getParameter("nomeLido")).thenReturn("nome");
    Mockito.when(mockReq.getParameter("indirizzoLido")).thenReturn("ind");
    Mockito.when(mockReq.getParameter("emailLido")).thenReturn("em@gmail.com");
    Mockito.when(mockReq.getParameter("telefonoLido")).thenReturn("123456789");
    Mockito.when(mockReq.getParameter("logoLido")).thenReturn("/images/foto,jpg");
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
    //parametri del responsabile lido
    Mockito.when(mockReq.getParameter("nomeResp")).thenReturn("mimmo");
    Mockito.when(mockReq.getParameter("cognomeResp")).thenReturn("foto");
    Mockito.when(mockReq.getParameter("emailResp")).thenReturn("em@gmail.com");
    Mockito.when(mockReq.getParameter("usernameResp")).thenReturn("mimmo123");
    Mockito.when(mockReq.getParameter("passwordResp")).thenReturn("Fotomimmo1");

    Mockito.when(mockReq.getSession()).thenReturn(mockSession);

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);

    action = new CreaLidoAction();

    String page = this.action.execute(mockReq, mockRes);

    assertEquals("/WEB-INF/views/creaLido.jsp", page);
  }
  /**
   * Test - crea lido con parametro RigheLido nullo
   */
  @Test
  public void CreaLidotestExecuteRigheNull() {
    //parametri del lido
    Mockito.when(mockReq.getParameter("nomeLido")).thenReturn("nome");
    Mockito.when(mockReq.getParameter("indirizzoLido")).thenReturn("ind");
    Mockito.when(mockReq.getParameter("emailLido")).thenReturn("em@gmail.com");
    Mockito.when(mockReq.getParameter("telefonoLido")).thenReturn("123456789");
    Mockito.when(mockReq.getParameter("logoLido")).thenReturn("/images/foto,jpg");
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
    //parametri del responsabile lido
    Mockito.when(mockReq.getParameter("nomeResp")).thenReturn("mimmo");
    Mockito.when(mockReq.getParameter("cognomeResp")).thenReturn("foto");
    Mockito.when(mockReq.getParameter("emailResp")).thenReturn("em@gmail.com");
    Mockito.when(mockReq.getParameter("usernameResp")).thenReturn("mimmo123");
    Mockito.when(mockReq.getParameter("passwordResp")).thenReturn("Fotomimmo1");

    Mockito.when(mockReq.getSession()).thenReturn(mockSession);

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);

    action = new CreaLidoAction();

    String page = this.action.execute(mockReq, mockRes);

    assertEquals("/WEB-INF/views/creaLido.jsp", page);
  }
  /**
   * Test - crea lido con parametro colonneLido errato
   */
  @Test
  public void CreaLidotestExecuteColonneNull() {
    //parametri del lido
    Mockito.when(mockReq.getParameter("nomeLido")).thenReturn("nome");
    Mockito.when(mockReq.getParameter("indirizzoLido")).thenReturn("ind");
    Mockito.when(mockReq.getParameter("emailLido")).thenReturn("em@gmail.com");
    Mockito.when(mockReq.getParameter("telefonoLido")).thenReturn("123456789");
    Mockito.when(mockReq.getParameter("logoLido")).thenReturn("/images/foto,jpg");
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
    //parametri del responsabile lido
    Mockito.when(mockReq.getParameter("nomeResp")).thenReturn("mimmo");
    Mockito.when(mockReq.getParameter("cognomeResp")).thenReturn("foto");
    Mockito.when(mockReq.getParameter("emailResp")).thenReturn("em@gmail.com");
    Mockito.when(mockReq.getParameter("usernameResp")).thenReturn("mimmo123");
    Mockito.when(mockReq.getParameter("passwordResp")).thenReturn("Fotomimmo1");

    Mockito.when(mockReq.getSession()).thenReturn(mockSession);

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);

    action = new CreaLidoAction();

    String page = this.action.execute(mockReq, mockRes);

    assertEquals("/WEB-INF/views/creaLido.jsp", page);
  }
  /**
   * Test - crea lido con parametro nomeResp nullo
   */
  @Test
  public void CreaLidotestExecuteNomeRespNull() {
    //parametri del lido
    Mockito.when(mockReq.getParameter("nomeLido")).thenReturn("nome");
    Mockito.when(mockReq.getParameter("indirizzoLido")).thenReturn("ind");
    Mockito.when(mockReq.getParameter("emailLido")).thenReturn("em@gmail.com");
    Mockito.when(mockReq.getParameter("telefonoLido")).thenReturn("123456789");
    Mockito.when(mockReq.getParameter("logoLido")).thenReturn("/images/foto,jpg");
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
    //parametri del responsabile lido
    Mockito.when(mockReq.getParameter("nomeResp")).thenReturn(null);
    Mockito.when(mockReq.getParameter("cognomeResp")).thenReturn("foto");
    Mockito.when(mockReq.getParameter("emailResp")).thenReturn("em@gmail.com");
    Mockito.when(mockReq.getParameter("usernameResp")).thenReturn("mimmo123");
    Mockito.when(mockReq.getParameter("passwordResp")).thenReturn("Fotomimmo1");

    Mockito.when(mockReq.getSession()).thenReturn(mockSession);

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);

    action = new CreaLidoAction();

    String page = this.action.execute(mockReq, mockRes);

    assertEquals("/WEB-INF/views/creaLido.jsp", page);
  }
  /**
   * Test - crea lido con parametro cognomeResp nullo
   */
  @Test
  public void CreaLidotestExecuteCognomeRespNull() {
    //parametri del lido
    Mockito.when(mockReq.getParameter("nomeLido")).thenReturn("nome");
    Mockito.when(mockReq.getParameter("indirizzoLido")).thenReturn("ind");
    Mockito.when(mockReq.getParameter("emailLido")).thenReturn("em@gmail.com");
    Mockito.when(mockReq.getParameter("telefonoLido")).thenReturn("123456789");
    Mockito.when(mockReq.getParameter("logoLido")).thenReturn("/images/foto,jpg");
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
    //parametri del responsabile lido
    Mockito.when(mockReq.getParameter("nomeResp")).thenReturn("mimmo");
    Mockito.when(mockReq.getParameter("cognomeResp")).thenReturn(null);
    Mockito.when(mockReq.getParameter("emailResp")).thenReturn("em@gmail.com");
    Mockito.when(mockReq.getParameter("usernameResp")).thenReturn("mimmo123");
    Mockito.when(mockReq.getParameter("passwordResp")).thenReturn("Fotomimmo1");

    Mockito.when(mockReq.getSession()).thenReturn(mockSession);

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);

    action = new CreaLidoAction();

    String page = this.action.execute(mockReq, mockRes);

    assertEquals("/WEB-INF/views/creaLido.jsp", page);
  }
  /**
   * Test - crea lido con parametro emailresp nullo
   */
  @Test
  public void CreaLidotestExecuteEmailRespNull() {
    //parametri del lido
    Mockito.when(mockReq.getParameter("nomeLido")).thenReturn("nome");
    Mockito.when(mockReq.getParameter("indirizzoLido")).thenReturn("ind");
    Mockito.when(mockReq.getParameter("emailLido")).thenReturn("em@gmail.com");
    Mockito.when(mockReq.getParameter("telefonoLido")).thenReturn("123456789");
    Mockito.when(mockReq.getParameter("logoLido")).thenReturn("/images/foto,jpg");
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
    //parametri del responsabile lido
    Mockito.when(mockReq.getParameter("nomeResp")).thenReturn("mimmo");
    Mockito.when(mockReq.getParameter("cognomeResp")).thenReturn("foto");
    Mockito.when(mockReq.getParameter("emailResp")).thenReturn(null);
    Mockito.when(mockReq.getParameter("usernameResp")).thenReturn("mimmo123");
    Mockito.when(mockReq.getParameter("passwordResp")).thenReturn("Fotomimmo1");

    Mockito.when(mockReq.getSession()).thenReturn(mockSession);

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);

    action = new CreaLidoAction();

    String page = this.action.execute(mockReq, mockRes);

    assertEquals("/WEB-INF/views/creaLido.jsp", page);
  }
  /**
   * Test - crea lido con parametro usernameResp nullo
   */
  @Test
  public void CreaLidotestExecuteUsernameNull() {
    //parametri del lido
    Mockito.when(mockReq.getParameter("nomeLido")).thenReturn("nome");
    Mockito.when(mockReq.getParameter("indirizzoLido")).thenReturn("ind");
    Mockito.when(mockReq.getParameter("emailLido")).thenReturn("em@gmail.com");
    Mockito.when(mockReq.getParameter("telefonoLido")).thenReturn("123456789");
    Mockito.when(mockReq.getParameter("logoLido")).thenReturn("/images/foto,jpg");
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
    //parametri del responsabile lido
    Mockito.when(mockReq.getParameter("nomeResp")).thenReturn("mimmo");
    Mockito.when(mockReq.getParameter("cognomeResp")).thenReturn("foto");
    Mockito.when(mockReq.getParameter("emailResp")).thenReturn("em@gmail.com");
    Mockito.when(mockReq.getParameter("usernameResp")).thenReturn(null);
    Mockito.when(mockReq.getParameter("passwordResp")).thenReturn("Fotomimmo1");

    Mockito.when(mockReq.getSession()).thenReturn(mockSession);

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);

    action = new CreaLidoAction();

    String page = this.action.execute(mockReq, mockRes);

    assertEquals("/WEB-INF/views/creaLido.jsp", page);
  }

  /**
   * Test - crea lido con parametro passwordResp nullo
   *
   */

  @Test
  public void CreaLidotestExecutePasswordNull() {
    //parametri del lido
    Mockito.when(mockReq.getParameter("nomeLido")).thenReturn("nome");
    Mockito.when(mockReq.getParameter("indirizzoLido")).thenReturn("ind");
    Mockito.when(mockReq.getParameter("emailLido")).thenReturn("em@gmail.com");
    Mockito.when(mockReq.getParameter("telefonoLido")).thenReturn("123456789");
    Mockito.when(mockReq.getParameter("logoLido")).thenReturn("/images/foto,jpg");
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
    //parametri del responsabile lido
    Mockito.when(mockReq.getParameter("nomeResp")).thenReturn("mimmo");
    Mockito.when(mockReq.getParameter("cognomeResp")).thenReturn("foto");
    Mockito.when(mockReq.getParameter("emailResp")).thenReturn("em@gmail.com");
    Mockito.when(mockReq.getParameter("usernameResp")).thenReturn("mimmo123");
    Mockito.when(mockReq.getParameter("passwordResp")).thenReturn(null);

    Mockito.when(mockReq.getSession()).thenReturn(mockSession);

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);

    action = new CreaLidoAction();

    String page = this.action.execute(mockReq, mockRes);

    assertEquals("/WEB-INF/views/creaLido.jsp", page);
  }
  /**
   * Test - crea lido con parametro nomeResp vuoto
   */
  @Test
  public void CreaLidotestExecuteNomeRespLenght() {
    //parametri del lido
    Mockito.when(mockReq.getParameter("nomeLido")).thenReturn("nome");
    Mockito.when(mockReq.getParameter("indirizzoLido")).thenReturn("ind");
    Mockito.when(mockReq.getParameter("emailLido")).thenReturn("em@gmail.com");
    Mockito.when(mockReq.getParameter("telefonoLido")).thenReturn("123456789");
    Mockito.when(mockReq.getParameter("logoLido")).thenReturn("/images/foto,jpg");
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
    //parametri del responsabile lido
    Mockito.when(mockReq.getParameter("nomeResp")).thenReturn("");
    Mockito.when(mockReq.getParameter("cognomeResp")).thenReturn("foto");
    Mockito.when(mockReq.getParameter("emailResp")).thenReturn("em@gmail.com");
    Mockito.when(mockReq.getParameter("usernameResp")).thenReturn("mimmo123");
    Mockito.when(mockReq.getParameter("passwordResp")).thenReturn("Fotomimmo1");

    Mockito.when(mockReq.getSession()).thenReturn(mockSession);

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);

    action = new CreaLidoAction();

    String page = this.action.execute(mockReq, mockRes);

    assertEquals("/WEB-INF/views/creaLido.jsp", page);
  }
  /**
   * Test - crea lido con parametro cognomeResp vuoto
   */
  @Test
  public void CreaLidotestExecuteCognomeRespLenght() {
    //parametri del lido
    Mockito.when(mockReq.getParameter("nomeLido")).thenReturn("nome");
    Mockito.when(mockReq.getParameter("indirizzoLido")).thenReturn("via roma 1");
    Mockito.when(mockReq.getParameter("emailLido")).thenReturn("em@gmail.com");
    Mockito.when(mockReq.getParameter("telefonoLido")).thenReturn("123456789");
    Mockito.when(mockReq.getParameter("logoLido")).thenReturn("/images/foto,jpg");
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
    //parametri del responsabile lido
    Mockito.when(mockReq.getParameter("nomeResp")).thenReturn("mimmo");
    Mockito.when(mockReq.getParameter("cognomeResp")).thenReturn("");
    Mockito.when(mockReq.getParameter("emailResp")).thenReturn("em@gmail.com");
    Mockito.when(mockReq.getParameter("usernameResp")).thenReturn("mimmo123");
    Mockito.when(mockReq.getParameter("passwordResp")).thenReturn("Fotomimmo1");

    Mockito.when(mockReq.getSession()).thenReturn(mockSession);

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);

    action = new CreaLidoAction();

    String page = this.action.execute(mockReq, mockRes);

    assertEquals("/WEB-INF/views/creaLido.jsp", page);
  }
  /**
   * Test - crea lido con parametro EmailResp errato
   */
  @Test
  public void CreaLidotestExecuteEmailRespFormat() {
    //parametri del lido
    Mockito.when(mockReq.getParameter("nomeLido")).thenReturn("nome");
    Mockito.when(mockReq.getParameter("indirizzoLido")).thenReturn("ind");
    Mockito.when(mockReq.getParameter("emailLido")).thenReturn("em@gmail.com");
    Mockito.when(mockReq.getParameter("telefonoLido")).thenReturn("123456789");
    Mockito.when(mockReq.getParameter("logoLido")).thenReturn("/images/foto,jpg");
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
    //parametri del responsabile lido
    Mockito.when(mockReq.getParameter("nomeResp")).thenReturn("mimmo");
    Mockito.when(mockReq.getParameter("cognomeResp")).thenReturn("foto");
    Mockito.when(mockReq.getParameter("emailResp")).thenReturn("em@");
    Mockito.when(mockReq.getParameter("usernameResp")).thenReturn("mimmo123");
    Mockito.when(mockReq.getParameter("passwordResp")).thenReturn("Fotomimmo1");

    Mockito.when(mockReq.getSession()).thenReturn(mockSession);

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);

    action = new CreaLidoAction();

    String page = this.action.execute(mockReq, mockRes);

    assertEquals("/WEB-INF/views/creaLido.jsp", page);
  }
  /**
   * Test - crea lido con parametro usernameResp errato
   */
  @Test
  public void CreaLidotestExecuteUsernameLenght() {
    //parametri del lido
    Mockito.when(mockReq.getParameter("nomeLido")).thenReturn("nome");
    Mockito.when(mockReq.getParameter("indirizzoLido")).thenReturn("ind");
    Mockito.when(mockReq.getParameter("emailLido")).thenReturn("em@gmail.com");
    Mockito.when(mockReq.getParameter("telefonoLido")).thenReturn("123456789");
    Mockito.when(mockReq.getParameter("logoLido")).thenReturn("/images/foto,jpg");
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
    //parametri del responsabile lido
    Mockito.when(mockReq.getParameter("nomeResp")).thenReturn("mimmo");
    Mockito.when(mockReq.getParameter("cognomeResp")).thenReturn("foto");
    Mockito.when(mockReq.getParameter("emailResp")).thenReturn("em@gmail.com");
    Mockito.when(mockReq.getParameter("usernameResp")).thenReturn("mim");
    Mockito.when(mockReq.getParameter("passwordResp")).thenReturn("Fotomimmo1");

    Mockito.when(mockReq.getSession()).thenReturn(mockSession);

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);

    action = new CreaLidoAction();

    String page = this.action.execute(mockReq, mockRes);

    assertEquals("/WEB-INF/views/creaLido.jsp", page);
  }
  /**
   * Test - crea lido con parametro passwordResp errato
   */
  @Test
  public void CreaLidotestExecutePasswordLenght() {
    //parametri del lido
    Mockito.when(mockReq.getParameter("nomeLido")).thenReturn("nome");
    Mockito.when(mockReq.getParameter("indirizzoLido")).thenReturn("ind");
    Mockito.when(mockReq.getParameter("emailLido")).thenReturn("em@gmail.com");
    Mockito.when(mockReq.getParameter("telefonoLido")).thenReturn("123456789");
    Mockito.when(mockReq.getParameter("logoLido")).thenReturn("/images/foto,jpg");
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
    //parametri del responsabile lido
    Mockito.when(mockReq.getParameter("nomeResp")).thenReturn("mimmo");
    Mockito.when(mockReq.getParameter("cognomeResp")).thenReturn("foto");
    Mockito.when(mockReq.getParameter("emailResp")).thenReturn("em@gmail.com");
    Mockito.when(mockReq.getParameter("usernameResp")).thenReturn("mimmo123");
    Mockito.when(mockReq.getParameter("passwordResp")).thenReturn("Foto");

    Mockito.when(mockReq.getSession()).thenReturn(mockSession);

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);

    action = new CreaLidoAction();

    String page = this.action.execute(mockReq, mockRes);

    assertEquals("/WEB-INF/views/creaLido.jsp", page);
  }
  /**
   * Test - crea lido con parametro nomeResp errato
   */
  @Test
  public void CreaLidotestExecuteNomeRespFormat() {
    //parametri del lido
    Mockito.when(mockReq.getParameter("nomeLido")).thenReturn("nome");
    Mockito.when(mockReq.getParameter("indirizzoLido")).thenReturn("ind");
    Mockito.when(mockReq.getParameter("emailLido")).thenReturn("em@gmail.com");
    Mockito.when(mockReq.getParameter("telefonoLido")).thenReturn("123456789");
    Mockito.when(mockReq.getParameter("logoLido")).thenReturn("/images/foto,jpg");
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
    //parametri del responsabile lido
    Mockito.when(mockReq.getParameter("nomeResp")).thenReturn("mas1");
    Mockito.when(mockReq.getParameter("cognomeResp")).thenReturn("foto");
    Mockito.when(mockReq.getParameter("emailResp")).thenReturn("em@gmail.com");
    Mockito.when(mockReq.getParameter("usernameResp")).thenReturn("mimmo123");
    Mockito.when(mockReq.getParameter("passwordResp")).thenReturn("Fotomimmo1");

    Mockito.when(mockReq.getSession()).thenReturn(mockSession);

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);

    action = new CreaLidoAction();

    String page = this.action.execute(mockReq, mockRes);

    assertEquals("/WEB-INF/views/creaLido.jsp", page);
  }
  /**
   * Test - crea lido con parametro cognomeResp errato
   */
  @Test
  public void CreaLidotestExecuteCognomeRespFormat() {
    //parametri del lido
    Mockito.when(mockReq.getParameter("nomeLido")).thenReturn("nome");
    Mockito.when(mockReq.getParameter("indirizzoLido")).thenReturn("via roma 1");
    Mockito.when(mockReq.getParameter("emailLido")).thenReturn("em@gmail.com");
    Mockito.when(mockReq.getParameter("telefonoLido")).thenReturn("123456789");
    Mockito.when(mockReq.getParameter("logoLido")).thenReturn("/images/foto,jpg");
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
    //parametri del responsabile lido
    Mockito.when(mockReq.getParameter("nomeResp")).thenReturn("mimmo");
    Mockito.when(mockReq.getParameter("cognomeResp")).thenReturn("cog123");
    Mockito.when(mockReq.getParameter("emailResp")).thenReturn("em@gmail.com");
    Mockito.when(mockReq.getParameter("usernameResp")).thenReturn("mimmo123");
    Mockito.when(mockReq.getParameter("passwordResp")).thenReturn("Fotomimmo1");

    Mockito.when(mockReq.getSession()).thenReturn(mockSession);

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);

    action = new CreaLidoAction();

    String page = this.action.execute(mockReq, mockRes);

    assertEquals("/WEB-INF/views/creaLido.jsp", page);
  }
  /**
   * Test - crea lido con parametro  usernameResp errato
   */
  @Test
  public void CreaLidotestExecuteUsernameFormat() {
    //parametri del lido
    Mockito.when(mockReq.getParameter("nomeLido")).thenReturn("nome");
    Mockito.when(mockReq.getParameter("indirizzoLido")).thenReturn("ind");
    Mockito.when(mockReq.getParameter("emailLido")).thenReturn("em@gmail.com");
    Mockito.when(mockReq.getParameter("telefonoLido")).thenReturn("123456789");
    Mockito.when(mockReq.getParameter("logoLido")).thenReturn("/images/foto,jpg");
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
    //parametri del responsabile lido
    Mockito.when(mockReq.getParameter("nomeResp")).thenReturn("mimmo");
    Mockito.when(mockReq.getParameter("cognomeResp")).thenReturn("foto");
    Mockito.when(mockReq.getParameter("emailResp")).thenReturn("em@gmail.com");
    Mockito.when(mockReq.getParameter("usernameResp")).thenReturn("mimmo11$%");
    Mockito.when(mockReq.getParameter("passwordResp")).thenReturn("Fotomimmo1");

    Mockito.when(mockReq.getSession()).thenReturn(mockSession);

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);

    action = new CreaLidoAction();

    String page = this.action.execute(mockReq, mockRes);

    assertEquals("/WEB-INF/views/creaLido.jsp", page);
  }
  /**
   * Test - crea lido con parametro passwordResp errato
   */
  @Test
  public void CreaLidotestExecutePasswordFormat() {
    //parametri del lido
    Mockito.when(mockReq.getParameter("nomeLido")).thenReturn("nome");
    Mockito.when(mockReq.getParameter("indirizzoLido")).thenReturn("ind");
    Mockito.when(mockReq.getParameter("emailLido")).thenReturn("em@gmail.com");
    Mockito.when(mockReq.getParameter("telefonoLido")).thenReturn("123456789");
    Mockito.when(mockReq.getParameter("logoLido")).thenReturn("/images/foto,jpg");
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
    //parametri del responsabile lido
    Mockito.when(mockReq.getParameter("nomeResp")).thenReturn("mimmo");
    Mockito.when(mockReq.getParameter("cognomeResp")).thenReturn("foto");
    Mockito.when(mockReq.getParameter("emailResp")).thenReturn("em@gmail.com");
    Mockito.when(mockReq.getParameter("usernameResp")).thenReturn("mimmo123");
    Mockito.when(mockReq.getParameter("passwordResp")).thenReturn("Fotofoto");

    Mockito.when(mockReq.getSession()).thenReturn(mockSession);

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);

    action = new CreaLidoAction();

    String page = this.action.execute(mockReq, mockRes);

    assertEquals("/WEB-INF/views/creaLido.jsp", page);
  }
}
