package theboys.sorrentomarina.actions;

import theboys.sorrentomarina.models.Turista;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MostraProfiloAction implements Action {

  /**
   * Mostra il profilo all'utente loggato
   *
   * @param request  la request
   * @param response la response
   * @return ritorna la pagina profilo dell'utente
   */
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {
    Turista t = (Turista) request.getSession().getAttribute("utente");
    if (t != null) {
      request.getSession().setAttribute("utente", t);
      return view("profilo");
    }
    return view("index");
  }
}
