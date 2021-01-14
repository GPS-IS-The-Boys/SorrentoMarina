package theboys.sorrentomarina.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TuristaTest {

  private Turista turista;

  @BeforeEach
  public void init() {
    turista = new Turista(1, "Guido", "Lavespa", "guido.l@unisa.it", "Gvespa", "LavespaGuido");
  }


  @Test
  public void getIdTest() {
    int id = turista.getId();
    assertEquals(1, id, "Should return 1");
  }

  @Test
  public void getNomeTest() {
    String nome = turista.getNome();
    assertEquals("Guido", nome, "should return Guido");
  }

  @Test
  public void getCognomeTest() {
    String cognome = turista.getCognome();
    assertEquals("Lavespa", cognome, "Should return Lavespa");
  }

  @Test
  public void getEmailTest() {
    String email = turista.getEmail();
    assertEquals("guido.l@unisa.it", email, "Should return guido.l@unisa.it");
  }

  @Test
  public void getUsernameTest() {
    String username = turista.getUsername();
    assertEquals("Gvespa", username, "Should return Gvespa");
  }

  @Test
  public void getPasswordTest() {
    String pwd = turista.getPassword_turista();
    assertEquals("LavespaGuido", pwd, "Sgould return LavespaGuido");
  }

  @Test
  public void setIdTest() {
    turista.setId(7);
    int id = turista.getId();
    assertEquals(7, id, "Should return 7");
  }

  @Test
  public void setNomeTest() {
    turista.setNome("Antonio");
    String nome = turista.getNome();
    assertEquals("Antonio", nome, "Should return Antonio");
  }

  @Test
  public void setCognomeTest() {
    turista.setCognome("Verdi");
    String cognome = turista.getCognome();
    assertEquals("Verdi", cognome, "Should return Verdi");
  }

  @Test
  public void setEmailTest() {
    turista.setEmail("A-Verdi@unisa.it");
    String email = turista.getEmail();
    assertEquals("A-Verdi@unisa.it", email, "Should return A-Verdi@unisa.it");
  }

  @Test
  public void setUsernameTest() {
    turista.setUsername("A_Verdi");
    String username = turista.getUsername();
    assertEquals("A_Verdi", username, "Should return A_Verdi");
  }

  @Test
  public void setPasswordTest() {
    turista.setPassword_turista("VerdiAntonio");
    String pwd = turista.getPassword_turista();
    assertEquals("VerdiAntonio", pwd, "Sgould return VerdiAntonio");
  }

  @Test
  public void createTest(){
    Turista t = new Turista("cas", "acs", "abc");
    assertNotNull(t);
  }

  @Test
  public void toStringTest(){
    String result = turista.toString();
    assertEquals(result, "Turista[id=1,nome=Guido,cognome=Lavespa,email=guido.l@unisa.it,username=Gvespa,password=LavespaGuido]");
  }
}