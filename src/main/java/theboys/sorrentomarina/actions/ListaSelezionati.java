package theboys.sorrentomarina.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListaSelezionati implements Action {

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
