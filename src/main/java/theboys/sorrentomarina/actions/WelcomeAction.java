package theboys.sorrentomarina.actions;

import theboys.sorrentomarina.managers.LidoManager;
import theboys.sorrentomarina.managers.TableLidoManager;
import theboys.sorrentomarina.models.Lido;
import theboys.sorrentomarina.models.Servizio;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * @author theBoys
 */
public class WelcomeAction implements Action {

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {
    response.setStatus(HttpServletResponse.SC_ACCEPTED);

    try {
      // nome lido inserito nel form
      String nomeLido = request.getParameter("nomeRicerca");
      Servizio servizio = new Servizio();
      String servizio1 = request.getParameter("servizio1");
      String servizio2 = request.getParameter("servizio2");
      String servizio3 = request.getParameter("servizio3");
      String servizio4 = request.getParameter("servizio4");
      String servizio5 = request.getParameter("servizio5");
      String servizio6 = request.getParameter("servizio6");
      String servizio7 = request.getParameter("servizio7");

      if (servizio1 != null) servizio.setBar(true);
      if (servizio2 != null) servizio.setRistorante(true);
      if (servizio3 != null) servizio.setAnimazione(true);
      if (servizio4 != null) servizio.setWifi(true);
      if (servizio5 != null) servizio.setCabina(true);
      if (servizio6 != null) servizio.setBeach_volley(true);
      if (servizio7 != null) servizio.setCanoa(true);

      // controllo se nomeLido e servizi sono vuoti, se lo sono non faccio nessuna ricerca
      if (nomeLido == null && servizio.isEmpty()) {
        response.setStatus(HttpServletResponse.SC_ACCEPTED);
        return view("index");
      }
      // se è stato inserito solo il nome effettuo una ricerca tramite nome
      if (nomeLido != null && servizio.isEmpty()) {
        LidoManager manager = new TableLidoManager(this.getSource(request));
        Lido lido = manager.retriveByName(nomeLido);
        if (lido != null) {
          request.setAttribute("lidoRicerca", lido);
        }
        response.setStatus(HttpServletResponse.SC_ACCEPTED);
        return view("index");
      }
      response.setStatus(HttpServletResponse.SC_ACCEPTED);
      return view("index");
    } catch (SQLException throwables) {
      return view("500");
    }
  }
}