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
