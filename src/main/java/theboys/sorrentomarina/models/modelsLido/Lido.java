package theboys.sorrentomarina.models.modelsLido;
/**
 * @author theboys
 */
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Lido {
  private int id;
  private String nome;
  private String indirizzo;
  private String telefono;
  private String email;
  private String logo;
  private float prezzo_singolo;
  private int num_righe;
  private int num_colonne;
  private int id_servizi;
  private int id_resp_ente;

  /**
   * Costruttore crea un lido vuoto
   */
  public Lido() {
    super();
  }

  /**
   * Costruttore crea un lido con parametri
   *
   * @param id
   * @param nome
   * @param indirizzo
   * @param telefono
   * @param email
   * @param logo
   * @param prezzo_singolo
   * @param num_righe
   * @param num_colonne
   * @param id_servizi
   * @param id_resp_ente
   */
  public Lido(int id, String nome, String indirizzo, String telefono, String email, String logo, float prezzo_singolo, int num_righe, int num_colonne, int id_servizi, int id_resp_ente) {
    this.id = id;
    this.nome = nome;
    this.indirizzo = indirizzo;
    this.telefono = telefono;
    this.email = email;
    this.logo = logo;
    this.prezzo_singolo = prezzo_singolo;
    this.num_righe = num_righe;
    this.num_colonne = num_colonne;
    this.id_servizi = id_servizi;
    this.id_resp_ente = id_resp_ente;
  }

  /**
   * Metodo to string
   *
   * @return String - stringa che riassume lo stato del lido
   */
  @Override
  public String toString() {
    return "Lido[id=" + this.id + ", nome=" + this.nome + ", indirizzo=" + this.indirizzo + ", telefono=" + this.telefono + ", email=" + this.email + ", prezzo_singolo=" + this.prezzo_singolo + "]";
  }
}