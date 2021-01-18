package theboys.sorrentomarina.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import theboys.sorrentomarina.models.modelsPrenotazione.Prenotazione;

import static org.junit.jupiter.api.Assertions.*;
/**
 * @author theboys
 */
public class PrenotazioneTest {
  private Prenotazione prenotazione;

  /**
   * Metodo che inizializza una prenotazione
   *
   */
  @BeforeEach
  public void init() {
    prenotazione = new Prenotazione(1,"2020-06-10","2020-06-14",2,30,"AB1234",1,1);
  }

  /**
   * test per il metodo getId
   */
  @Test
  public void getIdTest(){
    int id=prenotazione.getId();
    assertEquals(1,id,"Should return 1");
  }

  /**
   * test per il metodo getData_inizio
   */
  @Test
  public void getDataInizioTest(){
    String dataInizio=prenotazione.getData_inizio();
    assertEquals("2020-06-10",dataInizio,"Should return 2020-06-10");
  }

  /**
   * test per il metodo getData_fine
   */
  @Test
  public void getDataFineTest(){
    String dataFine = prenotazione.getData_fine();
    assertEquals("2020-06-14",dataFine,"Should return 2020-06-14");
  }

  /**
   * test per il metodo getNum_posti
   */
  @Test
  public void getNumPostiTest(){
    int numPosti = prenotazione.getNum_posti();
    assertEquals(2,numPosti,"Should return 2");
  }

  /**
   * test per il metodo getCosto
   */
  @Test
  public void getCostoTest(){
    float costo=prenotazione.getCosto();
    assertEquals(30,costo,"Should return 30");
  }

  /**
   * test per il metodo getId_lido
   */
  @Test
  public void getIdLidoTest(){
    int idLido=prenotazione.getId_lido();
    assertEquals(1,idLido,"Should return 1");
  }

  /**
   * test per il metodo getId_turista
   */
  @Test
  public void getIdTuristaTest(){
    int idTurista=prenotazione.getId_turista();
    assertEquals(1,idTurista,"Should return 1");
  }

  /**
   * test per il metodo getCodice
   */
  @Test
  public void getCodiceTest(){
    String codice=prenotazione.getCodice();
    assertEquals("AB1234",codice,"Should return AB1234");
  }

  /**
   * test per il metodo setId
   */
  @Test
  public void setIdTest(){
    prenotazione.setId(2);
    int id=prenotazione.getId();
    assertEquals(2,id,"Should return 2");
  }

  /**
   * test per il metodo setData_inizio
   */
  @Test
  public void setDataInizioTest(){
    prenotazione.setData_inizio("2020-10-12");
    String dataInizio=prenotazione.getData_inizio();
    assertEquals("2020-10-12",dataInizio,"Should return 2020-10-12");
  }

  /**
   * test per il metodo setData_fine
   */
  @Test
  public void setDataFineTest(){
    prenotazione.setData_fine("2020-10-15");
    String dataFine = prenotazione.getData_fine();
    assertEquals("2020-10-15",dataFine,"Should return 2020-10-15");
  }

  /**
   * test per il metodo setNum_posti
   */
  @Test
  public void setNumPostiTest(){
    prenotazione.setNum_posti(1);
    int numPosti = prenotazione.getNum_posti();
    assertEquals(1,numPosti,"Should return 1");
  }

  /**
   * test per il metodo setCosto
   */
  @Test
  public void setCostoTest(){
    prenotazione.setCosto(28);
    float costo=prenotazione.getCosto();
    assertEquals(28,costo,"Should return 28");
  }

  /**
   * test per il metodo setId_lido
   */
  @Test
  public void setIdLidoTest(){
    prenotazione.setId_lido(2);
    int idLido=prenotazione.getId_lido();
    assertEquals(2,idLido,"Should return 2");
  }

  /**
   * test per il metodo setId_turista
   */
  @Test
  public void setIdTuristaTest(){
    prenotazione.setId_turista(2);
    int idTurista=prenotazione.getId_turista();
    assertEquals(2,idTurista,"Should return 2");
  }

  /**
   * test per il metodo setCodice
   */
  @Test
  public void setCodiceTest(){
    prenotazione.setCodice("ZZ1234");
    String codice=prenotazione.getCodice();
    assertEquals("ZZ1234",codice,"Should return ZZ1234");
  }

  /**
   * test per il metodo create
   */
  @Test
  public void createTest(){
    Prenotazione p = new Prenotazione(1, "", "", 1, 10F, "ASDV1", 1,2);
    assertNotNull(p, "La prenotazione deve contenere i campi inseriti");
  }

  /**
   * test per il metodo create
   */
  @Test
  public void createTest2(){
    Prenotazione p = new Prenotazione("", "", 1, 10F, "ASDV1", 1,2);
    assertNotNull(p, "La prenotazione deve contenere i campi inseriti");
  }

  /**
   * test per il metodo toString
   */
  @Test
  public void toStringTest(){
    String result = prenotazione.toString();
    assertEquals(result, "Prenotazione(id=1, data_inizio=2020-06-10, data_fine=2020-06-14, num_posti=2, costo=30.0, codice=AB1234, id_lido=1, id_turista=1)");
  }
}
