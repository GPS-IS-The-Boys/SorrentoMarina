package theboys.sorrentomarina.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author theBoys
 */
public class ShowDashboardAction implements Action {

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {
    return view("admin/index");
  }

}
