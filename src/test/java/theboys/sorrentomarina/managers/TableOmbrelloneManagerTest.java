package theboys.sorrentomarina.managers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import theboys.sorrentomarina.models.Ombrellone;
import theboys.sorrentomarina.models.Prenotazione;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static theboys.sorrentomarina.managers.IntegrationTestCase.mockDb;

public class TableOmbrelloneManagerTest extends IntegrationTestCase{
  TableOmbrelloneManager manager;


  @Test
  public void createTest() throws SQLException {
    manager = new TableOmbrelloneManager(mockDb);
    manager.create(4,12,4);
    List<Ombrellone> lista = manager.retriveByIdPrenotazione(4);
    assertEquals(2,lista.size(),"It should create the Ombrellone");
  }

  @Test
  public void retriveByIdPrenotazioneTest() throws SQLException{
    manager = new TableOmbrelloneManager(mockDb);
    List<Ombrellone> lista=manager.retriveByIdPrenotazione(1);
    assertEquals(1,lista.size(),"It should retrieve all Ombrelloni of a Prenotazione");
  }

  @Test
  public void retriveByIdTest() throws SQLException {
    manager = new TableOmbrelloneManager(mockDb);
    Ombrellone ombrellone = manager.retrviveById(1);
    assertNotNull(ombrellone,"It should find the Ombrellone");
  }



}
