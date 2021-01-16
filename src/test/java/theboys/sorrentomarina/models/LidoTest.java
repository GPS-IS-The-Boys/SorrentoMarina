package theboys.sorrentomarina.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import theboys.sorrentomarina.models.modelsLido.Lido;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * @author theboys
 */
public class LidoTest {

  private Lido lido;

  /**
   * Metodo che inizializza un lido
   *
   */
  @BeforeEach
  public void init() {
    lido = new Lido(1, "Marinella", "Via Colombo", "082743123", "marinella@tiscali.it", "logo/logo", 10.5F, 2, 2, 1,1);
  }

  /**
   * test per il metodo getId
   */
  @Test
  public void getIdTest(){
    int id = lido.getId();
    assertEquals(1, id, "Should return 1");
  }

  /**
   * test per il metodo getNome
   */
  @Test
  public void getNomeTest(){
    String nome = lido.getNome();
    assertEquals("Marinella", nome, "Should return Marinella");
  }

  /**
   * test per il metodo getIndirizzo
   */
  @Test
  public void getIndirizzoTest(){
    String ind = lido.getIndirizzo();
    assertEquals("Via Colombo", ind, "Should return Via Colombo");
  }

  /**
   * test per il metodo getTelefono
   */
  @Test
  public void getTelefonoTest(){
    String tel = lido.getTelefono();
    assertEquals("082743123", tel, "Should return 082743123");
  }

  /**
   * test per il metodo getEmail
   */
  @Test
  public void getEmailTest(){
    String em = lido.getEmail();
    assertEquals("marinella@tiscali.it", em, "Should return marinella@tiscali.it");
  }

  /**
   * test per il metodo getLogo
   */
  @Test
  public void getLogoTest(){
    String logo = lido.getLogo();
    assertEquals("logo/logo", logo, "Should return logo/logo");
  }

  /**
   * test per il metodo getPrezzo_singolo
   */
  @Test
  public void getPrezzo_singoloTest(){
    Float val = lido.getPrezzo_singolo();
    assertEquals(10.5F, val, "Should return 10.5");
  }

  /**
   * test per il metodo getNum_righe
   */
  @Test
  public void getNum_righeTest(){
    int a = lido.getNum_righe();
    assertEquals(2, a, "Should return 2");
  }

  /**
   * test per il metodo getNum_colonne
   */
  @Test
  public void getNum_colonneTest(){
    int a = lido.getNum_colonne();
    assertEquals(2, a, "Should return 2");
  }

  /**
   * test per il metodo getId_servizi
   */
  @Test
  public void getId_serviziTest(){
    int a = lido.getId_servizi();
    assertEquals(1, a, "Should return 1");
  }

  /**
   * test per il metodo setId
   */
  @Test
  public void setIdTest(){
    lido.setId(7);
    int id = lido.getId();
    assertEquals(7, id, "Should return 7");
  }

  /**
   * test per il metodo setNome
   */
  @Test
  public void setNomeTest(){
    lido.setNome("Antonio");
    String nome = lido.getNome();
    assertEquals("Antonio", nome, "Should return Antonio");
  }

  /**
   * test per il metodo setIndirizzo
   */
  @Test
  public void setIndirizzoTest(){
    lido.setIndirizzo("Via Mario");
    String em = lido.getIndirizzo();
    assertEquals("Via Mario", em, "Should return Via Mario");
  }

  /**
   * test per il metodo setTelefono
   */
  @Test
  public void setTelefonoTest(){
    lido.setTelefono("081923000");
    String tel = lido.getTelefono();
    assertEquals("081923000", tel, "Should return 081923000");
  }

  /**
   * test per il metodo setEmail
   */
  @Test
  public void setEmailTest(){
    lido.setEmail("antonio@gmail.com");
    String em = lido.getEmail();
    assertEquals("antonio@gmail.com", em, "Should return antonio@gmail.com");
  }

  /**
   * test per il metodo setLogo
   */
  @Test
  public void setLogoTest(){
    lido.setLogo("logo/mario");
    String nome = lido.getLogo();
    assertEquals("logo/mario", nome, "Should return logo/mario");
  }

  /**
   * test per il metodo setPrezzo_singol
   */
  @Test
  public void setPrezzo_singoloTest(){
    lido.setPrezzo_singolo(8.0F);
    Float val = lido.getPrezzo_singolo();
    assertEquals(8.0F, val, "Should return 8.0F");
  }

  /**
   * test per il metodo setNum_righe
   */
  @Test
  public void setNum_righeTest(){
    lido.setNum_righe(6);
    int val = lido.getNum_righe();
    assertEquals(6, val, "Should return 6");
  }

  /**
   * test per il metodo setNum_colonne
   */
  @Test
  public void setNum_colonneTest(){
    lido.setNum_colonne(6);
    int val = lido.getNum_colonne();
    assertEquals(6, val, "Should return 6");
  }

  /**
   * test per il metodo setId_servizi
   */
  @Test
  public void setId_serviziTest(){
    lido.setId_servizi(6);
    int val = lido.getId_servizi();
    assertEquals(6, val, "Should return 6");
  }

  /**
   * test per il metodo setId_servizi
   */
  @Test
  public void setId_resp_ente_Test(){
    lido.setId_resp_ente(2);
    int val = lido.getId_resp_ente();
    assertEquals(2, val, "Should return 6");
  }

  /**
   * test per il metodo setId_servizi
   */
  @Test
  public void getId_resp_ente_Test(){
    int val = lido.getId_resp_ente();
    assertEquals(1, val, "Should return 6");
  }

  /**
   * test per il metodo toString
   */
  @Test
  public void toStringTest(){
    String result = lido.toString();
    assertEquals(result, "Lido[id=1, nome=Marinella, indirizzo=Via Colombo, telefono=082743123, email=marinella@tiscali.it, prezzo_singolo=10.5]");
  }
}
