package theboys.sorrentomarina.actions.actionsLido;

import theboys.sorrentomarina.actions.actionsUtils.Action;
import theboys.sorrentomarina.managers.managersLido.LidoManager;
import theboys.sorrentomarina.managers.managersLido.TableLidoManager;
import theboys.sorrentomarina.models.modelsLido.Lido;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
/**
 * @author theboys
 */
public class RimuoviLidoAction implements Action {
  /**
   * Azione che permette al responsabile ente di cancellare un lido dalla piattaforma
   *
   * @param request  la request
   * @param response la response
   * @return ritorna nella dashboard ente dopo aver cancellato il lido
   */
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {

    try {
      LidoManager lidoManager = new TableLidoManager(this.getSource(request));
      int idLido = Integer.parseInt(request.getParameter("id"));

      Lido lido = lidoManager.retriveById(idLido);
      if (lido == null) {
        return view("500");
      }
      lidoManager.delete(idLido);
      return redirect("/SorrentoMarina/dashboardEnte");

    } catch (SQLException e) {
      e.printStackTrace();
      return view("500");
    }
  }
}
