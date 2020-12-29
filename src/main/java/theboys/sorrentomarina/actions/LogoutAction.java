package theboys.sorrentomarina.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutAction implements Action {

  /**
   * effettua il logout dall'account utente
   *
   * @param request  la request
   * @param response la response
   * @return torna nella pagina da cui si è svolto il login
   */
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {
    request.getSession().removeAttribute("utente");
    return view("index");
  }
}