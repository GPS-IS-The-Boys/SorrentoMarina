package theboys.sorrentomarina.actions;

import theboys.sorrentomarina.managers.AnnuncioManager;
import theboys.sorrentomarina.managers.TableAnnuncioManager;
import theboys.sorrentomarina.models.Annuncio;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * @author theboys
 */
public class DettagliAnnuncioAction implements Action {
  /**
   * Mostra i dettagli di un annuncio
   *
   * @param request the request
   * @param response the response
   * @return ritorna la view con i dettagli di un annuncio
   */
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {
    response.setStatus(HttpServletResponse.SC_ACCEPTED);
    AnnuncioManager manager = new TableAnnuncioManager(this.getSource(request));
    try {
      int idAnnuncio = Integer.parseInt(request.getParameter("idAnnuncio"));
      Annuncio annuncio = manager.retriveById(idAnnuncio);
      request.getSession().setAttribute("annuncio", annuncio);
      return view("dettagliAnnuncio");
    } catch (Exception e) {
      return view("500");
    }
  }
}
