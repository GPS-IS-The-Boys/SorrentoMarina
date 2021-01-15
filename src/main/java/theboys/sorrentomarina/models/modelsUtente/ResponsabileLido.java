package theboys.sorrentomarina.models.modelsUtente;

import lombok.Getter;
import lombok.Setter;
/**
 * @author theboys
 */
@Getter
@Setter
public class ResponsabileLido {
  private int id;
  private String nome;
  private String cognome;
  private String email;
  private String username;
  private String password_responsabile_lido;
  private int id_lido;

  /**
   * Costruttore crea un reasponsabile lido vuoto
   */
  public ResponsabileLido() {
    super();
  }

  public ResponsabileLido(int id, String nome, String cognome, String email, String username, String password, int id_lido) {
    this.id = id;
    this.nome = nome;
    this.cognome = cognome;
    this.email = email;
    this.username = username;
    this.password_responsabile_lido = password;
    this.id_lido = id_lido;
  }

  /**
   * Costruttore crea un reasponsabile lido con parametri
   *
   * @param nome
   * @param cognome
   * @param email
   * @param username
   * @param password
   * @param id_lido
   */
  public ResponsabileLido(String nome, String cognome, String email, String username, String password, int id_lido) {
    this.nome = nome;
    this.cognome = cognome;
    this.email = email;
    this.username = username;
    this.password_responsabile_lido = password;
    this.id_lido = id_lido;
  }

  /**
   * Metodo to string
   *
   * @return String - stringa che riassume lo stato del responsabile lido
   */
  @Override
  public String toString() {
    return "ResponsabileLido[id=" + this.id + ",nome=" + this.nome + ",cognome=" + this.cognome + ",email=" + this.email + ",username=" + this.username + "]";
  }
}
