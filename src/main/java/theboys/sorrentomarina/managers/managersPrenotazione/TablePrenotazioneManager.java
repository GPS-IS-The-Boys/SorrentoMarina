package theboys.sorrentomarina.managers.managersPrenotazione;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import theboys.sorrentomarina.managers.managersUtils.TableManager;
import theboys.sorrentomarina.models.modelsLido.Lido;
import theboys.sorrentomarina.models.modelsPrenotazione.Ombrellone;
import theboys.sorrentomarina.models.modelsPrenotazione.Prenotazione;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 * @author theboys
 */
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
  public void create(int id, String data_inizio, String data_fine, int num_posti, float costo,String codice, int id_lido, int id_turista)
      throws SQLException {
    runner.update("INSERT INTO PRENOTAZIONE(id,data_inizio,data_fine,num_posti,costo,codice,id_lido,id_turista) VALUES (?,?,?,?,?,?,?,?)", id, data_inizio, data_fine, num_posti, costo,codice, id_lido, id_turista);
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
  public void create(String data_inizio, String data_fine, int num_posti, float costo,String codice, int id_lido, int id_turista) throws SQLException {
    runner.update("INSERT INTO PRENOTAZIONE(data_inizio,data_fine,num_posti,costo,codice,id_lido,id_turista) VALUES (?,?,?,?,?,?,?)", data_inizio, data_fine, num_posti, costo,codice , id_lido, id_turista);
  }

  /**
   * Ricerca tramite id
   *
   * @param id
   * @return una prenotazione
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
   * @return una lista di prenotazioni
   * @throws SQLException
   */
  @Override
  public List<Prenotazione> retriveByIdTurista(int id_turista) throws SQLException {
    List<Prenotazione> lista = runner.query("SELECT * FROM PRENOTAZIONE WHERE id_turista=?", PRE_MAPPER_LIST, id_turista);
    return lista;
  }

  /**
   * Ricerca di tutte le prenotazioni di un lido
   *
   * @return una lista di prenotazioni
   * @throws SQLException
   */
  @Override
  public List<Prenotazione> retriveByIdLido(int id_lido) throws SQLException {
    List<Prenotazione> lista = runner.query("SELECT * FROM PRENOTAZIONE WHERE id_lido=?", PRE_MAPPER_LIST, id_lido);
    return lista;
  }

  /**
   * Ricerca tutte le prenotazioni effettuarte su sorrento marina
   *
   * @return una lista di tutte le prenotazioni
   * @throws SQLException
   */
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
   * @return costo di una prenotazione
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
   * @return il totale incasso
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
   * @return l'incasso totale del lido
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
   * @return l'incasso di un lido in un periodo specifico
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
   * @return una lista di ombrelloni occupati tra due date
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
   * @param idLido
   * @return una lista di ombrelloni occupati tra due date
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
   * @return l'ultima prenotazione effettuata
   * @throws SQLException
   */
  public int ultimateId() throws SQLException {
    Prenotazione prenotazione = runner.query("SELECT max(id) AS id FROM PRENOTAZIONE", PRE_MAPPER);
    return prenotazione.getId();
  }

  /**
   * Ricerca il numero di prenotazioni effettuate per ogni giorno della settimana.
   *
   * @return una map contentente numero prenotazioni per giorno
   * @throws SQLException
   */
  public HashMap<String,Integer> getAffluenza() throws SQLException {
    HashMap<String,Integer> map = new HashMap<>();
    List<Prenotazione> prenotazione = runner.query("select count(id) as num_posti,DAYNAME(data_inizio) as data_inizio from PRENOTAZIONE group by DAYNAME(data_inizio)", PRE_MAPPER_LIST);
    for(Prenotazione p : prenotazione) {
      if (map.containsKey(p.getData_inizio())) {
        map.put(p.getData_inizio(), map.get(p.getData_inizio()) + p.getNum_posti());
      } else {
        map.put(p.getData_inizio(), p.getNum_posti());
      }
    }
    prenotazione = runner.query("select count(id) as num_posti,DAYNAME(data_fine) as data_fine from PRENOTAZIONE group by DAYNAME(data_fine)", PRE_MAPPER_LIST);
    for(Prenotazione p : prenotazione) {
      if (map.containsKey(p.getData_inizio())) {
        map.put(p.getData_inizio(), map.get(p.getData_inizio()) + p.getNum_posti());
      } else {
        map.put(p.getData_inizio(), p.getNum_posti());
      }
    }
    return map;
  }

  @Override
  public boolean codiceIsPresent(String codice) throws SQLException {
    Prenotazione prenotazione = runner.query("SELECT * FROM PRENOTAZIONE WHERE codice=?", PRE_MAPPER, codice);
    if(prenotazione!=null){
      return true;
    }
    else return false;
  }
}
