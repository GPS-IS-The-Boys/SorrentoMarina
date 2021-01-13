package theboys.sorrentomarina.actions;

import theboys.sorrentomarina.managers.LidoManager;
import theboys.sorrentomarina.managers.ServizioManager;
import theboys.sorrentomarina.managers.TableLidoManager;
import theboys.sorrentomarina.managers.TableServizioManager;
import theboys.sorrentomarina.models.Lido;
import theboys.sorrentomarina.models.ResponsabileLido;
import theboys.sorrentomarina.models.Servizio;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * @author theBoys
 */
public class ShowDashboardAction implements Action {
  /**
   * mostra la dashboard del responsabile lido
   *
   * @param request the request
   * @param response the response
   * @return ritorna la view respLidoDashboard
   */
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {

    //mostra la dashboard del responsabile lido
    ResponsabileLido rl = (ResponsabileLido) request.getSession().getAttribute("adminLido");
    if (rl == null) {
      return view("403");
    }
    try {
      LidoManager lidoManager = new TableLidoManager(this.getSource(request));
      ServizioManager sm = new TableServizioManager(this.getSource(request));

      int idLido = rl.getId_lido();
      Lido lido = lidoManager.retriveById(idLido);
      Servizio servizi = sm.retriveById(lido.getId_servizi());

      request.setAttribute("serviziLido", servizi);
      request.setAttribute("lido", lido);

      return view("respLidoDashboard");

    } catch (SQLException throwables) {
      return view("500");
    }
  }

}
