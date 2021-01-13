package theboys.sorrentomarina.actions;

import theboys.sorrentomarina.managers.AnnuncioManager;
import theboys.sorrentomarina.managers.TableAnnuncioManager;
import theboys.sorrentomarina.models.ResponsabileLido;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class CreaAnnuncioAction implements Action {
  /**
   * Permette al responsabile lido di aggiungere un annuncio al suo lido
   *
   * @param request  la request
   * @param response la response
   * @return ritorna nella pagina del lido o nella dashboard
   * @author Francesco Pio Covino
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
