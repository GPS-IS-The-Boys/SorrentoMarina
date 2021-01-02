package theboys.sorrentomarina.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MostraPrenotazione3Action implements Action {
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {
    try {
      return view("prenotazione3");
    }catch (Exception e){
      return view("500");
    }
  }
}
