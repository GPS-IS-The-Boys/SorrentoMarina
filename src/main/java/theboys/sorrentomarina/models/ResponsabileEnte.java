package theboys.sorrentomarina.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ResponsabileEnte {

    private String nome, cognome, email, username, password;
    private int id;

    public  ResponsabileEnte(){
        super();
    }

    public ResponsabileEnte(int id, String nome, String cognome, String email, String username, String password){
        this.id=id;
        this.nome=nome;
        this.cognome=cognome;
        this.email=email;
        this.username=username;
        this.password=password;
    }

    public ResponsabileEnte(String nome, String cognome, String email, String username, String password){
        this.nome=nome;
        this.cognome=cognome;
        this.email=email;
        this.username=username;
        this.password=password;
    }
}
