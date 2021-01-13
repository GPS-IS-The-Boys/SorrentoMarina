package theboys.sorrentomarina.actions;

import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author theBoys
 */
public class UnauthorizedAction extends ChainableAction {

  /**
   *
   * @param request the request
   * @param response the response
   * @return
   */
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(false);
    if (Objects.nonNull(session)) {
      return super.execute(request, response);
    } else {
      response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
      return view("401");
    }
  }

}
