package theboys.sorrentomarina.actions.actionsAnnuncio;

import theboys.sorrentomarina.actions.actionsUtils.Action;
import theboys.sorrentomarina.managers.managersAnnuncio.AnnuncioManager;
import theboys.sorrentomarina.managers.managersAnnuncio.TableAnnuncioManager;
import theboys.sorrentomarina.models.modelsAnnuncio.Annuncio;
import theboys.sorrentomarina.models.modelsLido.Lido;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
/**
 * @author theboys
 */
public class AnnunciLidoAction implements Action {
  /**
   * Effetua una ricerca degli annunci di un lido
   *
   * @param request the request
   * @param response the response
   * @return la view annunciLido o in caso di errore la view 500
   */
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {
    response.setStatus(HttpServletResponse.SC_ACCEPTED);
    try {
      AnnuncioManager manager = new TableAnnuncioManager(getSource(request));
      Lido lido = (Lido) request.getSession().getAttribute("lido");
      List<Annuncio> list = manager.retriveById_Lido(lido.getId());
      request.setAttribute("listaAnnunci", list);
      return view("annunciLido");
    } catch (Exception e) {
      e.printStackTrace();
      return view("500");
    }
  }
}
