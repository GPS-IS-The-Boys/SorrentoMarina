package theboys.sorrentomarina.actions.account;

import theboys.sorrentomarina.models.Account;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import theboys.sorrentomarina.actions.ChainableAction;

/**
 *
 * @author Diequ
 */
public class AuthorizeAdminAction extends ChainableAction {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        Account account = (Account) session.getAttribute("account");
        if(account.isAdmin()){
            return super.execute(request, response);
        } else {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            return view("forbidden");
        }
    }
    
    
}
