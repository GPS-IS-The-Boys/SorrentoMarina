package theboys.sorrentomarina.actions;

import theboys.sorrentomarina.managers.*;
import theboys.sorrentomarina.models.Lido;
import theboys.sorrentomarina.models.Turista;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
/**
 * @author theboys
 */
public class EseguiPrenotazione1Action  implements Action{

  /**
   * Acquisisce tutte le informazioni per una determinata prenotazione che verrà effettuata
   *
   * @param request the request
   * @param response the response
   * @return ritorna una view di conferma della prenotazione
   */

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {
    try {
      Lido lido = (Lido) request.getSession().getAttribute("lido");
      int idLido = lido.getId();
      PrenotazioneManager prenotazioneManager = new TablePrenotazioneManager(getSource(request));

      // DURATA e POSTI
      String dataInizio = request.getParameter("dataInizio");
      String dataFine = request.getParameter("dataFine");
      int numPosti = Integer.parseInt(request.getParameter("numPosti"));

      // COSTO
      int giorni = (int) request.getSession().getAttribute("giorni");
      float costo = numPosti * lido.getPrezzo_singolo() * giorni;

      // DATI PERSONALI
      TuristaManager turistaManager = new TableTuristaManager(getSource(request));
      Turista turista = (Turista) request.getSession().getAttribute("utente");
      int idTurista;
      if (turista == null) {
        String nome = request.getParameter("nome");
        String cognome = request.getParameter("cognome");
        String email = request.getParameter("email");
        turistaManager.create(nome, cognome, email);
        idTurista = turistaManager.ultimateId();
      } else {
        idTurista = turista.getId();
      }
      // CREAZIONE PRENOTAZIONE
      prenotazioneManager.create(dataInizio, dataFine, numPosti, costo, idLido, idTurista);
      int idPrenotazione = prenotazioneManager.ultimateId();

      // OMBRELLONE
      OmbrelloneManager ombrelloneManager = new TableOmbrelloneManager(getSource(request));
      String[] ombrelloniSelezionati = (String[]) request.getSession().getAttribute("postiSelezionati");
      int numRiga;
      int numColonna;
      String[] coordinate;
      for (int i = 0; i < ombrelloniSelezionati.length; i++) {
        //SPLIT PER RICAVARE RIGA E COLONNA
        coordinate = ombrelloniSelezionati[i].split("_");
        numRiga = Integer.parseInt(coordinate[0]);
        numColonna = Integer.parseInt(coordinate[1]);
        //CREAZIONE OMBRELLONE
        ombrelloneManager.create(numRiga, numColonna, idPrenotazione);
      }

      // PAGAMENTO
      /*
      String intestatario = request.getParameter("intestatario");
      int numCarta = Integer.parseInt(request.getParameter("numCarta"));
      String dataScadenza = request.getParameter("dataScadenza");
      int cvv = Integer.parseInt(request.getParameter("cvv"));
      */
      return view("prenotazioneConfermata");
    } catch (Exception e) {
      e.printStackTrace();
      return view("500");
    }
  }
}
