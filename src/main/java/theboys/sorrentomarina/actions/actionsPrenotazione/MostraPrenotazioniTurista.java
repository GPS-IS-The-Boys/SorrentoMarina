package theboys.sorrentomarina.actions.actionsPrenotazione;

import theboys.sorrentomarina.actions.actionsUtils.Action;
import theboys.sorrentomarina.managers.managersLido.LidoManager;
import theboys.sorrentomarina.managers.managersPrenotazione.PrenotazioneManager;
import theboys.sorrentomarina.managers.managersLido.TableLidoManager;
import theboys.sorrentomarina.managers.managersPrenotazione.TablePrenotazioneManager;
import theboys.sorrentomarina.models.modelsLido.Lido;
import theboys.sorrentomarina.models.modelsPrenotazione.Prenotazione;
import theboys.sorrentomarina.models.modelsUtente.Turista;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
/**
 * @author theBoys
 */
public class MostraPrenotazioniTurista implements Action {
  /**
   * Metodo che mostra la lista di tutte le prenotazioni del turista
   *
   * @param request the request
   * @param response the response
   * @return ritorna la view prenotazioniTurista
   */
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {
    LidoManager lidoManager = new TableLidoManager(this.getSource(request));
    PrenotazioneManager tablePrenotazioneManager =
        new TablePrenotazioneManager(this.getSource(request));

    HttpSession session = request.getSession();
    Turista turista = (Turista) session.getAttribute("utente");
    HashMap<Lido, Prenotazione> map = new HashMap<Lido, Prenotazione>();

    if (turista != null) {
      try {
        List<Prenotazione> list = tablePrenotazioneManager.retriveByIdTurista(turista.getId());
        for (Prenotazione p : list) {
          Lido lido = lidoManager.retriveById(p.getId_lido());
          map.put(lido, p);
        }
        request.setAttribute("prenotazioniMap", map);
        return view("prenotazioniTurista");

      } catch (SQLException throwables) {
        return view("500");
      }
    } else
      return view("prenotazioniTurista");
  }
}