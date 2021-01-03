package theboys.sorrentomarina.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Turista {
  private int id;
  private String nome;
  private String cognome;
  private String email;
  private String username;
  private String password_turista;

  public Turista() {
    super();
  }

  public Turista(int id, String nome, String cognome, String email, String username, String password) {
    this.id = id;
    this.nome = nome;
    this.cognome = cognome;
    this.email = email;
    this.username = username;
    this.password_turista = password;
  }

  public Turista(String nome, String cognome, String email, String username, String password) {
    this.nome = nome;
    this.cognome = cognome;
    this.email = email;
    this.username = username;
    this.password_turista = password;
  }

  public Turista(String nome, String cognome, String email) {
    this.nome = nome;
    this.cognome = cognome;
    this.email = email;
  }

  @Override
  public String toString() {
    return "Turista[id=" + this.id + ",nome=" + this.nome + ",cognome=" + this.cognome + ",email=" + this.email + ",username=" + this.username + ",password="+this.password_turista+"]";
  }
}
