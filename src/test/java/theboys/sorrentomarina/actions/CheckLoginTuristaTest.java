package theboys.sorrentomarina.actions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.servlet.http.HttpSession;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckLoginTuristaTest extends ActionSetup{

  @Override
  @BeforeEach
  public void setup() {
    super.setup();
  }

  /**
   * Caso in cui le credenziali appartengono al turista e viene mostrata l'index
   */
  @Test
  public void textSuccessExecuteWithoutNext() {
    CheckLoginTurista ca = Mockito.mock(CheckLoginTurista.class, Mockito.CALLS_REAL_METHODS);
    HttpSession session = Mockito.mock(HttpSession.class);
    Mockito.when(mockReq.getParameter("username")).thenReturn("mgiordano");
    Mockito.when(mockReq.getParameter("password")).thenReturn("Masterchef1");
    Mockito.when(mockReq.getSession()).thenReturn(session);
    String result = ca.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/index.jsp", result, "Ritorna la pagina principale");
  }

  /**
   * Caso in cui le credenziali non sono di un turista e viene richiamata una seconda azione
   */
  @Test
  public void testExecuteWithNext() {
    CheckLoginTurista ca = Mockito.mock(CheckLoginTurista.class, Mockito.CALLS_REAL_METHODS);
    ca.setNext(new CheckLoginRespLido());
    String result = ca.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/index.jsp", result, "Porta ");
  }
}
