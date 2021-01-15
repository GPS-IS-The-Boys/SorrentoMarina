package theboys.sorrentomarina.managers;

import org.junit.jupiter.api.Test;
import theboys.sorrentomarina.managers.managersUtente.TableResponsabileEnteManager;
import theboys.sorrentomarina.models.modelsUtente.ResponsabileEnte;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
/**
 * @author theboys
 */
public class TableResponsabileEnteManagerTest extends IntegrationTestCase {

  TableResponsabileEnteManager manager;
  /**
   * Testa che il metodo retriveById torni un responsabile ente presente
   *
   * @throws SQLException
   */
  @Test
  public void retriveByIdTest() throws SQLException {
    manager = new TableResponsabileEnteManager(mockDb);
    ResponsabileEnte responsabileEnte = manager.retriveById(1);
    assertNotNull(responsabileEnte, "It should find the Responsabile ente");
  }

  /**
   * Testa che il metodo retriveAll torni una lista di responsabli ente
   *
   * @throws SQLException
   */
  @Test
  public void retriveAllTest() throws SQLException {
    manager = new TableResponsabileEnteManager(mockDb);
    List<ResponsabileEnte> lista = manager.retriveAll();
    assertEquals( 4, lista.size(), "It should return 4");
  }

  /**
   * Testa che il metodo update effetui una modifica ad un responsabile ente
   *
   * @throws SQLException
   */
  @Test
  public void updateTest() throws SQLException {
    manager = new TableResponsabileEnteManager(mockDb);
    ResponsabileEnte responsabile = new ResponsabileEnte(1, "Mario", "Verdi", "m.rossi@unisa.it", "mrossi", "rossimario");
    manager.update(responsabile);
    String cognome = manager.retriveById(1).getCognome();
    assertEquals(cognome, "Verdi", "Should return Verdi");
  }

  /**
   * Testa che il metodo findResponsabileEnte effettui una ricerca avendo username e password
   *
   * @throws SQLException
   */
  @Test
  public void findResponsabileEnteTest() throws SQLException {
    manager = new TableResponsabileEnteManager(mockDb);
    Optional<ResponsabileEnte> responsabile = manager.findResponsabileEnte("Nome1", "password1");
    assertNotNull(responsabile, "Should return true if responsabile is present");
  }
}
