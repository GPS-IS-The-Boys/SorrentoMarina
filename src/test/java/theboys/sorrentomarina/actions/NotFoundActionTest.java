package theboys.sorrentomarina.actions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

/**
 * @author Diequ
 */
public class NotFoundActionTest extends ActionSetup {

  @Override
  @BeforeEach
  public void setup() {
    super.setup();
  }

  @Test
  public void testExecute() {
    NotFoundAction nfa = new NotFoundAction();
    String result = nfa.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/404.jsp", result,
        "It should return not found view path");
  }

}
