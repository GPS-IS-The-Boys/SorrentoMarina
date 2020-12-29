package theboys.sorrentomarina.managers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import theboys.sorrentomarina.models.Annuncio;
import theboys.sorrentomarina.models.Recensione;

import static org.junit.jupiter.api.Assertions.*;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Luigi Maiorano
 * @version 0.1
 */

public class TableRecensioneManagerTest extends IntegrationTestCase{

  TableRecensioneManager manager;

  /**
   * Metodo che inizializza un TableAnnuncioManager
   *
   */
  @BeforeEach
  public void init() { manager=new TableRecensioneManager(mockDb); }

  /**
   * Metodo che testa il create inserendo una recensione nel database
   * e poi verificando che essa sia presente
   *
   */
  @Test
  public void createTest() throws SQLException{
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
    List<Recensione> lista = manager.retriveById_Lido(1);
    assertEquals(lista.size(),2,"It should return a list of length 2");
  }

  /**
   * Metodo che testa il retriveById_Turista verificando che
   * la lista contenga il giusto numero di elementi
   *
   */
  @Test
  public void retriveById_TuristaTest() throws SQLException{
    List<Recensione> lista = manager.retriveById_Turista(1);
    assertEquals(lista.size(),2,"It should return a list of length 2");
  }

  /**
   * Metodo che testa il retriveAll verificando che
   * la lista contenga il giusto numero di elementi
   *
   */
  @Test
  public void retriveAllTest() throws SQLException{
    List<Recensione> lista = manager.retriveAll();
    assertEquals(lista.size(),3,"It should return a list of length 4");
  }

  /**
   * Metodo che testa l'update verificando che
   * la recensionoe è stata modificata correttamente
   *
   */
  @Test
  public void updateTest() throws SQLException{
    Recensione recensione = manager.retriveById(1);
    recensione.setContenuto("Contenuto");
    manager.update(recensione);
    Recensione recensione1= manager.retriveById(1);
    assertEquals(recensione,recensione1,"It should return the same Recensione");
  }

  /**
   * Metodo che testa il delete verificando che
   * la recensione eliminata non sia presente nel database
   *
   */
  @Test
  public void deleteTest() throws SQLException{
    manager.delete(3);
    assertNull(manager.retriveById(3),"It should return null");
  }

  /**
   * Metodo che testa il deleteById_Lido verificando che
   * le recensioni eliminate non siano presenti nel database
   *
   */
  @Test
  public void deleteTestById_Lido() throws SQLException{
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
    manager.deleteById_Turista(4);
    assertEquals(manager.retriveById_Lido(4).size(),0,"It should return an empty list");
  }
}
