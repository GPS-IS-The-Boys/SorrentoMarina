package theboys.sorrentomarina.managers.managersUtente;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import theboys.sorrentomarina.managers.managersUtils.TableManager;
import theboys.sorrentomarina.models.modelsUtente.ResponsabileEnte;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * @author theboys
 */
public class TableResponsabileEnteManager extends TableManager implements ResponsabileEnteManager {

  private static final ResultSetHandler<ResponsabileEnte> ENTE_MAPPER =
      new BeanHandler<>(ResponsabileEnte.class);
  private static final ResultSetHandler<List<ResponsabileEnte>> ENTE_MAPPER_LIST =
      new BeanListHandler<>(ResponsabileEnte.class);

  public TableResponsabileEnteManager(DataSource dataSource) {
    super(dataSource);
  }


  /**
   * Ricerca Responsabile Ente tramite Id
   *
   * @param id
   * @return ResponsabileEnte
   * @throws SQLException
   */
  @Override
  public ResponsabileEnte retriveById(int id) throws SQLException {
    ResponsabileEnte responsabileEnte = runner.query("SELECT nome,cognome,email,username,password_ente FROM RESPONSABILE_ENTE WHERE id = ?", ENTE_MAPPER, id);
    return responsabileEnte;
  }

  /**
   * Ritorna tutti i Responsabili Ente
   *
   * @return List<ResponsabileEnte>
   * @throws SQLException
   */
  @Override
  public List<ResponsabileEnte> retriveAll() throws SQLException {
    List<ResponsabileEnte> lista = runner.query("SELECT * FROM RESPONSABILE_ENTE", ENTE_MAPPER_LIST);
    return lista;
  }

  /**
   * Update Responsabile Ente
   *
   * @param responsabile
   * @throws SQLException
   */
  @Override
  public void update(ResponsabileEnte responsabile) throws SQLException {
    runner.update("UPDATE RESPONSABILE_ENTE SET nome = ?,cognome = ?,email = ?,username = ?,password_ente = ? WHERE id = ?",
        responsabile.getNome(), responsabile.getCognome(), responsabile.getEmail(), responsabile.getUsername(), responsabile.getPassword_ente(), responsabile.getId());
  }

  /**
   * Ricerca Responsabile Ente tramite Credenziali
   *
   * @param username
   * @param password
   * @return Optional<ResponsabileEnte>
   * @throws SQLException
   */
  @Override
  public Optional<ResponsabileEnte> findResponsabileEnte(String username, String password) throws SQLException {
    ResponsabileEnte responsabileEnte = runner.query("SELECT * FROM RESPONSABILE_ENTE WHERE username= ? AND password_ente= ?", ENTE_MAPPER, username, password);
    return Optional.ofNullable(responsabileEnte);
  }
}
