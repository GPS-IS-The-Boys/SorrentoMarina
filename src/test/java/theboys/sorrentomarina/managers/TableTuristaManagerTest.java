package theboys.sorrentomarina.managers;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import theboys.sorrentomarina.managers.managersUtente.TableTuristaManager;
import theboys.sorrentomarina.models.modelsUtente.Turista;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author theboys
 */
public class TableTuristaManagerTest extends IntegrationTestCase {

  TableTuristaManager manager;

  /**
   * Testa la creazione, avvenuta tramite registrazione
   */
  @Test
  public void createTest1() throws SQLException {
    manager = new TableTuristaManager(mockDb);
    manager.create("Nome5", "Cognome5", "Email5", "Username5", "password5");
    assertNotNull(manager.retriveById(5), "Deve tornare un turista");
  }

  /**
   * Testa la creazione, avvenuta tramite alla prenotazione
   */
  @Test
  public void createTest2() throws SQLException {
    manager = new TableTuristaManager(mockDb);
    manager.create("Nome5", "Cognome5", "Email5");
    assertNotNull(manager.retriveById(5), "Deve tornare un turista");
  }

  /**
   * testa il retrievebyid
   *
   * @throws SQLException
   */
  @Test
  public void retriveByIdTest() throws SQLException {
    manager = new TableTuristaManager(mockDb);
    assertNotNull(manager.retriveById(1), "Deve tornare un turista");
  }

  /**
   * testa il retrieveAll che torna tutti i turisti
   *
   * @throws SQLException
   */
  @Test
  public void retriveAllTest() throws SQLException {
    manager = new TableTuristaManager(mockDb);
    List<Turista> lista = manager.retriveAll();
    assertEquals(6, lista.size(), "Deve tornare 6");
  }

  /**
   * Testa l'aggiornamento di un turista
   *
   * @throws SQLException
   */
  @Test
  public void updateTest() throws SQLException {
    manager = new TableTuristaManager(mockDb);
    Turista turista = manager.retriveById(1);
    turista.setNome("Nome1");
    manager.update(turista);
    assertEquals("Nome1", manager.retriveById(1).getNome(), "Deve ritornare Elio");
  }

  /**
   * Testa la cancellazione di un turista
   *
   * @throws SQLException
   */
  @Test
  public void deleteTest() throws SQLException {
    manager = new TableTuristaManager(mockDb);
    manager.delete(1);
    assertNull(manager.retriveById(1), "Deve tornare null");
  }

  /**
   * Testa se trova un turista con quelle credenziali
   *
   * @throws SQLException
   */
 /* @Test
  public void findTuristaTest() throws SQLException {
    manager = new TableTuristaManager(mockDb);
    Optional<Turista> t = manager.findTurista("Username1", "password1");
    assertNotNull(t, "Deve tornare un turista");
  }*/
}
