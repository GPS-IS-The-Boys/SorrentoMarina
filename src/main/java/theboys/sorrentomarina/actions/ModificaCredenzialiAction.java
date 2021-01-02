package theboys.sorrentomarina.actions;

import org.apache.commons.codec.digest.DigestUtils;
import theboys.sorrentomarina.managers.*;
import theboys.sorrentomarina.models.ResponsabileEnte;
import theboys.sorrentomarina.models.ResponsabileLido;
import theboys.sorrentomarina.models.Turista;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.Optional;

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
    String oldPassword = DigestUtils.sha1Hex(request.getParameter("oldPassword"));
    String newPassword = DigestUtils.sha1Hex(request.getParameter("newPassword"));

    //prendo i 3 possibili utenti dalla sessione
    Turista turista = (Turista) request.getSession().getAttribute("utente");
    ResponsabileLido respLido = (ResponsabileLido) request.getSession().getAttribute("adminLido");
    ResponsabileEnte respEnte = (ResponsabileEnte) request.getSession().getAttribute("adminEnte");

    TuristaManager tm = new TableTuristaManager(this.getSource(request));
    ResponsabileLidoManager lm = new TableResponsabileLidoManager(this.getSource(request));
    ResponsabileEnteManager em = new TableResponsabileEnteManager(this.getSource(request));

    //controllo se è un turista che sta chiedendo la modifica delle credenziali
    if (turista != null) {
      try {
        Optional<Turista> t2 = tm.findTurista(turista.getUsername(), oldPassword);
        if (t2.isPresent()) {
          turista = t2.get();
          if (oldPassword.equals(turista.getPassword())) {
            turista.setPassword(newPassword);
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
        Optional<ResponsabileLido> r2 = lm.findResponsabileLido(respLido.getUsername(), oldPassword);
        if (r2.isPresent()) {
          respLido = r2.get();
          if (oldPassword.equals(respLido.getPassword())) {
            respLido.setPassword(newPassword);
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
        Optional<ResponsabileEnte> e2 = em.findResponsabileEnte(respEnte.getUsername(), oldPassword);
        if (e2.isPresent()) {
          respEnte = e2.get();
          if (oldPassword.equals(respEnte.getPassword())) {
            respEnte.setPassword(newPassword);
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
