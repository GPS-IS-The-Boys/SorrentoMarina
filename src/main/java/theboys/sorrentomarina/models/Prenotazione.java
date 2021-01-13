package theboys.sorrentomarina.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


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

  public Prenotazione() {super();  }

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
