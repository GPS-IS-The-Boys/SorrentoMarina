package theboys.sorrentomarina.actions.actionsLido;

import theboys.sorrentomarina.actions.actionsUtils.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * @author theboys
 */
public class MostraPrevisioni implements Action {
  /**
   * Esegue la request action
   *
   * @param request the request
   * @param response the response
   * @return ritorna la view previsioniMeteo
   */
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {
    return view("previsioniMeteo");
  }
}
