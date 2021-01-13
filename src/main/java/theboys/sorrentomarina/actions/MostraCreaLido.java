package theboys.sorrentomarina.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * @author theboys
 */
public class MostraCreaLido implements Action {
  /**
   * Mostra il form per l'aggiunta di un nuovo lido
   *
   * @param request  la request
   * @param response la response
   * @return ritorna la view con il form di creazione lido
   */
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {
    return view("creaLido");
  }
}
