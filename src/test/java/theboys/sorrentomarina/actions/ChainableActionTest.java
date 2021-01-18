package theboys.sorrentomarina.actions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import theboys.sorrentomarina.actions.actionsUtils.ChainableAction;
import theboys.sorrentomarina.actions.actionsUtils.NotFoundAction;

/**
 * @author theBoys
 */
public class ChainableActionTest extends ActionSetup {

  @Override
  @BeforeEach
  public void setup(){
    super.setup();
  }

  /**
   * Esegue Test senza un successivo ()
   */
  @Test
  public void textExecuteWithoutNext() {
    ChainableAction ca = Mockito.mock(ChainableAction.class,
        Mockito.CALLS_REAL_METHODS);
    String result = ca.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/500.jsp", result,
        "It should return internal error view  without next");
  }

  /**
   *Esegue Test con un successivo  ()
   */
  @Test
  public void testExecuteWithNext() {
    ChainableAction ca = Mockito.mock(ChainableAction.class,
        Mockito.CALLS_REAL_METHODS);
    ca.setNext(new NotFoundAction());
    String result = ca.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/404.jsp", result,
        "It should return not found view path");
  }
}
