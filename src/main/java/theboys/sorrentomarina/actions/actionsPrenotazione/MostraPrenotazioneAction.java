package theboys.sorrentomarina.actions.actionsPrenotazione;

import theboys.sorrentomarina.actions.actionsUtils.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author theboys
 */
public class MostraPrenotazioneAction implements Action {

  /**
   * Esegue la request action
   *
   * @param request the request
   * @param response the response
   * @return ritorna la view prenotazione1
   */
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {
    return view("prenotazione1");
  }
}
