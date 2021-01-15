package theboys.sorrentomarina.actions.actionsUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author theBoys
 */
public class NotFoundAction implements Action {
  /**
   * Esegue la request action
   *
   * @param request the request
   * @param response the response
   * @return ritorna la view 404
   */
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {
    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    return view("404");
  }

}
