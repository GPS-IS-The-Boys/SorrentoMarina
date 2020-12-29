package theboys.sorrentomarina.actions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WelcomeActionTest extends ActionSetup{

  @Override
  @BeforeEach
  public void setup() {
    super.setup();
  }

  /**
   * Controlla che la view ritornata è quella corretta, ossia la index
   *
   * @author Francesco Pio Covino
   */
  @Test
  public void textView() {
    Action ac = Mockito.mock(WelcomeAction.class, Mockito.CALLS_REAL_METHODS);
    String result = ac.view("index");
    assertEquals("/WEB-INF/views/index.jsp", result,
        "It should return the view path");
  }
}
