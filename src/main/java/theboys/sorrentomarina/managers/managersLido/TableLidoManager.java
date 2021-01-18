package theboys.sorrentomarina.managers.managersLido;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import theboys.sorrentomarina.managers.managersUtils.TableManager;
import theboys.sorrentomarina.models.modelsLido.Lido;
import theboys.sorrentomarina.models.modelsLido.Servizio;


import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
/**
 * @author theboys
 */
public class TableLidoManager extends TableManager implements LidoManager {

  private static final ResultSetHandler<Lido> LIDO_MAPPER =
      new BeanHandler<>(Lido.class);

  private static final ResultSetHandler<List<Lido>> LIDO_MAPPER_LIST =
      new BeanListHandler<>(Lido.class);

  public TableLidoManager(DataSource dataSource) {
    super(dataSource);
  }

  /**
   * Inserimento lido
   *
   * @param nome
   * @param indirizzo
   * @param telefono
   * @param email
   * @param prezzo_singolo
   * @param num_righe
   * @param num_colonne
   * @param id_servizi
   * @param id_resp_ente
   * @throws SQLException
   */
  @Override
  public void create(String nome, String indirizzo, String telefono, String email, String logo, float prezzo_singolo, int num_righe, int num_colonne, int id_servizi, int id_resp_ente) throws SQLException {
    runner.update("INSERT INTO LIDO(nome,indirizzo,telefono,email,logo,prezzo_singolo,num_righe,num_colonne, id_servizi, id_resp_ente) VALUES(?,?,?,?,?,?,?,?,?,?)",
        nome, indirizzo, telefono, email, logo, prezzo_singolo, num_righe, num_colonne, id_servizi, id_resp_ente);
  }

  /**
   * Ricerca lido per id
   *
   * @param id
   * @return lido
   * @throws SQLException
   */
  @Override
  public Lido retriveById(int id) throws SQLException {
    Lido lido = runner.query("SELECT * FROM LIDO WHERE id = ?", LIDO_MAPPER, id);
    return lido;
  }

  /**
   * Ricerca lido per nome
   *
   * @param nome
   * @return lido
   * @throws SQLException
   */
  @Override
  public List<Lido> retriveByName(String nome) throws SQLException {
    String q = "%" + nome + "%";
    List<Lido> lidi = runner.query("SELECT * FROM LIDO WHERE nome LIKE ?", LIDO_MAPPER_LIST, q);
    return lidi;
  }

  /**
   * Ricerca dei lidi che soddisfano i servizi passati come parametro
   *
   * @param servizio
   * @return lidi con determinati servizi
   * @throws SQLException
   */
  @Override
  public List<Lido> retriveByServizi(Servizio servizio) throws SQLException {
    String where = "1=1";
    for (int i = 0; i < 8; i++) {
      switch (i) {
        case 0:
          if (servizio.isBar()) {
            where = where + " AND s.bar=1";
            break;
          } else break;
        case 1:
          if (servizio.isRistorante()) {
            where = where + " AND s.ristorante=1";
            break;
          } else break;
        case 2:
          if (servizio.isAnimazione()) {
            where = where + " AND s.animazione=1";
            break;
          } else break;
        case 3:
          if (servizio.isWifi()) {
            where = where + " AND s.wifi=1";
            break;
          } else break;
        case 4:
          if (servizio.isCabina()) {
            where = where + " AND s.cabina=1";
            break;
          } else break;
        case 5:
          if (servizio.isBeach_volley()) {
            where = where + " AND s.beach_volley=1";
            break;
          } else break;
        case 6:
          if (servizio.isCanoa()) {
            where = where + " AND s.canoa=1";
            break;
          } else break;
      }
    }
    String sql = "SELECT * FROM LIDO AS l,SERVIZI AS s WHERE l.id_servizi=s.id AND " + where;
    List<Lido> lista = runner.query(sql, LIDO_MAPPER_LIST);
    return lista;
  }

  /**
   * Ricerca di tutti i lidi
   *
   * @return tutti i lidi
   * @throws SQLException
   */
  @Override
  public List<Lido> retriveAll() throws SQLException {
    List<Lido> lista = runner.query("SELECT * FROM LIDO", LIDO_MAPPER_LIST);
    return lista;
  }

  /**
   * Modifica di un lido
   *
   * @param lido
   * @throws SQLException
   */
  @Override
  public void update(Lido lido) throws SQLException {
    runner.update("UPDATE LIDO SET nome=?,indirizzo=?,telefono=?,email=?,logo=?,prezzo_singolo=?,num_righe=?,num_colonne=?,id_servizi=? WHERE id=?",
        lido.getNome(), lido.getIndirizzo(), lido.getTelefono(), lido.getEmail(), lido.getLogo(), lido.getPrezzo_singolo(), lido.getNum_righe(), lido.getNum_colonne(), lido.getId_servizi(), lido.getId());
  }

  /**
   * Eliminazione di un lido
   *
   * @param id
   * @throws SQLException
   */
  @Override
  public void delete(int id) throws SQLException {
    runner.update("DELETE FROM LIDO WHERE id=?", id);
  }


  /**
   * Ricerca del numero di righe nella disposizione del lido
   *
   * @param id
   * @return numero di righe
   * @throws SQLException
   */
  @Override
  public int getNumRighe(int id) throws SQLException {
    Lido lido = runner.query("SELECT num_righe FROM LIDO WHERE id=?", LIDO_MAPPER, id);
    return lido.getNum_righe();
  }

  /**
   * Ricerca del numero di colonne nella disposizione del lido
   *
   * @param id
   * @return numero di colonne
   * @throws SQLException
   */
  @Override
  public int getNumColonne(int id) throws SQLException {
    Lido lido = runner.query("SELECT num_colonne FROM LIDO WHERE id=?", LIDO_MAPPER, id);
    return lido.getNum_colonne();
  }
}
