package theboys.sorrentomarina.actions;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

/**
 * @author Diequ
 */
public class ActionTest extends ActionSetup {

  @Override
  @BeforeEach
  public void setup() {
    super.setup();
  }


  @Test
  public void testView() {
    Action ac = Mockito.mock(Action.class, Mockito.CALLS_REAL_METHODS);
    String result = ac.view("testView");
    assertEquals("/WEB-INF/views/testView.jsp", result,
        "It should return the view path");
  }

  @Test
  public void testGetSource() {
    Action ac = Mockito.mock(Action.class, Mockito.CALLS_REAL_METHODS);
    ServletContext sc = Mockito.mock(ServletContext.class);
    Mockito.when(sc.getAttribute("db"))
        .thenReturn(Mockito.mock(DataSource.class));
    Mockito.when(mockReq.getServletContext()).thenReturn(sc);
    assertNotNull(ac.getSource(mockReq), "It should return a data source");
  }
}
