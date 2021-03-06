package theboys.sorrentomarina.actions.actionsUtente;

import org.apache.commons.codec.digest.DigestUtils;
import theboys.sorrentomarina.actions.actionsUtils.ChainableAction;
import theboys.sorrentomarina.managers.managersUtente.ResponsabileEnteManager;
import theboys.sorrentomarina.managers.managersUtente.TableResponsabileEnteManager;
import theboys.sorrentomarina.models.modelsUtente.ResponsabileEnte;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.Optional;
/**
 * @author theboys
 */
public class CheckLoginRespEnte extends ChainableAction {

  /**
   * Controlla le credenziali passate e ritorna la dashboard con l'admin loggato
   * o avvisa che le credenziali non sono corrette
   *
   * @param request la request
   * @param response la response
   * @return ritorna la dashboard con l'admin loggato o la pagina di login
   *
   */
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {
    try {
      String username = request.getParameter("username");
      String password = DigestUtils.sha1Hex(request.getParameter("password"));
      ResponsabileEnteManager em = new TableResponsabileEnteManager(this.getSource(request));
      Optional<ResponsabileEnte> opt = em.findResponsabileEnte(username, password);
      if (opt.isPresent()) {
        request.getSession().setAttribute("adminEnte", opt.get());
        return redirect("/SorrentoMarina/");
      }
    } catch (SQLException ex) {
      return view("500");
    }
    request.setAttribute("messaggio", "Credenziali non corrette! Riprova.");
    setNext(new MostraFormLoginAction());
    return super.execute(request, response);
  }
}
