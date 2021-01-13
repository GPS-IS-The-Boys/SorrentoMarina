package theboys.sorrentomarina.managers;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import theboys.sorrentomarina.models.Lido;
import theboys.sorrentomarina.models.Ombrellone;
import theboys.sorrentomarina.models.Prenotazione;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TablePrenotazioneManager extends TableManager implements PrenotazioneManager {

  private static final ResultSetHandler<Prenotazione> PRE_MAPPER =
      new BeanHandler<>(Prenotazione.class);

  private static final ResultSetHandler<List<Prenotazione>> PRE_MAPPER_LIST =
      new BeanListHandler<>(Prenotazione.class);

  private static final ResultSetHandler<List<Ombrellone>> OMBRELLONE_MAPPER_LIST =
      new BeanListHandler<>(Ombrellone.class);

  public TablePrenotazioneManager(DataSource dataSource) {
    super(dataSource);
  }

  /**
   * Inserimento prenotazione
   *
   * @param id
   * @param data_inizio
   * @param data_fine
   * @param num_posti
   * @param costo
   * @param id_lido
   * @param id_turista
   * @throws SQLException
   */
  @Override
  public void create(int id, String data_inizio, String data_fine, int num_posti,
                     float costo, int id_lido, int id_turista)
      throws SQLException {
    runner.update("INSERT INTO PRENOTAZIONE VALUES (?,?,?,?,?,?,?)", id, data_inizio, data_fine, num_posti, costo, id_lido, id_turista);
  }

  /**
   * Inserimento prenotazione
   *
   * @param data_inizio
   * @param data_fine
   * @param num_posti
   * @param costo
   * @param id_lido
   * @param id_turista
   * @throws SQLException
   */
  @Override
  public void create(String data_inizio, String data_fine, int num_posti, float costo, int id_lido, int id_turista) throws SQLException {
    runner.update("INSERT INTO PRENOTAZIONE(data_inizio,data_fine,num_posti,costo,id_lido,id_turista) VALUES (?,?,?,?,?,?)", data_inizio, data_fine, num_posti, costo, id_lido, id_turista);
  }

  /**
   * Ricerca tramite id
   *
   * @param id
   * @return
   * @throws SQLException
   */
  @Override
  public Prenotazione retriveById(int id) throws SQLException {
    Prenotazione prenotazione = runner.query("SELECT * FROM PRENOTAZIONE WHERE id=?", PRE_MAPPER, id);
    return prenotazione;
  }

  /**
   * Ricerca tramite turista
   *
   * @param id_turista
   * @return
   * @throws SQLException
   */
  @Override
  public List<Prenotazione> retriveByIdTurista(int id_turista) throws SQLException {
    List<Prenotazione> lista = runner.query("SELECT * FROM PRENOTAZIONE WHERE id_turista=?", PRE_MAPPER_LIST, id_turista);
    return lista;
  }

  /**
   * Ricerca di tutte le prenotazioni
   *
   * @return
   * @throws SQLException
   */
  @Override
  public List<Prenotazione> retriveByIdLido(int id_lido) throws SQLException {
    List<Prenotazione> lista = runner.query("SELECT * FROM PRENOTAZIONE WHERE id_lido=?", PRE_MAPPER_LIST, id_lido);
    return lista;
  }

  @Override
  public List<Prenotazione> retriveAll() throws SQLException {
    List<Prenotazione> lista = runner.query("SELECT * FROM PRENOTAZIONE", PRE_MAPPER_LIST);
    return lista;
  }

  /**
   * Modifica prenotazione
   *
   * @param p
   * @throws SQLException
   */
  @Override
  public void update(Prenotazione p) throws SQLException {
    runner.update("UPDATE PRENOTAZIONE SET data_inizio=?,data_fine=?,num_posti=?,costo=?,id_lido=?,id_turista=? WHERE id=?",
        p.getData_inizio(), p.getData_fine(), p.getNum_posti(), p.getCosto(), p.getId_lido(), p.getId_turista(), p.getId());
  }

  /**
   * Eliminazione prenotazione
   *
   * @param id
   * @throws SQLException
   */
  @Override
  public void delete(int id) throws SQLException {
    runner.update("DELETE FROM PRENOTAZIONE WHERE id=?", id);
  }

  /**
   * Prenotazioni totali
   *
   * @return
   * @throws SQLException
   */
  @Override
  public int prenotazioniTotali() throws SQLException {
    Prenotazione prenotazione = runner.query("SELECT count(id) AS costo FROM PRENOTAZIONE", PRE_MAPPER);
    return (int) prenotazione.getCosto();
  }

  /**
   * Incasso del consorzio
   *
   * @return
   * @throws SQLException
   */
  @Override
  public float incassoConsorzio() throws SQLException {
    Prenotazione prenotazione = runner.query("SELECT sum(costo) AS costo FROM PRENOTAZIONE", PRE_MAPPER);
    return prenotazione.getCosto();
  }

  /**
   * Incasso di un determinato lido
   *
   * @param id_lido
   * @return
   * @throws SQLException
   */
  @Override
  public float incassoLidoTotale(int id_lido) throws SQLException {
    Prenotazione prenotazione = runner.query("SELECT sum(costo) AS costo FROM PRENOTAZIONE WHERE id_lido=?", PRE_MAPPER, id_lido);
    return prenotazione.getCosto();
  }

  /**
   * Incasso lido in un periodo specifico
   *
   * @param id_lido
   * @param inizio
   * @param fine
   * @return
   * @throws SQLException
   */
  @Override
  public float incassoLidoDa_A(int id_lido, String inizio, String fine) throws SQLException {
    String sql = "SELECT sum(costo) AS costo FROM PRENOTAZIONE WHERE id_lido=" + id_lido + " AND data_inizio>='" + inizio + "' AND data_fine<='" + fine + "' ";
    Prenotazione prenotazione = runner.query(sql, PRE_MAPPER);
    return prenotazione.getCosto();
  }

  /**
   * Ricerca ombrelloni occupati
   *
   * @param inizio
   * @param fine
   * @param lido
   * @return
   * @throws SQLException
   */
  @Override
  public List<String> ombrelloniOccupati(String inizio, String fine, Lido lido) throws SQLException {
    String sql = "SELECT o.num_riga AS num_riga, o.num_colonna AS num_colonna"
        + "       FROM OMBRELLONE AS o "
        + "       WHERE o.id_prenotazione IN ( SELECT p.id "
        + "                                    FROM PRENOTAZIONE AS p, LIDO AS l "
        + "                                    WHERE p.id_lido =" + lido.getId() + " AND p.data_inizio>='"
        + inizio + "' AND p.data_fine<='" + fine + "')";
    List<Ombrellone> list = runner.query(sql, OMBRELLONE_MAPPER_LIST);
    List<String> listString = new ArrayList<>();
    for (Ombrellone o : list) {
      listString.add(o.getNum_riga() + "_" + o.getNum_colonna());
    }
    return listString;
  }

  /**
   * Ricerca ombrelloni occupati
   *
   * @param inizio
   * @param fine
   * @param lido
   * @return
   * @throws SQLException
   */
  public List<Ombrellone> ombrelloniListOccupati(String inizio, String fine, int idLido) throws SQLException {
    String sql = "SELECT o.num_riga AS num_riga, o.num_colonna AS num_colonna"
        + "       FROM OMBRELLONE AS o "
        + "       WHERE o.id_prenotazione IN ( SELECT p.id "
        + "                                    FROM PRENOTAZIONE AS p, LIDO AS l "
        + "                                    WHERE p.id_lido =" + idLido + " AND p.data_inizio>='"
        + inizio + "' AND p.data_fine<='" + fine + "')";
    List<Ombrellone> lista = runner.query(sql, OMBRELLONE_MAPPER_LIST);
    return lista;
  }

  /**
   * Ricerca dell'ultima prenotazione inserita
   *
   * @return
   * @throws SQLException
   */
  public int ultimateId() throws SQLException {
    Prenotazione prenotazione = runner.query("SELECT max(id) AS id FROM PRENOTAZIONE", PRE_MAPPER);
    return prenotazione.getId();
  }
}
