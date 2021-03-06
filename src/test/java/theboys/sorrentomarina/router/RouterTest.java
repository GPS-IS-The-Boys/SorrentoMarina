package theboys.sorrentomarina.router;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.mockito.Mockito;
import theboys.sorrentomarina.actions.actionsUtils.Action;
import theboys.sorrentomarina.actions.actionsUtils.ChainableAction;
import theboys.sorrentomarina.actions.actionsUtils.NotFoundAction;

/**
 *@author theboys
 */
public class RouterTest {

  /**
   * Test - router
   */
  @Test
  public void testCtor() {
    Router router = new Router(new HashMap<>());
    assertNotNull(router, "It should create a non empty router");
  }

  /**
   * Test - senza percorso
   */
  @Test
  public void testAddRouteWithNoRoutes() {
    Router router = new Router(new HashMap<>());
    router.addRoute(HttpMethod.GET, "/someUrl", null);
    int size = router.getActionMap().get(HttpMethod.GET).size();
    assertEquals(1, size, "It should initialize and add route");
  }

  /**
   * Test - con percorso
   */
  @Test
  public void testAddRouteWithRoutes() {
    Router router = new Router(new HashMap<>());
    router.addRoute(HttpMethod.GET, "/someUrl", null);
    router.addRoute(HttpMethod.GET, "/another", null);
    int size = router.getActionMap().get(HttpMethod.GET).size();
    assertEquals(2, size, "It sohuld append route");
  }

  /**
   * Testa la gestione del percorso con azione non registrata
   */
  @Test
  public void testHandleRouteWithUnregisteredAction() {
    Router router = new Router(new HashMap<>());
    Action action = router.handleRoute(HttpMethod.GET, "/");
    assertTrue(action instanceof NotFoundAction,
        "It should return NotFound Action");
  }

  /**
   * Testa la gestione del percorso con azione registrata
   */
  @Test
  public void testHandleRouteWithRegisteredActions() {
    Router router = new Router(new HashMap<>());
    ChainableAction ca = Mockito.mock(ChainableAction.class);
    router.post("/postaction", ca);
    Action action = router.handleRoute(HttpMethod.POST, "/postaction");
    assertTrue(action instanceof ChainableAction,
        "It should return a ChainableAction");
  }

  /**
   * Testa la gestione del percorso senza azione
   */
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
