package theboys.sorrentomarina.models.modelsUtente;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/**
 * @author theboys
 */
@Getter
@Setter
@ToString
public class ResponsabileEnte {

  private String nome, cognome, email, username, password_ente;
  private int id;

  /**
   * Costruttore crea un reasponsabile ente vuoto
   */
  public ResponsabileEnte() {
    super();
  }

  /**
   * Costruttore crea un reasponsabile ente con parametri
   *
   * @param id
   * @param nome
   * @param cognome
   * @param email
   * @param username
   * @param password
   */
  public ResponsabileEnte(int id, String nome, String cognome, String email, String username, String password) {
    this.id = id;
    this.nome = nome;
    this.cognome = cognome;
    this.email = email;
    this.username = username;
    this.password_ente = password;
  }

  /**
   * Costruttore crea un reasponsabile ente con parametri escluso id
   *
   * @param nome
   * @param cognome
   * @param email
   * @param username
   * @param password
   */
  public ResponsabileEnte(String nome, String cognome, String email, String username, String password) {
    this.nome = nome;
    this.cognome = cognome;
    this.email = email;
    this.username = username;
    this.password_ente = password;
  }
}
