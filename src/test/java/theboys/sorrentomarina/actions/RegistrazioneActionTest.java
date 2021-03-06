package theboys.sorrentomarina.actions;

import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import theboys.sorrentomarina.actions.actionsUtente.RegistrazioneAction;
import theboys.sorrentomarina.managers.managersUtente.TableTuristaManager;
import theboys.sorrentomarina.managers.managersUtente.TuristaManager;
import theboys.sorrentomarina.models.modelsUtente.Turista;

import javax.servlet.ServletContext;


import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
/**
 * @author theBoys
 */
public class RegistrazioneActionTest extends ActionSetupDB {

  private RegistrazioneAction rgAction;

  /**
   * Test nel caso il nome sia non corretto
   */
  @Test
  public void testExecuteFailNomeFormat(){
    Mockito.when(mockReq.getParameter("nome")).thenReturn("M1rio");
    Mockito.when(mockReq.getParameter("cognome")).thenReturn("Prova");
    Mockito.when(mockReq.getParameter("email")).thenReturn("prova@gmail.com");
    Mockito.when(mockReq.getParameter("username")).thenReturn("mimmuzzo");
    Mockito.when(mockReq.getParameter("password")).thenReturn("Marioooo1");
    Mockito.when(mockReq.getParameter("passwordConferma")).thenReturn("Marioooo1");

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);
    rgAction = new RegistrazioneAction();
    String page = this.rgAction.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/registrazione.jsp", page);
  }

  /**
   * Test nel caso il cognome sia non corretto
   */
  @Test
  public void testExecuteFailCognomeFormat(){
    Mockito.when(mockReq.getParameter("nome")).thenReturn("Mario");
    Mockito.when(mockReq.getParameter("cognome")).thenReturn("P1rova");
    Mockito.when(mockReq.getParameter("email")).thenReturn("prova@gmail.com");
    Mockito.when(mockReq.getParameter("username")).thenReturn("mimmuzzo");
    Mockito.when(mockReq.getParameter("password")).thenReturn("Marioooo1");
    Mockito.when(mockReq.getParameter("passwordConferma")).thenReturn("Marioooo1");
    rgAction = new RegistrazioneAction();
    String page = this.rgAction.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/registrazione.jsp", page);
  }

  /**
   * Test nel caso l'email sia non corretta
   */
  @Test
  public void testExecuteFailEmailFormat(){
    Mockito.when(mockReq.getParameter("nome")).thenReturn("Mario");
    Mockito.when(mockReq.getParameter("cognome")).thenReturn("Prova");
    Mockito.when(mockReq.getParameter("email")).thenReturn("prova@gmailcom");
    Mockito.when(mockReq.getParameter("username")).thenReturn("mimmuzzo");
    Mockito.when(mockReq.getParameter("password")).thenReturn("Marioooo1");
    Mockito.when(mockReq.getParameter("passwordConferma")).thenReturn("Marioooo1");

    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);
    rgAction = new RegistrazioneAction();
    String page = this.rgAction.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/registrazione.jsp", page);
  }

  /**
   * Test nel caso l'username sia non corretto
   */
  @Test
  public void testExecuteFailUsernameFormat(){
    Mockito.when(mockReq.getParameter("nome")).thenReturn("Mario");
    Mockito.when(mockReq.getParameter("cognome")).thenReturn("Prova");
    Mockito.when(mockReq.getParameter("email")).thenReturn("prova@gmail.com");
    Mockito.when(mockReq.getParameter("username")).thenReturn("mim");
    Mockito.when(mockReq.getParameter("password")).thenReturn("Marioooo1");
    Mockito.when(mockReq.getParameter("passwordConferma")).thenReturn("Marioooo1");

    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);
    rgAction = new RegistrazioneAction();
    String page = this.rgAction.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/registrazione.jsp", page);
  }

  /**
   * Test nel caso la password e la confermaPassword non coincidano
   */
  @Test
  public void testExecuteFailPasswordFormat(){
    Mockito.when(mockReq.getParameter("nome")).thenReturn("Mario");
    Mockito.when(mockReq.getParameter("cognome")).thenReturn("Prova");
    Mockito.when(mockReq.getParameter("email")).thenReturn("prova@gmail.com");
    Mockito.when(mockReq.getParameter("username")).thenReturn("mimmuzzo");
    Mockito.when(mockReq.getParameter("password")).thenReturn("Mariooo1");
    Mockito.when(mockReq.getParameter("passwordConferma")).thenReturn("Mari1");

    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);
    rgAction = new RegistrazioneAction();
    String page = this.rgAction.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/registrazione.jsp", page);
  }

  /**
   * Test nel caso i dati siano inseriti correttamente
   */
  @Test
  public void testExecuteSuccessValidation(){
    Mockito.when(mockReq.getParameter("nome")).thenReturn("Mario");
    Mockito.when(mockReq.getParameter("cognome")).thenReturn("Prova");
    Mockito.when(mockReq.getParameter("email")).thenReturn("prova@gmail.com");
    Mockito.when(mockReq.getParameter("username")).thenReturn("mimmuzzo");
    Mockito.when(mockReq.getParameter("password")).thenReturn("Marioooo1");
    Mockito.when(mockReq.getParameter("passwordConferma")).thenReturn("Marioooo1");
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);
    rgAction = new RegistrazioneAction();
    String page = this.rgAction.execute(mockReq, mockRes);

    TuristaManager tm = new TableTuristaManager(mockConnection);
    Turista t = null;
    try {
      t = tm.retriveById(5);
    } catch (SQLException e){}

    assertNotNull(t);
    assertEquals("redirect:/SorrentoMarina/", page);
  }

  /**
   * Test nel caso il nome sia non corretto
   */
  @Test
  public void testExecuteNomeNull(){
    Mockito.when(mockReq.getParameter("nome")).thenReturn(null);
    Mockito.when(mockReq.getParameter("cognome")).thenReturn("Prova");
    Mockito.when(mockReq.getParameter("email")).thenReturn("prova@gmail.com");
    Mockito.when(mockReq.getParameter("username")).thenReturn("mimmuzzo");
    Mockito.when(mockReq.getParameter("password")).thenReturn("Marioooo1");
    Mockito.when(mockReq.getParameter("passwordConferma")).thenReturn("Marioooo1");

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);
    rgAction = new RegistrazioneAction();
    String page = this.rgAction.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/registrazione.jsp", page);
  }

  /**
   * Test nel caso il cognome sia non corretto
   */
  @Test
  public void testExecuteFailCognomeNull(){
    Mockito.when(mockReq.getParameter("nome")).thenReturn("Mario");
    Mockito.when(mockReq.getParameter("cognome")).thenReturn(null);
    Mockito.when(mockReq.getParameter("email")).thenReturn("prova@gmail.com");
    Mockito.when(mockReq.getParameter("username")).thenReturn("mimmuzzo");
    Mockito.when(mockReq.getParameter("password")).thenReturn("Marioooo1");
    Mockito.when(mockReq.getParameter("passwordConferma")).thenReturn("Marioooo1");
    rgAction = new RegistrazioneAction();
    String page = this.rgAction.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/registrazione.jsp", page);
  }

  /**
   * Test nel caso l'email sia non corretta
   */
  @Test
  public void testExecuteFailEmailNull(){
    Mockito.when(mockReq.getParameter("nome")).thenReturn("Mario");
    Mockito.when(mockReq.getParameter("cognome")).thenReturn("Prova");
    Mockito.when(mockReq.getParameter("email")).thenReturn(null);
    Mockito.when(mockReq.getParameter("username")).thenReturn("mimmuzzo");
    Mockito.when(mockReq.getParameter("password")).thenReturn("Marioooo1");
    Mockito.when(mockReq.getParameter("passwordConferma")).thenReturn("Marioooo1");

    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);
    rgAction = new RegistrazioneAction();
    String page = this.rgAction.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/registrazione.jsp", page);
  }

  /**
   * Test nel caso l'username sia non corretto
   */
  @Test
  public void testExecuteFailUsernameNull(){
    Mockito.when(mockReq.getParameter("nome")).thenReturn("Mario");
    Mockito.when(mockReq.getParameter("cognome")).thenReturn("Prova");
    Mockito.when(mockReq.getParameter("email")).thenReturn("prova@gmail.com");
    Mockito.when(mockReq.getParameter("username")).thenReturn(null);
    Mockito.when(mockReq.getParameter("password")).thenReturn("Marioooo1");
    Mockito.when(mockReq.getParameter("passwordConferma")).thenReturn("Marioooo1");

    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);
    rgAction = new RegistrazioneAction();
    String page = this.rgAction.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/registrazione.jsp", page);
  }

  /**
   * Test nel caso la password e la confermaPassword non coincidano
   */
  @Test
  public void testExecuteFailPasswordNull(){
    Mockito.when(mockReq.getParameter("nome")).thenReturn("Mario");
    Mockito.when(mockReq.getParameter("cognome")).thenReturn("Prova");
    Mockito.when(mockReq.getParameter("email")).thenReturn("prova@gmail.com");
    Mockito.when(mockReq.getParameter("username")).thenReturn("mimmuzzo");
    Mockito.when(mockReq.getParameter("password")).thenReturn(null);
    Mockito.when(mockReq.getParameter("passwordConferma")).thenReturn("Marioooo1");

    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);
    rgAction = new RegistrazioneAction();
    String page = this.rgAction.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/registrazione.jsp", page);
  }

  /**
   * Test nel caso il nome sia non corretto
   */
  @Test
  public void testExecuteNomeLenght(){
    Mockito.when(mockReq.getParameter("nome")).thenReturn("");
    Mockito.when(mockReq.getParameter("cognome")).thenReturn("Prova");
    Mockito.when(mockReq.getParameter("email")).thenReturn("prova@gmail.com");
    Mockito.when(mockReq.getParameter("username")).thenReturn("mimmuzzo");
    Mockito.when(mockReq.getParameter("password")).thenReturn("Marioooo1");
    Mockito.when(mockReq.getParameter("passwordConferma")).thenReturn("Marioooo1");

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);
    rgAction = new RegistrazioneAction();
    String page = this.rgAction.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/registrazione.jsp", page);
  }

  /**
   * Test nel caso il cognome sia non corretto
   */
  @Test
  public void testExecuteFailCognomeLenght(){
    Mockito.when(mockReq.getParameter("nome")).thenReturn("Mario");
    Mockito.when(mockReq.getParameter("cognome")).thenReturn("");
    Mockito.when(mockReq.getParameter("email")).thenReturn("prova@gmail.com");
    Mockito.when(mockReq.getParameter("username")).thenReturn("mimmuzzo");
    Mockito.when(mockReq.getParameter("password")).thenReturn("Marioooo1");
    Mockito.when(mockReq.getParameter("passwordConferma")).thenReturn("Marioooo1");
    rgAction = new RegistrazioneAction();
    String page = this.rgAction.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/registrazione.jsp", page);
  }

  /**
   * Test nel caso l'username sia non corretto
   */
  @Test
  public void testExecuteFailUsernameLenght(){
    Mockito.when(mockReq.getParameter("nome")).thenReturn("Mario");
    Mockito.when(mockReq.getParameter("cognome")).thenReturn("Prova");
    Mockito.when(mockReq.getParameter("email")).thenReturn("prova@gmail.com");
    Mockito.when(mockReq.getParameter("username")).thenReturn("");
    Mockito.when(mockReq.getParameter("password")).thenReturn("Marioooo1");
    Mockito.when(mockReq.getParameter("passwordConferma")).thenReturn("Marioooo1");

    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);
    rgAction = new RegistrazioneAction();
    String page = this.rgAction.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/registrazione.jsp", page);
  }

  /**
   * Test nel caso la password e la confermaPassword non coincidano
   */
  @Test
  public void testExecuteFailPasswordLenght(){
    Mockito.when(mockReq.getParameter("nome")).thenReturn("Mario");
    Mockito.when(mockReq.getParameter("cognome")).thenReturn("Prova");
    Mockito.when(mockReq.getParameter("email")).thenReturn("prova@gmail.com");
    Mockito.when(mockReq.getParameter("username")).thenReturn("mimmuzzo");
    Mockito.when(mockReq.getParameter("password")).thenReturn("");
    Mockito.when(mockReq.getParameter("passwordConferma")).thenReturn("Marioooo1");

    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);
    rgAction = new RegistrazioneAction();
    String page = this.rgAction.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/registrazione.jsp", page);
  }

}