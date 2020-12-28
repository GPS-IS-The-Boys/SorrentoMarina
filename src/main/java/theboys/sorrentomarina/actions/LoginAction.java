package theboys.sorrentomarina.actions;

import java.sql.SQLException;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import theboys.sorrentomarina.managers.AccountManager;
import theboys.sorrentomarina.managers.TableAccountManager;
import theboys.sorrentomarina.managers.TableTuristaManager;
import theboys.sorrentomarina.managers.TuristaManager;
import theboys.sorrentomarina.models.Account;
import theboys.sorrentomarina.models.Turista;

/**
 * @author theBoys
 */
public class LoginAction implements Action {

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {
    try {
      String username = request.getParameter("username");
      String password = request.getParameter("password");
      TuristaManager tm = new TableTuristaManager(this.getSource(request));
      Optional<Turista> optTurista = tm.findTurista(username, password);
      request.getSession().setAttribute("utente", optTurista);
      return view("index");
    } catch (SQLException ex) {
      return view("500");
    }
  }

}
