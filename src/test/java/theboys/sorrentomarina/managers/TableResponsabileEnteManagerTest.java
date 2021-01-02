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
   * Test method retriveById
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
   * Test method retriveAll
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
   * Test method update
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
   * Test method findResponsabileEnte
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
