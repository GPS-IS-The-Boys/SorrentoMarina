package theboys.sorrentomarina.actions;

import java.sql.SQLException;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import theboys.sorrentomarina.managers.AccountManager;
import theboys.sorrentomarina.managers.TableAccountManager;
import theboys.sorrentomarina.models.Account;

/**
 * @author theboys
 */
public class LoginAction implements Action {

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {
    try {
      String email = request.getParameter("email");
      String password = request.getParameter("password");
      AccountManager am = new TableAccountManager(this.getSource(request));
      Optional<Account> optAccount = am.findAccount(email, password);
      if (optAccount.isPresent()) {
        return view("admin/index");
      } else {
        return "/SorrentoMarina/dashboard";
      }
    } catch (SQLException ex) {
      return view("500");
    }
  }

}
