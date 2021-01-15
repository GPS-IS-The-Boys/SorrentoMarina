package theboys.sorrentomarina.actions.actionsRecensione;

import theboys.sorrentomarina.actions.actionsUtils.Action;
import theboys.sorrentomarina.managers.managersRecensione.RecensioneManager;
import theboys.sorrentomarina.managers.managersRecensione.TableRecensioneManager;
import theboys.sorrentomarina.managers.managersUtente.TableTuristaManager;
import theboys.sorrentomarina.managers.managersUtente.TuristaManager;
import theboys.sorrentomarina.models.modelsRecensione.Recensione;
import theboys.sorrentomarina.models.modelsUtente.ResponsabileLido;
import theboys.sorrentomarina.models.modelsUtente.Turista;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
/**
 * @author theboys
 */
public class MostraRecensioniRespLidoAction implements Action {
  /**
   * Mostra tutte le recensioni del lido al responsabile
   *
   * @param request  la request
   * @param response la response
   * @return ritorna alla ddashboard dopo aver eliminato la recensione
   */
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {
    response.setStatus(HttpServletResponse.SC_ACCEPTED);
    try {
      RecensioneManager manager = new TableRecensioneManager(this.getSource(request));
      ResponsabileLido rl = (ResponsabileLido) request.getSession().getAttribute("adminLido") ;
      TuristaManager turistaManager = new TableTuristaManager(this.getSource(request));
      List<Recensione> listaRecensioni = manager.retriveById_Lido(rl.getId_lido());

      HashMap<Recensione, String> map = new HashMap<Recensione, String>();
      for (Recensione r : listaRecensioni) {
        Turista turista = turistaManager.retriveById(r.getId_turista());
        map.put(r, turista.getUsername());
      }
      request.setAttribute("mapRecensioni", map);
      return view("respLidoRecensioni");
    } catch (Exception e) {
      return view("500");
    }
  }
}
