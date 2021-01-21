package theboys.sorrentomarina.actions.actionsLido;

import org.apache.commons.codec.digest.DigestUtils;
import theboys.sorrentomarina.actions.actionsUtils.ChainableAction;
import theboys.sorrentomarina.managers.managersLido.LidoManager;
import theboys.sorrentomarina.managers.managersLido.ServizioManager;
import theboys.sorrentomarina.managers.managersLido.TableLidoManager;
import theboys.sorrentomarina.managers.managersLido.TableServizioManager;
import theboys.sorrentomarina.managers.managersUtente.ResponsabileLidoManager;
import theboys.sorrentomarina.managers.managersUtente.TableResponsabileLidoManager;
import theboys.sorrentomarina.models.modelsLido.Lido;
import theboys.sorrentomarina.models.modelsLido.Servizio;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;
/**
 * @author theboys
 */
public class CreaLidoAction extends ChainableAction {

  /**
   * Permette al responsabile lido di aggiungere un lido alla piattaforma, con relativo responsabile
   * lido e servizi
   *
   * @param request  la request
   * @param response la response
   * @return aggiunge un lido nella piattaforma
   *
   */
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {
    response.setStatus(HttpServletResponse.SC_ACCEPTED);

    LidoManager lidoManager = new TableLidoManager(this.getSource(request));
    ServizioManager servizioManager = new TableServizioManager(this.getSource(request));
    ResponsabileLidoManager responsabileLidoManager =
        new TableResponsabileLidoManager(this.getSource(request));

    try {
      // informazioni sul lido
      String nomeLido = request.getParameter("nomeLido");
      if (!(nomeLido != null && nomeLido.trim().length() > 0)) {
        request.setAttribute("messaggio", "Nome del Lido non valido");
        return view("creaLido");
      }

      String indirizzoLido = request.getParameter("indirizzoLido");
      if (!(indirizzoLido != null && indirizzoLido.trim().length() > 0)) {
        request.setAttribute("messaggio", "Indirizzo del Lido non valido");
        return view("creaLido");
      }

      String emailLido = request.getParameter("emailLido");
      if (!(emailLido != null && emailLido.matches("^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w+)+$"))) {
        request.setAttribute("messaggio", "Email del lido non valida");
        return view("creaLido");
      }

      String telefonoLido = request.getParameter("telefonoLido");
      if (!(telefonoLido != null && telefonoLido.trim().length() > 8)) {
        request.setAttribute("messaggio", "Telefono del Lido non valido");
        return view("creaLido");
      }

      String logoLido = request.getParameter("logoLido");

      String strPrezzoLido = request.getParameter("prezzoLido");
      if (strPrezzoLido == null) {
        request.setAttribute("messaggio", "Prezzo singolo non valido");
        return view("creaLido");
      }
      float prezzoLido = Float.parseFloat(strPrezzoLido);

      String strRighe = request.getParameter("righeLido");
      if (strRighe == null) {
        request.setAttribute("messaggio", "Numero di righe del Lido non valido");
        return view("creaLido");
      }
      int rigLido = Integer.parseInt(strRighe);

      String strColonne = request.getParameter("colonneLido");
      if (strColonne == null) {
        request.setAttribute("messaggio", "Numero di colonne del Lido non valido");
        return view("creaLido");
      }
      int colLido = Integer.parseInt(strColonne);

      //informazioni sui servizi offerti
      Servizio servizio = new Servizio();
      String servizio1 = request.getParameter("servizio1");
      String servizio2 = request.getParameter("servizio2");
      String servizio3 = request.getParameter("servizio3");
      String servizio4 = request.getParameter("servizio4");
      String servizio5 = request.getParameter("servizio5");
      String servizio6 = request.getParameter("servizio6");
      String servizio7 = request.getParameter("servizio7");

      servizio.setBar(servizio1 != null);
      servizio.setRistorante(servizio2 != null);
      servizio.setAnimazione(servizio3 != null);
      servizio.setWifi(servizio4 != null);
      servizio.setCabina(servizio5 != null);
      servizio.setBeach_volley(servizio6 != null);
      servizio.setCanoa(servizio7 != null);

      //informazioni sul responsabile Lido
      String nomeResp = request.getParameter("nomeResp");
      if (!(nomeResp != null && nomeResp.trim().length() > 0 && nomeResp.matches("^[ a-zA-Z\u00C0-\u00ff]+$"))) {
        request.setAttribute("messaggio", "Nome del responsabile non valido");
        return view("creaLido");
      }

      String cognomeResp = request.getParameter("cognomeResp");
      if (!(cognomeResp != null && cognomeResp.trim().length() > 0 && cognomeResp.matches("^[ a-zA-Z\u00C0-\u00ff]+$"))) {
        request.setAttribute("messaggio", "Cognome del responsabile non valido");
        return view("creaLido");
      }

      String emailResp = request.getParameter("emailResp");
      if (!(emailResp != null && emailResp.matches("^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w+)+$"))) {
        request.setAttribute("messaggio", "Email del responsabile non valido");
        return view("creaLido");
      }

      String usernameResp = request.getParameter("usernameResp");
      if (!(usernameResp != null && usernameResp.length() >= 6 && usernameResp.matches("^[0-9a-zA-Z]+$"))) {
        request.setAttribute("messaggio", "Username del responsabile non valido");
        return view("creaLido");
      }

      String passwordResp = request.getParameter("passwordResp");
      if (!(passwordResp != null && passwordResp.length() >= 8 && passwordResp.matches(".*[0-9].*"))) {
        request.setAttribute("messaggio", "Password del responsabile non valido");
        return view("creaLido");
      }

      //creo il lido
      if(logoLido==null)
        logoLido="";

      lidoManager.create(nomeLido, indirizzoLido, telefonoLido, emailLido, logoLido, prezzoLido,
          rigLido, colLido, 2, 2);
      //mi riprendo l'id
      Lido lidoDappoggio = lidoManager.retriveByName(nomeLido).get(0);
      //lo uso per creare il responsabile lido
      responsabileLidoManager.create(nomeResp, cognomeResp, emailResp, usernameResp,
          DigestUtils.sha1Hex(passwordResp), lidoDappoggio.getId(), 2);
      //e per creare il servizio
      servizioManager.create1(servizio.isBar(), servizio.isRistorante(), servizio.isAnimazione(),
          servizio.isWifi(), servizio.isCabina(), servizio.isBeach_volley(), servizio.isCanoa());
      //riprendo l'id del servizio appena aggiunto
      List<Servizio> listaServizi = servizioManager.retriveAll();
      servizio = listaServizi.get(listaServizi.size() - 1);
      lidoDappoggio.setId_servizi(servizio.getId());
      lidoManager.update(lidoDappoggio);

      return redirect("/SorrentoMarina/dashboardEnte");
    } catch (SQLException | NullPointerException e) {
      e.printStackTrace();
      return view("creaLido");
    }

  }
}
