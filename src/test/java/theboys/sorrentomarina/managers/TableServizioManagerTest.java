package theboys.sorrentomarina.managers;

import org.junit.jupiter.api.Test;
import theboys.sorrentomarina.managers.managersLido.TableServizioManager;
import theboys.sorrentomarina.models.modelsLido.Servizio;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.SQLException;
import java.util.List;
/**
 * @author theboys
 */
public class TableServizioManagerTest extends IntegrationTestCase{

  TableServizioManager manager;

  /**
   * Testa la creazione di un nuovo servizio
   * @throws SQLException
   */
  @Test
  public void create1Test1() throws SQLException {
    manager = new TableServizioManager(mockDb);
    manager.create1(false,false,false,false,false,false,false);
    Servizio servizio = manager.retriveById(5);
    assertNotNull(servizio,"Should return true if create Servizio");
  }

  /**
   * Testa la creazione di un nuovo servizio
   * @throws SQLException
   */
  @Test
  public void create1Test2() throws SQLException {
    manager = new TableServizioManager(mockDb);
    manager.create1(true,true,true,true,true,true,true);
    Servizio servizio = manager.retriveById(5);
    assertNotNull(servizio,"Should return true if create Servizio");
  }

  /**
   * Testa la creazione di un nuovo servizio
   * @throws SQLException
   */
  @Test
  public void create2Test() throws SQLException {
    manager = new TableServizioManager(mockDb);
    manager.create2(false,true,false,true,false,false,true);
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
  public void updateTest1() throws SQLException {
    manager = new TableServizioManager(mockDb);
    Servizio servizio = manager.retriveById(2);
    servizio.setCabina(false);
    manager.update(servizio);
    servizio = manager.retriveById(2);
    assertEquals(false, servizio.isCabina() ,"Should return true if update Servizio");
  }

  /**
   * Controlla se viene aggiornato il servizio
   * @throws SQLException
   */
  @Test
  public void updateTest2() throws SQLException {
    manager = new TableServizioManager(mockDb);
    Servizio servizio = manager.retriveById(2);
    servizio.setBar(false);
    manager.update(servizio);
    servizio = manager.retriveById(2);
    assertEquals(false, servizio.isBar() ,"Should return true if update Servizio");
  }

  /**
   * Controlla se viene aggiornato il servizio
   * @throws SQLException
   */
  @Test
  public void updateTest3() throws SQLException {
    manager = new TableServizioManager(mockDb);
    Servizio servizio = manager.retriveById(2);
    servizio.setRistorante(false);
    manager.update(servizio);
    servizio = manager.retriveById(2);
    assertEquals(false, servizio.isRistorante() ,"Should return true if update Servizio");
  }

  /**
   * Controlla se viene aggiornato il servizio
   * @throws SQLException
   */
  @Test
  public void updateTest4() throws SQLException {
    manager = new TableServizioManager(mockDb);
    Servizio servizio = manager.retriveById(2);
    servizio.setAnimazione(false);
    manager.update(servizio);
    servizio = manager.retriveById(2);
    assertEquals(false, servizio.isAnimazione() ,"Should return true if update Servizio");
  }

  /**
   * Controlla se viene aggiornato il servizio
   * @throws SQLException
   */
  @Test
  public void updateTest5() throws SQLException {
    manager = new TableServizioManager(mockDb);
    Servizio servizio = manager.retriveById(2);
    servizio.setWifi(false);
    manager.update(servizio);
    servizio = manager.retriveById(2);
    assertEquals(false, servizio.isWifi() ,"Should return true if update Servizio");
  }

  /**
   * Controlla se viene aggiornato il servizio
   * @throws SQLException
   */
  @Test
  public void updateTest6() throws SQLException {
    manager = new TableServizioManager(mockDb);
    Servizio servizio = manager.retriveById(2);
    servizio.setBeach_volley(false);
    manager.update(servizio);
    servizio = manager.retriveById(2);
    assertEquals(false, servizio.isBeach_volley() ,"Should return true if update Servizio");
  }

  /**
   * Controlla se viene aggiornato il servizio
   * @throws SQLException
   */
  @Test
  public void updateTest7() throws SQLException {
    manager = new TableServizioManager(mockDb);
    Servizio servizio = manager.retriveById(2);
    servizio.setCanoa(false);
    manager.update(servizio);
    servizio = manager.retriveById(2);
    assertEquals(false, servizio.isCanoa() ,"Should return true if update Servizio");
  }


  /**
   * Controlla se viene aggiornato il servizio
   * @throws SQLException
   */
  @Test
  public void updateTest8() throws SQLException {
    manager = new TableServizioManager(mockDb);
    Servizio servizio = manager.retriveById(2);
    servizio.setCanoa(true);
    manager.update(servizio);
    servizio = manager.retriveById(2);
    assertEquals(true, servizio.isCanoa() ,"Should return true if update Servizio");
  }

  /**
   * Controlla se viene aggiornato il servizio
   * @throws SQLException
   */
  @Test
  public void updateTest9() throws SQLException {
    manager = new TableServizioManager(mockDb);
    Servizio servizio = manager.retriveById(2);
    servizio.setCabina(true);
    manager.update(servizio);
    servizio = manager.retriveById(2);
    assertEquals(true, servizio.isCabina() ,"Should return true if update Servizio");
  }

  /**
   * Controlla se viene aggiornato il servizio
   * @throws SQLException
   */
  @Test
  public void updateTest10() throws SQLException {
    manager = new TableServizioManager(mockDb);
    Servizio servizio = manager.retriveById(2);
    servizio.setBar(true);
    manager.update(servizio);
    servizio = manager.retriveById(2);
    assertEquals(true, servizio.isBar() ,"Should return true if update Servizio");
  }

  /**
   * Controlla se viene aggiornato il servizio
   * @throws SQLException
   */
  @Test
  public void updateTest11() throws SQLException {
    manager = new TableServizioManager(mockDb);
    Servizio servizio = manager.retriveById(2);
    servizio.setRistorante(true);
    manager.update(servizio);
    servizio = manager.retriveById(2);
    assertEquals(true, servizio.isRistorante() ,"Should return true if update Servizio");
  }

  /**
   * Controlla se viene aggiornato il servizio
   * @throws SQLException
   */
  @Test
  public void updateTest12() throws SQLException {
    manager = new TableServizioManager(mockDb);
    Servizio servizio = manager.retriveById(2);
    servizio.setAnimazione(true);
    manager.update(servizio);
    servizio = manager.retriveById(2);
    assertEquals(true, servizio.isAnimazione() ,"Should return true if update Servizio");
  }

  /**
   * Controlla se viene aggiornato il servizio
   * @throws SQLException
   */
  @Test
  public void updateTest13() throws SQLException {
    manager = new TableServizioManager(mockDb);
    Servizio servizio = manager.retriveById(2);
    servizio.setWifi(true);
    manager.update(servizio);
    servizio = manager.retriveById(2);
    assertEquals(true , servizio.isWifi() ,"Should return true if update Servizio");
  }

  /**
   * Controlla se viene aggiornato il servizio
   * @throws SQLException
   */
  @Test
  public void updateTest14() throws SQLException {
    manager = new TableServizioManager(mockDb);
    Servizio servizio = manager.retriveById(2);
    servizio.setBeach_volley(true);
    manager.update(servizio);
    servizio = manager.retriveById(2);
    assertEquals(true, servizio.isBeach_volley() ,"Should return true if update Servizio");
  }

  /**
   * Controlla se il servizio viene cancellato
   * @throws SQLException
   */
  @Test
  public void deleteTest() throws SQLException {
    manager = new TableServizioManager(mockDb);
    manager.delete(1);
    Servizio servizio= manager.retriveById(1);
    assertNull(servizio,"Should return true if delete Servizio");
  }

  /**
   * Controlla se vengono restuiti tutti i servizi
   * @throws SQLException
   */
  @Test
  public void retriveAllTest() throws SQLException {
    manager = new TableServizioManager(mockDb);
    List<Servizio> lista = manager.retriveAll();
    assertEquals(7,lista.size(),"It should return a list of length 7");
  }


}
