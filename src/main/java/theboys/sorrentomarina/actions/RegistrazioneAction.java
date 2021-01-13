package theboys.sorrentomarina.actions;

import org.apache.commons.codec.digest.DigestUtils;
import theboys.sorrentomarina.managers.TableTuristaManager;
import theboys.sorrentomarina.managers.TuristaManager;
import theboys.sorrentomarina.models.Turista;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * @author theboys
 */
public class RegistrazioneAction extends ChainableAction {

  /**
   * Esegue la registrazione dell'utente, previo controllo dei campi
   *
   * @param request  la request
   * @param response la response
   * @return ritorna nell'index se la registrazione è andata a buon fine o un errore altrimenti
   * @author Francesco Pio Covino
   */
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {
    //controlliamo i parametri anche lato server
    String username = request.getParameter("username");
    if (!(username != null && username.length() >= 6 && username.matches("^[0-9a-zA-Z]+$"))) {
      request.setAttribute("messaggio", "Campo Username non valido");
      return view("registrazione");
    }

    String password = request.getParameter("password");
    if (!(password != null && password.length() >= 8 && !password.toUpperCase().equals(password)
        && !password.toLowerCase().equals(password) && password.matches(".*[0-9].*"))) {
      request.setAttribute("messaggio", "Campo Password non valido");
      return view("registrazione");
    }

    String passwordConferma = request.getParameter("passwordConferma");
    if (!password.equals(passwordConferma)) {
      request.setAttribute("messaggio", "Password e Conferma non coincidono");
      return view("registrazione");
    }

    String nome = request.getParameter("nome");
    if (!(nome != null && nome.trim().length() > 0 && nome.matches("^[ a-zA-Z\u00C0-\u00ff]+$"))) {
      request.setAttribute("messaggio", "Campo Nome non valido");
      return view("registrazione");
    }

    String cognome = request.getParameter("cognome");
    if (!(cognome != null && cognome.trim().length() > 0
        &&
        cognome.matches("^[ a-zA-Z\u00C0-\u00ff]+$"))) {
      request.setAttribute("messaggio", "Campo Cognome non valido");
      return view("registrazione");
    }

    String email = request.getParameter("email");
    if (!(email != null && email.matches("^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w+)+$"))) {
      request.setAttribute("messaggio", "Campo Email non valido");
      return view("registrazione");
    }
    //dopo aver controllato i campi passiamo alla memorizzazione del turista vero

    try {
      Turista t = new Turista(nome, cognome, email, username, password);
      TuristaManager tm = new TableTuristaManager(this.getSource(request));
      String hashPassword = DigestUtils.sha1Hex(t.getPassword_turista());
      tm.create(t.getNome(), t.getCognome(), t.getEmail(), t.getUsername(), hashPassword);
      request.getSession().setAttribute("utente", t);
      return redirect("/SorrentoMarina/");

    } catch (SQLException e) {
      request.setAttribute("messaggio", "Non hai riempito correttamente i campi");
      return view("registrazione");
    }
  }
}
