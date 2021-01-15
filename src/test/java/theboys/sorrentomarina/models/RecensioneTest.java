package theboys.sorrentomarina.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import theboys.sorrentomarina.models.modelsRecensione.Recensione;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author theboys
 */

public class RecensioneTest {

  private Recensione recensione;

  /**
   * Metodo che inizializza una recensione
   *
   */
  @BeforeEach
  public void init() {
    recensione= new Recensione(1, 3, "Struttura sufficiente", 1, 1);
  }

  /**
   * Test per il metodo getId
   *
   */
  @Test
  public void getIdTest() {
    int id = recensione.getId();
    assertEquals(1, id, "Should return 1");
  }

  /**
   * Test per il metodo getGiudizio
   *
   */
  @Test
  public void getGiudizioTest() {
    int giudizio = recensione.getGiudizio();
    assertEquals(3, giudizio, "Should return 3");
  }

  /**
   * Test per il metodo getContenuto
   *
   */
  @Test
  public void getContenutoTest() {
    String contenuto = recensione.getContenuto();
    assertEquals("Struttura sufficiente", contenuto, "Should return Struttura sufficiente");
  }

  /**
   * Test per il metodo getId_Lido
   *
   */
  @Test
  public void getId_LidoTest() {
    int id_lido = recensione.getId_lido();
    assertEquals(1, id_lido, "Should return 1");
  }

  /**
   * Test per il metodo getId_Turista
   *
   */
  @Test
  public void getId_TuristaTest() {
    int id_turista = recensione.getId_turista();
    assertEquals(1, id_turista, "Should return 1");
  }

  /**
   * Test per il metodo setId
   *
   */
  @Test
  public void setIdTest() {
    recensione.setId(5);
    int id = recensione.getId();
    assertEquals(5, id, "Should return 5");
  }

  /**
   * Test per il metodo setGiudizio
   *
   */
  @Test
  public void setGiudizioTest() {
    recensione.setGiudizio(4);
    int giudizio = recensione.getGiudizio();
    assertEquals(4, giudizio, "Should return 4");
  }

  /**
   * Test per il metodo setContenuto
   *
   */
  @Test
  public void setContenutoTest() {
    recensione.setContenuto("Struttura molto attrezzata");
    String contenuto = recensione.getContenuto();
    assertEquals("Struttura molto attrezzata", contenuto, "Should return Struttura molto attrezzata");
  }

  /**
   * Test per il metodo setId_Lido
   *
   */
  @Test
  public void setId_LidoTest() {
    recensione.setId_lido(3);
    int id_lido = recensione.getId_lido();
    assertEquals(3, id_lido, "Should return 3");
  }

  /**
   * Test per il metodo setId_Turista
   *
   */
  @Test
  public void setId_TuristaTest() {
    recensione.setId_lido(2);
    int id_turista = recensione.getId_lido();
    assertEquals(2, id_turista, "Should return 2");
  }

  /**
   * test per il metodo create
   */
  @Test
  public void createTest(){
    Recensione r = new Recensione(1, "abc", 1, 1);
    assertNotNull(r);
  }

  /**
   * test per il metodo toString
   */
  @Test
  public void toStringTest(){
    String result = recensione.toString();
    assertEquals(result, "Recensione[id=1,giudizio=3,contenuto=Struttura sufficiente,id_lido=1,id_turista=1]");
  }
}
