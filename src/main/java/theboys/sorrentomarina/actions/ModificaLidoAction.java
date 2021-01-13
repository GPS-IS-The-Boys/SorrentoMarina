package theboys.sorrentomarina.actions;

import theboys.sorrentomarina.managers.*;
import theboys.sorrentomarina.models.Lido;
import theboys.sorrentomarina.models.ResponsabileLido;
import theboys.sorrentomarina.models.Servizio;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
/**
 * @author theboys
 */
public class ModificaLidoAction implements Action {
  /**
   * Modifica gli attributi di un lido della piattaforma
   *
   * @param request  la request
   * @param response la response
   * @return ritorna alla dashboard del responsabile lido
   */
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {
    response.setStatus(HttpServletResponse.SC_ACCEPTED);

    LidoManager lidoManager = new TableLidoManager(this.getSource(request));
    ServizioManager servizioManager = new TableServizioManager(this.getSource(request));
    ResponsabileLido respLido = (ResponsabileLido) request.getSession().getAttribute("adminLido");

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

      //modifico il lido
      Lido lido = lidoManager.retriveById(respLido.getId_lido());
      lido.setNome(nomeLido);

      lido.setIndirizzo(indirizzoLido);
      lido.setEmail(emailLido);
      lido.setTelefono(telefonoLido);
      lido.setLogo(logoLido);
      lido.setPrezzo_singolo(prezzoLido);
      lido.setNum_righe(rigLido);
      lido.setNum_colonne(colLido);
      //informazioni sui servizi offerti

      Servizio servizio = servizioManager.retriveById(lido.getId_servizi());

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

      //aggiorno lido e servizio
      lidoManager.update(lido);
      servizioManager.update(servizio);

      return redirect("/SorrentoMarina/dashboard");
    } catch (Exception e) {
      e.printStackTrace();
      return view("respLidoModifica");
    }

  }
}