package theboys.sorrentomarina.actions;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import theboys.sorrentomarina.actions.actionsUtente.MostraInfoAction;
import theboys.sorrentomarina.actions.actionsUtils.Action;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * @author theBoys
 */
public class MostraInfoActionTest extends ActionSetup{

  @Override
  @BeforeEach
  public void setup(){
    super.setup();
  }

  /**
   * Controlla che la view tornata sia corretta
   */
  @Test
  public void testAction(){
    Action ac = Mockito.mock(MostraInfoAction.class, Mockito.CALLS_REAL_METHODS);
    String result = ac.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/info.jsp", result, "It should return the info path");
  }
}
