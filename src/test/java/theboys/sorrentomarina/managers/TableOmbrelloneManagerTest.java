package theboys.sorrentomarina.managers;

import org.junit.jupiter.api.Test;
import theboys.sorrentomarina.managers.managersPrenotazione.TableOmbrelloneManager;
import theboys.sorrentomarina.models.modelsPrenotazione.Ombrellone;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author theboys
 */
public class TableOmbrelloneManagerTest extends IntegrationTestCase{
  TableOmbrelloneManager manager;

  /**
   * testa che venga creato un ombrellone
   * @throws SQLException
   */
  @Test
  public void createTest() throws SQLException {
    manager = new TableOmbrelloneManager(mockDb);
    manager.create(4,12,4);
    List<Ombrellone> lista = manager.retriveByIdPrenotazione(4);
    assertEquals(2,lista.size(),"It should create the Ombrellone");
  }

  /**
   * Testa che retruveByIdPrenotazione ritorni tutti gli ombrelloni associati ad una prenotazione
   * @throws SQLException
   */
  @Test
  public void retriveByIdPrenotazioneTest() throws SQLException{
    manager = new TableOmbrelloneManager(mockDb);
    List<Ombrellone> lista=manager.retriveByIdPrenotazione(1);
    assertEquals(1,lista.size(),"It should retrieve all Ombrelloni of a Prenotazione");
  }

  /**
   * Testa che un ombrellone sia presente nel database
   * @throws SQLException
   */
  @Test
  public void retriveByIdTest() throws SQLException {
    manager = new TableOmbrelloneManager(mockDb);
    Ombrellone ombrellone = manager.retrviveById(1);
    assertNotNull(ombrellone,"It should find the Ombrellone");
  }



}
