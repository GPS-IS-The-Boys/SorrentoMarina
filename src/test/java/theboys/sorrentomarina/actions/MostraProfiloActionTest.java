package theboys.sorrentomarina.actions;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import theboys.sorrentomarina.models.ResponsabileEnte;
import theboys.sorrentomarina.models.ResponsabileLido;
import theboys.sorrentomarina.models.Turista;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MostraProfiloActionTest extends ActionSetup {

  private MostraProfiloAction action;

  /**
   * Test nel caso di successo
   * mostra il profilo dell'utente loggato
   */
  @Test
  public void SuccessTest(){
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    Mockito.when(mockReq.getSession().getAttribute("adminLido")).thenReturn(new ResponsabileLido(1,"", "", "", "","",2));
    Mockito.when(mockReq.getSession().getAttribute("adminEnte")).thenReturn(new ResponsabileEnte());
    Mockito.when(mockReq.getSession().getAttribute("utente")).thenReturn(new Turista());

    action = new MostraProfiloAction();
    String page = this.action.execute(mockReq, mockRes);

    assertEquals("/WEB-INF/views/profilo.jsp", page);
  }

  /**
   * Test nel caso di insuccesso
   * mostra l'homepage
   */
  @Test
  public void FailureTest(){
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    Mockito.when(mockReq.getSession().getAttribute("adminLido")).thenReturn(null);
    Mockito.when(mockReq.getSession().getAttribute("adminEnte")).thenReturn(null);
    Mockito.when(mockReq.getSession().getAttribute("utente")).thenReturn(null);

    action = new MostraProfiloAction();
    String page = this.action.execute(mockReq, mockRes);

    assertEquals("redirect:/SorrentoMarina/", page);
  }
}
