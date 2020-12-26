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

    public ResponsabileLido() { super(); }

    public ResponsabileLido(int id, String nome, String cognome, String email, String username, String password) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public ResponsabileLido(String nome, String cognome, String email, String username, String password) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString(){
        return "ResponsabileLido[id="+this.id+",nome="+this.nome+",cognome="+this.cognome+",email="+this.email+",username="+this.username+"]";
    }
}
