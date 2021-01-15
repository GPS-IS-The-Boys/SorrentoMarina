package theboys.sorrentomarina.managers;

import org.junit.jupiter.api.Test;
import theboys.sorrentomarina.managers.managersAnnuncio.TableAnnuncioManager;
import theboys.sorrentomarina.models.modelsAnnuncio.Annuncio;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;

/**
 * @author theboys
 */

public class TableAnnuncioManagerTest extends IntegrationTestCase {

  TableAnnuncioManager manager;

  /**
   * Metodo che testa il create inserendo un annuncio nel database
   * e poi verificando che esso sia presente
   */
  @Test
  public void createTest() throws SQLException {
    manager = new TableAnnuncioManager(mockDb);
    manager.create("TitoloTest", "ContenutoTest", "Fototest", 1);
    Annuncio annuncio = manager.retriveById(5);
    assertNotNull(annuncio, "It should find the Annuncio");
  }

  /**
   * Metodo che testa il retriveById verificando che
   * uno specifico annuncio sia presente nel database
   */
  @Test
  public void retriveByIdTest() throws SQLException {
    manager = new TableAnnuncioManager(mockDb);
    Annuncio annuncio = manager.retriveById(1);
    assertNotNull(annuncio, "It should find the Annuncio");
  }

  /**
   * Metodo che testa il retriveById_Lido verificando che
   * la lista contenga il giusto numero di elementi
   */
  @Test
  public void retriveById_LidoTest() throws SQLException {
    manager = new TableAnnuncioManager(mockDb);
    List<Annuncio> lista = manager.retriveById_Lido(1);
    assertEquals(lista.size(), 2, "It should return a list of length 2");
  }

  /**
   * Metodo che testa il retriveAll verificando che
   * la lista contenga il giusto numero di elementi
   */
  @Test
  public void retriveAllTest() throws SQLException {
    manager = new TableAnnuncioManager(mockDb);
    List<Annuncio> lista = manager.retriveAll();
    assertEquals(3, lista.size(), "It should return a list of length 3");
  }

  /**
   * Metodo che testa l'update verificando che
   * l'annuncio è stato modificato correttamente
   */
  @Test
  public void updateTest() throws SQLException {
    manager = new TableAnnuncioManager(mockDb);
    Annuncio annuncio = new Annuncio(1, "titolo", "contenuto", "foto", 1);
    annuncio.setId_lido(3);
    manager.update(annuncio);
    annuncio = manager.retriveById(1);
    assertEquals(1, annuncio.getId_lido(), "It should return the same Annuncio");
  }

  /**
   * Metodo che testa il delete verificando che
   * l'annuncio eliminato non sia presente nel database
   */
  @Test
  public void deleteTest() throws SQLException {
    manager = new TableAnnuncioManager(mockDb);
    manager.delete(1);
    assertNull(manager.retriveById(1), "It should return null");
  }

  /**
   * Metodo che testa il deleteById_Lido verificando che
   * gli annunci eliminati non siano presenti nel database
   */
  @Test
  public void deleteTestById_Lido() throws SQLException {
    manager = new TableAnnuncioManager(mockDb);
    manager.deleteById_Lido(2);
    assertEquals(manager.retriveById_Lido(2).size(), 0, "It should return an empty list");
  }

}
