package theboys.sorrentomarina.actions;

import theboys.sorrentomarina.actions.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MostraAffluenza implements Action {


  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {
    return view("affluenzaLido");
  }
}
