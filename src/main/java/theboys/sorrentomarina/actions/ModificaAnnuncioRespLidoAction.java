package theboys.sorrentomarina.actions;

import theboys.sorrentomarina.managers.AnnuncioManager;
import theboys.sorrentomarina.managers.TableAnnuncioManager;
import theboys.sorrentomarina.models.Annuncio;
import theboys.sorrentomarina.models.ResponsabileLido;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
/**
 * @author theboys
 */
public class ModificaAnnuncioRespLidoAction implements Action {

  /**
   * Esegue la modifica di un annuncio
   *
   * @param request  la request
   * @param response la response
   * @return ritorna nella dashboard del responsabile lido
   */
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {
    String titolo = request.getParameter("titolo");
    String foto = request.getParameter("foto");
    String contenuto = request.getParameter("contenuto");
    int idAnnuncio = Integer.parseInt(request.getParameter("id"));
    ResponsabileLido rl = (ResponsabileLido) request.getSession().getAttribute("adminLido");

    AnnuncioManager am = new TableAnnuncioManager(this.getSource(request));
    try {
      Annuncio newAnnuncio = new Annuncio(idAnnuncio, titolo, contenuto, foto, rl.getId_lido());
      am.update(newAnnuncio);
      return redirect("/SorrentoMarina/dashboard");
    } catch (SQLException e) {
      return view("500");
    }
  }
}
