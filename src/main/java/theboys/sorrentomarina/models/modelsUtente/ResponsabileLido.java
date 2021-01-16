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
  private int id_resp_ente;

  /**
   * Costruttore crea un reasponsabile lido vuoto
   */
  public ResponsabileLido() {
    super();
  }

  public ResponsabileLido(int id, String nome, String cognome, String email, String username, String password, int id_lido, int id_resp_ente) {
    this.id = id;
    this.nome = nome;
    this.cognome = cognome;
    this.email = email;
    this.username = username;
    this.password_responsabile_lido = password;
    this.id_lido = id_lido;
    this.id_resp_ente = id_resp_ente;
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
   * @param id_resp_ente
   */
  public ResponsabileLido(String nome, String cognome, String email, String username, String password, int id_lido, int id_resp_ente) {
    this.nome = nome;
    this.cognome = cognome;
    this.email = email;
    this.username = username;
    this.password_responsabile_lido = password;
    this.id_lido = id_lido;
    this.id_resp_ente = id_resp_ente;
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
