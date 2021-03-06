package theboys.sorrentomarina.actions;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import theboys.sorrentomarina.actions.actionsPrenotazione.MostraPrenotazioniTurista;
import theboys.sorrentomarina.models.modelsUtente.Turista;
import javax.servlet.ServletContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * @author theBoys
 */
public class MostraPrenotazioniTuristaTest extends ActionSetupDB {

  private MostraPrenotazioniTurista spt;


  /**
   * Test Mostra le prenotazioni del turista
   */
  @Test
  public void ShowPrenotazioniTuristaTest() {
    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(ActionSetupDB.mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    Mockito.when(mockReq.getSession().getAttribute("utente")).thenReturn(new Turista(1, "nome", "cognome", "email", "Username1", "password1"));
    spt = Mockito.mock(MostraPrenotazioniTurista.class,Mockito.CALLS_REAL_METHODS);

    String page = this.spt.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/prenotazioniTurista.jsp", page);
  }

  /**
   * Test Mostra la view 500 in caso di errore
   */

  @Test
  public void ShowPrenotazioniTuristaFaiulureTest(){
    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(null);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    Mockito.when(mockReq.getSession().getAttribute("utente")).thenReturn(new Turista(1, "nome", "cognome", "email", "Username1", "password1"));
    spt = Mockito.mock(MostraPrenotazioniTurista.class,Mockito.CALLS_REAL_METHODS);

    String page = this.spt.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/500.jsp", page);
  }

  /**
   *
   */
  @Test
  public void ShowPrenotazioniTuristaNullTest(){
    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(null);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    Mockito.when(mockReq.getSession().getAttribute("utente")).thenReturn(null);
    spt = Mockito.mock(MostraPrenotazioniTurista.class,Mockito.CALLS_REAL_METHODS);

    String page = this.spt.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/prenotazioniTurista.jsp", page);
  }
}