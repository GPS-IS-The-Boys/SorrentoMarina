package theboys.sorrentomarina.actions;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import theboys.sorrentomarina.actions.actionsPrenotazione.ShowPrenotazioniTurista;
import theboys.sorrentomarina.models.modelsUtente.Turista;
import javax.servlet.ServletContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShowPrenotazioniTuristaTest extends ActionSetupDB {

  private ShowPrenotazioniTurista spt;



  @Test
  public void ShowPrenotazioniTuristaTest() {
    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(ActionSetupDB.mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    Mockito.when(mockReq.getSession().getAttribute("utente")).thenReturn(new Turista(1, "nome", "cognome", "email", "Username1", "password1"));
    spt = Mockito.mock(ShowPrenotazioniTurista.class,Mockito.CALLS_REAL_METHODS);

    String page = this.spt.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/prenotazioniTurista.jsp", page);
  }

  @Test
  public void ShowPrenotazioniTuristaFaiulureTest(){
    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(null);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    Mockito.when(mockReq.getSession().getAttribute("utente")).thenReturn(new Turista(1, "nome", "cognome", "email", "Username1", "password1"));
    spt = Mockito.mock(ShowPrenotazioniTurista.class,Mockito.CALLS_REAL_METHODS);

    String page = this.spt.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/500.jsp", page);
  }

  @Test
  public void ShowPrenotazioniTuristaNullTest(){
    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(null);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    Mockito.when(mockReq.getSession().getAttribute("utente")).thenReturn(null);
    spt = Mockito.mock(ShowPrenotazioniTurista.class,Mockito.CALLS_REAL_METHODS);

    String page = this.spt.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/prenotazioniTurista.jsp", page);
  }
}