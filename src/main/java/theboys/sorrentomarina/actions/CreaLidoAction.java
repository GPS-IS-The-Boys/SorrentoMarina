package theboys.sorrentomarina.actions;

import org.apache.commons.codec.digest.DigestUtils;
import theboys.sorrentomarina.managers.*;
import theboys.sorrentomarina.models.Lido;
import theboys.sorrentomarina.models.ResponsabileLido;
import theboys.sorrentomarina.models.Servizio;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public class CreaLidoAction extends ChainableAction {

  /**
   * Permette al responsabile lido di aggiungere un lido alla piattaforma
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
    ResponsabileLidoManager responsabileLidoManager = new TableResponsabileLidoManager(this.getSource(request));

    try {
      // informazioni sul lido
      String nomeLido = request.getParameter("nomeLido");
      String indirizzoLido = request.getParameter("indirizzoLido");
      String emailLido = request.getParameter("indirizzoLido");
      String telefonoLido = request.getParameter("indirizzoLido");
      String logoLido = request.getParameter("indirizzoLido");
      Float prezzoLido = Float.parseFloat(request.getParameter("prezzoLido"));
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
      if (servizio1 != null) servizio.setBar(true);
      if (servizio2 != null) servizio.setRistorante(true);
      if (servizio3 != null) servizio.setAnimazione(true);
      if (servizio4 != null) servizio.setWifi(true);
      if (servizio5 != null) servizio.setCabina(true);
      if (servizio6 != null) servizio.setBeach_volley(true);
      if (servizio7 != null) servizio.setCanoa(true);

      //informazioni sul responsabile Lido
      String nomeResp = request.getParameter("nomeResp");
      String cognomeResp = request.getParameter("cognomeResp");
      String emailResp = request.getParameter("emailResp");
      String usernameResp = request.getParameter("usernameResp");
      String passwordResp = request.getParameter("passwordResp");
      //creo il lido
      lidoManager.create(nomeLido, indirizzoLido, telefonoLido, emailLido, logoLido, prezzoLido, rigLido, colLido, 1);
      //mi riprendo l'id
      Lido lidoDappoggio = lidoManager.retriveByName(nomeLido);
      //lo uso per creare il responsabile lido
      responsabileLidoManager.create(nomeResp, cognomeResp, emailResp, usernameResp, DigestUtils.sha1Hex(passwordResp), lidoDappoggio.getId());
      //e per creare il servizio
      servizioManager.create(servizio.isBar(), servizio.isRistorante(), servizio.isAnimazione(), servizio.isWifi(), servizio.isCabina(), servizio.isBeach_volley(), servizio.isCanoa());
      //riprendo l'id del servizio appena aggiunto
      List<Servizio> listaServizi = servizioManager.retrieveAll();
      servizio = listaServizi.get(listaServizi.size() - 1);
      lidoDappoggio.setId_servizi(servizio.getId());
      lidoManager.update(lidoDappoggio);

      return redirect("/SorrentoMarina/");
    } catch (SQLException e) {
      e.printStackTrace();
      return view("500");
    }

  }
}
