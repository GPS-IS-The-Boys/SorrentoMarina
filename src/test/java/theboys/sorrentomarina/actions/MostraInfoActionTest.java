package theboys.sorrentomarina.actions;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MostraInfoActionTest extends ActionSetup{

  @Override
  @BeforeEach
  public void setup(){
    super.setup();
  }

  /**
   * Controlla che la view tornata è corretta
   */
  @Test
  public void testAction(){
    Action ac = Mockito.mock(MostraInfoAction.class, Mockito.CALLS_REAL_METHODS);
    String result = ac.view("info");
    assertEquals("/WEB-INF/views/info.jsp", result, "It should return the info path");
  }
}
