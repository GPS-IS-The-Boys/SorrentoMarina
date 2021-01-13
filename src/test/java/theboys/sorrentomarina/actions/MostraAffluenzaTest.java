package theboys.sorrentomarina.actions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MostraAffluenzaTest extends ActionSetup {
  @Override
  @BeforeEach
  public void setup(){
    super.setup();
  }

  /**
   * Controlla che la view ritornata è quella corretta, ossia la pagina di affluenza
   *
   */
  @Test
  public void textView() {
    Action ac = Mockito.mock(MostraAffluenza.class, Mockito.CALLS_REAL_METHODS);
    String result = ac.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/affluenzaLido.jsp", result, "It should return the view path");
  }
}
