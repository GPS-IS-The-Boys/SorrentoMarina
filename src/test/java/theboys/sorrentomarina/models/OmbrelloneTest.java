package theboys.sorrentomarina.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OmbrelloneTest {
  private Ombrellone ombrellone;

  @BeforeEach
  public void init() {
    ombrellone = new Ombrellone(1, 5, 12, 27);
  }

  @Test
  public void getIdTest() {
    int id = ombrellone.getId();
    assertEquals(1, id, "Should return 1");
  }

  @Test
  public void getNumRigaTest(){
    int num_riga=ombrellone.getNum_riga();
    assertEquals(5,num_riga,"Should return 5");
  }

  @Test
  public void getNumColonnaTest(){
    int num_colonna=ombrellone.getNum_colonna();
    assertEquals(12,num_colonna,"Should return 12");
  }

  @Test
  public void getIdPrenotazioneTest(){
    int id=ombrellone.getId_prenotazione();
    assertEquals(27,id,"Should return 27");
  }

  @Test
  public void setIdTest() {
    ombrellone.setId(5);
    int id = ombrellone.getId();
    assertEquals(5, id, "Should return 5");
  }

  @Test
  public void setNumRigaTest(){
    ombrellone.setNum_riga(3);
    int num_riga=ombrellone.getNum_riga();
    assertEquals(3,num_riga,"Should return 3");
  }

  @Test
  public void setNumColonnaTest(){
    ombrellone.setNum_colonna(7);
    int num_colonna=ombrellone.getNum_colonna();
    assertEquals(7,num_colonna,"Should return 7");
  }

  @Test
  public void setIdPrenotazioneTest(){
    ombrellone.setId_prenotazione(30);
    int id=ombrellone.getId_prenotazione();
    assertEquals(30,id,"Should return 30");
  }



}
