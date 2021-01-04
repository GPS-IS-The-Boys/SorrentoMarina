package theboys.sorrentomarina.actions;

import theboys.sorrentomarina.managers.AnnuncioManager;
import theboys.sorrentomarina.managers.TableAnnuncioManager;
import theboys.sorrentomarina.models.Annuncio;
import theboys.sorrentomarina.models.Lido;
import theboys.sorrentomarina.models.ResponsabileLido;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
      return view("annunciRespLido");
    } catch (Exception e) {
      e.printStackTrace();
      return view("500");
    }
  }
}
