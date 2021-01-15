package theboys.sorrentomarina.actions.actionsUtente;

import theboys.sorrentomarina.actions.actionsUtils.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * @author theboys
 */
public class MostraInfoAction implements Action {

  /**
   * Esegue la request action
   *
   * @param request  the request
   * @param response the response
   * @return ritorna una view
   */
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {
    response.setStatus(HttpServletResponse.SC_ACCEPTED);
    return view("info");
  }
}
