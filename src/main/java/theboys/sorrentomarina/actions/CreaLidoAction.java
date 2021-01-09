package theboys.sorrentomarina.actions;

import org.apache.commons.codec.digest.DigestUtils;
import theboys.sorrentomarina.managers.*;
import theboys.sorrentomarina.models.Lido;
import theboys.sorrentomarina.models.Servizio;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public class CreaLidoAction extends ChainableAction {

  /**
   * Permette al responsabile lido di aggiungere un lido alla piattaforma, con relativo responsabile
   * lido e servizi
   *
   * @param request  la request
   * @param response la response
   * @return aggiunge un lido nella piattaforma
   * @author Francesco Pio Covino
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
      String indirizzoLido = request.getParameter("indirizzoLido");
      String emailLido = request.getParameter("emailLido");
      String telefonoLido = request.getParameter("telefonoLido");
      String logoLido = request.getParameter("logoLido");
      float prezzoLido = Float.parseFloat(request.getParameter("prezzoLido"));
      int rigLido = Integer.parseInt(request.getParameter("righeLido"));
      int colLido = Integer.parseInt(request.getParameter("colonneLido"));
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
      String cognomeResp = request.getParameter("cognomeResp");
      String emailResp = request.getParameter("emailResp");
      String usernameResp = request.getParameter("usernameResp");
      String passwordResp = request.getParameter("passwordResp");
      //creo il lido
      lidoManager.create(nomeLido, indirizzoLido, telefonoLido, emailLido, logoLido, prezzoLido,
          rigLido, colLido, 2);
      //mi riprendo l'id
      Lido lidoDappoggio = lidoManager.retriveByName(nomeLido);
      //lo uso per creare il responsabile lido
      responsabileLidoManager.create(nomeResp, cognomeResp, emailResp, usernameResp,
          DigestUtils.sha1Hex(passwordResp), lidoDappoggio.getId());
      //e per creare il servizio
      servizioManager.create(servizio.isBar(), servizio.isRistorante(), servizio.isAnimazione(),
          servizio.isWifi(), servizio.isCabina(), servizio.isBeach_volley(), servizio.isCanoa());
      //riprendo l'id del servizio appena aggiunto
      List<Servizio> listaServizi = servizioManager.retrieveAll();
      servizio = listaServizi.get(listaServizi.size() - 1);
      lidoDappoggio.setId_servizi(servizio.getId());
      lidoManager.update(lidoDappoggio);

      return redirect("/SorrentoMarina/dashboardEnte");
    } catch (SQLException e) {
      e.printStackTrace();
      return view("500");
    }

  }
}
