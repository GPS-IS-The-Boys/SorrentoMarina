package theboys.sorrentomarina.actions;

import theboys.sorrentomarina.managers.LidoManager;
import theboys.sorrentomarina.managers.ServizioManager;
import theboys.sorrentomarina.managers.TableLidoManager;
import theboys.sorrentomarina.managers.TableServizioManager;
import theboys.sorrentomarina.models.Lido;
import theboys.sorrentomarina.models.ResponsabileEnte;
import theboys.sorrentomarina.models.ResponsabileLido;
import theboys.sorrentomarina.models.Servizio;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public class ShowDashboardEnteAction implements Action {

  /**
   * Exec a request action
   *
   * @param request  the request
   * @param response the response
   * @return can return a URL or a view name
   */
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {
    //mostra la dashboard del responsabile lido
    ResponsabileEnte re = (ResponsabileEnte) request.getSession().getAttribute("adminEnte");
    if (re == null) {
      return view("403");
    }
    try {
      LidoManager lidoManager = new TableLidoManager(this.getSource(request));
      List<Lido> lidi = lidoManager.retriveAll();
      request.setAttribute("lidiEnte", lidi);
      return view("respEnteDashboard");

    } catch (SQLException throwables) {
      throwables.printStackTrace();
      return view("500");
    }
  }
}
