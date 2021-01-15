package theboys.sorrentomarina.actions;

import theboys.sorrentomarina.managers.*;
import theboys.sorrentomarina.models.Lido;
import theboys.sorrentomarina.models.ResponsabileLido;
import theboys.sorrentomarina.models.Servizio;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
      if (!(nomeLido != null && nomeLido.trim().length() > 0)) {
        request.setAttribute("messaggio", "Nome del Lido non valido");
        return view("respLidoModifica");
      }

      String indirizzoLido = request.getParameter("indirizzoLido");
      if (!(indirizzoLido != null && indirizzoLido.trim().length() > 0)) {
        request.setAttribute("messaggio", "Indirizzo del Lido non valido");
        return view("respLidoModifica");
      }

      String emailLido = request.getParameter("emailLido");
      if (!(emailLido != null && emailLido.matches("^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w+)+$"))) {
        request.setAttribute("messaggio", "Email del lido non valida");
        return view("respLidoModifica");
      }

      String telefonoLido = request.getParameter("telefonoLido");
      if (!(telefonoLido != null && telefonoLido.trim().length() > 8)) {
        request.setAttribute("messaggio", "Telefono del Lido non valido");
        return view("respLidoModifica");
      }

      String logoLido = request.getParameter("logoLido");
      if (!(logoLido != null && logoLido.trim().length() > 13)) {
        request.setAttribute("messaggio", "Path logo del Lido non valido");
        return view("respLidoModifica");
      }

      String strPrezzoLido = request.getParameter("prezzoLido");
      if (strPrezzoLido == null) {
        request.setAttribute("messaggio", "Prezzo singolo non valido");
        return view("respLidoModifica");
      }
      float prezzoLido = Float.parseFloat(strPrezzoLido);

      String strRighe = request.getParameter("righeLido");
      if (strRighe == null) {
        request.setAttribute("messaggio", "Numero di righe del Lido non valido");
        return view("respLidoModifica");
      }
      int rigLido = Integer.parseInt(strRighe);

      String strColonne = request.getParameter("colonneLido");
      if (strColonne == null) {
        request.setAttribute("messaggio", "Numero di colonne del Lido non valido");
        return view("respLidoModifica");
      }
      int colLido = Integer.parseInt(strColonne);

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