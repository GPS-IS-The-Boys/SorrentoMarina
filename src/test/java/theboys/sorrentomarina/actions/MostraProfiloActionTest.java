package theboys.sorrentomarina.actions;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import theboys.sorrentomarina.actions.actionsUtente.MostraProfiloAction;
import theboys.sorrentomarina.models.modelsUtente.ResponsabileEnte;
import theboys.sorrentomarina.models.modelsUtente.ResponsabileLido;
import theboys.sorrentomarina.models.modelsUtente.Turista;
import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * @author theBoys
 */
public class MostraProfiloActionTest extends ActionSetup {

  private MostraProfiloAction action;

  /**
   * Test nel caso di successo
   * mostra il profilo del turista loggato
   */
  @Test
  public void TuristaSuccessTest(){
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    Mockito.when(mockReq.getSession().getAttribute("adminLido")).thenReturn(null);
    Mockito.when(mockReq.getSession().getAttribute("adminEnte")).thenReturn(null);
    Mockito.when(mockReq.getSession().getAttribute("utente")).thenReturn(new Turista(1, "", "", "", "", ""));

    action = new MostraProfiloAction();
    String page = this.action.execute(mockReq, mockRes);

    assertEquals("/WEB-INF/views/profilo.jsp", page);
  }

  /**
   * Test nel caso di successo
   * mostra il profilo del responsabile lido loggato
   */
  @Test
  public void RespLidoSuccessTest(){
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    Mockito.when(mockReq.getSession().getAttribute("adminLido")).thenReturn(new ResponsabileLido(1, "", "", "", "", "", 1,1));
    Mockito.when(mockReq.getSession().getAttribute("adminEnte")).thenReturn(null);
    Mockito.when(mockReq.getSession().getAttribute("utente")).thenReturn(null);

    action = new MostraProfiloAction();
    String page = this.action.execute(mockReq, mockRes);

    assertEquals("/WEB-INF/views/profilo.jsp", page);
  }

  /**
   * Test nel caso di successo
   * mostra il profilo del responsabile ente loggato
   */
  @Test
  public void RespEnteSuccessTest(){
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    Mockito.when(mockReq.getSession().getAttribute("adminLido")).thenReturn(null);
    Mockito.when(mockReq.getSession().getAttribute("adminEnte")).thenReturn(new ResponsabileEnte(1, "", "", "", "", ""));
    Mockito.when(mockReq.getSession().getAttribute("utente")).thenReturn(null);

    action = new MostraProfiloAction();
    String page = this.action.execute(mockReq, mockRes);

    assertEquals("/WEB-INF/views/profilo.jsp", page);
  }

  /**
   * Test nel caso di insuccesso per il turista
   * mostra l'homepage
   */
  @Test
  public void TuristaFailureTest(){
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    Mockito.when(mockReq.getSession().getAttribute("adminLido")).thenReturn(null);
    Mockito.when(mockReq.getSession().getAttribute("adminEnte")).thenReturn(null);
    Mockito.when(mockReq.getSession().getAttribute("utente")).thenReturn(null);

    action = new MostraProfiloAction();
    String page = this.action.execute(mockReq, mockRes);

    assertEquals("redirect:/SorrentoMarina/", page);
  }
}
