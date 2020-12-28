package theboys.sorrentomarina.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponsabileLido {
    private int id;
    private String nome;
    private String cognome;
    private String email;
    private String username;
    private String password;
    private int id_lido;

    public ResponsabileLido() { super(); }

    public ResponsabileLido(int id, String nome, String cognome, String email, String username, String password, int id_lido) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.username = username;
        this.password = password;
        this.id_lido = id_lido;
    }

    public ResponsabileLido(String nome, String cognome, String email, String username, String password, int id_lido) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.username = username;
        this.password = password;
        this.id_lido = id_lido;
    }

    @Override
    public String toString(){
        return "ResponsabileLido[id="+this.id+",nome="+this.nome+",cognome="+this.cognome+",email="+this.email+",username="+this.username+"]";
    }
}
