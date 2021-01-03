package theboys.sorrentomarina.actions;

import theboys.sorrentomarina.managers.PrenotazioneManager;
import theboys.sorrentomarina.managers.TablePrenotazioneManager;
import theboys.sorrentomarina.models.Prenotazione;
import theboys.sorrentomarina.models.ResponsabileLido;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Luigi Maiorano
 * @version 0.1
 */

public class ShowPrenotazioniRespLido implements Action {


  /**
   * Metodo che mostra la lista di tutte le prenotazioni del lido
   *
   * @param request - HttpServletRequest
   * @param response - HttpServletResponse
   * @return String - path della prossmia pagina
   * @throws SQLException - eccezione lanciata a causa di problemi con la query
   */
  @Override
  public String execute(HttpServletRequest request , HttpServletResponse response) {
    PrenotazioneManager tablePrenotazioneManager = new TablePrenotazioneManager(this.getSource(request));
    HttpSession session = request.getSession();
    ResponsabileLido responsabileLido = (ResponsabileLido) session.getAttribute("adminLido");
    if(responsabileLido!=null)
    try {
      List<Prenotazione> list = tablePrenotazioneManager.retriveByIdLido(responsabileLido.getId_lido());
      request.setAttribute("prenotazioni", list);
      return view("prenotazioniRespLido");
    } catch (SQLException throwables) {
      return view("500");
    }else
    return view("prenotazioniRespLido");
  }
}

