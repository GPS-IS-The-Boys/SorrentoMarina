package theboys.sorrentomarina.models;

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

  public Lido() {
    super();
  }

  public Lido(int id, String nome, String indirizzo, String telefono, String email, String logo, float prezzo_singolo, int num_righe, int num_colonne, int id_servizi) {
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
  }

  @Override
  public String toString() {
    return "Lido[id=" + this.id + ", nome=" + this.nome + ", indirizzo=" + this.indirizzo + ", telefono=" + this.telefono + ", email=" + this.email + ", prezzo_singolo=" + this.prezzo_singolo + "]";
  }
}