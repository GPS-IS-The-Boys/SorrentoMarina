package theboys.sorrentomarina.managers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import theboys.sorrentomarina.models.Servizio;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.SQLException;

public class TableServizioManagerTest extends IntegrationTestCase{

  TableServizioManager manager;

  @BeforeEach
  public void init(){
    manager = new TableServizioManager(mockDb);
  }

  @Test
  public void createTest() throws SQLException {
    manager.create(3,true, false,true,false,true,false,false);
    Servizio servizio = manager.retriveById(3);
    assertTrue(servizio != null,"Should return true if create Servizio");
  }

  @Test
  public void retriveByIdTest() throws SQLException {
    Servizio servizio = manager.retriveById(1);
    assertTrue(servizio != null,"Should return true if return Servizio 1");
  }

  @Test
  public void updateTest() throws SQLException {
    Servizio servizio = manager.retriveById(2);
    servizio.setCabina(false);
    assertTrue(servizio.isCabina() == false,"Should return true if update Servizio");
  }

  @Test
  public void deleteTest() throws SQLException {
    manager.delete(1);
    Servizio servizio= manager.retriveById(1);
    assertTrue(servizio == null,"Should return true if delete Servizio");
  }
}
