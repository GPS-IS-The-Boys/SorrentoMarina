package theboys.sorrentomarina.actions;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import theboys.sorrentomarina.actions.actionsRecensione.AggiungiRecensioneChainableAction;
import theboys.sorrentomarina.managers.managersAnnuncio.AnnuncioManager;
import theboys.sorrentomarina.managers.managersRecensione.RecensioneManager;
import theboys.sorrentomarina.managers.managersAnnuncio.TableAnnuncioManager;
import theboys.sorrentomarina.managers.managersRecensione.TableRecensioneManager;
import theboys.sorrentomarina.models.modelsAnnuncio.Annuncio;
import theboys.sorrentomarina.models.modelsLido.Lido;
import theboys.sorrentomarina.models.modelsRecensione.Recensione;
import theboys.sorrentomarina.models.modelsUtente.Turista;

import javax.servlet.ServletContext;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
/**
 * @author theBoys
 */
public class AggiungiRecensioneChainableActionTest extends ActionSetupDB {

  private AggiungiRecensioneChainableAction action;

  /**
   * Test nel caso i dati siano inseriti correttamente e viene aggiunta
   * la recensione
   */
  @Test
  public void AggiungiRecensionetestExecuteSuccess() {
    Mockito.when(mockReq.getParameter("contenutoRecensione")).thenReturn("Prova recensione");
    Mockito.when(mockReq.getParameter("giudizioRecensione")).thenReturn("3");
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    Mockito.when(mockReq.getSession().getAttribute("utente")).thenReturn(new Turista(1, "a", "", "", "", ""));
    Mockito.when(mockReq.getSession().getAttribute("lido")).thenReturn(new Lido(1, "a", "", "", "", "", 1.0F, 1, 1, 1, 1));

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);

    action = new AggiungiRecensioneChainableAction();
    String page = this.action.execute(mockReq, mockRes);
    RecensioneManager am = new TableRecensioneManager(mockConnection);
    Recensione rec = null;
    try {
      rec = am.retriveById(5);
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    assertNotNull(rec);
    assertEquals("/WEB-INF/views/recensioniLido.jsp", page);
  }

  /**
   * Test nel caso i dati non siano inseriti correttamente
   * e la recensione non viene aggiunta
   */
  @Test
  public void AggiungiRecensionetestExecuteFailure() {
    Mockito.when(mockReq.getParameter("contenutoRecensione")).thenReturn("Prova recensione");
    Mockito.when(mockReq.getParameter("giudizioRecensione")).thenReturn("3");
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    Mockito.when(mockReq.getSession().getAttribute("utente")).thenReturn(new Turista(1, "a", "", "", "", ""));
    Mockito.when(mockReq.getSession().getAttribute("lido")).thenReturn(new Lido());

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);
    AnnuncioManager am = new TableAnnuncioManager(mockConnection);
    Annuncio ann = null;
    try {
      ann = am.retriveById(5);
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    action = new AggiungiRecensioneChainableAction();
    String page = this.action.execute(mockReq, mockRes);
    assertNull(ann);
    assertEquals("/WEB-INF/views/500.jsp", page);
  }

  @Test
  public void AggiungiRecensionetestExecuteContenutoNull() {
    Mockito.when(mockReq.getParameter("contenutoRecensione")).thenReturn(null);
    Mockito.when(mockReq.getParameter("giudizioRecensione")).thenReturn("3");
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    Mockito.when(mockReq.getSession().getAttribute("utente")).thenReturn(new Turista(1, "a", "", "", "", ""));
    Mockito.when(mockReq.getSession().getAttribute("lido")).thenReturn(new Lido(1, "", "", "", "", "", 1F, 1,1,1, 1));

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);

    action = new AggiungiRecensioneChainableAction();
    String page = this.action.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/formRecensione.jsp", page);
  }

  @Test
  public void AggiungiRecensionetestExecuteGiudizioNull() {
    Mockito.when(mockReq.getParameter("contenutoRecensione")).thenReturn("Contenuto recensione");
    Mockito.when(mockReq.getParameter("giudizioRecensione")).thenReturn(null);
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    Mockito.when(mockReq.getSession().getAttribute("utente")).thenReturn(new Turista(1, "a", "", "", "", ""));
    Mockito.when(mockReq.getSession().getAttribute("lido")).thenReturn(new Lido());

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);

    action = new AggiungiRecensioneChainableAction();
    String page = this.action.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/formRecensione.jsp", page);
  }

}
