package theboys.sorrentomarina.actions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * @author theBoys
 */
public class MostraPrenotazioneActionTest extends ActionSetup {
  /**
   *
   */
  @Test
  public void executeSuccess(){
    MostraPrenotazione1Action action = new MostraPrenotazione1Action();
    String page = action.execute(mockReq, mockRes);
    assertEquals(page, "/WEB-INF/views/prenotazione1.jsp");
  }
}
