package theboys.sorrentomarina.actions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import theboys.sorrentomarina.models.Turista;
import javax.servlet.ServletContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShowPrenotazioniTuristaTest extends ActionSetup {

  private ShowPrenotazioniTurista spt;

  @Override
  @BeforeEach
  public void setup() {
    super.setup();
  }

  @Test
  public void ShowPrenotazioniTuristaTest() {
    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(ActionSetupDB.mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    Mockito.when(mockReq.getSession().getAttribute("utente")).thenReturn(new Turista(1, "nome", "cognome", "email", "Username1", "password1"));
    spt = new ShowPrenotazioniTurista();

    String page = this.spt.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/500.jsp", page);
  }
}