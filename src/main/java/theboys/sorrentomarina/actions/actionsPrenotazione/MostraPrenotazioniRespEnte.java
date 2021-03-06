package theboys.sorrentomarina.actions.actionsPrenotazione;

import theboys.sorrentomarina.actions.actionsUtils.Action;
import theboys.sorrentomarina.managers.managersPrenotazione.PrenotazioneManager;
import theboys.sorrentomarina.managers.managersPrenotazione.TablePrenotazioneManager;
import theboys.sorrentomarina.models.modelsPrenotazione.Prenotazione;
import theboys.sorrentomarina.models.modelsUtente.ResponsabileEnte;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

/**
 * @author theBoys
 */

public class MostraPrenotazioniRespEnte implements Action {


  /**
   * Metodo che mostra la lista di tutte le prenotazioni
   *
   * @param request  - HttpServletRequest
   * @param response - HttpServletResponse
   * @return String - path della prossmia pagina
   * @throws SQLException - eccezione lanciata a causa di problemi con la query
   */
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {
    PrenotazioneManager tablePrenotazioneManager =
        new TablePrenotazioneManager(this.getSource(request));
    HttpSession session = request.getSession();
    ResponsabileEnte responsabileEnte = (ResponsabileEnte) session.getAttribute("adminEnte");
    if (responsabileEnte != null)
      try {
        List<Prenotazione> list = tablePrenotazioneManager.retriveAll();
        request.setAttribute("prenotazioni", list);
        return view("prenotazioniRespEnte");
      } catch (SQLException throwables) {
        return view("500");
      }
    else
      return view("prenotazioniRespEnte");
  }
}
