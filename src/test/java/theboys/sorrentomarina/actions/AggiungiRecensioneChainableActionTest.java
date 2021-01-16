package theboys.sorrentomarina.actions;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import theboys.sorrentomarina.managers.AnnuncioManager;
import theboys.sorrentomarina.managers.RecensioneManager;
import theboys.sorrentomarina.managers.TableAnnuncioManager;
import theboys.sorrentomarina.managers.TableRecensioneManager;
import theboys.sorrentomarina.models.Annuncio;
import theboys.sorrentomarina.models.Lido;
import theboys.sorrentomarina.models.Recensione;
import theboys.sorrentomarina.models.Turista;

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
    Mockito.when(mockReq.getSession().getAttribute("lido")).thenReturn(new Lido(1, "a", "", "", "", "", 1.0F, 1, 1, 1));

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

}
