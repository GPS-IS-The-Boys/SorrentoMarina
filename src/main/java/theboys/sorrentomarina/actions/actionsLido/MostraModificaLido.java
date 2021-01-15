package theboys.sorrentomarina.actions.actionsLido;

import theboys.sorrentomarina.actions.actionsUtils.Action;
import theboys.sorrentomarina.managers.managersLido.LidoManager;
import theboys.sorrentomarina.managers.managersLido.ServizioManager;
import theboys.sorrentomarina.managers.managersLido.TableLidoManager;
import theboys.sorrentomarina.managers.managersLido.TableServizioManager;
import theboys.sorrentomarina.models.modelsLido.Lido;
import theboys.sorrentomarina.models.modelsUtente.ResponsabileLido;
import theboys.sorrentomarina.models.modelsLido.Servizio;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
/**
 * @author theboys
 */
public class MostraModificaLido implements Action {
  /**
   * Mostra la pagina dedicata alla modifica del lido
   *
   * @param request  la request
   * @param response la response
   * @return ritorna la pagina con il form per la modifica lido
   */
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {
    ResponsabileLido respLido = (ResponsabileLido) request.getSession().getAttribute("adminLido");
    LidoManager lidoManager = new TableLidoManager(this.getSource(request));
    ServizioManager servizioManager = new TableServizioManager(this.getSource(request));

    if (respLido == null) {
      return redirect("/SorrentoMarina/dashboard");
    }
    try {
      Lido lido = lidoManager.retriveById(respLido.getId_lido());
      Servizio servizio = servizioManager.retriveById(lido.getId_servizi());

      request.getSession().setAttribute("lido", lido);
      request.getSession().setAttribute("servizi", servizio);
      return view("respLidoModifica");

    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }

    return null;
  }
}
