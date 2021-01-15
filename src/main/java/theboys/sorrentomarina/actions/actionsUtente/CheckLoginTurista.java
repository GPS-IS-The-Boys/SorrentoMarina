package theboys.sorrentomarina.actions.actionsUtente;

import org.apache.commons.codec.digest.DigestUtils;
import theboys.sorrentomarina.actions.actionsUtils.ChainableAction;
import theboys.sorrentomarina.managers.managersUtente.TableTuristaManager;
import theboys.sorrentomarina.managers.managersUtente.TuristaManager;
import theboys.sorrentomarina.models.modelsUtente.Turista;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.Optional;

/**
 * @author theboys
 */
public class CheckLoginTurista extends ChainableAction {

  /**
   * Controlla le credenziali passate e ritorna l'index
   * con l'utente loggato altrimenti passa all'azione CheckLoginRespLido
   *
   * @param request la request
   * @param response la response
   * @return ritorna l'index, con l'utente loggato nella sessione
   *
   */
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {
    try {
      String username = request.getParameter("username");
      String password = DigestUtils.sha1Hex(request.getParameter("password"));
      TuristaManager tm = new TableTuristaManager(this.getSource(request));
      Optional<Turista> optTurista = tm.findTurista(username, password);
      if (optTurista.isPresent()) {
        request.getSession().setAttribute("utente", optTurista.get() );
        return redirect("/SorrentoMarina/");
      } else {
        setNext(new CheckLoginRespLido());
      }
      return super.execute(request, response);
    } catch (SQLException ex) {
      return view("500");
    }
  }
}
