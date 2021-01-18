package theboys.sorrentomarina.actions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import theboys.sorrentomarina.actions.actionsLido.MostraCreaLido;
import theboys.sorrentomarina.actions.actionsUtils.Action;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * @author theBoys
 */
public class MostraCreaLidoActionTest extends ActionSetup {
  @Override
  @BeforeEach
  public void setup(){
    super.setup();
  }

  /**
   * Controlla che la view ritornata è quella corretta, ossia la
   * pagina con il form per l'aggiunta di un lido
   */
  @Test
  public void textView() {
    Action ac = Mockito.mock(MostraCreaLido.class, Mockito.CALLS_REAL_METHODS);
    String result = ac.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/creaLido.jsp", result, "It should return the view path");
  }
}
