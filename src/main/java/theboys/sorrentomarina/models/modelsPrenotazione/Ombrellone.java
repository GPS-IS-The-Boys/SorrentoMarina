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
public class Ombrellone {

  private int id;
  private int num_riga;
  private int num_colonna;
  private int id_prenotazione;

  /**
   * Costruttore crea un ombrellone vuoto
   */
  public Ombrellone() {
    super();
  }

  /**
   * Costruttore crea un ombrellone con parametri
   *
   * @param id
   * @param num_riga
   * @param num_colonna
   * @param id_prenotazione
   */
  public Ombrellone(int id,int num_riga,int num_colonna,int id_prenotazione) {
    this.id=id;
    this.num_riga=num_riga;
    this.num_colonna=num_colonna;
    this.id_prenotazione=id_prenotazione;
  }
}
