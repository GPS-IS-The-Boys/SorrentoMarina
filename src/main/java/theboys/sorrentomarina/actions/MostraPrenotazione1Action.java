package theboys.sorrentomarina.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MostraPrenotazione1Action implements Action {
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {
    try {
      return view("prenotazione1");
    } catch (Exception e) {
      return view("500");
    }
  }
}
