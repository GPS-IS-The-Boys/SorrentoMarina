package theboys.sorrentomarina.managers;

import org.junit.jupiter.api.Test;
import theboys.sorrentomarina.managers.managersUtente.TableResponsabileLidoManager;
import theboys.sorrentomarina.models.modelsUtente.ResponsabileLido;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author theboys
 */

public class TableResponsabileLidoManagerTest extends IntegrationTestCase{

  TableResponsabileLidoManager manager;

  /**
   * Controlla se il create crea un responsabile Lido
   */
  @Test
  public void createTest() throws SQLException {
    manager = new TableResponsabileLidoManager(mockDb);
    manager.create("Nome5", "Cognome5", "email5", "Username5", "Password5", 1, 1);
    assertNotNull(manager.retriveById(5), "Deve ritornare not null");
  }

  /**
   * Testa che il retrieveById torni un lido presente
   *
   * @throws SQLException
   */
  @Test
  public void retriveByIdTest() throws SQLException {
    manager = new TableResponsabileLidoManager(mockDb);
    ResponsabileLido responsabileLido = manager.retriveById(1);
    assertNotNull(responsabileLido, "Deve trovare il Responsabile lido");
  }

  /**
   * Testa il retriveAll controllando il numero di elementi tornati
   *
   * @throws SQLException
   */
  @Test
  public void retriveAllTest() throws SQLException {
    manager = new TableResponsabileLidoManager(mockDb);
    List<ResponsabileLido> lista = manager.retriveAll();
    assertEquals(4, lista.size(), "Deve ritornare 4");
  }

  /**
   * Testa l'update controllando che aggiorna un responsabile lido nel db
   *
   * @throws SQLException
   */
  @Test
  public void updateTest() throws SQLException {
    manager = new TableResponsabileLidoManager(mockDb);
    ResponsabileLido rl = new ResponsabileLido(1, "Carlo", "Cognome1", "Email1", "Username1", "password1",1, 1);
    manager.update(rl);
    assertEquals("Carlo", manager.retriveById(1).getNome(), "Deve tornare Carlo");
  }

  /**
   * Testa il delete di un responsabile Lido dal db
   *
   * @throws SQLException
   */
  @Test
  public void deleteTest() throws SQLException {
    manager = new TableResponsabileLidoManager(mockDb);
    manager.delete(1);
    assertNull(manager.retriveById(1), "Deve tornare null");
  }

  /**
   * Testa la ricerca di un responsabile lido avendo username e password
   */
  @Test
  public void findResponsabileLidoTest() throws SQLException {
    manager = new TableResponsabileLidoManager(mockDb);
    Optional<ResponsabileLido> responsabileLido= manager.findResponsabileLido("Username1", "password1");
    assertNotNull(responsabileLido, "Deve tornare un responsabile lido");
  }

}


