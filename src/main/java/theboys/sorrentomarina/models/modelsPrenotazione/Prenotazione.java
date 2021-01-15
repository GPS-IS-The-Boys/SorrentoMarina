package theboys.sorrentomarina.models.modelsPrenotazione;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author theboys
 */
@Getter
@Setter
@ToString
public class Prenotazione {
  private int id;
  private String data_inizio;
  private String data_fine;
  private int num_posti;
  private float costo;
  private String codice;
  private int id_lido;
  private int id_turista;

  /**
   * Costruttore crea una prenotazione vuota
   */
  public Prenotazione() {super();  }

  /**
   * Costruttore crea una prenotazione con paramentri
   *
   * @param id
   * @param data_inizio
   * @param data_fine
   * @param num_posti
   * @param costo
   * @param id_lido
   * @param id_turista
   */
  public Prenotazione(int id, String data_inizio, String data_fine, int num_posti, float costo, String codice, int id_lido, int id_turista) {
    this.id = id;
    this.data_inizio = data_inizio;
    this.data_fine = data_fine;
    this.num_posti = num_posti;
    this.costo = costo;
    this.codice = codice;
    this.id_lido = id_lido;
    this.id_turista = id_turista;
  }

  /**
   * Costruttore crea una prenotazione con paramentri escluso id
   *
   * @param data_inizio
   * @param data_fine
   * @param num_posti
   * @param costo
   * @param id_lido
   * @param id_turista
   */
  public Prenotazione(String data_inizio, String data_fine, int num_posti, float costo, String codice, int id_lido, int id_turista) {
    this.data_inizio = data_inizio;
    this.data_fine = data_fine;
    this.num_posti = num_posti;
    this.costo = costo;
    this.codice = codice;
    this.id_lido = id_lido;
    this.id_turista = id_turista;
  }
}
