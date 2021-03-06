package theboys.sorrentomarina.actions.actionsAnnuncio;

import theboys.sorrentomarina.actions.actionsUtils.Action;
import theboys.sorrentomarina.managers.managersAnnuncio.AnnuncioManager;
import theboys.sorrentomarina.managers.managersAnnuncio.TableAnnuncioManager;
import theboys.sorrentomarina.models.modelsAnnuncio.Annuncio;
import theboys.sorrentomarina.models.modelsUtente.ResponsabileLido;

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
    if (!(titolo != null && titolo.length() <= 32)) {
      request.setAttribute("messaggio", "Titolo annuncio troppo lungo");
      return view("respLidoAnnunci");
    }

    String foto = request.getParameter("foto");
    if (!(foto != null && foto.length() >= 13)) {
      request.setAttribute("messaggio", "Path immagine non valido");
      return view("respLidoAnnunci");
    }

    String contenuto = request.getParameter("contenuto");
    if (!(contenuto != null && contenuto.length() <= 256)) {
      request.setAttribute("messaggio", "Contenuto annuncio troppo lungo");
      return view("respLidoAnnunci");
    }

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
