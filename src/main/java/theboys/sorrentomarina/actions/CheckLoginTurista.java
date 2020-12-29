package theboys.sorrentomarina.actions;

import theboys.sorrentomarina.managers.TableTuristaManager;
import theboys.sorrentomarina.managers.TuristaManager;
import theboys.sorrentomarina.models.Turista;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.Optional;


public class CheckLoginTurista extends ChainableAction {

  /**
   * Controlla le credenziali passate e ritorna l'index
   * con l'utente loggato altrimenti passa all'azione CheckLoginRespLido
   *
   * @param request la request
   * @param response la response
   * @return ritorna l'index, con l'utente loggato nella sessione
   * @author Francesco Pio Covino
   */
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {
    try {
      String username = request.getParameter("username");
      String password = request.getParameter("password");
      TuristaManager tm = new TableTuristaManager(this.getSource(request));
      Optional<Turista> optTurista = tm.findTurista(username, password);
      if (optTurista.isPresent()) {
        request.getSession().setAttribute("utente", optTurista.get() );
        return view("index");
      } else {
        setNext(new CheckLoginRespLido());
      }
      return super.execute(request, response);
    } catch (SQLException ex) {
      return view("500");
    }
  }
}
