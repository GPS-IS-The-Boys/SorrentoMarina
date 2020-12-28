package theboys.sorrentomarina.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author theboys
 */
public class ShowDashboardAction implements Action {

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {
    request.setAttribute("nome", "diego");
    return view("admin/index");
  }

}
