package theboys.sorrentomarina.actions;

import theboys.sorrentomarina.managers.*;
import theboys.sorrentomarina.models.Lido;
import theboys.sorrentomarina.models.Ombrellone;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class EseguiPrenotazione1Action  implements Action{
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {
    try{
      /*
      Lido lido = (Lido) request.getSession().getAttribute("lido");
      int idLido = lido.getId();
      PrenotazioneManager prenotazioneManager = new TablePrenotazioneManager(getSource(request));

      // DURATA e POSTI
      String dataInizio = request.getParameter("dataInizio");
      String dataFine = request.getParameter("dataFine");
      int numPosti = Integer.parseInt(request.getParameter("numPosti"));

      // COSTO
      float costo = numPosti * lido.getPrezzo_singolo();

      // DATI PERSONALI
      TuristaManager turistaManager = new TableTuristaManager(getSource(request));
      String nome = request.getParameter("nome");
      String cognome = request.getParameter("cognome");
      String email = request.getParameter("email");
      //turistaManager.create(nome,cognome,email);
      int idTurista ;

      // Creazione Prenotazione
      PrenotazioneManager manager = new TablePrenotazioneManager(getSource(request));
      //manager.create(dataInizio,dataFine,numPosti,costo,idLido,idTurista);
      System.out.println(manager.ultimateId());
      List<Ombrellone> list=manager.ombrelloniDisponibili("2020-01-01","2020-12-01",lido);
      for(Ombrellone o :list)
        System.out.println(o.getNum_riga()+"_"+o.getNum_colonna());
      int idPrenotazione;

      // OMBRELLONE
      OmbrelloneManager ombrelloneManager = new TableOmbrelloneManager(getSource(request));
      int numRiga;
      int numColonna;
      //ombrelloneManager.create(numRiga,numColonna,idPrenotazione);

      // PAGAMENTO
      String intestatario = request.getParameter("intestatario");
      int numCarta = Integer.parseInt(request.getParameter("numCarta"));
      String dataScadenza = request.getParameter("dataScadenza");
      int cvv = Integer.parseInt(request.getParameter("cvv"));
    */
      return view("index");
    }catch(Exception e){
      e.printStackTrace();
      return view("500");
    }
  }
}
