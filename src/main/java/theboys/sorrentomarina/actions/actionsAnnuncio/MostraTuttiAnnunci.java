package theboys.sorrentomarina.actions.actionsAnnuncio;

import theboys.sorrentomarina.actions.actionsUtils.Action;
import theboys.sorrentomarina.managers.managersAnnuncio.AnnuncioManager;
import theboys.sorrentomarina.managers.managersAnnuncio.TableAnnuncioManager;
import theboys.sorrentomarina.managers.managersLido.LidoManager;
import theboys.sorrentomarina.managers.managersLido.TableLidoManager;
import theboys.sorrentomarina.models.modelsAnnuncio.Annuncio;
import theboys.sorrentomarina.models.modelsLido.Lido;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

public class MostraTuttiAnnunci implements Action {
  /**
   * Mostra al responsabile ente tutti gli annunci
   *
   * @param request  the request
   * @param response the response
   * @return ritorna la view respEnteAnnunci
   */
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {
    response.setStatus(HttpServletResponse.SC_ACCEPTED);
    try {
      AnnuncioManager managerAnnuncio = new TableAnnuncioManager(this.getSource(request));
      LidoManager managerLido = new TableLidoManager(this.getSource(request));

      //prendo tutti i lidi della piattaforma
      List<Lido> lidi = managerLido.retriveAll();
      //per ogni lido prendo tutte le recensioni
      List<Annuncio> annunci;
      //conservo tutto in una hashmap
      HashMap<String, List<Annuncio>> map = new HashMap<String, List<Annuncio>>();

      for (Lido l: lidi) {
        annunci = managerAnnuncio.retriveById_Lido(l.getId());
        //prendo tutte le recensioni di quel lido
        map.put(l.getNome(), annunci);
      }
      request.setAttribute("mapAnnunci", map);
      return view("respEnteAnnunci");
    } catch (Exception e) {
      return view("500");
    }
  }
}
