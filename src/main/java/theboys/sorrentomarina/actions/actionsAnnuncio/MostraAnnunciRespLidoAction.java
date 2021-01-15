package theboys.sorrentomarina.actions.actionsAnnuncio;

import theboys.sorrentomarina.actions.actionsUtils.Action;
import theboys.sorrentomarina.managers.managersAnnuncio.AnnuncioManager;
import theboys.sorrentomarina.managers.managersAnnuncio.TableAnnuncioManager;
import theboys.sorrentomarina.models.modelsAnnuncio.Annuncio;
import theboys.sorrentomarina.models.modelsUtente.ResponsabileLido;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
/**
 * @author theboys
 */
public class MostraAnnunciRespLidoAction implements Action {

  /**
   * Mostra al responsabile lido gli annunci relativi al suo lido
   *
   * @param request  la request
   * @param response la response
   * @return ritorna la pagina dedicata agli annunci
   */
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {
    response.setStatus(HttpServletResponse.SC_ACCEPTED);
    try {
      AnnuncioManager manager = new TableAnnuncioManager(getSource(request));
      ResponsabileLido rlido = (ResponsabileLido) request.getSession().getAttribute("adminLido");
      List<Annuncio> list = manager.retriveById_Lido(rlido.getId_lido());
      request.setAttribute("listaAnnunci", list);
      return view("respLidoAnnunci");
    } catch (Exception e) {
      e.printStackTrace();
      return view("500");
    }
  }
}
