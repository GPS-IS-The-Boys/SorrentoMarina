package theboys.sorrentomarina.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import theboys.sorrentomarina.models.modelsUtente.ResponsabileLido;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * @author theboys
 */
public class ResponsabileLidoTest {

  private ResponsabileLido responsabileLido;

  /**
   * Metodo che inizializza un Responsabile lido
   */
  @BeforeEach
  public void init() {
    responsabileLido = new ResponsabileLido(1, "Guido", "Lavespa", "guido.l@unisa.it", "Gvespa", "LavespaGuido",1, 1);
  }

  /**
   * test per il metodo getId
   */
  @Test
  public void getIdTest() {
    int id = responsabileLido.getId();
    assertEquals(1, id, "Should return 1");
  }

  /**
   * test per il metodo getNome
   */
  @Test
  public void getNomeTest() {
    String nome = responsabileLido.getNome();
    assertEquals("Guido", nome, "should return Guido");
  }

  /**
   * test per il metodo getCognome
   */
  @Test
  public void getCognomeTest() {
    String cognome = responsabileLido.getCognome();
    assertEquals("Lavespa", cognome, "Should return Lavespa");
  }

  /**
   * test per il metodo getEmail
   */
  @Test
  public void getEmailTest() {
    String email = responsabileLido.getEmail();
    assertEquals("guido.l@unisa.it", email, "Should return guido.l@unisa.it");
  }

  /**
   * test per il metodo getUsername
   */
  @Test
  public void getUsernameTest() {
    String username = responsabileLido.getUsername();
    assertEquals("Gvespa", username, "Should return Gvespa");
  }

  /**
   * test per il metodo getPassword_responsabile_lido
   */
  @Test
  public void getPasswordTest() {
    String pwd = responsabileLido.getPassword_responsabile_lido();
    assertEquals("LavespaGuido", pwd, "Sgould return LavespaGuido");
  }

  /**
   * test per il metodo getId_lido
   */
  @Test
  public void getIdLidoTest() {
    int id_lido = responsabileLido.getId_lido();
    assertEquals(1, id_lido, "Sgould return 1");
  }

  /**
   * test per il metodo setId
   */
  @Test
  public void setIdTest() {
    responsabileLido.setId(7);
    int id = responsabileLido.getId();
    assertEquals(7, id, "Should return 7");
  }

  /**
   * test per il metodo setNome
   */
  @Test
  public void setNomeTest() {
    responsabileLido.setNome("Antonio");
    String nome = responsabileLido.getNome();
    assertEquals("Antonio", nome, "Should return Antonio");
  }

  /**
   * test per il metodo setCognome
   */
  @Test
  public void setCognomeTest() {
    responsabileLido.setCognome("Verdi");
    String cognome = responsabileLido.getCognome();
    assertEquals("Verdi", cognome, "Should return Verdi");
  }

  /**
   * test per il metodo setEmail
   */
  @Test
  public void setEmailTest() {
    responsabileLido.setEmail("A-Verdi@unisa.it");
    String email = responsabileLido.getEmail();
    assertEquals("A-Verdi@unisa.it", email, "Should return A-Verdi@unisa.it");
  }

  /**
   * test per il metodo setUsername
   */
  @Test
  public void setUsernameTest() {
    responsabileLido.setUsername("A_Verdi");
    String username = responsabileLido.getUsername();
    assertEquals("A_Verdi", username, "Should return A_Verdi");
  }

  /**
   * test per il metodo setPassword_responsabile_lido
   */
  @Test
  public void setPasswordTest() {
    responsabileLido.setPassword_responsabile_lido("VerdiAntonio");
    String pwd = responsabileLido.getPassword_responsabile_lido();
    assertEquals("VerdiAntonio", pwd, "Sgould return VerdiAntonio");
  }

   /**
   * test per il metodo setId_lido
   */
    @Test
    public void setIdLidoTest() {
      responsabileLido.setId_lido(7);
     int id_lido = responsabileLido.getId_lido();
      assertEquals(7, id_lido, "Sgould return 7");
    }

  /**
   * test per il metodo getId_resp_ente
   */
  @Test
  public void getId_resp_ente_Test() {
    int id = responsabileLido.getId_resp_ente();
    assertEquals(1, id, "Should return 1");
  }

  /**
   * test per il metodo setId_resp_ente
   */
  @Test
  public void setId_resp_ente_Test() {
    responsabileLido.setId_resp_ente(7);
    int id = responsabileLido.getId_resp_ente();
    assertEquals(7, id, "Sgould return 7");
  }

  /**
   * test per il metodo toString
   */
    @Test
    public void toStringTest(){
      String result = responsabileLido.toString();
      assertEquals(result, "ResponsabileLido[id=1,nome=Guido,cognome=Lavespa,email=guido.l@unisa.it,username=Gvespa]");
    }
}
