package theboys.sorrentomarina.router;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.mockito.Mockito;
import theboys.sorrentomarina.actions.Action;
import theboys.sorrentomarina.actions.ChainableAction;
import theboys.sorrentomarina.actions.NotFoundAction;

/**
 *@author theboys
 */
public class RouterTest {

  @Test
  public void testCtor() {
    Router router = new Router(new HashMap<>());
    assertNotNull(router, "It should create a non empty eouter");
  }

  @Test
  public void testAddRouteWithNoRoutes() {
    Router router = new Router(new HashMap<>());
    router.addRoute(HttpMethod.GET, "/someUrl", null);
    int size = router.getActionMap().get(HttpMethod.GET).size();
    assertEquals(1, size, "It should initialize and add route");
  }

  @Test
  public void testAddRouteWithRoutes() {
    Router router = new Router(new HashMap<>());
    router.addRoute(HttpMethod.GET, "/someUrl", null);
    router.addRoute(HttpMethod.GET, "/another", null);
    int size = router.getActionMap().get(HttpMethod.GET).size();
    assertEquals(2, size, "It sohuld append route");
  }

  @Test
  public void testHandleRouteWithUnregisteredAction() {
    Router router = new Router(new HashMap<>());
    Action action = router.handleRoute(HttpMethod.GET, "/");
    assertTrue(action instanceof NotFoundAction,
        "It should return NotFound Action");
  }

  @Test
  public void testHandleRouteWithRegisteredActions() {
    Router router = new Router(new HashMap<>());
    ChainableAction ca = Mockito.mock(ChainableAction.class);
    router.post("/postaction", ca);
    Action action = router.handleRoute(HttpMethod.POST, "/postaction");
    assertTrue(action instanceof ChainableAction,
        "It should return a ChainableAction");
  }

  @Test
  public void testHandleRouteWithActionNotFound() {
    Router router = new Router(new HashMap<>());
    ChainableAction ca = Mockito.mock(ChainableAction.class);
    router.post("/postaction", ca);
    Action action = router.handleRoute(HttpMethod.POST, "/post");
    assertTrue(action instanceof NotFoundAction,
        "It should return a NotFound action");
  }
}
