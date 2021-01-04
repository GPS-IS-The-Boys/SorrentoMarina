package theboys.sorrentomarina.actions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import theboys.sorrentomarina.models.ResponsabileEnte;
import theboys.sorrentomarina.models.ResponsabileLido;
import javax.servlet.ServletContext;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShowPrenotazioniRespEnteTest extends ActionSetup{

  private ShowPrenotazioniRespEnte spre;

  @Override
  @BeforeEach
  public void setup(){
    super.setup();
  }

  @Test
  public void ShowPrenotazioniRespEnteTest(){
    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(ActionSetupDB.mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    Mockito.when(mockReq.getSession().getAttribute("adminENte")).thenReturn(new ResponsabileEnte(1, "nome", "cognome", "email", "username", "password"));
    spre = new ShowPrenotazioniRespEnte();
    String page = this.spre.execute(mockReq,mockRes);
    assertEquals("/WEB-INF/views/prenotazioniRespEnte.jsp",page);
  }

}
