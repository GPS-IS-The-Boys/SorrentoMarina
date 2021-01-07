package theboys.sorrentomarina.actions;

import theboys.sorrentomarina.models.Turista;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MostraFormRecensione implements Action {
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {
    response.setStatus(HttpServletResponse.SC_ACCEPTED);
    try {
      Turista turista = (Turista) request.getSession().getAttribute("utente");
      if (turista != null) {
        return view("formRecensione");
      } else {
        return view("login");
      }
    } catch (Exception e) {
      e.printStackTrace();
      return view("500");
    }
  }
}
