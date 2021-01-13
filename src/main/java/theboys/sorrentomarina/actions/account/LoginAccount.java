package theboys.sorrentomarina.actions.account;

import theboys.sorrentomarina.models.Account;
import theboys.sorrentomarina.managers.TableAccountManager;
import theboys.sorrentomarina.managers.AccountManager;

import java.sql.SQLException;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import theboys.sorrentomarina.actions.Action;
/**
 * @author theboys
 */
public class LoginAccount implements Action {

  /**
   * Login di tutti gli account
   *
   * @param request the request
   * @param response the response
   * @return alla dashboard o in caso di errore alla pagina di login
   */
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {
    try {
      String email = request.getParameter("email");
      String password = DigestUtils.sha256Hex(request.getParameter("password"));
      AccountManager am = new TableAccountManager(getSource(request));
      Optional<Account> optAccount = am.findAccount(email, password);
      if (optAccount.isPresent()) {
        HttpSession session = request.getSession(true);
        session.setAttribute("account", optAccount.get());
        return "/dashboard";
      } else {
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return view("login");
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
      return view("internal_error");
    }
  }

}
