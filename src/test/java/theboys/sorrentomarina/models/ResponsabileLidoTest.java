package theboys.sorrentomarina.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResponsabileLidoTest {

  private  ResponsabileLido responsabileLido;

  @BeforeEach
  public void init() {
    responsabileLido = new ResponsabileLido(1, "Guido", "Lavespa", "guido.l@unisa.it", "Gvespa", "LavespaGuido",1);
  }


  @Test
  public void getIdTest() {
    int id = responsabileLido.getId();
    assertEquals(1, id, "Should return 1");
  }

  @Test
  public void getNomeTest() {
    String nome = responsabileLido.getNome();
    assertEquals("Guido", nome, "should return Guido");
  }

  @Test
  public void getCognomeTest() {
    String cognome = responsabileLido.getCognome();
    assertEquals("Lavespa", cognome, "Should return Lavespa");
  }

  @Test
  public void getEmailTest() {
    String email = responsabileLido.getEmail();
    assertEquals("guido.l@unisa.it", email, "Should return guido.l@unisa.it");
  }

  @Test
  public void getUsernameTest() {
    String username = responsabileLido.getUsername();
    assertEquals("Gvespa", username, "Should return Gvespa");
  }

  @Test
  public void getPasswordTest() {
    String pwd = responsabileLido.getPassword();
    assertEquals("LavespaGuido", pwd, "Sgould return LavespaGuido");
  }

  @Test
  public void getIdLidoTest() {
    int id_lido = responsabileLido.getId_lido();
    assertEquals(1, id_lido, "Sgould return 1");
  }

  @Test
  public void setIdTest() {
    responsabileLido.setId(7);
    int id = responsabileLido.getId();
    assertEquals(7, id, "Should return 7");
  }

  @Test
  public void setNomeTest() {
    responsabileLido.setNome("Antonio");
    String nome = responsabileLido.getNome();
    assertEquals("Antonio", nome, "Should return Antonio");
  }

  @Test
  public void setCognomeTest() {
    responsabileLido.setCognome("Verdi");
    String cognome = responsabileLido.getCognome();
    assertEquals("Verdi", cognome, "Should return Verdi");
  }

  @Test
  public void setEmailTest() {
    responsabileLido.setEmail("A-Verdi@unisa.it");
    String email = responsabileLido.getEmail();
    assertEquals("A-Verdi@unisa.it", email, "Should return A-Verdi@unisa.it");
  }

  @Test
  public void setUsernameTest() {
    responsabileLido.setUsername("A_Verdi");
    String username = responsabileLido.getUsername();
    assertEquals("A_Verdi", username, "Should return A_Verdi");
  }

  @Test
  public void setPasswordTest() {
    responsabileLido.setPassword("VerdiAntonio");
    String pwd = responsabileLido.getPassword();
    assertEquals("VerdiAntonio", pwd, "Sgould return VerdiAntonio");
  }


    @Test
    public void setIdLidoTest() {
      responsabileLido.setId_lido(7);
     int id_lido = responsabileLido.getId_lido();
      assertEquals(7, id_lido, "Sgould return 7");
    }
}
