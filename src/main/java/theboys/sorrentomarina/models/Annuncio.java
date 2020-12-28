package theboys.sorrentomarina.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Annuncio {
  private int id;
  private String titolo;
  private String contenuto;
  private String foto;
  private String id_lido;

  public Annuncio(){super(); }

  public Annuncio(int id, String titolo,String contenuto, String foto, String id_lido){
    this.id=id;
    this.titolo=titolo;
    this.contenuto=contenuto;
    this.foto=foto;
    this.id_lido=id_lido;
  }

  public Annuncio(String titolo,String contenuto, String foto, String id_Lido){
    this.titolo=titolo;
    this.contenuto=contenuto;
    this.foto=foto;
    this.id_lido=id_Lido;
  }

  @Override
  public String toString(){
    return "Annuncio[id="+this.id+",titolo="+this.titolo+",contenuto="+this.contenuto+",foto="+this.foto+",id_Lido="+this.id_lido+"]";
  }

}
