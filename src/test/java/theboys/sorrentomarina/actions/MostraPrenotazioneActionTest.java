package theboys.sorrentomarina.actions;

import org.junit.jupiter.api.Test;
import theboys.sorrentomarina.actions.actionsPrenotazione.MostraPrenotazioneAction;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * @author theBoys
 */
public class MostraPrenotazioneActionTest extends ActionSetup {
  /**
   *test - mostra con successo la prenotazione
   */
  @Test
  public void executeSuccess(){
    MostraPrenotazioneAction action = new MostraPrenotazioneAction();
    String page = action.execute(mockReq, mockRes);
    assertEquals(page, "/WEB-INF/views/prenotazione1.jsp");
  }
}
