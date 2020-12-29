package theboys.sorrentomarina.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Ombrellone {

  private int id;
  private int num_riga;
  private int num_colonna;
  private int id_prenotazione;

  public Ombrellone() {
    super();
  }

  public Ombrellone(int id,int num_riga,int num_colonna,int id_prenotazione) {
    this.id=id;
    this.num_riga=num_riga;
    this.num_colonna=num_colonna;
    this.id_prenotazione=id_prenotazione;
  }
}
