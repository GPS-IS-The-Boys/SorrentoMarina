package theboys.sorrentomarina.actions.actionsLido;

import theboys.sorrentomarina.actions.actionsUtils.Action;
import theboys.sorrentomarina.managers.managersLido.LidoManager;
import theboys.sorrentomarina.managers.managersLido.ServizioManager;
import theboys.sorrentomarina.managers.managersLido.TableLidoManager;
import theboys.sorrentomarina.managers.managersLido.TableServizioManager;
import theboys.sorrentomarina.models.modelsLido.Lido;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * @author theboys
 */
public class LidoAction implements Action {
  /**
   * Acquisisce i servizi relativi al lido
   *
   * @param request the request
   * @param response the response
   * @return ritorna la view del lido
   */
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {
    response.setStatus(HttpServletResponse.SC_ACCEPTED);
    try {
      int idLido = Integer.parseInt(request.getParameter("id"));
      request.getSession().setAttribute("idLido", idLido);
      LidoManager manager = new TableLidoManager(this.getSource(request));
      Lido lido = manager.retriveById(idLido);
      request.getSession().setAttribute("lido", lido);
      ServizioManager servizioManager = new TableServizioManager(this.getSource(request));
      request.setAttribute("serviziLido", servizioManager.retriveById(lido.getId_servizi()));
      return view("lido");
    } catch (Exception e) {
      return view("500");
    }
  }
}
