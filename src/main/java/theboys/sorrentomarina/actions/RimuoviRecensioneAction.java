package theboys.sorrentomarina.actions;

import theboys.sorrentomarina.managers.RecensioneManager;
import theboys.sorrentomarina.managers.TableRecensioneManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
/**
 * @author theboys
 */
public class RimuoviRecensioneAction implements Action {
  /**
   * Cancella una recensione
   *
   * @param request  la request
   * @param response la response
   * @return ritorna nella dashboard del responsabile lido
   */
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {
    int idRecensione = Integer.parseInt(request.getParameter("id"));
    RecensioneManager rm = new TableRecensioneManager(this.getSource(request));
    try {
      rm.delete(idRecensione);
      return redirect("/SorrentoMarina/dashboard");
    } catch (SQLException throwables) {
      throwables.printStackTrace();
      return view("500");
    }
  }
}
