package theboys.sorrentomarina.actions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import theboys.sorrentomarina.actions.actionsUtente.MostraFormRegistrazioneAction;
import theboys.sorrentomarina.actions.actionsUtils.Action;
import theboys.sorrentomarina.models.modelsUtente.Turista;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * @author theBoys
 */
public class MostraFormRegistrazioneActionTest extends ActionSetup{

  @Override
  @BeforeEach
  public void setup(){
    super.setup();
  }

  /**
   * Controlla che la view ritornata è quella corretta, ossia la pagina di registrazione
   *
   */
  @Test
  public void successTest() {
    Action ac = Mockito.mock(MostraFormRegistrazioneAction.class, Mockito.CALLS_REAL_METHODS);
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    Mockito.when(mockReq.getSession().getAttribute("utente")).thenReturn(null);
    String result = ac.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/registrazione.jsp", result,
        "It should return the view path");
  }

  /**
   * Controlla che la view ritornata è quella  non corretta, ossia ritorna la pagina di index
   *
   */
  @Test
  public void failureTest() {
    Action ac = Mockito.mock(MostraFormRegistrazioneAction.class, Mockito.CALLS_REAL_METHODS);
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    Mockito.when(mockReq.getSession().getAttribute("utente")).thenReturn(new Turista(1, "a", "", "", "", ""));
    String result = ac.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/index.jsp", result,
        "It should return the view path");
  }
}
