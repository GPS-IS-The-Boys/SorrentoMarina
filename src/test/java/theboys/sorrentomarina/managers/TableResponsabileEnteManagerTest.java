package theboys.sorrentomarina.managers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import theboys.sorrentomarina.models.ResponsabileEnte;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

public class TableResponsabileEnteManagerTest extends IntegrationTestCase {

  TableResponsabileEnteManager manager;

  @BeforeEach
  public void init(){
    manager = new TableResponsabileEnteManager(mockDb);
  }

  @Test
  public void retriveByIdTest() throws SQLException {
    ResponsabileEnte responsabileEnte = manager.retriveById(1);
    assertTrue(responsabileEnte != null, "It should find the Responsabile ente");
  }


}
