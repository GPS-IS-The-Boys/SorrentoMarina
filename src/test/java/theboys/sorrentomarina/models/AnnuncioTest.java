package theboys.sorrentomarina.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import theboys.sorrentomarina.models.modelsAnnuncio.Annuncio;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author theboys
 */

public class AnnuncioTest {

  private Annuncio annuncio;

  /**
   * Metodo che inizializza un annuncio
   *
   */
  @BeforeEach
  public void init() {
    annuncio= new Annuncio(1, "Riapertura", "Grande riapertura il giorno 9 Giugno", "C:\\Users\\User\\Desktop\\Uni\\IS\\foto1.jpg", 1);
  }

  /**
   * Test per il metodo getId
   *
   */
  @Test
  public void getIdTest() {
    int id = annuncio.getId();
    assertEquals(1, id, "Should return 1");
  }

  /**
   * Test per il metodo getTitolo
   *
   */
  @Test
  public void getTitoloTest() {
    String titolo = annuncio.getTitolo();
    assertEquals("Riapertura", titolo, "Should return Riapertura");
  }

  /**
   * Test per il metodo getContenuto
   *
   */
  @Test
  public void getContenutoTest() {
    String contenuto = annuncio.getContenuto();
    assertEquals("Grande riapertura il giorno 9 Giugno", contenuto, "Should return Grande riapertura il giorno 9 Giugno");
  }

  /**
   * Test per il metodo getFoto
   *
   */
  @Test
  public void getFotoTest() {
    String foto = annuncio.getFoto();
    assertEquals("C:\\Users\\User\\Desktop\\Uni\\IS\\foto1.jpg", foto, "Should return C:\\Users\\User\\Desktop\\Uni\\IS\\foto1.jpg");
  }

  /**
   * Test per il metodo getId_Lido
   *
   */
  @Test
  public void getId_LidoTest() {
    int id_lido = annuncio.getId_lido();
    assertEquals(1, id_lido, "Should return 1");
  }

  /**
   * Test per il metodo setId
   *
   */
  @Test
  public void setIdTest() {
    annuncio.setId(5);
    int id = annuncio.getId();
    assertEquals(5, id, "Should return 5");
  }

  /**
   * Test per il metodo setTitolo
   *
   */
  @Test
  public void setTitoloTest() {
    annuncio.setTitolo("Sconti");
    String titolo = annuncio.getTitolo();
    assertEquals("Sconti", titolo, "Should return Sconti");
  }

  /**
   * Test per il metodo setContenuto
   *
   */
  @Test
  public void setContenutoTest() {
    annuncio.setContenuto("Sconti la prossima settimana");
    String contenuto = annuncio.getContenuto();
    assertEquals("Sconti la prossima settimana", contenuto, "Should return Sconti la prossima settimana");
  }

  /**
   * Test per il metodo setFoto
   *
   */
  @Test
  public void setFotoTest() {
    annuncio.setFoto("C:\\Users\\User\\Desktop\\Uni\\IS\\foto2.jpg");
    String foto = annuncio.getFoto();
    assertEquals("C:\\Users\\User\\Desktop\\Uni\\IS\\foto2.jpg", foto, "Should return C:\\Users\\User\\Desktop\\Uni\\IS\\foto2.jpg");
  }

  /**
   * Test per il metodo setId_Lido
   *
   */
  @Test
  public void setId_LidoTest() {
    annuncio.setId_lido(3);
    int id_lido = annuncio.getId_lido();
    assertEquals(3, id_lido, "Should return 3");
  }

  /**
   * Test per il metodo create
   */
  @Test
  public void createTest(){
    Annuncio a = new Annuncio("asc", "adc", "acs", 1);
    assertNotNull(a);
  }

  /**
   * Test per il metodo toString
   */
  @Test
  public void toStringTest(){
    String result = annuncio.toString();
    assertEquals(result, "Annuncio[id=1,titolo=Riapertura,contenuto=Grande riapertura il giorno 9 Giugno,foto=C:\\Users\\User\\Desktop\\Uni\\IS\\foto1.jpg,id_Lido=1]");
  }
}
