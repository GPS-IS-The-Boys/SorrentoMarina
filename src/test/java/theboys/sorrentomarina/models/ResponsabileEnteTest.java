package theboys.sorrentomarina.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ResponsabileEnteTest {

  private ResponsabileEnte responsabileEnte;

  @BeforeEach
  public void init() {
    responsabileEnte = new ResponsabileEnte(1, "Mario", "Rossi", "m.rossi@unisa.it", "mrossi", "rossimario");
  }

  @Test
  public void getIdTest() {
    int id = responsabileEnte.getId();
    assertEquals(1, id, "Should return 1");
  }

  @Test
  public void getNomeTest() {
    String nome = responsabileEnte.getNome();
    assertEquals("Mario", nome, "Should return Mario");
  }

  @Test
  public void getCognomeTest() {
    String cognome = responsabileEnte.getCognome();
    assertEquals("Rossi", cognome, "Should return Rossi");
  }

  @Test
  public void getEmailTest() {
    String email = responsabileEnte.getEmail();
    assertEquals("m.rossi@unisa.it", email, "Should return m.rossi@unisa.it");
  }

  @Test
  public void getUsernameTest() {
    String username = responsabileEnte.getUsername();
    assertEquals("mrossi", username, "Should return mrossi");
  }

  @Test
  public void getPasswordTest() {
    String pwd = responsabileEnte.getPassword();
    assertEquals("rossimario", pwd, "Sgould return rossimario");
  }

  @Test
  public void setIdTest() {
    responsabileEnte.setId(5);
    int id = responsabileEnte.getId();
    assertEquals(5, id, "Should return 5");
  }

  @Test
  public void setNomeTest() {
    responsabileEnte.setNome("Luigi");
    String nome = responsabileEnte.getNome();
    assertEquals("Luigi", nome, "Should return Luigi");
  }

  @Test
  public void setCognomeTest() {
    responsabileEnte.setCognome("Bianchi");
    String cognome = responsabileEnte.getCognome();
    assertEquals("Bianchi", cognome, "Should return Bianchi");
  }

  @Test
  public void setEmailTest() {
    responsabileEnte.setEmail("lbianchi@unisa.it");
    String email = responsabileEnte.getEmail();
    assertEquals("lbianchi@unisa.it", email, "Should return lbianchi@unisa.it");
  }

  @Test
  public void setUsernameTest() {
    responsabileEnte.setUsername("lbianchi");
    String username = responsabileEnte.getUsername();
    assertEquals("lbianchi", username, "Should return lbianchi");
  }

  @Test
  public void setPasswordTest() {
    responsabileEnte.setPassword("bianchiluigi");
    String pwd = responsabileEnte.getPassword();
    assertEquals("bianchiluigi", pwd, "Sgould return bianchiluigi");
  }


}
