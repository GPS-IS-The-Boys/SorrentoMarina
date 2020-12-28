package theboys.sorrentomarina.actions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrazioneActionTest extends ActionSetup{

  private RegistrazioneAction rgAction;

  @Override
  @BeforeEach
  public void setup() {
    this.rgAction = new RegistrazioneAction();
    super.setup();
  }

  /**
   * Test nel caso il nome sia non corretto
   */
  @Test
  public void testExecuteFailNomeValidation(){
    String[] nome = {"m1ario"};
    String[] cognome = {"Prova"};
    String[] email = {"prova@tiscali.it"};
    String[] username = {"provolone"};
    String[] password = {"Passwordprova1"};
    String[] passwordConferma = {"Passwordprova1"};
    Mockito.when(mockReq.getParameterMap()).thenReturn(Map.of("nome", nome, "cognome", cognome, "email", email, "username", username, "password", password, "passwordConferma", passwordConferma));
    String page = this.rgAction.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/registrazione.jsp", page);
  }

  /**
   * Test nel caso il cognome sia non corretto
   */
  @Test
  public void testExecuteFailCognomeValidation(){
    String[] nome = {"Mario"};
    String[] cognome = {"P1.rova"};
    String[] email = {"prova@tiscali.it"};
    String[] username = {"provolone"};
    String[] password = {"Passwordprova1"};
    String[] passwordConferma = {"Passwordprova1"};
    Mockito.when(mockReq.getParameterMap()).thenReturn(Map.of("nome", nome, "cognome", cognome, "email", email, "username", username, "password", password, "passwordConferma", passwordConferma));
    String page = this.rgAction.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/registrazione.jsp", page);
  }

  /**
   * Test nel caso l'email sia non corretta
   */
  @Test
  public void testExecuteFailEmailValidation(){
    String[] nome = {"Mario"};
    String[] cognome = {"Prova"};
    String[] email = {"prova@tiscaliit"};
    String[] username = {"provolone"};
    String[] password = {"Passwordprova1"};
    String[] passwordConferma = {"Passwordprova1"};
    Mockito.when(mockReq.getParameterMap()).thenReturn(Map.of("nome", nome, "cognome", cognome, "email", email, "username", username, "password", password, "passwordConferma", passwordConferma));
    String page = this.rgAction.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/registrazione.jsp", page);
  }

  /**
   * Test nel caso l'username sia non corretto
   */
  @Test
  public void testExecuteFailUsernameValidation(){
    String[] nome = {"Mario"};
    String[] cognome = {"Prova"};
    String[] email = {"prova@tiscali.it"};
    String[] username = {"pro"};
    String[] password = {"Passwordprova1"};
    String[] passwordConferma = {"Passwordprova1"};
    Mockito.when(mockReq.getParameterMap()).thenReturn(Map.of("nome", nome, "cognome", cognome, "email", email, "username", username, "password", password, "passwordConferma", passwordConferma));
    String page = this.rgAction.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/registrazione.jsp", page);
  }

  /**
   * Test nel caso la password e la confermaPassword non coincidano
   */
  @Test
  public void testExecuteFailPasswordValidation(){
    String[] nome = {"Mario"};
    String[] cognome = {"Prova"};
    String[] email = {"prova@tiscali.it"};
    String[] username = {"provolone"};
    String[] password = {"Passwordprova1"};
    String[] passwordConferma = {"Passwordprova"};
    Mockito.when(mockReq.getParameterMap()).thenReturn(Map.of("nome", nome, "cognome", cognome, "email", email, "username", username, "password", password, "passwordConferma", passwordConferma));
    String page = this.rgAction.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/registrazione.jsp", page);
  }

  /**
   * Test nel caso i dati siano inseriti correttamente
   */
  @Test
  public void testExecuteSuccessValidation(){
    String[] nome = {"Mario"};
    String[] cognome = {"Prova"};
    String[] email = {"prova@tiscali.it"};
    String[] username = {"provolone"};
    String[] password = {"Passwordprova1"};
    String[] passwordConferma = {"Passwordprova1"};
    Mockito.when(mockReq.getParameterMap()).thenReturn(Map.of("nome", nome, "cognome", cognome, "email", email, "username", username, "password", password, "passwordConferma", passwordConferma));
    String page = this.rgAction.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/index.jsp", page);
  }
}