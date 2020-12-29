package theboys.sorrentomarina.managers;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import theboys.sorrentomarina.models.Annuncio;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Luigi Maiorano
 * @version 0.1
 */

public class TableAnnuncioManagerTest extends IntegrationTestCase{

  TableAnnuncioManager manager;

  /**
   * Metodo che inizializza un TableAnnuncioManager
   *
   */
  @BeforeEach
  public void init() { manager=new TableAnnuncioManager(mockDb); }

  /**
   * Metodo che testa il create inserendo un annuncio nel database
   * e poi verificando che esso sia presente
   *
   */
  @Test
  public void createTest() throws SQLException{
    manager.create("TitoloTest","ContenutoTest","Fototest",1);
    Annuncio annuncio = manager.retriveById(5);
    assertNotNull(annuncio,"It should find the Annuncio");
  }

  /**
   * Metodo che testa il retriveById verificando che
   * uno specifico annuncio sia presente nel database
   *
   */
  @Test
  public void retriveByIdTest() throws SQLException{
    Annuncio annuncio = manager.retriveById(1);
    assertNotNull(annuncio,"It should find the Annuncio");
  }

  /**
   * Metodo che testa il retriveById_Lido verificando che
   * la lista contenga il giusto numero di elementi
   *
   */
  @Test
  public void retriveById_LidoTest() throws SQLException{
    List<Annuncio> lista = manager.retriveById_Lido(1);
    assertEquals(lista.size(),2,"It should return a list of length 2");
  }

  /**
   * Metodo che testa il retriveAll verificando che
   * la lista contenga il giusto numero di elementi
   *
   */
  @Test
  public void retriveAllTest() throws SQLException{
    List<Annuncio> lista = manager.retriveAll();
    assertEquals(lista.size(),3,"It should return a list of length 3");
  }

  /**
   * Metodo che testa l'update verificando che
   * l'annuncio è stato modificato correttamente
   *
   */
  @Test
  public void updateTest() throws SQLException{
    Annuncio annuncio = manager.retriveById(4);
    annuncio.setTitolo("Titolo");
    manager.update(annuncio);
    TableAnnuncioManager manager2= new TableAnnuncioManager(mockDb);
    Annuncio annuncio2= manager2.retriveById(4);
    assertEquals(annuncio,annuncio2,"It should return the same Annuncio");
  }

  /**
   * Metodo che testa il delete verificando che
   * l'annuncio eliminato non sia presente nel database
   *
   */
  @Test
  public void deleteTest() throws SQLException{
    manager.delete(1);
    assertNull(manager.retriveById(1),"It should return null");
  }

  /**
   * Metodo che testa il deleteById_Lido verificando che
   * gli annunci eliminati non siano presenti nel database
   *
   */
  @Test
  public void deleteTestById_Lido() throws SQLException{
    manager.deleteById_Lido(2);
    assertEquals(manager.retriveById_Lido(2).size(),0,"It should return an empty list");
  }

}
