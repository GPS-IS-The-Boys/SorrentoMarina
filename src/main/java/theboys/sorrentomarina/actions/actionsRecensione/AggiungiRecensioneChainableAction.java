package theboys.sorrentomarina.actions.actionsRecensione;

import theboys.sorrentomarina.actions.actionsUtils.ChainableAction;
import theboys.sorrentomarina.managers.managersRecensione.RecensioneManager;
import theboys.sorrentomarina.managers.managersRecensione.TableRecensioneManager;
import theboys.sorrentomarina.models.modelsLido.Lido;
import theboys.sorrentomarina.models.modelsUtente.Turista;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * @author theboys
 */

public class AggiungiRecensioneChainableAction extends ChainableAction {

  /**
   * Memorizzazione recensione di un turista su un lido
   *
   * @param request
   * @param response
   * @return in caso di errore la view 500
   */
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {
    try {
      String contenutoRecensione = request.getParameter("contenutoRecensione");
      if (!(contenutoRecensione != null && contenutoRecensione.length() <= 256 )) {
        request.setAttribute("messaggio", "Contenuto troppo grande");
        return view("formRecensione");
      }

      String strGiudizio = request.getParameter("giudizioRecensione");
      if (strGiudizio == null) {
        request.setAttribute("messaggio", "Devi aggiungere un giudizio");
        return view("formRecensione");
      }
      int giudizio = Integer.parseInt(strGiudizio);

      int idLido = ((Lido) (request.getSession().getAttribute("lido"))).getId();
      int idTurista = ((Turista) (request.getSession().getAttribute("utente"))).getId();
      RecensioneManager manager = new TableRecensioneManager(getSource(request));
      manager.create(giudizio, contenutoRecensione, idLido, idTurista);
      setNext(new RecensioniLidoAction());
      return super.execute(request, response);
    } catch (Exception e) {
      e.printStackTrace();
      return view("500");
    }
  }
}
