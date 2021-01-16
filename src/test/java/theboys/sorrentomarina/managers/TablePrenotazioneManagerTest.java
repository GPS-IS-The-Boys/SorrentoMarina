package theboys.sorrentomarina.managers;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import theboys.sorrentomarina.managers.managersPrenotazione.TablePrenotazioneManager;
import theboys.sorrentomarina.models.modelsLido.Lido;
import theboys.sorrentomarina.models.modelsPrenotazione.Ombrellone;
import theboys.sorrentomarina.models.modelsPrenotazione.Prenotazione;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
/**
 * @author theboys
 */

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
   * controlla se il numero delle prenotazioni trovate coincide
   * con quelle presenti nel db
   * @throws SQLException
   */
  @Test
  public void retriveByIdLidoTest() throws SQLException {
    manager = new TablePrenotazioneManager(mockDb);
    List<Prenotazione> prenotazioni = manager.retriveByIdLido(1);
    assertNotNull(prenotazioni,"It should retrive all Prenotazioni by lido");
  }

  /**
   * Controlla se la create rende persistente una prenotazione
   * @throws SQLException
   */
  @Test
  public void createTest1() throws SQLException {
    manager = new TablePrenotazioneManager(mockDb);
    manager.create(5,"2020-06-12","2020-06-14",2,30,"AB1234",1,1);
    Prenotazione prenotazione = manager.retriveById(5);
    assertNotNull(prenotazione,"It should create the Prenotazione");
  }

  /**
   * Controlla se la create rende persistente una prenotazione
   * @throws SQLException
   */
  @Test
  public void createTest2() throws SQLException {
    manager = new TablePrenotazioneManager(mockDb);
    manager.create("2020-06-12","2020-06-14",2,30,"AB1234",1,1);
    Prenotazione prenotazione = manager.retriveById(6);
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
    assertEquals(6,list.size(),"It should retrive all Prenotazioni");
  }

  /**
   * controlla se il lido viene aggiornato nel db
   * @throws SQLException
   */
  @Test
  public void updateTest() throws SQLException {
    manager = new TablePrenotazioneManager(mockDb);
    Prenotazione prenotazione = new Prenotazione(1,"2020-06-09","2020-06-09",2,30,"AB1234",1,1);
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
   * Controlla Se il numero di prenotazioni totali è uguale a quello ritornato
   * @throws SQLException
   */
  @Test
  public void prenotazioniTotaliTest() throws SQLException {
    manager = new TablePrenotazioneManager(mockDb);
    int prenotazioniTotali = manager.prenotazioniTotali();
    assertEquals(6,prenotazioniTotali,"It should return 6");
  }

  /**
   * Controlla se il totale del consorzio è la somma di tutti gli incassi
   * derivati dalle prenotazioni
   * @throws SQLException
   */
  @Test
  public void incassoConsorzio() throws SQLException {
    manager = new TablePrenotazioneManager(mockDb);
    float incassoConsorzio = manager.incassoConsorzio();
    assertEquals(150,incassoConsorzio,"It should return 150");
  }

  /**
   * Controlla l'incasso totale del lido passato
   * @throws SQLException
   */
  @Test
  public void incassoLidoTotaleTest() throws SQLException {
    manager = new TablePrenotazioneManager(mockDb);
    float incassoTotale = manager.incassoLidoTotale(1);
    assertEquals(90, incassoTotale, "It should return 90");
  }

  /**
   * Controlla se l'incasso tra due date corrisponde
   * @throws SQLException
   */
  @Test
  public void incassoLidoDaATest() throws SQLException {
    manager = new TablePrenotazioneManager(mockDb);
    float incassoTotale = manager.incassoLidoDa_A(1, "2020-06-09", "2020-06-09");
    assertEquals(30, incassoTotale, "It should return 30");
  }

  /**
   * Controlla se gli ombrelloni disponibili per un certo periodo corrispondono
   * @throws SQLException
   */
  @Test
  public void ombrelloniOccupatiTest() throws SQLException {
    manager = new TablePrenotazioneManager(mockDb);
    Lido lido = new Lido(1, "Nome1", "Indirizzo1", "Telefono1", "email1", "logo1", 12.5F, 4, 5, 1, 1);
    List<String> list = manager.ombrelloniOccupati("2020-06-09", "2020-06-09", lido);
    assertEquals(1, list.size(), "It should return 1");
  }

  /**
   * Controlla se gli ombrelloni occupati per un certo periodo in un
   * certo lido corrispondono
   * @throws SQLException
   */
  @Test
  public void ombrelloniListOccupatiTest() throws SQLException {
    manager = new TablePrenotazioneManager(mockDb);
    List<Ombrellone> list=manager.ombrelloniListOccupati("2020-06-09","2020-06-09",1);
    assertEquals(1, list.size(), "It should return 1");
  }

  /**
   * Controlla l'ultima prenotazione effettuata
   * @throws SQLException
   */
  @Test
  public void ultimateIdTest() throws SQLException {
    manager = new TablePrenotazioneManager(mockDb);
    int idPre=manager.ultimateId();
    Prenotazione prenotazione= manager.retriveById(idPre);
    assertNotNull(prenotazione,"It should retrive the last Prenotazione");
  }

  /**
   * Controlla l'affluenza nei giorni della settimana
   * @throws SQLException
   */

  @Test
  public void getAffluenza() throws SQLException{
    manager = new TablePrenotazioneManager(mockDb);
    HashMap<String,Integer> map=manager.getAffluenza();
    assertNotNull(map,"It should retrive the map");
  }

  /**
   * Controlla se il codice prenotazione è presente
   * @throws SQLException
   */
  @Test
  public void codiceIsPresentTest1() throws SQLException {
    manager = new TablePrenotazioneManager(mockDb);
    boolean present=manager.codiceIsPresent("AA1234");
    assertEquals(true,present,"It should find the Prenotazione");
  }

  /**
   * Controlla se il codice prenotazione è presente
   * @throws SQLException
   */
  @Test
  public void codiceIsPresentTest2() throws SQLException {
    manager = new TablePrenotazioneManager(mockDb);
    boolean present=manager.codiceIsPresent("AA789");
    assertEquals(false,present,"It should not find the Prenotazione");
  }

}
