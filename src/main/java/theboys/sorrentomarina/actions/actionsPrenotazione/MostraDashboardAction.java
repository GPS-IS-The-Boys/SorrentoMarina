package theboys.sorrentomarina.actions.actionsPrenotazione;

import theboys.sorrentomarina.actions.actionsUtils.Action;
import theboys.sorrentomarina.managers.managersLido.LidoManager;
import theboys.sorrentomarina.managers.managersLido.ServizioManager;
import theboys.sorrentomarina.managers.managersLido.TableLidoManager;
import theboys.sorrentomarina.managers.managersLido.TableServizioManager;
import theboys.sorrentomarina.managers.managersPrenotazione.PrenotazioneManager;
import theboys.sorrentomarina.managers.managersPrenotazione.TablePrenotazioneManager;
import theboys.sorrentomarina.models.modelsLido.Lido;
import theboys.sorrentomarina.models.modelsPrenotazione.Prenotazione;
import theboys.sorrentomarina.models.modelsUtente.ResponsabileLido;
import theboys.sorrentomarina.models.modelsLido.Servizio;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

/**
 * @author theBoys
 */
public class MostraDashboardAction implements Action {
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
      PrenotazioneManager pm = new TablePrenotazioneManager(this.getSource(request));

      int idLido = rl.getId_lido();
      Lido lido = lidoManager.retriveById(idLido);
      Servizio servizi = sm.retriveById(lido.getId_servizi());
      List<Prenotazione> pren = pm.retriveByIdLido(idLido);
      int numPre = pren.size();

      request.setAttribute("serviziLido", servizi);
      request.setAttribute("lido", lido);
      request.setAttribute("mapPrenotazioni", pren);
      request.setAttribute("size", numPre);

      return view("respLidoDashboard");

    } catch (SQLException throwables) {
      return view("500");
    }
  }

}
