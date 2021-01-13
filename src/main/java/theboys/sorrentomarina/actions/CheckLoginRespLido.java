package theboys.sorrentomarina.actions;

import org.apache.commons.codec.digest.DigestUtils;
import theboys.sorrentomarina.managers.ResponsabileLidoManager;
import theboys.sorrentomarina.managers.TableResponsabileLidoManager;
import theboys.sorrentomarina.models.ResponsabileLido;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.Optional;
/**
 * @author theboys
 */
public class CheckLoginRespLido extends ChainableAction {
  /**
   * Controlla le credenziali passate e
   * ritorna la dashboard con l'admin loggato o passa all'azione CheckRespEnte
   *
   * @param request la request
   * @param response la response
   * @return la dashboard con l'admin loggato
   *
   */
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {
    try {
      String username = request.getParameter("username");
      String password = DigestUtils.sha1Hex(request.getParameter("password"));
      ResponsabileLidoManager lm = new TableResponsabileLidoManager(this.getSource(request));
      Optional<ResponsabileLido> opt = lm.findResponsabileLido(username, password);
      if (opt.isPresent()) {
        request.getSession().setAttribute("adminLido", opt.get());
        return redirect("/SorrentoMarina/");
      } else {
        setNext(new CheckLoginRespEnte());
      }
      return super.execute(request, response);
    } catch (SQLException ex) {
      return view("500");
    }
  }
}
