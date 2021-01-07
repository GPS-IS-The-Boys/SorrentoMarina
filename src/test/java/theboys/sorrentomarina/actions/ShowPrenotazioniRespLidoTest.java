package theboys.sorrentomarina.actions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import theboys.sorrentomarina.models.ResponsabileLido;
import javax.servlet.ServletContext;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShowPrenotazioniRespLidoTest extends ActionSetup {

  private ShowPrenotazioniRespLido sprl;

  @Override
  @BeforeEach
  public void setup(){
    super.setup();
  }

  @Test
  public void ShowPrenotazioniRespLidoTest(){
    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(ActionSetupDB.mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    Mockito.when(mockReq.getSession().getAttribute("adminLido")).thenReturn(new ResponsabileLido(1, "nome", "cognome", "email", "username", "password",1));
    sprl = new ShowPrenotazioniRespLido();
    String page = this.sprl.execute(mockReq,mockRes);
    assertEquals("/WEB-INF/views/500.jsp",page);
  }
}
