package theboys.sorrentomarina.actions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MostraPrevisioniTest extends ActionSetup {
  @Override
  @BeforeEach
  public void setup(){
    super.setup();
  }

  /**
   * Controlla che la view ritornata è quella corretta, ossia la pagina delle previsioni meteo
   *
   */
  @Test
  public void textView() {
    Action ac = Mockito.mock(MostraPrevisioni.class, Mockito.CALLS_REAL_METHODS);
    String result = ac.view("previsioniMeteo");
    assertEquals("/WEB-INF/views/previsioniMeteo.jsp", result, "It should return the view path");
  }
}
