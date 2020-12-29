package theboys.sorrentomarina.actions;

import theboys.sorrentomarina.managers.PrenotazioneManager;
import theboys.sorrentomarina.managers.TablePrenotazioneManager;
import theboys.sorrentomarina.models.Prenotazione;
import theboys.sorrentomarina.models.Turista;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

public class ShowPrenotazioniTurista implements Action{

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {

    PrenotazioneManager tablePrenotazioneManager = new TablePrenotazioneManager(this.getSource(request));
    HttpSession session = request.getSession();
    Turista turista = (Turista) session.getAttribute("utente");
    if(turista != null){
      try {
        List<Prenotazione> list = tablePrenotazioneManager.retriveByIdTurista(turista.getId());
        request.setAttribute("prenotazioni", list);
        return view("prenotazioniTurista");
      } catch (SQLException throwables) {
        return view("500");
      }
    }
    else
      return view("prenotazioniTurista");

  }
}
