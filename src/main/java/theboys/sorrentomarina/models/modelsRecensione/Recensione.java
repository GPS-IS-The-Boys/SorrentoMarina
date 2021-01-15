package theboys.sorrentomarina.models.modelsRecensione;

import lombok.Getter;
import lombok.Setter;

/**
 * @author theboys
 */

@Getter
@Setter
public class Recensione {
  private int id;
  private int giudizio;
  private String contenuto;
  private int id_lido;
  private int id_turista;

  /**
   * Costruttore crea una recensione vuota
   *
   */
  public Recensione() {
    super();
  }

  /**
   * Costruttore crea una recensione con i parametri
   *
   * @param id - codice univoco di una recensione
   * @param giudizio - voto da 1 a 5
   * @param contenuto - testo della recensione
   * @param id_lido - codice del lido a cui è riferita la recensione
   * @param id_turista - codice del turista che fa la recensione
   */
  public Recensione(int id, int giudizio,String contenuto, int id_lido, int id_turista) {
    this.id = id;
    this.giudizio = giudizio;
    this.contenuto = contenuto;
    this.id_lido = id_lido;
    this.id_turista = id_turista;
  }

  /**
   * Costruttore crea una recensione con i parametri escluso id
   *
   * @param giudizio - voto da 1 a 5
   * @param contenuto - testo della recensione
   * @param id_lido - codice del lido a cui è riferita la recensione
   * @param id_turista - codice del turista che fa la recensione
   */
  public Recensione(int giudizio,String contenuto, int id_lido, int id_turista) {
    this.giudizio = giudizio;
    this.contenuto = contenuto;
    this.id_lido = id_lido;
    this.id_turista = id_turista;
  }

  /**
   * Metodo to string
   *
   * @return String - stringa che riassume lo stato della recensione
   */
  @Override
  public String toString() {
    return "Recensione[id=" + this.id + ",giudizio=" + this.giudizio + ",contenuto="+this.contenuto+",id_lido=" + this.id_lido + ",id_turista=" + this.id_turista + "]";
  }


}

