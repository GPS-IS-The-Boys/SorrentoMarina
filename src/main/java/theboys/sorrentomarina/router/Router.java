package theboys.sorrentomarina.router;

import theboys.sorrentomarina.actions.Action;
import theboys.sorrentomarina.actions.NotFoundAction;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author theboys
 */
class Router {
    
    private final Map<HttpMethod, Map<String, Action>> actionMap;

    public Router(Map<HttpMethod, Map<String, Action>> actionMap) {
        this.actionMap = actionMap;
    }
    
    public Router addRoute(HttpMethod method, String url, Action action){
        if(!actionMap.containsKey(method)) {
            actionMap.put(method, new HashMap<>());
        }
        actionMap.get(method).put(url, action);
        return this;
    }
    
    public Router get(String url, Action action){
        return addRoute(HttpMethod.GET, url, action);
    }
    
    public Router post(String url, Action action){
        return addRoute(HttpMethod.POST, url, action);
    }
    
    public Action handleRoute(HttpMethod method, String route){
        if(!actionMap.containsKey(method)){
            return new NotFoundAction();
        } else if(!actionMap.get(method).containsKey(route)) {
            return new NotFoundAction();
        } else {
            return actionMap.get(method).get(route);
        }
    }
    
    public Map<HttpMethod, Map<String, Action>> getActionMap() {
        return actionMap;
    }
}
