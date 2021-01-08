package theboys.sorrentomarina.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MostraPrevisioni implements Action {

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {
    return view("previsioniMeteo");
  }
}
