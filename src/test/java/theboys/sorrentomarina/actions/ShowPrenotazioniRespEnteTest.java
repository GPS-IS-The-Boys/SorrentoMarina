package theboys.sorrentomarina.actions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import theboys.sorrentomarina.actions.actionsPrenotazione.ShowPrenotazioniRespEnte;
import theboys.sorrentomarina.models.modelsUtente.ResponsabileEnte;

import javax.servlet.ServletContext;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShowPrenotazioniRespEnteTest extends ActionSetupDB{

  private ShowPrenotazioniRespEnte spre;

  @Test
  public void ShowPrenotazioniRespEnteTest(){
    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(ActionSetupDB.mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    Mockito.when(mockReq.getSession().getAttribute("adminEnte")).thenReturn(new ResponsabileEnte(1, "nome", "cognome", "email", "username", "password"));
    spre = new ShowPrenotazioniRespEnte();
    String page = this.spre.execute(mockReq,mockRes);
    assertEquals("/WEB-INF/views/prenotazioniRespEnte.jsp",page);
  }

  @Test
  public void ShowPrenotazioniRespEnte500(){
    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(null);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    Mockito.when(mockReq.getSession().getAttribute("adminEnte")).thenReturn(new ResponsabileEnte(1, "nome", "cognome", "email", "username", "password"));
    spre = new ShowPrenotazioniRespEnte();
    String page = this.spre.execute(mockReq,mockRes);
    assertEquals("/WEB-INF/views/500.jsp",page);
  }

  @Test
  public void ShowPrenotazioniRespEnteNull(){
    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(ActionSetupDB.mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    Mockito.when(mockReq.getSession().getAttribute("adminEnte")).thenReturn(null);
    spre = new ShowPrenotazioniRespEnte();
    String page = this.spre.execute(mockReq,mockRes);
    assertEquals("/WEB-INF/views/prenotazioniRespEnte.jsp",page);
  }
}
