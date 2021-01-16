package theboys.sorrentomarina.actions;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import theboys.sorrentomarina.managers.*;
import theboys.sorrentomarina.models.Lido;
import theboys.sorrentomarina.models.ResponsabileLido;
import theboys.sorrentomarina.models.Servizio;

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
  public void CreaLidotestExecuteSuccess() {
    //parametri del lido
    Mockito.when(mockReq.getParameter("nomeLido")).thenReturn("nom");
    Mockito.when(mockReq.getParameter("indirizzoLido")).thenReturn("ind");
    Mockito.when(mockReq.getParameter("emailLido")).thenReturn("em@gmail.com");
    Mockito.when(mockReq.getParameter("telefonoLido")).thenReturn("1234");
    Mockito.when(mockReq.getParameter("logoLido")).thenReturn("foto");
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
    Mockito.when(mockReq.getParameter("usernameResp")).thenReturn("mimmo");
    Mockito.when(mockReq.getParameter("passwordResp")).thenReturn("fotomimmo");

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
   * Test nel caso i dati non siano inseriti correttamente e non
   * viene aggiunto l'annuncio
   *
  @Test
  public void CreaLidotestExecuteFailure() {
    //parametri del lido

    Mockito.when(mockReq.getParameter("nomeLido")).thenReturn("nom");
    Mockito.when(mockReq.getParameter("indirizzoLido")).thenReturn("ind");
    Mockito.when(mockReq.getParameter("emailLido")).thenReturn("em@gmail.com");
    Mockito.when(mockReq.getParameter("telefonoLido")).thenReturn("1234");
    Mockito.when(mockReq.getParameter("logoLido")).thenReturn("foto");
    Mockito.when(mockReq.getParameter("prezzoLido")).thenReturn(null);
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
    Mockito.when(mockReq.getParameter("usernameResp")).thenReturn("mimmo");
    Mockito.when(mockReq.getParameter("passwordResp")).thenReturn("fotomimmo");

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

    assertNull(l);
    assertNull(rl);
    assertNull(s);
    assertEquals("/WEB-INF/views/creaLido.jsp", page);
  }
  */
}