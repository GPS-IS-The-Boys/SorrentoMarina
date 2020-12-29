package theboys.sorrentomarina.managers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import theboys.sorrentomarina.models.ResponsabileEnte;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class TableResponsabileEnteManagerTest extends IntegrationTestCase {

  TableResponsabileEnteManager manager;

  /**
   * Init TableResponsabileEnteManager
   */
  @BeforeEach
  public void init() {
    manager = new TableResponsabileEnteManager(mockDb);
  }

  /**
   * Test method retriveById
   *
   * @throws SQLException
   */
  @Test
  public void retriveByIdTest() throws SQLException {
    ResponsabileEnte responsabileEnte = manager.retriveById(1);
    assertTrue(responsabileEnte != null, "It should find the Responsabile ente");
  }

  /**
   * Test method retriveAll
   *
   * @throws SQLException
   */
  @Test
  public void retriveAllTest() throws SQLException {
    List<ResponsabileEnte> lista = manager.retriveAll();
    assertTrue(lista.size() == 2, "It should return 2");
  }

  /**
   * Test method update
   *
   * @throws SQLException
   */
  @Test
  public void updateTest() throws SQLException {
    ResponsabileEnte responsabile = new ResponsabileEnte(1, "Mario", "Verdi", "m.rossi@unisa.it", "mrossi", "rossimario");
    manager.update(responsabile);
    String cognome = manager.retriveById(1).getCognome();
    assertEquals(cognome, "Verdi", "Should return Verdi");
  }

  /**
   * Test method findResponsabileEnte
   *
   * @throws SQLException
   */
  @Test
  public void findResponsabileEnteTest() throws SQLException {
    Optional<ResponsabileEnte> responsabile = manager.findResponsabileEnte("mrossi", "rossimario");
    assertTrue(responsabile.isPresent(), "Should return true if responsabile is present");
  }
}
