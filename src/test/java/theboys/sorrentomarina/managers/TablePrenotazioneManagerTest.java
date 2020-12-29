package theboys.sorrentomarina.managers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import theboys.sorrentomarina.models.Prenotazione;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TablePrenotazioneManagerTest extends IntegrationTestCase{
  TablePrenotazioneManager manager ;

  @BeforeEach
  public void init(){ manager = new TablePrenotazioneManager(mockDb); }

  @Test
  public void retriveByIdTest() throws SQLException {
    Prenotazione prenotazione = manager.retriveById(1);
    assertTrue(prenotazione != null,"It should find the Prenotazione");
  }

  @Test
  public void createTest() throws SQLException {
    manager.create(2,"2020-06-12","2020-06-14",2,30,1,1);
    Prenotazione prenotazione = manager.retriveById(2);
    assertTrue(prenotazione != null,"It should create the Prenotazione");
  }

  @Test
  public void retriveAllTest() throws SQLException {
    List<Prenotazione> list = manager.retriveAll();
    assertEquals(1,list.size(),"It should retrive all Prenotazioni");
  }

  @Test
  public void updateTest() throws SQLException {
    Prenotazione prenotazione = new Prenotazione(1,"2020-06-12","2020-06-14",2,30,1,1);
    prenotazione.setNum_posti(1);
    manager.update(prenotazione);
    prenotazione = manager.retriveById(1);
    assertEquals(1,prenotazione.getNum_posti(),"It should update");
  }

  @Test
  public void deleteTest() throws SQLException {
    manager.delete(1);
    Prenotazione prenotazione = manager.retriveById(1);
    assertEquals(null,prenotazione,"It should delete Prenotazione");
  }

  @Test
  public void prenotazioniTotaliTest() throws SQLException {
    int prenotazioniTotali = manager.prenotazioniTotali();
    assertEquals(1,prenotazioniTotali,"It should return 1");
  }

  @Test
  public void incassoConsorzio() throws SQLException {
    float incassoConsorzio = manager.incassoConsorzio();
    assertEquals(23,incassoConsorzio,"It should return ");
  }
}
