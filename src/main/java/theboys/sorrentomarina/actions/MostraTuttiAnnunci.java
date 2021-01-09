package theboys.sorrentomarina.actions;

import theboys.sorrentomarina.managers.*;
import theboys.sorrentomarina.models.Annuncio;
import theboys.sorrentomarina.models.Lido;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

public class MostraTuttiAnnunci implements Action {
  /**
   * Mostra al responsabile
   *
   * @param request  the request
   * @param response the response
   * @return can return a URL or a view name
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
