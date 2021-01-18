package theboys.sorrentomarina.models.modelsUtente;

import lombok.Getter;
import lombok.Setter;
/**
 * @author theboys
 */

@Getter
@Setter
public class Turista {
  private int id;
  private String nome;
  private String cognome;
  private String email;
  private String username;
  private String password_turista;

  /**
   * Costruttore turista vuoto
   */
  public Turista() {
    super();
  }

  /**
   * Costruttore turista con parametri
   *
   * @param id
   * @param nome
   * @param cognome
   * @param email
   * @param username
   * @param password
   */
  public Turista(int id, String nome, String cognome, String email, String username, String password) {
    this.id = id;
    this.nome = nome;
    this.cognome = cognome;
    this.email = email;
    this.username = username;
    this.password_turista = password;
  }

  /**
   * Costruttore turista con parametri escluso id
   *
   * @param nome
   * @param cognome
   * @param email
   * @param username
   * @param password
   */
  public Turista(String nome, String cognome, String email, String username, String password) {
    this.nome = nome;
    this.cognome = cognome;
    this.email = email;
    this.username = username;
    this.password_turista = password;
  }

  /**
   * Costruttore turista solo con alcuni parametri
   *
   * @param nome
   * @param cognome
   * @param email
   */
  public Turista(String nome, String cognome, String email) {
    this.nome = nome;
    this.cognome = cognome;
    this.email = email;
  }

  /**
   * Metodo to string
   *
   * @return String - stringa che riassume lo stato del turista
   */
  @Override
  public String toString() {
    return "Turista[id=" + this.id + ",nome=" + this.nome + ",cognome=" + this.cognome + ",email=" + this.email + ",username=" + this.username + ",password="+this.password_turista+"]";
  }
}
