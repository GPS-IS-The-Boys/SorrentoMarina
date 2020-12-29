package theboys.sorrentomarina.managers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import theboys.sorrentomarina.models.ResponsabileEnte;
import theboys.sorrentomarina.models.ResponsabileLido;

import javax.sql.DataSource;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static theboys.sorrentomarina.managers.IntegrationTestCase.mockDb;

public class TableResponsabileLidoManagerTest {

  TableResponsabileLidoManager manager;

  @BeforeEach
  public void init(){

    manager = new TableResponsabileLidoManager(mockDb);
  }

  @Test
  public void retriveByIdTest() throws SQLException {
    ResponsabileLido responsabileLido = manager.retriveById(7);
    assertTrue(responsabileLido != null, "It should find the Responsabile lido");
  }


}


