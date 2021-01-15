package theboys.sorrentomarina.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import theboys.sorrentomarina.models.modelsUtente.ResponsabileEnte;

import static org.junit.jupiter.api.Assertions.*;
/**
 * @author theboys
 */
public class ResponsabileEnteTest {

  private ResponsabileEnte responsabileEnte;

  /**
   * Metodo che inizializza un Responsabile ente
   */
  @BeforeEach
  public void init() {
    responsabileEnte = new ResponsabileEnte(1, "Mario", "Rossi", "m.rossi@unisa.it", "mrossi", "rossimario");
  }

  /**
   * test per il metodo getId
   */
  @Test
  public void getIdTest() {
    int id = responsabileEnte.getId();
    assertEquals(1, id, "Should return 1");
  }

  /**
   * test per il metodo getNome
   */
  @Test
  public void getNomeTest() {
    String nome = responsabileEnte.getNome();
    assertEquals("Mario", nome, "Should return Mario");
  }

  /**
   * test per il metodo getCognome
   */
  @Test
  public void getCognomeTest() {
    String cognome = responsabileEnte.getCognome();
    assertEquals("Rossi", cognome, "Should return Rossi");
  }

  /**
   * test per il metodo getEmail
   */
  @Test
  public void getEmailTest() {
    String email = responsabileEnte.getEmail();
    assertEquals("m.rossi@unisa.it", email, "Should return m.rossi@unisa.it");
  }

  /**
   * test per il metodo getUsername
   */
  @Test
  public void getUsernameTest() {
    String username = responsabileEnte.getUsername();
    assertEquals("mrossi", username, "Should return mrossi");
  }

  /**
   * test per il metodo getPassword
   */
  @Test
  public void getPasswordTest() {
    String pwd = responsabileEnte.getPassword_ente();
    assertEquals("rossimario", pwd, "Sgould return rossimario");
  }

  /**
   * test per il metodo setId
   */
  @Test
  public void setIdTest() {
    responsabileEnte.setId(5);
    int id = responsabileEnte.getId();
    assertEquals(5, id, "Should return 5");
  }

  /**
   * test per il metodo setNome
   */
  @Test
  public void setNomeTest() {
    responsabileEnte.setNome("Luigi");
    String nome = responsabileEnte.getNome();
    assertEquals("Luigi", nome, "Should return Luigi");
  }

  /**
   * test per il metodo setCognome
   */
  @Test
  public void setCognomeTest() {
    responsabileEnte.setCognome("Bianchi");
    String cognome = responsabileEnte.getCognome();
    assertEquals("Bianchi", cognome, "Should return Bianchi");
  }

  /**
   * test per il metodo setEmail
   */
  @Test
  public void setEmailTest() {
    responsabileEnte.setEmail("lbianchi@unisa.it");
    String email = responsabileEnte.getEmail();
    assertEquals("lbianchi@unisa.it", email, "Should return lbianchi@unisa.it");
  }

  /**
   * test per il metodo setUsername
   */
  @Test
  public void setUsernameTest() {
    responsabileEnte.setUsername("lbianchi");
    String username = responsabileEnte.getUsername();
    assertEquals("lbianchi", username, "Should return lbianchi");
  }

  /**
   * test per il metodo setPassword
   */
  @Test
  public void setPasswordTest() {
    responsabileEnte.setPassword_ente("bianchiluigi");
    String pwd = responsabileEnte.getPassword_ente();
    assertEquals("bianchiluigi", pwd, "Sgould return bianchiluigi");
  }

  /**
   * test per il metodo cerate
   */
  @Test
  public void createTest(){
    ResponsabileEnte re = new ResponsabileEnte(1, "", "", "", "","");
    assertNotNull(re);
  }

  /**
   * test per il metodo create
   */
  @Test
  public void createTest2(){
    ResponsabileEnte re = new ResponsabileEnte("", "", "", "","");
    assertNotNull(re);
  }

  /**
   * test per il metodo toString
   */
  @Test
  public void toStringTest(){
    String result = responsabileEnte.toString();
    assertEquals(result, "ResponsabileEnte(nome=Mario, cognome=Rossi, email=m.rossi@unisa.it, username=mrossi, password_ente=rossimario, id=1)");
  }
}
