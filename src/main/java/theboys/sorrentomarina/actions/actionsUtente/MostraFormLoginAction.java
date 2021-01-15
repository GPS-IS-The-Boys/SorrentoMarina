package theboys.sorrentomarina.actions.actionsUtente;

import theboys.sorrentomarina.actions.actionsUtils.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * @author theboys
 */
public class MostraFormLoginAction implements Action {

  /**
   * Mostra il form di login
   * @author Francesco Pio Covino
   * @param request  la request
   * @param response la response
   * @return ritorna la view del form di login
   */
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {
    response.setStatus(HttpServletResponse.SC_ACCEPTED);
    return view("login");
  }
}
