package theboys.sorrentomarina.actions.actionsUtente;

import org.apache.commons.codec.digest.DigestUtils;
import theboys.sorrentomarina.actions.actionsUtils.Action;
import theboys.sorrentomarina.managers.managersUtente.*;
import theboys.sorrentomarina.models.modelsUtente.ResponsabileEnte;
import theboys.sorrentomarina.models.modelsUtente.ResponsabileLido;
import theboys.sorrentomarina.models.modelsUtente.Turista;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.Optional;
/**
 * @author theboys
 */
public class ModificaCredenzialiAction implements Action {

  /**
   * Modifica la password di un turista
   *
   * @param request  la request
   * @param response la response
   * @return ritorna alla pagina di login da cui rieffettuare il login con la nuova password
   */
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {
    //prendo le due password
    String noOldPassword = request.getParameter("oldPassword");
    if (!(noOldPassword != null && noOldPassword.length() >= 8 && noOldPassword.matches(".*[0-9].*"))) {
      request.setAttribute("messaggio", "Password Attuale non valida");
      return view("profilo");
    }
    String oldPassword = DigestUtils.sha1Hex(noOldPassword);

    String noNewPassword = request.getParameter("newPassword");
    if (!(noNewPassword != null && noNewPassword.length() >= 8 && noNewPassword.matches(".*[0-9].*"))) {
      request.setAttribute("messaggio", "Nuova password non valida");
      return view("profilo");
    }
    String newPassword = DigestUtils.sha1Hex(noNewPassword);

    //prendo i 3 possibili utenti dalla sessione
    Turista turista = (Turista) request.getSession().getAttribute("utente");
    ResponsabileLido respLido = (ResponsabileLido) request.getSession().getAttribute("adminLido");
    ResponsabileEnte respEnte = (ResponsabileEnte) request.getSession().getAttribute("adminEnte");


    //controllo se è un turista che sta chiedendo la modifica delle credenziali
    if (turista != null) {
      try {
        TuristaManager tm = new TableTuristaManager(this.getSource(request));
        Optional<Turista> t2 = tm.findTurista(turista.getUsername(), oldPassword);
        if (t2.isPresent()) {
          turista = t2.get();
          if (oldPassword.equals(turista.getPassword_turista())) {
            turista.setPassword_turista(newPassword);
            tm.update(turista);
            request.getSession().removeAttribute("utente");
            request.setAttribute("messaggio", "Accedi con le nuove credenziali");
            return redirect("/SorrentoMarina/login");
          }
        }
        request.setAttribute("messaggio", "La password attuale non coincide, ricontrolla");
        return redirect("/SorrentoMarina/profilo");
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }
    }

    //controllo se è il responsabile lido che sta chiedendo di modificare la password
    if (respLido != null) {
      try {
        ResponsabileLidoManager lm = new TableResponsabileLidoManager(this.getSource(request));
        Optional<ResponsabileLido> r2 =
            lm.findResponsabileLido(respLido.getUsername(), oldPassword);
        if (r2.isPresent()) {
          respLido = r2.get();
          if (oldPassword.equals(respLido.getPassword_responsabile_lido())) {
            respLido.setPassword_responsabile_lido(newPassword);
            lm.update(respLido);
            request.getSession().removeAttribute("adminLido");
            request.setAttribute("messaggio", "Accedi con le nuove credenziali");
            return redirect("/SorrentoMarina/login");
          }
        }
        request.setAttribute("messaggio", "La password attuale non coincide, ricontrolla");
        return redirect("/SorrentoMarina/profilo");
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }
    }

    //controllo se è il responsabile ente che sta chiedendo di modificare la password
    if (respEnte != null) {
      try {
        ResponsabileEnteManager em =
            new TableResponsabileEnteManager(this.getSource(request));
        Optional<ResponsabileEnte> e2 =
            em.findResponsabileEnte(respEnte.getUsername(), oldPassword);
        if (e2.isPresent()) {
          respEnte = e2.get();
          if (oldPassword.equals(respEnte.getPassword_ente())) {
            respEnte.setPassword_ente(newPassword);
            em.update(respEnte);
            request.getSession().removeAttribute("adminEnte");
            request.setAttribute("messaggio", "Accedi con le nuove credenziali");
            return redirect("/SorrentoMarina/login");
          }
        }
        request.setAttribute("messaggio", "La password attuale non coincide, ricontrolla");
        return redirect("/SorrentoMarina/profilo");
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }
    }

    return view("login");
  }
}
