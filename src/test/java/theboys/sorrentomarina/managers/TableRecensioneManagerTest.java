package theboys.sorrentomarina.managers;

import org.junit.jupiter.api.Test;
import theboys.sorrentomarina.managers.managersRecensione.TableRecensioneManager;
import theboys.sorrentomarina.models.modelsRecensione.Recensione;

import static org.junit.jupiter.api.Assertions.*;
import java.sql.SQLException;
import java.util.List;

/**
 * @author theboys
 */

public class TableRecensioneManagerTest extends IntegrationTestCase{

  TableRecensioneManager manager;

  /**
   * Metodo che testa il create inserendo una recensione nel database
   * e poi verificando che essa sia presente
   *
   */
  @Test
  public void createTest() throws SQLException{
    manager = new TableRecensioneManager(mockDb);
    manager.create(3,"ContenutoTest",1,1);
    Recensione recensione = manager.retriveById(6);
    assertNotNull(recensione,"It should find the Recensione");
  }

  /**
   * Metodo che testa il retriveById verificando che
   * una specifica recensione sia presente nel database
   *
   */
  @Test
  public void retriveByIdTest() throws SQLException {
    manager = new TableRecensioneManager(mockDb);
    Recensione recensione = manager.retriveById(1);
    assertNotNull(recensione, "It should find the Annuncio");
  }

  /**
   * Metodo che testa il retriveById_Lido verificando che
   * la lista contenga il giusto numero di elementi
   *
   */
  @Test
  public void retriveById_LidoTest() throws SQLException{
    manager = new TableRecensioneManager(mockDb);
    List<Recensione> lista = manager.retriveById_Lido(1);
    assertEquals( 2, lista.size(),"It should return a list of length 2");
  }

  /**
   * Metodo che testa il retriveById_Turista verificando che
   * la lista contenga il giusto numero di elementi
   *
   */
  @Test
  public void retriveById_TuristaTest() throws SQLException{
    manager = new TableRecensioneManager(mockDb);
    List<Recensione> lista = manager.retriveById_Turista(1);
    assertEquals(2,lista.size(),"It should return a list of length 2");
  }

  /**
   * Metodo che testa il retriveAll verificando che
   * la lista contenga il giusto numero di elementi
   *
   */
  @Test
  public void retriveAllTest() throws SQLException{
    manager = new TableRecensioneManager(mockDb);
    List<Recensione> lista = manager.retriveAll();
    assertEquals(3,lista.size(),"It should return a list of length 4");
  }

  /**
   * Metodo che testa l'update verificando che
   * la recensionoe è stata modificata correttamente
   *
   */
  @Test
  public void updateTest() throws SQLException{
    manager = new TableRecensioneManager(mockDb);
    Recensione recensione = new Recensione(1,3,"Struttura sufficiente",1,1);
    recensione.setGiudizio(5);
    manager.update(recensione);
    recensione= manager.retriveById(1);
    assertEquals(5,recensione.getGiudizio(),"It should return the same Recensione");
  }

  /**
   * Metodo che testa il delete verificando che
   * la recensione eliminata non sia presente nel database
   *
   */
  @Test
  public void deleteTest() throws SQLException{
    manager = new TableRecensioneManager(mockDb);
    manager.delete(1);
    Recensione recensione = manager.retriveById(1);
    assertNull(recensione,"It should return null");
  }

  /**
   * Metodo che testa il deleteById_Lido verificando che
   * le recensioni eliminate non siano presenti nel database
   *
   */
  @Test
  public void deleteTestById_Lido() throws SQLException{
    manager = new TableRecensioneManager(mockDb);
    manager.deleteById_Lido(3);
    assertEquals(manager.retriveById_Lido(3).size(),0,"It should return an empty list");
  }

  /**
   * Metodo che testa il deleteBy_Lido verificando che
   * le recensioni eliminate non siano presenti nel database
   *
   */
  @Test
  public void deleteTestById_Turista() throws SQLException{
    manager = new TableRecensioneManager(mockDb);
    manager.deleteById_Turista(4);
    assertEquals(manager.retriveById_Lido(4).size(),0,"It should return an empty list");
  }
}
