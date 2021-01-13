package theboys.sorrentomarina.actions;

import theboys.sorrentomarina.managers.LidoManager;
import theboys.sorrentomarina.managers.PrenotazioneManager;
import theboys.sorrentomarina.managers.TableLidoManager;
import theboys.sorrentomarina.managers.TablePrenotazioneManager;
import theboys.sorrentomarina.models.Lido;
import theboys.sorrentomarina.models.Prenotazione;
import theboys.sorrentomarina.models.Turista;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class ShowPrenotazioniTurista implements Action {

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