package theboys.sorrentomarina.managers;
import org.junit.jupiter.api.Test;
import theboys.sorrentomarina.models.Lido;
import theboys.sorrentomarina.models.Prenotazione;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TablePrenotazioneManagerTest extends IntegrationTestCase{
  TablePrenotazioneManager manager ;

  /**
   * Controlla se il retrieveById torna la prenotazione corretta
   * @throws SQLException
   */
  @Test
  public void retriveByIdTest() throws SQLException {
    manager = new TablePrenotazioneManager(mockDb);
    Prenotazione prenotazione = manager.retriveById(1);
    assertNotNull(prenotazione,"It should find the Prenotazione");
  }

  /**
   * Controlla se la create rende persistente una prenotazione
   * @throws SQLException
   */
  @Test
  public void createTest() throws SQLException {
    manager = new TablePrenotazioneManager(mockDb);
    manager.create(5,"2020-06-12","2020-06-14",2,30,1,1);
    Prenotazione prenotazione = manager.retriveById(5);
    assertNotNull(prenotazione,"It should create the Prenotazione");
  }

  /**
   * controlla se il numero delle prenotazioni trovate coincide
   * con quelle presenti nel db
   * @throws SQLException
   */
  @Test
  public void retriveAllTest() throws SQLException {
    manager = new TablePrenotazioneManager(mockDb);
    List<Prenotazione> list = manager.retriveAll();
    assertEquals(4,list.size(),"It should retrive all Prenotazioni");
  }

  /**
   * controlla se il lido viene aggiornato nel db
   * @throws SQLException
   */
  @Test
  public void updateTest() throws SQLException {
    manager = new TablePrenotazioneManager(mockDb);
    Prenotazione prenotazione = new Prenotazione(1,"2020-06-09","2020-06-09",2,30,1,1);
    prenotazione.setNum_posti(10);
    manager.update(prenotazione);
    prenotazione = manager.retriveById(1);
    assertEquals(10,prenotazione.getNum_posti(),"It should update");
  }

  /**
   * Controlla se il lido viene cancellato dal db
   * @throws SQLException
   */
  @Test
  public void deleteTest() throws SQLException {
    manager = new TablePrenotazioneManager(mockDb);
    manager.delete(1);
    Prenotazione prenotazione = manager.retriveById(1);
    assertNull(prenotazione,"It should delete Prenotazione");
  }

  /**
   * Controlla che il numero di prenotazioni totali sia uguale a quello ritornato
   */
  @Test
  public void prenotazioniTotaliTest() throws SQLException {
    manager = new TablePrenotazioneManager(mockDb);
    int prenotazioniTotali = manager.prenotazioniTotali();
    assertEquals(4,prenotazioniTotali,"It should return 1");
  }

  /**
   * Controlla che il totale del consorzio e la somma di tutti gli incassi
   * derivati dalle prenotazioni siano uguali
   */
  @Test
  public void incassoConsorzio() throws SQLException {
    manager = new TablePrenotazioneManager(mockDb);
    float incassoConsorzio = manager.incassoConsorzio();
    assertEquals(120,incassoConsorzio,"It should return 240");
  }

  /**
   * Controlla l'incasso totale del lido passato
   * @throws SQLException
   */
  @Test
  public void incassoLidoTotaleTest() throws SQLException {
    manager = new TablePrenotazioneManager(mockDb);
    float incassoTotale = manager.incassoLidoTotale(1);
    assertEquals(30, incassoTotale, "It should return 60");
  }

  /**
   * Controlla se l'incasso tra due date corrisponde
   * @throws SQLException
   */
  @Test
  public void incassoLidoDaATest() throws SQLException {
    manager = new TablePrenotazioneManager(mockDb);
    float incassoTotale = manager.incassoLidoDa_A(1, "2020-06-09", "2020-06-09");
    assertEquals(30, incassoTotale, "It should return 60");
  }

  /**
   * Controlla se gli ombrelloni disponibili per un certo periodo corrispondono
   * @throws SQLException
   */
  @Test
  public void ombrelloniDisponibiliTest() throws SQLException {
    manager = new TablePrenotazioneManager(mockDb);
    Lido lido = new Lido(1, "Nome1", "Indirizzo1", "Telefono1", "email1", "logo1", 12.5F, 4, 5, 1);
    int ombDisp = manager.ombrelloniDisponibili("2020-06-09", "2020-06-09", lido);
    assertEquals(19, ombDisp, "It should return 18");
  }
}
