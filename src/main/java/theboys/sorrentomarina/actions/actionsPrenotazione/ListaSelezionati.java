package theboys.sorrentomarina.actions.actionsPrenotazione;

import theboys.sorrentomarina.actions.actionsUtils.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * @author theboys
 */
public class ListaSelezionati implements Action {

  /**
   * Setta nella sessione i posti selezionati e i giorni
   *
   * @param request the request
   * @param response the response
   * @return
   */
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {

    String lista = request.getParameter("lista");
    String [] selezionati = lista.split(",");
    int giorni = Integer.parseInt(request.getParameter("giorni"));
    request.getSession().setAttribute("postiSelezionati", selezionati);
    request.getSession().setAttribute("giorni", giorni);
    return "ajax";
  }
}
