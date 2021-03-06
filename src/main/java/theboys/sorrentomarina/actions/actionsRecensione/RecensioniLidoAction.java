package theboys.sorrentomarina.actions.actionsRecensione;

import theboys.sorrentomarina.actions.actionsUtils.Action;
import theboys.sorrentomarina.managers.managersRecensione.RecensioneManager;
import theboys.sorrentomarina.managers.managersRecensione.TableRecensioneManager;
import theboys.sorrentomarina.managers.managersUtente.TableTuristaManager;
import theboys.sorrentomarina.managers.managersUtente.TuristaManager;
import theboys.sorrentomarina.models.modelsLido.Lido;
import theboys.sorrentomarina.models.modelsRecensione.Recensione;
import theboys.sorrentomarina.models.modelsUtente.Turista;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
/**
 * @author theboys
 */
public class RecensioniLidoAction implements Action {
  /**
   * Acquisisce tutte le recensioni di un lido
   *
   * @param request the request
   * @param response the response
   * @return ritorna alla view recensioniLido
   */
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {
    response.setStatus(HttpServletResponse.SC_ACCEPTED);
    try {
      RecensioneManager manager = new TableRecensioneManager(this.getSource(request));
      TuristaManager managerTurista = new TableTuristaManager(this.getSource(request));
      Lido lido = (Lido) request.getSession().getAttribute("lido");
      List<Recensione> listaRecensioni = manager.retriveById_Lido(lido.getId());
      System.out.println(listaRecensioni.size());
      HashMap<Recensione, String> map = new HashMap<Recensione, String>();
      for (Recensione r : listaRecensioni) {
        Turista turista = managerTurista.retriveById(r.getId_turista());
        map.put(r, turista.getUsername());
      }
      request.setAttribute("mapRecensioni", map);
      return view("recensioniLido");
    } catch (Exception e) {
      return view("500");
    }
  }
}
