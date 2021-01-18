package theboys.sorrentomarina.actions.actionsRecensione;

import theboys.sorrentomarina.actions.actionsUtils.Action;
import theboys.sorrentomarina.managers.managersLido.LidoManager;
import theboys.sorrentomarina.managers.managersLido.TableLidoManager;
import theboys.sorrentomarina.managers.managersRecensione.RecensioneManager;
import theboys.sorrentomarina.managers.managersRecensione.TableRecensioneManager;
import theboys.sorrentomarina.models.modelsLido.Lido;
import theboys.sorrentomarina.models.modelsRecensione.Recensione;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

/**
 * @author theboys
 */
public class MostraTutteRecensioni implements Action {
  /**
   * Esegue la request action
   *
   * @param request  the request
   * @param response the response
   * @return ritorna la view respEnteRecensioni
   */
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {

    response.setStatus(HttpServletResponse.SC_ACCEPTED);
    try {
      RecensioneManager managerRecensione = new TableRecensioneManager(this.getSource(request));
      LidoManager managerLido = new TableLidoManager(this.getSource(request));

      //prendo tutti i lidi della piattaforma
      List<Lido> lidi = managerLido.retriveAll();
      //per ogni lido prendo tutte le recensioni
      List<Recensione> recensioni;
      //conservo tutto in una hashmap
      HashMap<String, List<Recensione>> map = new HashMap<String, List<Recensione>>();

      for (Lido l: lidi) {
        recensioni = managerRecensione.retriveById_Lido(l.getId());
        //prendo tutte le recensioni di quel lido
        map.put(l.getNome(), recensioni);
      }
      request.setAttribute("mapRecensioni", map);
      return view("respEnteRecensioni");
    } catch (Exception e) {
      return view("500");
    }
  }
}