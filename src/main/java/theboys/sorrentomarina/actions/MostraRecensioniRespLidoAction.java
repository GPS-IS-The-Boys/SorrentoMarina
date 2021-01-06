package theboys.sorrentomarina.actions;

import theboys.sorrentomarina.managers.*;
import theboys.sorrentomarina.models.Lido;
import theboys.sorrentomarina.models.Recensione;
import theboys.sorrentomarina.models.ResponsabileLido;
import theboys.sorrentomarina.models.Turista;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

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
