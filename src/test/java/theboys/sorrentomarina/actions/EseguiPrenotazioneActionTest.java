package theboys.sorrentomarina.actions;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import theboys.sorrentomarina.actions.actionsPrenotazione.EseguiPrenotazioneAction;
import theboys.sorrentomarina.models.modelsLido.Lido;
import theboys.sorrentomarina.models.modelsUtente.Turista;

import javax.servlet.ServletContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * @author theBoys
 */
public class EseguiPrenotazioneActionTest extends ActionSetupDB {

  private EseguiPrenotazioneAction action;

  /**
   * test esegue la prenotazione di un turista  registrato
   */
  @Test
  public void executeSuccessTuristaRegistrato(){
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);

    Mockito.when(mockReq.getSession().getAttribute("lido")).thenReturn(new Lido(1,"","","","","",1F,1,1,1,1));
    Mockito.when(mockReq.getParameter("dataInizio")).thenReturn("2021-01-01");
    Mockito.when(mockReq.getParameter("dataFine")).thenReturn("2021-01-01");
    Mockito.when(mockReq.getParameter("numPosti")).thenReturn("1");
    Mockito.when(mockReq.getSession().getAttribute("giorni")).thenReturn("1");

    Mockito.when(mockReq.getSession().getAttribute("utente")).thenReturn(new Turista(1, "", "", "abc@gmail.com", "", ""));
    Mockito.when(mockReq.getParameter("nome")).thenReturn("abc");
    Mockito.when(mockReq.getParameter("cognome")).thenReturn("abc");
    Mockito.when(mockReq.getParameter("email")).thenReturn("abc@tiscali.it");

    String[] array = {"1_1", "1_2", "1_3"};
    Mockito.when(mockReq.getSession().getAttribute("postiSelezionati")).thenReturn(array);

    action = new EseguiPrenotazioneAction();
    String result = action.execute(mockReq, mockRes);
    assertEquals(result, "/WEB-INF/views/prenotazioneConfermata.jsp");
  }

  /**
   * test esegue la prenotazione di un turista non registrato
   */
  @Test
  public void executeSuccessTuristaNonRegistrato(){
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);

    Mockito.when(mockReq.getSession().getAttribute("lido")).thenReturn(new Lido(1,"","","","","",1F,1,1,1,1));
    Mockito.when(mockReq.getParameter("dataInizio")).thenReturn("2021-01-01");
    Mockito.when(mockReq.getParameter("dataFine")).thenReturn("2021-01-01");
    Mockito.when(mockReq.getParameter("numPosti")).thenReturn("1");
    Mockito.when(mockReq.getSession().getAttribute("giorni")).thenReturn("1");

    Mockito.when(mockReq.getSession().getAttribute("utente")).thenReturn(null);
    Mockito.when(mockReq.getParameter("nome")).thenReturn("abc");
    Mockito.when(mockReq.getParameter("cognome")).thenReturn("abc");
    Mockito.when(mockReq.getParameter("email")).thenReturn("abc@tiscali.it");

    String[] array = {"1_1", "1_2", "1_3"};
    Mockito.when(mockReq.getSession().getAttribute("postiSelezionati")).thenReturn(array);

    action = new EseguiPrenotazioneAction();
    String result = action.execute(mockReq, mockRes);
    assertEquals(result, "/WEB-INF/views/prenotazioneConfermata.jsp");
  }
}
