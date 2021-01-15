package theboys.sorrentomarina.actions;

import org.junit.jupiter.api.Test;
import theboys.sorrentomarina.actions.actionsPrenotazione.MostraPrenotazioneAction;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MostraPrenotazioneActionTest extends ActionSetup {

  @Test
  public void executeSuccess(){
    MostraPrenotazioneAction action = new MostraPrenotazioneAction();
    String page = action.execute(mockReq, mockRes);
    assertEquals(page, "/WEB-INF/views/prenotazione1.jsp");
  }
}
