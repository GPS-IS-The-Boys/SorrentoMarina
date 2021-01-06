package theboys.sorrentomarina.actions;

import theboys.sorrentomarina.managers.*;
import theboys.sorrentomarina.models.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class ShowDashboardEnteAction implements Action {

  /**
   * Exec a request action
   *
   * @param request  the request
   * @param response the response
   * @return can return a URL or a view name
   */
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {
    //mostra la dashboard del responsabile lido
    ResponsabileEnte re = (ResponsabileEnte) request.getSession().getAttribute("adminEnte");
    if (re == null) {
      return view("403");
    }
    try {
      LidoManager lidoManager = new TableLidoManager(this.getSource(request));
      List<Lido> lidi = lidoManager.retriveAll();
      request.setAttribute("lidiEnte", lidi);
      PrenotazioneManager prenotazioneManager = new TablePrenotazioneManager(getSource(request));
      request.setAttribute("incassoTotale",prenotazioneManager.incassoConsorzio());
      request.setAttribute("numeroPrenotazioni",prenotazioneManager.prenotazioniTotali());
      List<Prenotazione> prenotazioneList = prenotazioneManager.retriveAll();
      HashMap<Prenotazione,String> map =new HashMap<Prenotazione, String>();
      for(Prenotazione p : prenotazioneList){
        map.put(p,lidoManager.retriveById(p.getId_lido()).getNome());
      }
      request.setAttribute("mapPrenotazioni",map);
      return view("respEnteDashboard");

    } catch (SQLException throwables) {
      throwables.printStackTrace();
      return view("500");
    }
  }
}
