package theboys.sorrentomarina.actions.actionsUtente;

import theboys.sorrentomarina.actions.actionsUtils.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * @author theboys
 */
public class MostraFormRegistrazioneAction implements Action {
  /**
   * Apre il form di registrazione del turista
   *
   * @param request  la request
   * @param response la response
   * @return la jsp adibita alla registrazione del turista
   * @author Francesco Pio Covino
   */
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {
    if (request.getSession().getAttribute("utente") != null) {
      return view("index");
    }
    response.setStatus(HttpServletResponse.SC_ACCEPTED);
    return view("registrazione");
  }
}
