package theboys.sorrentomarina.managers;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import theboys.sorrentomarina.models.Account;
import theboys.sorrentomarina.models.Turista;

import javax.faces.application.ProjectStage;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class TableTuristaManager extends TableManager implements TuristaManager{

    private static final ResultSetHandler<Turista> TUR_MAPPER =
            new BeanHandler<>(Turista.class);

    public TableTuristaManager(DataSource dataSource) {
        super(dataSource);
    }

    /* Inserimento di un turista  */
    @Override
    public void create(String nome, String cognome, String email, String username, String password) throws SQLException {
        runner.update("INSERT INTO TURISTA(nome,cognome,email,username,password_turista) VALUES ('gerardo','iuliano','email','user','password')");
    }

    /* Ricerca di un turista tramite id */
    @Override
    public Turista retriveById(int id) throws SQLException {
        Turista turista = runner.query("SELECT nome,cognome FROM TURISTA WHERE id = ?",TUR_MAPPER,id);
        return turista;
    }

    /* Ricerca di tutti i turisti */
    @Override
    public List<Turista> retriveAll() throws SQLException {
       return null;
    }

    /* Modifica di un turista */
    @Override
    public void update(Turista turista) throws SQLException {
        runner.update("UPDATE TURISTA SET nome = ?,cognome = ?,email = ?,username = ?,password_turista = ? WHERE id = ?",
                turista.getNome(),turista.getCognome(),turista.getEmail(),turista.getUsername(),turista.getPassword(),turista.getId());
    }

    /* Eliminazione di un turista tramite id */
    @Override
    public void delete(int id) throws SQLException {
        //DA IMPLEMENTARE
    }

    /* Ricerca di un turista tramite credenziali */
    @Override
    public Optional<Turista> findTurista(String username, String password) throws SQLException {
        return Optional.empty();
    }
}
