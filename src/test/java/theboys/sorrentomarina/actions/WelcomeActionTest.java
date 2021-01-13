package theboys.sorrentomarina.actions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.servlet.ServletContext;
import java.io.FileNotFoundException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WelcomeActionTest extends ActionSetupDB{

  /**
   * Controlla che la view ritornata è quella corretta, ossia la index
   *
   * @author Francesco Pio Covino
   */
  @Test
  public void textView() {
    Action ac = Mockito.mock(WelcomeAction.class, Mockito.CALLS_REAL_METHODS);
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    Mockito.when(mockReq.getParameter("nomeRicerca")).thenReturn("Lido1");
    Mockito.when(mockReq.getParameter("servizio1")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio2")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio3")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio4")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio5")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio6")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio7")).thenReturn("true");
    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);
    String result = ac.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/index.jsp", result,
        "It should return the view path");
  }

  @Test
  public void textServizio1Null() {
    Action ac = Mockito.mock(WelcomeAction.class, Mockito.CALLS_REAL_METHODS);
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    Mockito.when(mockReq.getParameter("nomeRicerca")).thenReturn("Lido1");
    Mockito.when(mockReq.getParameter("servizio1")).thenReturn(null);
    Mockito.when(mockReq.getParameter("servizio2")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio3")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio4")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio5")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio6")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio7")).thenReturn("true");
    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);
    String result = ac.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/index.jsp", result,
        "It should return the view path");
  }
  @Test
  public void textServizio2Null() {
    Action ac = Mockito.mock(WelcomeAction.class, Mockito.CALLS_REAL_METHODS);
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    Mockito.when(mockReq.getParameter("nomeRicerca")).thenReturn("Lido1");
    Mockito.when(mockReq.getParameter("servizio1")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio2")).thenReturn(null);
    Mockito.when(mockReq.getParameter("servizio3")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio4")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio5")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio6")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio7")).thenReturn("true");
    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);
    String result = ac.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/index.jsp", result,
        "It should return the view path");
  }
  @Test
  public void textServizio3Null() {
    Action ac = Mockito.mock(WelcomeAction.class, Mockito.CALLS_REAL_METHODS);
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    Mockito.when(mockReq.getParameter("nomeRicerca")).thenReturn("Lido1");
    Mockito.when(mockReq.getParameter("servizio1")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio2")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio3")).thenReturn(null);
    Mockito.when(mockReq.getParameter("servizio4")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio5")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio6")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio7")).thenReturn("true");
    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);
    String result = ac.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/index.jsp", result,
        "It should return the view path");
  }
  @Test
  public void textServizio4Null() {
    Action ac = Mockito.mock(WelcomeAction.class, Mockito.CALLS_REAL_METHODS);
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    Mockito.when(mockReq.getParameter("nomeRicerca")).thenReturn("Lido1");
    Mockito.when(mockReq.getParameter("servizio1")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio2")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio3")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio4")).thenReturn(null);
    Mockito.when(mockReq.getParameter("servizio5")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio6")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio7")).thenReturn("true");
    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);
    String result = ac.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/index.jsp", result,
        "It should return the view path");
  }
  @Test
  public void textServizio5Null() {
    Action ac = Mockito.mock(WelcomeAction.class, Mockito.CALLS_REAL_METHODS);
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    Mockito.when(mockReq.getParameter("nomeRicerca")).thenReturn("Lido1");
    Mockito.when(mockReq.getParameter("servizio1")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio2")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio3")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio4")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio5")).thenReturn(null);
    Mockito.when(mockReq.getParameter("servizio6")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio7")).thenReturn("true");
    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);
    String result = ac.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/index.jsp", result,
        "It should return the view path");
  }
  @Test
  public void textServizio6Null() {
    Action ac = Mockito.mock(WelcomeAction.class, Mockito.CALLS_REAL_METHODS);
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    Mockito.when(mockReq.getParameter("nomeRicerca")).thenReturn("Lido1");
    Mockito.when(mockReq.getParameter("servizio1")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio2")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio3")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio4")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio5")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio6")).thenReturn(null);
    Mockito.when(mockReq.getParameter("servizio7")).thenReturn("true");
    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);
    String result = ac.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/index.jsp", result,
        "It should return the view path");
  }
  @Test
  public void textServizio7Null() {
    Action ac = Mockito.mock(WelcomeAction.class, Mockito.CALLS_REAL_METHODS);
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    Mockito.when(mockReq.getParameter("nomeRicerca")).thenReturn("Lido1");
    Mockito.when(mockReq.getParameter("servizio1")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio2")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio3")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio4")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio5")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio6")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio7")).thenReturn(null);
    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);
    String result = ac.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/index.jsp", result,
        "It should return the view path");
  }
  @Test
  public void textNomeLidoNull() {
    Action ac = Mockito.mock(WelcomeAction.class, Mockito.CALLS_REAL_METHODS);
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    Mockito.when(mockReq.getParameter("nomeRicerca")).thenReturn(null);
    Mockito.when(mockReq.getParameter("servizio1")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio2")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio3")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio4")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio5")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio6")).thenReturn("true");
    Mockito.when(mockReq.getParameter("servizio7")).thenReturn("true");
    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);
    String result = ac.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/index.jsp", result,
        "It should return the view path");
  }

  @Test
  public void textRicercaSenzaNessunCampo() {
    Action ac = Mockito.mock(WelcomeAction.class, Mockito.CALLS_REAL_METHODS);
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    Mockito.when(mockReq.getParameter("nomeRicerca")).thenReturn(null);
    Mockito.when(mockReq.getParameter("servizio1")).thenReturn(null);
    Mockito.when(mockReq.getParameter("servizio2")).thenReturn(null);
    Mockito.when(mockReq.getParameter("servizio3")).thenReturn(null);
    Mockito.when(mockReq.getParameter("servizio4")).thenReturn(null);
    Mockito.when(mockReq.getParameter("servizio5")).thenReturn(null);
    Mockito.when(mockReq.getParameter("servizio6")).thenReturn(null);
    Mockito.when(mockReq.getParameter("servizio7")).thenReturn(null);
    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);
    String result = ac.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/index.jsp", result,
        "It should return the view path");
  }
}
