package theboys.sorrentomarina.actions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrazioneActionTest extends ActionSetup {

  private RegistrazioneAction rgAction;

  @Override
  @BeforeEach
  public void setup() {
    rgAction = new RegistrazioneAction();
    super.setup();
  }

  /**
   * Test nel caso il nome sia non corretto
   */
  @Test
  public void testExecuteFailNomeValidation(){
    Mockito.when(mockReq.getParameter("nome")).thenReturn("M1rio");
    Mockito.when(mockReq.getParameter("cognome")).thenReturn("Prova");
    Mockito.when(mockReq.getParameter("email")).thenReturn("prova@gmail.com");
    Mockito.when(mockReq.getParameter("username")).thenReturn("mimmuzzo");
    Mockito.when(mockReq.getParameter("password")).thenReturn("Marioooo1");
    Mockito.when(mockReq.getParameter("passwordConferma")).thenReturn("Marioooo1");
    String page = this.rgAction.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/registrazione.jsp", page);
  }

  /**
   * Test nel caso il cognome sia non corretto
   */
  @Test
  public void testExecuteFailCognomeValidation(){
    Mockito.when(mockReq.getParameter("nome")).thenReturn("Mario");
    Mockito.when(mockReq.getParameter("cognome")).thenReturn("P1rova");
    Mockito.when(mockReq.getParameter("email")).thenReturn("prova@gmail.com");
    Mockito.when(mockReq.getParameter("username")).thenReturn("mimmuzzo");
    Mockito.when(mockReq.getParameter("password")).thenReturn("Marioooo1");
    Mockito.when(mockReq.getParameter("passwordConferma")).thenReturn("Marioooo1");
    String page = this.rgAction.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/registrazione.jsp", page);
  }

  /**
   * Test nel caso l'email sia non corretta
   */
  @Test
  public void testExecuteFailEmailValidation(){
    Mockito.when(mockReq.getParameter("nome")).thenReturn("Mario");
    Mockito.when(mockReq.getParameter("cognome")).thenReturn("Prova");
    Mockito.when(mockReq.getParameter("email")).thenReturn("prova@gmailcom");
    Mockito.when(mockReq.getParameter("username")).thenReturn("mimmuzzo");
    Mockito.when(mockReq.getParameter("password")).thenReturn("Marioooo1");
    Mockito.when(mockReq.getParameter("passwordConferma")).thenReturn("Marioooo1");
    String page = this.rgAction.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/registrazione.jsp", page);
  }

  /**
   * Test nel caso l'username sia non corretto
   */
  @Test
  public void testExecuteFailUsernameValidation(){
    Mockito.when(mockReq.getParameter("nome")).thenReturn("Mario");
    Mockito.when(mockReq.getParameter("cognome")).thenReturn("Prova");
    Mockito.when(mockReq.getParameter("email")).thenReturn("prova@gmail.com");
    Mockito.when(mockReq.getParameter("username")).thenReturn("mim");
    Mockito.when(mockReq.getParameter("password")).thenReturn("Marioooo1");
    Mockito.when(mockReq.getParameter("passwordConferma")).thenReturn("Marioooo1");
    String page = this.rgAction.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/registrazione.jsp", page);
  }

  /**
   * Test nel caso la password e la confermaPassword non coincidano
   */
  @Test
  public void testExecuteFailPasswordValidation(){
    Mockito.when(mockReq.getParameter("nome")).thenReturn("Mario");
    Mockito.when(mockReq.getParameter("cognome")).thenReturn("Prova");
    Mockito.when(mockReq.getParameter("email")).thenReturn("prova@gmail.com");
    Mockito.when(mockReq.getParameter("username")).thenReturn("mimmuzzo");
    Mockito.when(mockReq.getParameter("password")).thenReturn("Mario1");
    Mockito.when(mockReq.getParameter("passwordConferma")).thenReturn("Marioooo1");
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
    String page = this.rgAction.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/index.jsp", page);
  }
}