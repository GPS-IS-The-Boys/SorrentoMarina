package theboys.sorrentomarina.models.modelsAnnuncio;

import lombok.Getter;
import lombok.Setter;


/**
 * @author theboys
 */

@Getter
@Setter
public class Annuncio {
  private int id;
  private String titolo;
  private String contenuto;
  private String foto;
  private int id_lido;

  /**
   * Costruttore annuncio senza parametri
   */
  public Annuncio() {
    super();
  }

  /**
   * Costruttore annuncio con tutti i parametri
   *
   * @param id        - codice univoco di un annuncio
   * @param titolo    - titolo dell'annunicio
   * @param contenuto - testo dell'annuncio
   * @param foto      - foto rappresentativa
   * @param id_lido   - codice del lido a cui fa riferimento l'annuncio
   */
  public Annuncio(int id, String titolo, String contenuto, String foto, int id_lido) {
    this.id = id;
    this.titolo = titolo;
    this.contenuto = contenuto;
    this.foto = foto;
    this.id_lido = id_lido;
  }

  /**
   * Costruttore annuncio con i parametri escluso id
   *
   * @param titolo    - titolo dell'annunicio
   * @param contenuto - testo dell'annuncio
   * @param foto      - foto rappresentativa
   * @param id_lido   - codice del lido a cui fa riferimento l'annuncio
   */
  public Annuncio(String titolo, String contenuto, String foto, int id_lido) {
    this.titolo = titolo;
    this.contenuto = contenuto;
    this.foto = foto;
    this.id_lido = id_lido;
  }

  /**
   * Metodo to string
   *
   * @return String - stringa che riassume lo stato dell'annuncio
   */
  @Override
  public String toString() {
    return "Annuncio[id=" + this.id + ",titolo=" + this.titolo + ",contenuto=" + this.contenuto + ",foto=" + this.foto + ",id_Lido=" + this.id_lido + "]";
  }

}
