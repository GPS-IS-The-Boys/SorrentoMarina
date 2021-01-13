package theboys.sorrentomarina.actions;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import theboys.sorrentomarina.models.Lido;
import theboys.sorrentomarina.models.Turista;

import javax.servlet.ServletContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EseguiPrenotazione1ActionTest extends ActionSetupDB {

  private EseguiPrenotazione1Action action;

  @Test
  public void executeSuccessTuristaRegistrato(){
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);

    Mockito.when(mockReq.getSession().getAttribute("lido")).thenReturn(new Lido(1,"","","","","",1F,1,1,1));
    Mockito.when(mockReq.getParameter("dataInizio")).thenReturn("2021-01-01");
    Mockito.when(mockReq.getParameter("dataFine")).thenReturn("2021-01-01");
    Mockito.when(mockReq.getParameter("numPosti")).thenReturn("1");
    Mockito.when(mockReq.getSession().getAttribute("giorni")).thenReturn("1");

    Mockito.when(mockReq.getSession().getAttribute("utente")).thenReturn(new Turista(1, "", "", "", "", ""));
    Mockito.when(mockReq.getParameter("nome")).thenReturn("abc");
    Mockito.when(mockReq.getParameter("cognome")).thenReturn("abc");
    Mockito.when(mockReq.getParameter("email")).thenReturn("abc");

    String[] array = {"1_1", "1_2", "1_3"};
    Mockito.when(mockReq.getSession().getAttribute("postiSelezionati")).thenReturn(array);

    action = new EseguiPrenotazione1Action();
    String result = action.execute(mockReq, mockRes);
    assertEquals(result, "/WEB-INF/views/prenotazioneConfermata.jsp");
  }

  @Test
  public void executeSuccessTuristaNonRegistrato(){
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);

    Mockito.when(mockReq.getSession().getAttribute("lido")).thenReturn(new Lido(1,"","","","","",1F,1,1,1));
    Mockito.when(mockReq.getParameter("dataInizio")).thenReturn("2021-01-01");
    Mockito.when(mockReq.getParameter("dataFine")).thenReturn("2021-01-01");
    Mockito.when(mockReq.getParameter("numPosti")).thenReturn("1");
    Mockito.when(mockReq.getSession().getAttribute("giorni")).thenReturn("1");

    Mockito.when(mockReq.getSession().getAttribute("utente")).thenReturn(null);
    Mockito.when(mockReq.getParameter("nome")).thenReturn("abc");
    Mockito.when(mockReq.getParameter("cognome")).thenReturn("abc");
    Mockito.when(mockReq.getParameter("email")).thenReturn("abc");

    String[] array = {"1_1", "1_2", "1_3"};
    Mockito.when(mockReq.getSession().getAttribute("postiSelezionati")).thenReturn(array);

    action = new EseguiPrenotazione1Action();
    String result = action.execute(mockReq, mockRes);
    assertEquals(result, "/WEB-INF/views/prenotazioneConfermata.jsp");
  }
}
