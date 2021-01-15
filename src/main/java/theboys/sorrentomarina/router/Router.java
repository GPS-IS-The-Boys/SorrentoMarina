package theboys.sorrentomarina.router;

import theboys.sorrentomarina.actions.actionsUtils.Action;
import theboys.sorrentomarina.actions.actionsUtils.NotFoundAction;

import java.util.HashMap;
import java.util.Map;

/**
 * @author theboys
 */
class Router {

  private final Map<HttpMethod, Map<String, Action>> actionMap;

  /**
   * Costruttore
   *
   * @param actionMap
   */
  public Router(Map<HttpMethod, Map<String, Action>> actionMap) {
    this.actionMap = actionMap;
  }

  /**
   * Aggiunta alla Route
   *
   * @param method
   * @param url
   * @param action
   * @return
   */
  public Router addRoute(HttpMethod method, String url, Action action) {
    if (!actionMap.containsKey(method)) {
      actionMap.put(method, new HashMap<>());
    }
    actionMap.get(method).put(url, action);
    return this;
  }

  /**
   * get Route
   *
   * @param url
   * @param action
   * @return
   */
  public Router get(String url, Action action) {
    return addRoute(HttpMethod.GET, url, action);
  }

  /**
   * post Route
   *
   * @param url
   * @param action
   * @return
   */
  public Router post(String url, Action action) {
    return addRoute(HttpMethod.POST, url, action);
  }

  /**
   * gestione della Route
   *
   * @param method
   * @param route
   * @return Action
   */
  public Action handleRoute(HttpMethod method, String route) {
    if (!actionMap.containsKey(method)) {
      return new NotFoundAction();
    } else if (!actionMap.get(method).containsKey(route)) {
      return new NotFoundAction();
    } else {
      return actionMap.get(method).get(route);
    }
  }

  /**
   *
   * @return una map
   */
  public Map<HttpMethod, Map<String, Action>> getActionMap() {
    return actionMap;
  }
}
