package theboys.sorrentomarina.managers;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import theboys.sorrentomarina.models.Turista;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class TableTuristaManager extends TableManager implements TuristaManager {

  private static final ResultSetHandler<Turista> TUR_MAPPER =
      new BeanHandler<>(Turista.class);

  private static final ResultSetHandler<List<Turista>> TUR_MAPPER_LIST =
      new BeanListHandler<>(Turista.class);

  public TableTuristaManager(DataSource dataSource) {
    super(dataSource);
  }

  /**
   * Inserimento di un turista
   *
   * @param nome
   * @param cognome
   * @param email
   * @param username
   * @param password
   * @throws SQLException
   */
  @Override
  public void create(String nome, String cognome, String email, String username, String password) throws SQLException {
    runner.update("INSERT INTO TURISTA(nome,cognome,email,username,password_turista) VALUES (?, ?, ?, ?, ?)", nome, cognome, email, username, password);
  }

  /**
   * Inserimento di un turista
   *
   * @param nome
   * @param cognome
   * @param email
   * @throws SQLException
   */
  @Override
  public void create(String nome, String cognome, String email) throws SQLException {
    runner.update("INSERT INTO TURISTA(nome,cognome,email) VALUES (?, ?, ?)", nome, cognome, email);
  }

  /**
   * Ricerca di un turista tramite id
   *
   * @param id
   * @return
   * @throws SQLException
   */
  @Override
  public Turista retriveById(int id) throws SQLException {
    Turista turista = runner.query("SELECT nome,cognome,email,username,password_turista FROM TURISTA WHERE id = ?", TUR_MAPPER, id);
    return turista;
  }

  /**
   * Ricerca di tutti i turisti
   *
   * @return
   * @throws SQLException
   */
  @Override
  public List<Turista> retriveAll() throws SQLException {
    List<Turista> lista = runner.query("SELECT * FROM TURISTA", TUR_MAPPER_LIST);
    return lista;
  }

  /**
   * Modifica di un turista
   *
   * @param turista
   * @throws SQLException
   */
  @Override
  public void update(Turista turista) throws SQLException {
    runner.update("UPDATE TURISTA SET nome = ?,cognome = ?,email = ?,username = ?,password_turista = ? WHERE id = ?",
        turista.getNome(), turista.getCognome(), turista.getEmail(), turista.getUsername(), turista.getPassword_turista(), turista.getId());
  }

  /**
   * Eliminazione di un turista tramite id
   *
   * @param id
   * @throws SQLException
   */
  @Override
  public void delete(int id) throws SQLException {
    runner.update("DELETE FROM TURISTA WHERE id= ?", id);
  }

  /**
   * Ricerca di un turista tramite credenziali
   *
   * @param username
   * @param password
   * @return turista
   * @throws SQLException
   */
  @Override
  public Optional<Turista> findTurista(String username, String password) throws SQLException {
    Turista turista= runner.query("SELECT * FROM TURISTA WHERE username= ? AND password_turista= ?", TUR_MAPPER, username, password);
    return  Optional.ofNullable(turista);
  }
}
