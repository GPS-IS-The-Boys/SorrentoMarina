package theboys.sorrentomarina.actions;

import theboys.sorrentomarina.managers.AnnuncioManager;
import theboys.sorrentomarina.managers.TableAnnuncioManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class EliminaAnnuncioRespLido implements Action {
  /**
   * Esegue l'eliminazione di un annuncio
   *
   * @param request  la request
   * @param response la response
   * @return ritorna alla dashboard del responsabile Lido dopo l'avvenuta cancellazione
   */
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {
    try {
      int idAnnuncio = Integer.parseInt(request.getParameter("id"));
      AnnuncioManager am = new TableAnnuncioManager(this.getSource(request));
      am.delete(idAnnuncio);
      return redirect("/SorrentoMarina/dashboard");
    } catch (SQLException throwables) {
      throwables.printStackTrace();
      return view("500");
    }
  }
}
