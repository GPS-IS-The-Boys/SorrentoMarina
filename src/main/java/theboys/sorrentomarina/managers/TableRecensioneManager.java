package theboys.sorrentomarina.managers;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import theboys.sorrentomarina.models.Lido;
import theboys.sorrentomarina.models.Recensione;
import theboys.sorrentomarina.models.ResponsabileLido;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

public class TableRecensioneManager extends TableManager implements RecensioneManager{

  private static final ResultSetHandler<Recensione> RECENSIONE_MAPPER =
      new BeanHandler<>(Recensione.class);

  private static final ResultSetHandler<List<Recensione>> RECENSIONE_MAPPER_LIST =
      new BeanListHandler<>(Recensione.class);

  public TableRecensioneManager(DataSource dataSource) {
    super(dataSource);
  }

  /**
   * Inserimento recensione
   *
   * @param giudizio
   * @param id_lido
   * @param id_turista
   * @throws SQLException
   */
  @Override
  public void create(int giudizio, String id_lido, String id_turista) throws SQLException {
    runner.update("INSERT INTO RECENSIONE VALUES(?,?,?)",giudizio,id_lido,id_turista);
  }

  /**
   * Ricerca recensione per id
   *
   * @param id
   * @return Recensione
   * @throws SQLException
   */
  @Override
  public Recensione retriveById(int id) throws SQLException {
    Recensione recensione = runner.query("SELECT * FROM RECENSIONE WHERE id = ?",RECENSIONE_MAPPER,id);
    return recensione;
  }

  /**
   * Ricerca recensioni per id_lido
   *
   * @param id_lido
   * @return List<Recensione>
   * @throws SQLException
   */
  @Override
  public List<Recensione> retriveById_Lido(String id_lido) throws SQLException {
    List<Recensione> lista = runner.query("SELECT * FROM RECENSIONE WHERE id_lido = ?",RECENSIONE_MAPPER_LIST,id_lido);
    return lista;
  }

  /**
   * Ricerca recensioni per id_turista
   *
   * @param id_turista
   * @return List<Recensione>
   * @throws SQLException
   */
  @Override
  public List<Recensione> retriveById_Turista(String id_turista) throws SQLException {
    List<Recensione> lista = runner.query("SELECT * FROM RECENSIONE WHERE id_turista = ?",RECENSIONE_MAPPER_LIST,id_turista);
    return lista;
  }

  /**
   * Ricerca di tutte le recensioni
   *
   * @return List<Recensione>
   * @throws SQLException
   */
  @Override
  public List<Recensione> retriveAll(String id_lido) throws SQLException {
    List<Recensione> lista = runner.query("SELECT * FROM RECENSIONE",RECENSIONE_MAPPER_LIST);
    return lista;
  }

  /**
   * Modifica di una recensione
   *
   * @param recensione
   * @throws SQLException
   */
  @Override
  public void update(Recensione recensione) throws SQLException {
    runner.update("UPDATE RECENSIONE SET giudizio = ?,id_lido = ?,id_turista = ? WHERE id = ?",
        recensione.getGiudizio(),recensione.getId_lido(),recensione.getId_turista(),recensione.getId());
  }

  /**
   * Eliminazione di una recensione tramite id
   *
   * @param id
   * @throws SQLException
   */
  @Override
  public void delete(int id) throws SQLException {
    runner.update("DELETE FROM RECENSIONE WHERE id = ?",id);
  }

  /**
   * Eliminazione di recensioni tramite id_lido
   *
   * @param id_lido
   * @throws SQLException
   */
  @Override
  public void deleteById_Lido(String id_lido) throws SQLException {
    runner.update("DELETE FROM RECENSIONE WHERE id_lido = ?",id_lido);
  }

  /**
   * Eliminazione di recensioni tramite id_turista
   *
   * @param id_turista
   * @throws SQLException
   */
  @Override
  public void deleteById_Turista(String id_turista) throws SQLException {
    runner.update("DELETE FROM RECENSIONE WHERE id_lido = ?",id_turista);
  }
}
