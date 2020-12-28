package theboys.sorrentomarina.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Recensione {
  private int id;
  private int giudizio;
  private String id_lido;
  private String id_turista;


  public Recensione() { super(); }

  public Recensione(int id, int giudizio, String id_lido, String id_turista ) {
    this.id=id;
    this.giudizio=giudizio;
    this.id_lido=id_lido;
    this.id_turista=id_turista;
  }

  public Recensione(int giudizio, String id_lido, String id_turista) {
    this.giudizio=giudizio;
    this.id_lido=id_lido;
    this.id_turista=id_turista;
  }

  @Override
  public String toString() {
    return "Recensione[id="+this.id+",giudizio="+this.giudizio+",id_lido="+this.id_lido+",id_turista="+this.id_turista+"]";
  }







}

