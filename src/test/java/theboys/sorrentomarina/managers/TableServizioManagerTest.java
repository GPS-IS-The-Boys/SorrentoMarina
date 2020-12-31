package theboys.sorrentomarina.managers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import theboys.sorrentomarina.models.Servizio;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.SQLException;

public class TableServizioManagerTest extends IntegrationTestCase{

  TableServizioManager manager;

  /**
   * Testa la creazione di un nuovo servizio
   * @throws SQLException
   */
  @Test
  public void createTest() throws SQLException {
    manager = new TableServizioManager(mockDb);
    manager.create(5, false,true,false,true,false,false, true);
    Servizio servizio = manager.retriveById(5);
    assertNotNull(servizio,"Should return true if create Servizio");
  }

  /**
   * Testa se ritorna un servizio
   * @throws SQLException
   */
  @Test
  public void retriveByIdTest() throws SQLException {
    manager = new TableServizioManager(mockDb);
    Servizio servizio = manager.retriveById(1);
    assertNotNull(servizio,"Should return true if return Servizio 1");
  }

  /**
   * Controlla se viene aggiornato il servizio
   * @throws SQLException
   */
  @Test
  public void updateTest() throws SQLException {
    manager = new TableServizioManager(mockDb);
    Servizio servizio = manager.retriveById(2);
    servizio.setCabina(false);
    manager.update(servizio);
    servizio = manager.retriveById(2);
    assertEquals(false, servizio.isCabina() ,"Should return true if update Servizio");
  }

  /**
   * controlla se il servizio viene cancellato
   * @throws SQLException
   */
  @Test
  public void deleteTest() throws SQLException {
    manager = new TableServizioManager(mockDb);
    manager.delete(1);
    Servizio servizio= manager.retriveById(1);
    assertNull(servizio,"Should return true if delete Servizio");
  }
}
