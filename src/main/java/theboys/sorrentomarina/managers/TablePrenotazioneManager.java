package theboys.sorrentomarina.managers;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import theboys.sorrentomarina.models.Lido;
import theboys.sorrentomarina.models.Prenotazione;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

public class TablePrenotazioneManager extends TableManager implements PrenotazioneManager {

  private static final ResultSetHandler<Prenotazione> PRE_MAPPER =
      new BeanHandler<>(Prenotazione.class);

  private static final ResultSetHandler<List<Prenotazione>> PRE_MAPPER_LIST =
      new BeanListHandler<>(Prenotazione.class);

  public TablePrenotazioneManager(DataSource dataSource) {
    super(dataSource);
  }

  @Override
  public void create(int id, String data_inizio, String data_fine, int num_posti,
                     float costo, int id_lido, int id_turista)
      throws SQLException {
    runner.update("INSERT INTO PRENOTAZIONE VALUES (?,?,?,?,?,?,?)", id, data_inizio, data_fine, num_posti, costo, id_lido, id_turista);
  }

  @Override
  public void create(String data_inizio, String data_fine, int num_posti, float costo, int id_lido, int id_turista) throws SQLException {
    runner.update("INSERT INTO PRENOTAZIONE VALUES (?,?,?,?,?,?)", data_inizio, data_fine, num_posti, costo, id_lido, id_turista);
  }

  @Override
  public Prenotazione retriveById(int id) throws SQLException {
    Prenotazione prenotazione = runner.query("SELECT * FROM PRENOTAZIONE WHERE id=?", PRE_MAPPER, id);
    return prenotazione;
  }

  @Override
  public List<Prenotazione> retriveByIdTurista(int id_turista) throws SQLException {
    List<Prenotazione> lista = runner.query("SELECT * FROM PRENOTAZIONE WHERE id_turista=?", PRE_MAPPER_LIST, id_turista);
    return lista;
  }

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

  @Override
  public void update(Prenotazione p) throws SQLException {
    runner.update("UPDATE PRENOTAZIONE SET data_inizio=?,data_fine=?,num_posti=?,costo=?,id_lido=?,id_turista=? WHERE id=?",
        p.getData_inizio(), p.getData_fine(), p.getNum_posti(), p.getCosto(), p.getId_lido(), p.getId_turista(), p.getId());
  }

  @Override
  public void delete(int id) throws SQLException {
    runner.update("DELETE FROM PRENOTAZIONE WHERE id=?", id);
  }

  @Override
  public int prenotazioniTotali() throws SQLException {
    Prenotazione prenotazione = runner.query("SELECT count(id) AS costo FROM PRENOTAZIONE", PRE_MAPPER);
    return (int) prenotazione.getCosto();
  }

  @Override
  public float incassoConsorzio() throws SQLException {
    Prenotazione prenotazione = runner.query("SELECT sum(costo) AS costo FROM PRENOTAZIONE", PRE_MAPPER);
    return prenotazione.getCosto();
  }

  @Override
  public float incassoLidoTotale(int id_lido) throws SQLException {
    Prenotazione prenotazione = runner.query("SELECT sum(costo) AS costo FROM PRENOTAZIONE WHERE id_lido=?", PRE_MAPPER, id_lido);
    return prenotazione.getCosto();
  }

  @Override
  public float incassoLidoDa_A(int id_lido, String inizio, String fine) throws SQLException {
    String sql = "SELECT sum(costo) AS costo FROM PRENOTAZIONE WHERE id_lido=" + id_lido + " AND data_inizio>='" + inizio + "' AND data_fine<='" + fine + "' ";
    Prenotazione prenotazione = runner.query(sql, PRE_MAPPER);
    return prenotazione.getCosto();
  }

  @Override
  public int ombrelloniDisponibili(String inizio, String fine, Lido lido) throws SQLException {
    String sql = "SELECT COUNT(o.id) AS num_posti "
        + "       FROM OMBRELLONE AS o "
        + "       WHERE o.id_prenotazione IN ( SELECT p.id "
        + "                                    FROM PRENOTAZIONE AS p, LIDO AS l "
        + "                                    WHERE p.id_lido =" + lido.getId() + " AND p.data_inizio>='"
        + inizio + "' AND p.data_fine<='" + fine + "')";
    Prenotazione prenotazione = runner.query(sql, PRE_MAPPER);
    int ombrelloniTotali = lido.getNum_colonne() * lido.getNum_righe();
    return ombrelloniTotali - prenotazione.getNum_posti();
  }
}
