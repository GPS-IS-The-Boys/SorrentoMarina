package theboys.sorrentomarina.managers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import theboys.sorrentomarina.models.Ombrellone;
import theboys.sorrentomarina.models.Prenotazione;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static theboys.sorrentomarina.managers.IntegrationTestCase.mockDb;

public class TableOmbrelloneManagerTest extends IntegrationTestCase{
  TableOmbrelloneManager manager;

  @BeforeEach
  public void init(){

    manager = new TableOmbrelloneManager(mockDb);
  }

  @Test
  public void createTest() throws SQLException {
    manager.create(4,12,4);
    List<Ombrellone> lista = manager.retriveByIdPrenotazione(4);
    assertEquals(2,lista.size(),"It should create the Ombrellone");
  }

  @Test
  public void retriveByIdPrenotazioneTest() throws SQLException{
    List<Ombrellone> lista=manager.retriveByIdPrenotazione(1);
    assertEquals(1,lista.size(),"It should retrieve all Ombrelloni of a Prenotazione");
  }

  @Test
  public void retriveByIdTest() throws SQLException {
    Ombrellone ombrellone = manager.retrviveById(1);
    assertTrue(ombrellone != null,"It should find the Ombrellone");
  }



}
