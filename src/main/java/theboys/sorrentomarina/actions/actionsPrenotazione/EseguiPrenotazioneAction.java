package theboys.sorrentomarina.actions.actionsPrenotazione;

import theboys.sorrentomarina.actions.actionsUtils.Action;
import theboys.sorrentomarina.managers.managersPrenotazione.OmbrelloneManager;
import theboys.sorrentomarina.managers.managersPrenotazione.PrenotazioneManager;
import theboys.sorrentomarina.managers.managersPrenotazione.TableOmbrelloneManager;
import theboys.sorrentomarina.managers.managersPrenotazione.TablePrenotazioneManager;
import theboys.sorrentomarina.managers.managersUtente.TableTuristaManager;
import theboys.sorrentomarina.managers.managersUtente.TuristaManager;
import theboys.sorrentomarina.models.modelsLido.Lido;
import theboys.sorrentomarina.models.modelsUtente.Turista;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;

/**
 * @author theboys
 */
public class EseguiPrenotazioneAction implements Action {

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
        turista = turistaManager.retriveById(idTurista);
      } else {
        idTurista = turista.getId();
      }
      // CREAZIONE CODICE PRENOTAZIONE
      Random rand = new Random();
      String codice;
      do {
        int i1 = rand.nextInt(10);
        int i2 = rand.nextInt(10);
        int i3 = rand.nextInt(10);
        int i4 = rand.nextInt(10);
        char i5 = (char) (rand.nextInt(26) + 65);
        char i6 = (char) (rand.nextInt(26) + 65);
        codice = String.valueOf(i5) + String.valueOf(i6) + String.valueOf(i1) + String.valueOf(i2) + String.valueOf(i3) + String.valueOf(i4);
      }while(prenotazioneManager.codiceIsPresent(codice));

      //CREAZIONE PRENOTAZIONE
      prenotazioneManager.create(dataInizio, dataFine, numPosti, costo,codice, idLido, idTurista);
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

      // PAGAMENTO NON GESTITO
      /*
      String intestatario = request.getParameter("intestatario");
      int numCarta = Integer.parseInt(request.getParameter("numCarta"));
      String dataScadenza = request.getParameter("dataScadenza");
      int cvv = Integer.parseInt(request.getParameter("cvv"));
      */

      //INVIO EMAIL
      SendMail sender = new SendMail("Codice prenotazione", "Il tuo codice: " + codice, turista.getEmail());
      sender.send();

      return view("prenotazioneConfermata");
    } catch (Exception e) {
      e.printStackTrace();
      return view("500");
    }
  }
}
