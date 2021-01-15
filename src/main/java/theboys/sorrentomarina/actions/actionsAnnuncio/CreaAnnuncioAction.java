package theboys.sorrentomarina.actions.actionsAnnuncio;

import theboys.sorrentomarina.actions.actionsUtils.Action;
import theboys.sorrentomarina.managers.managersAnnuncio.AnnuncioManager;
import theboys.sorrentomarina.managers.managersAnnuncio.TableAnnuncioManager;
import theboys.sorrentomarina.models.modelsUtente.ResponsabileLido;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
/**
 * @author theboys
 */
public class CreaAnnuncioAction implements Action {
  /**
   * Permette al responsabile lido di aggiungere un annuncio al suo lido
   *
   * @param request  la request
   * @param response la response
   * @return ritorna nella pagina del lido o nella dashboard
   *
   */
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {
    String titolo = request.getParameter("titolo");
    String contenuto = request.getParameter("contenuto");
    String foto = request.getParameter("foto");
    ResponsabileLido rl = (ResponsabileLido) request.getSession().getAttribute("adminLido");

    AnnuncioManager am = new TableAnnuncioManager(this.getSource(request));
    try {

      am.create(titolo, contenuto, foto, rl.getId_lido());
      return redirect("/SorrentoMarina/dashboard");

    } catch (SQLException throwables) {
      throwables.printStackTrace();
      return view("500");
    }
  }
}
