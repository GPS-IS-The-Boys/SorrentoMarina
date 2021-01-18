package theboys.sorrentomarina.managers.managersUtente;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import theboys.sorrentomarina.managers.managersUtils.TableManager;
import theboys.sorrentomarina.models.modelsUtente.ResponsabileLido;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
/**
 * @author theboys
 */
public class TableResponsabileLidoManager extends TableManager implements ResponsabileLidoManager {

  private static final ResultSetHandler<ResponsabileLido> RES_LIDO_MAPPER =
      new BeanHandler<>(ResponsabileLido.class);

  private static final ResultSetHandler<List<ResponsabileLido>> RES_LIDO_MAPPER_LIST =
      new BeanListHandler<>(ResponsabileLido.class);

  public TableResponsabileLidoManager(DataSource dataSource) {
    super(dataSource);
  }

  /**
   * Inserimento di un responsabile lido
   *
   * @param nome
   * @param cognome
   * @param email
   * @param username
   * @param password
   * @throws SQLException
   */
  @Override
  public void create(String nome, String cognome, String email, String username, String password, int id_lido, int id_resp_ente) throws SQLException {
    runner.update("INSERT INTO RESPONSABILE_LIDO(nome,cognome,email,username,password_responsabile_lido,id_lido,id_resp_ente) VALUES (?, ?, ?, ?, ?, ?, ?)", nome, cognome, email, username, password, id_lido, id_resp_ente);
  }

  /**
   * Ricerca di un responsabile lido tramite id
   *
   * @param id
   * @return ResponsabileLido
   * @throws SQLException
   */
  @Override
  public ResponsabileLido retriveById(int id) throws SQLException {
    ResponsabileLido responsabileLido = runner.query("SELECT nome, cognome, email, username, password_responsabile_lido FROM RESPONSABILE_LIDO WHERE id = ?", RES_LIDO_MAPPER, id);
    return responsabileLido;
  }

  /**
   * Ricerca di tutti i responsabili lido
   *
   * @return List<ResponsabileLido>
   * @throws SQLException
   */
  @Override
  public List<ResponsabileLido> retriveAll() throws SQLException {
    List<ResponsabileLido> lista = runner.query("SELECT * FROM RESPONSABILE_LIDO", RES_LIDO_MAPPER_LIST);
    return lista;
  }

  /**
   * Modifica di un responsabile lido
   *
   * @param responsabileLido
   * @throws SQLException
   */
  @Override
  public void update(ResponsabileLido responsabileLido) throws SQLException {
    runner.update("UPDATE RESPONSABILE_LIDO SET nome = ?,cognome = ?,email = ?,username = ?,password_responsabile_lido = ? WHERE id = ?",
        responsabileLido.getNome(), responsabileLido.getCognome(), responsabileLido.getEmail(), responsabileLido.getUsername(), responsabileLido.getPassword_responsabile_lido(), responsabileLido.getId());
  }

  /**
   * Eliminazione di un responsabile lido tramite id
   *
   * @param id
   * @throws SQLException
   */
  @Override
  public void delete(int id) throws SQLException {
    runner.update("DELETE FROM RESPONSABILE_LIDO WHERE id = ?", id);
  }

  /**
   * Ricerca di un responsabile tramite credenziali
   *
   * @param username
   * @param password
   * @return Optional<ResponsabileLido>
   * @throws SQLException
   */
  @Override
  public Optional<ResponsabileLido> findResponsabileLido(String username, String password) throws SQLException {
    ResponsabileLido responsabileLido = runner.query("SELECT * FROM RESPONSABILE_LIDO WHERE username= ? AND password_responsabile_lido= ?", RES_LIDO_MAPPER, username, password);
    return Optional.ofNullable(responsabileLido);
  }
}
