package theboys.sorrentomarina.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MostraCreaLido implements Action{
  /**
   * Mostra il form per l'aggiunta di un nuovo lido
   *
   * @param request  the request
   * @param response the response
   * @return can return a URL or a view name
   */
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {
    return view("creaLido");
  }
}
