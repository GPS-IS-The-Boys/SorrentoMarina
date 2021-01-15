package theboys.sorrentomarina.actions.actionsUtils;

import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author theBoys
 */
public abstract class ChainableAction implements Action {

  private Action next;

  public void setNext(Action next) {
    this.next = next;
  }

  /**
   *
   *
   * @param request the request
   * @param response the response
   * @return
   */
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {
    return Objects.nonNull(next) ? next.execute(request, response) : view("500");
  }


}
