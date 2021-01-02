package theboys.sorrentomarina.actions;

import theboys.sorrentomarina.models.ResponsabileEnte;
import theboys.sorrentomarina.models.ResponsabileLido;
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
    ResponsabileLido rl = (ResponsabileLido) request.getSession().getAttribute("adminLido");
    ResponsabileEnte re = (ResponsabileEnte) request.getSession().getAttribute("adminEnte");

    if (t != null) {
      request.getSession().setAttribute("utente", t);
      return view("profilo");
    } else if (rl != null) {
      request.getSession().setAttribute("adminLido", rl);
      return view("profilo");
    } else if (re != null) {
      request.getSession().setAttribute("adminEnte", re);
      return view("profilo");
    }

    return redirect("/SorrentoMarina/");
  }
}
