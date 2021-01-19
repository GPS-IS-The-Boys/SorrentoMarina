package theboys.sorrentomarina.managers;

import org.junit.jupiter.api.Test;
import theboys.sorrentomarina.managers.managersLido.TableLidoManager;
import theboys.sorrentomarina.models.modelsLido.Lido;
import theboys.sorrentomarina.models.modelsLido.Servizio;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;

/**
 * @author theboys
 */
public class TableLidoManagerTest extends IntegrationTestCase {

  TableLidoManager manager;

  /**
   * Testa il create inserendo un lido nel database e verificando che
   * sia effettivamente presente
   */
  @Test
  public void createTest() throws SQLException {
    manager = new TableLidoManager(mockDb);
    manager.create("Nome5", "Indirizzo5", "Telefono5", "email5", "logo5", 12.5F, 4, 5, 1, 1);
    Lido lido = manager.retriveById(5);
    assertNotNull(lido, "Deve trovare il lido appena inserito");
  }

  /**
   * Metodo che testa il retriveById verificando che
   * uno specifico lido sia presente nel database
   */
  @Test
  public void retriveByIdTest() throws SQLException {
    manager = new TableLidoManager(mockDb);
    Lido lido = manager.retriveById(1);
    assertNotNull(lido, "Deve trovare il lido");
  }

  /**
   * Testa se il retrieveByName ritorna il nome corretto dal db
   */
  @Test
  public void retriveByNameTest() throws SQLException {
    manager = new TableLidoManager(mockDb);
    List<Lido> lido = manager.retriveByName("Nome1");
    assertEquals(1, lido.size(), "Il nome trovare deve coincidere con quello cercato");
  }

  /**
   * Testa che il numero di lidi con determinati servizi sia corretto
   */
  @Test
  public void retriveByServiziTest1() throws SQLException {
    manager = new TableLidoManager(mockDb);
    Servizio servizio = new Servizio(true, true, true, true, true, true, true);
    List<Lido> lidi = manager.retriveByServizi(servizio);
    assertEquals(0, lidi.size(), "Il numero di lidi che offrono i seguenti servizi");
  }

  /**
   * Testa che il numero di lidi con determinati servizi sia corretto
   */
  @Test
  public void retriveByServiziTest2() throws SQLException {
    manager = new TableLidoManager(mockDb);
    Servizio servizio = new Servizio(false, false, false, false, false, false, true);
    List<Lido> lidi = manager.retriveByServizi(servizio);
    assertEquals(4, lidi.size(), "Il numero di lidi che offrono i seguenti servizi");
  }

  /**
   * Testa che il numero di lidi con determinati servizi sia corretto
   */
  @Test
  public void retriveByServiziTest3() throws SQLException {
    manager = new TableLidoManager(mockDb);
    Servizio servizio = new Servizio(false, false, false, false, false, true, false);
    List<Lido> lidi = manager.retriveByServizi(servizio);
    assertEquals(0, lidi.size(), "Il numero di lidi che offrono i seguenti servizi");
  }

  /**
   * Testa che il numero di lidi con determinati servizi sia corretto
   */
  @Test
  public void retriveByServiziTest4() throws SQLException {
    manager = new TableLidoManager(mockDb);
    Servizio servizio = new Servizio(false, false, false, false, true, false, false);
    List<Lido> lidi = manager.retriveByServizi(servizio);
    assertEquals(3, lidi.size(), "Il numero di lidi che offrono i seguenti servizi");
  }

  /**
   * Testa che il numero di lidi con determinati servizi sia corretto
   */
  @Test
  public void retriveByServiziTest5() throws SQLException {
    manager = new TableLidoManager(mockDb);
    Servizio servizio = new Servizio(false, false, false, true, false, false, false);
    List<Lido> lidi = manager.retriveByServizi(servizio);
    assertEquals(3, lidi.size(), "Il numero di lidi che offrono i seguenti servizi");
  }

  /**
   * Testa che il numero di lidi con determinati servizi sia corretto
   */
  @Test
  public void retriveByServiziTest6() throws SQLException {
    manager = new TableLidoManager(mockDb);
    Servizio servizio = new Servizio(false, false, true, false, false, false, false);
    List<Lido> lidi = manager.retriveByServizi(servizio);
    assertEquals(3, lidi.size(), "Il numero di lidi che offrono i seguenti servizi");
  }

  /**
   * Testa che il numero di lidi con determinati servizi sia corretto
   */
  @Test
  public void retriveByServiziTest7() throws SQLException {
    manager = new TableLidoManager(mockDb);
    Servizio servizio = new Servizio(false, true, false, false, false, false, false);
    List<Lido> lidi = manager.retriveByServizi(servizio);
    assertEquals(1, lidi.size(), "Il numero di lidi che offrono i seguenti servizi");
  }

  /**
   * Testa che il numero di lidi con determinati servizi sia corretto
   */
  @Test
  public void retriveByServiziTest8() throws SQLException {
    manager = new TableLidoManager(mockDb);
    Servizio servizio = new Servizio(true, false, false, false, false, false, false);
    List<Lido> lidi = manager.retriveByServizi(servizio);
    assertEquals(2, lidi.size(), "Il numero di lidi che offrono i seguenti servizi");
  }

  /**
   * Metodo che testa il retriveAll verificando che
   * la lista contenga il giusto numero di elementi
   */
  @Test
  public void retriveAllTest() throws SQLException {
    manager = new TableLidoManager(mockDb);
    List<Lido> lista = manager.retriveAll();
    assertEquals(lista.size(), 4, "Deve tornare 4 elementi nella lista");
  }

  /**
   * Metodo che testa l'update verificando che
   * il lido sia stato modificato correttamente
   */
  @Test
  public void updateTest() throws SQLException {
    manager = new TableLidoManager(mockDb);
    Lido lido = new Lido(1, "Nome1", "Indirizzo1", "Telefono1", "email1", "logo1", 12.5F, 4, 5, 1, 1);
    lido.setNome("Test1");
    manager.update(lido);
    lido = manager.retriveById(1);
    assertEquals("Test1", lido.getNome(), "Deve tornare il nome modificato");
  }

  /**
   * Metodo che testa il delete verificando che
   * l'annuncio eliminato non sia presente nel database
   */
  @Test
  public void deleteTest() throws SQLException {
    manager = new TableLidoManager(mockDb);
    manager.delete(1);
    assertNull(manager.retriveById(1), "Deve tornare null");
  }

  /**
   * Testa il getNumRighe verificando che ritorni il corretto numero
   * di righe
   *
   * @throws SQLException
   */
  @Test
  public void getNumRigheTest() throws SQLException {
    manager = new TableLidoManager(mockDb);
    int numRighe = manager.getNumRighe(1);
    assertEquals(4, numRighe, "Deve restituire il corretto numero di righe");
  }

  /**
   * Testa il getNumColonne verificando che ritorni il corretto
   * numero di colonne
   *
   * @throws SQLException
   */
  @Test
  public void getNumColonneTest() throws SQLException {
    manager = new TableLidoManager(mockDb);
    int numColonne = manager.getNumColonne(1);
    assertEquals(5, numColonne, "Deve restituire il corretto numero di colonne");
  }

}