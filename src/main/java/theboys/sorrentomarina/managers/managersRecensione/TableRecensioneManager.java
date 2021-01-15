package theboys.sorrentomarina.managers.managersRecensione;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import theboys.sorrentomarina.managers.managersUtils.TableManager;
import theboys.sorrentomarina.models.modelsRecensione.Recensione;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

/**
 * @author theboys
 */

public class TableRecensioneManager extends TableManager implements RecensioneManager {

  private static final ResultSetHandler<Recensione> RECENSIONE_MAPPER =
      new BeanHandler<>(Recensione.class);

  private static final ResultSetHandler<List<Recensione>> RECENSIONE_MAPPER_LIST =
      new BeanListHandler<>(Recensione.class);

  /**
   * Creazione TableRecensioneManager e collegamento al database
   *
   * @param dataSource - oggetto che permette la connessione al database
   */
  public TableRecensioneManager(DataSource dataSource) {
    super(dataSource);
  }

  /**
   * Inserimento recensione
   *
   * @param giudizio - voto da 1 a 5
   * @param contenuto - testo della recensione
   * @param id_lido - codice del lido a cui è riferita la recensione
   * @param id_turista - codice del turista che fa la recensione
   * @throws SQLException - eccezione lanciata a causa di problemi con la query
   */
  @Override
  public void create(int giudizio,String contenuto, int id_lido, int id_turista) throws SQLException {
    runner.update("INSERT INTO RECENSIONE(giudizio,contenuto,id_lido,id_turista) VALUES (?,?,?,?)", giudizio, contenuto, id_lido, id_turista);
  }

  /**
   * Ricerca recensione per id
   *
   * @param id - codice univoco di una recensione
   * @return Recensione - una recensione con quello specifico id o null se non esistesse
   * @throws SQLException - eccezione lanciata a causa di problemi con la query
   */
  @Override
  public Recensione retriveById(int id) throws SQLException {
    Recensione recensione = runner.query("SELECT * FROM RECENSIONE WHERE id = ?", RECENSIONE_MAPPER, id);
    return recensione;
  }

  /**
   * Ricerca recensioni per id_lido
   *
   * @param id_lido - codice del lido di cui cercare le recensioni
   * @return List<Recensione> una lista di recensioni riferiti a qeullo specifico lido che sarà vuota se non ci sono
   * @throws SQLException - eccezione lanciata a causa di problemi con la query
   */
  @Override
  public List<Recensione> retriveById_Lido(int id_lido) throws SQLException {
    List<Recensione> lista = runner.query("SELECT * FROM RECENSIONE WHERE id_lido = ?", RECENSIONE_MAPPER_LIST, id_lido);
    return lista;
  }

  /**
   * Ricerca recensioni per id_turista
   *
   * @param id_turista - codice del turista di cui cercare le recensioni
   * @return List<Recensione>una lista di recensioni riferiti a qeullo specifico turista che sarà vuota se non ci sono
   * @throws SQLException - eccezione lanciata a causa di problemi con la query
   */
  @Override
  public List<Recensione> retriveById_Turista(int id_turista) throws SQLException {
    List<Recensione> lista = runner.query("SELECT * FROM RECENSIONE WHERE id_turista = ?", RECENSIONE_MAPPER_LIST, id_turista);
    return lista;
  }


  /**
   * Ricerca di tutte le recensioni
   *
   * @return List<Recensione> - una lista di tutte le recensioni che sarà vuota se non ci sono
   * @throws SQLException - eccezione lanciata a causa di problemi con la query
   */
  @Override
  public List<Recensione> retriveAll() throws SQLException {
    List<Recensione> lista = runner.query("SELECT * FROM RECENSIONE", RECENSIONE_MAPPER_LIST);
    return lista;
  }

  /**
   * Modifica di una recensione
   *
   * @param recensione - recensione da modificare
   * @throws SQLException - eccezione lanciata a causa di problemi con la query
   */
  @Override
  public void update(Recensione recensione) throws SQLException {
    runner.update("UPDATE RECENSIONE SET giudizio = ?,id_lido = ?,id_turista = ? WHERE id = ?",
        recensione.getGiudizio(), recensione.getId_lido(), recensione.getId_turista(), recensione.getId());
  }

  /**
   * Eliminazione di una recensione tramite id
   *
   * @param id - codice della recensione da eliminare
   * @throws SQLException - eccezione lanciata a causa di problemi con la query
   */
  @Override
  public void delete(int id) throws SQLException {
    runner.update("DELETE FROM RECENSIONE WHERE id = ?", id);
  }

  /**
   * Eliminazione di recensioni tramite id_lido
   *
   * @param id_lido - codice del lido di cui eliminare le recensioni
   * @throws SQLException - eccezione lanciata a causa di problemi con la query
   */
  @Override
  public void deleteById_Lido(int id_lido) throws SQLException {
    runner.update("DELETE FROM RECENSIONE WHERE id_lido = ?", id_lido);
  }

  /**
   * Eliminazione di recensioni tramite id_turista
   *
   * @param id_turista - codice del turista di cui eliminare le recensioni
   * @throws SQLException - eccezione lanciata a causa di problemi con la query
   */
  @Override
  public void deleteById_Turista(int id_turista) throws SQLException {
    runner.update("DELETE FROM RECENSIONE WHERE id_lido = ?", id_turista);
  }
}
