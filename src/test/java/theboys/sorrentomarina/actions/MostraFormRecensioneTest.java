package theboys.sorrentomarina.actions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import theboys.sorrentomarina.actions.actionsRecensione.MostraFormRecensione;
import theboys.sorrentomarina.actions.actionsUtils.Action;
import theboys.sorrentomarina.models.modelsUtente.Turista;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author theBoys
 */
public class MostraFormRecensioneTest extends ActionSetup{

  @Override
  @BeforeEach
  public void setup(){
    super.setup();
  }

  /**
   *test controlla che la view ritornata è quella corretta, ossia la pagina di formRecensione
   */
  @Test
  public void SuccessTextView() {
    Action ac = Mockito.mock(MostraFormRecensione.class, Mockito.CALLS_REAL_METHODS);
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    Mockito.when(mockReq.getSession().getAttribute("utente")).thenReturn(new Turista());
    String result = ac.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/formRecensione.jsp", result,
        "It should return the view path");
  }

  /**
   * Controlla che la view ritornata non è quella corretta, ritorna la pagina di login
   */
  @Test
  public void FailureTextView() {
    Action ac = Mockito.mock(MostraFormRecensione.class, Mockito.CALLS_REAL_METHODS);
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    Mockito.when(mockReq.getSession().getAttribute("utente")).thenReturn(null);
    String result = ac.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/login.jsp", result,
        "It should return the view path");
  }
}
