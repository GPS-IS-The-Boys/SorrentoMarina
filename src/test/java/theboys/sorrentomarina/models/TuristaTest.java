package theboys.sorrentomarina.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import theboys.sorrentomarina.models.modelsUtente.Turista;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
/**
 * @author theboys
 */
public class TuristaTest {

  private Turista turista;

  /**
   * Metodo che inizializza un turista
   */
  @BeforeEach
  public void init() {
    turista = new Turista(1, "Guido", "Lavespa", "guido.l@unisa.it", "Gvespa", "LavespaGuido");
  }


  /**
   * test per il metodo getId
   */
  @Test
  public void getIdTest() {
    int id = turista.getId();
    assertEquals(1, id, "Should return 1");
  }

  /**
   * test per il metodo getNome
   */
  @Test
  public void getNomeTest() {
    String nome = turista.getNome();
    assertEquals("Guido", nome, "should return Guido");
  }

  /**
   * test per il metodo getCognome
   */
  @Test
  public void getCognomeTest() {
    String cognome = turista.getCognome();
    assertEquals("Lavespa", cognome, "Should return Lavespa");
  }

  /**
   * test per il metodo getEmail
   */
  @Test
  public void getEmailTest() {
    String email = turista.getEmail();
    assertEquals("guido.l@unisa.it", email, "Should return guido.l@unisa.it");
  }

  /**
   * test per il metodo getUsername
   */
  @Test
  public void getUsernameTest() {
    String username = turista.getUsername();
    assertEquals("Gvespa", username, "Should return Gvespa");
  }

  /**
   * test per il metodo getPassword_turista
   */
  @Test
  public void getPasswordTest() {
    String pwd = turista.getPassword_turista();
    assertEquals("LavespaGuido", pwd, "Sgould return LavespaGuido");
  }

  /**
   * test per il metodo setId
   */
  @Test
  public void setIdTest() {
    turista.setId(7);
    int id = turista.getId();
    assertEquals(7, id, "Should return 7");
  }

  /**
   * test per il metodo setNome
   */
  @Test
  public void setNomeTest() {
    turista.setNome("Antonio");
    String nome = turista.getNome();
    assertEquals("Antonio", nome, "Should return Antonio");
  }

  /**
   * test per il metodo setCognome
   */
  @Test
  public void setCognomeTest() {
    turista.setCognome("Verdi");
    String cognome = turista.getCognome();
    assertEquals("Verdi", cognome, "Should return Verdi");
  }

  /**
   * test per il metodo setEmail
   */
  @Test
  public void setEmailTest() {
    turista.setEmail("A-Verdi@unisa.it");
    String email = turista.getEmail();
    assertEquals("A-Verdi@unisa.it", email, "Should return A-Verdi@unisa.it");
  }

  /**
   * test per il metodo setUsername
   */
  @Test
  public void setUsernameTest() {
    turista.setUsername("A_Verdi");
    String username = turista.getUsername();
    assertEquals("A_Verdi", username, "Should return A_Verdi");
  }

  /**
   * test per il metodo setPassword_turista
   */
  @Test
  public void setPasswordTest() {
    turista.setPassword_turista("VerdiAntonio");
    String pwd = turista.getPassword_turista();
    assertEquals("VerdiAntonio", pwd, "Sgould return VerdiAntonio");
  }

  /**
   * test per il metodo create
   */
  @Test
  public void createTest(){
    Turista t = new Turista("cas", "acs", "abc");
    assertNotNull(t);
  }

  /**
   * test per il metodo toString
   */
  @Test
  public void toStringTest(){
    String result = turista.toString();
    assertEquals(result, "Turista[id=1,nome=Guido,cognome=Lavespa,email=guido.l@unisa.it,username=Gvespa,password=LavespaGuido]");
  }
}