package theboys.sorrentomarina.managers;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import theboys.sorrentomarina.models.Annuncio;
import theboys.sorrentomarina.models.Lido;
import theboys.sorrentomarina.models.ResponsabileLido;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

public class TableAnnuncioManager extends TableManager implements AnnuncioManager{

  private static final ResultSetHandler<Annuncio> ANNUNCIO_MAPPER =
      new BeanHandler<>(Annuncio.class);

  private static final ResultSetHandler<List<Annuncio>> ANNUNCIO_MAPPER_LIST =
      new BeanListHandler<>(Annuncio.class);

  public TableAnnuncioManager(DataSource dataSource){ super(dataSource);}

  /**
   * Inserimento di un annuncio
   *
   * @param titolo
   * @param contenuto
   * @param foto
   * @param id_lido;
   * @throws SQLException
   */
  @Override
  public void create(String titolo, String contenuto, String foto, String id_lido) throws SQLException{
    runner.update("INSERT INTO ANNUNCIO(titolo,contenuto,foto,id_lido) VALUES (?, ?, ?, ?)", titolo, contenuto, foto, id_lido);
  }

  /**
   * Ricerca di un annuncio tramite id
   *
   * @param id
   * @return Annuncio
   * @throws SQLException
   */
  @Override
  public Annuncio retriveById(int id) throws SQLException{
    Annuncio annuncio=runner.query("SELECT titolo, contenuto, foto, id_lido FROM ANNUNCIO WHERE id = ?", ANNUNCIO_MAPPER, id);
    return annuncio;
  }

  /**
   * Ricerca degli annunci tramite id_lido
   *
   * @param id_lido
   * @return Annuncio
   * @throws SQLException
   */
  @Override
  public Annuncio retriveById_Lido(String id_lido) throws SQLException {
    Annuncio annuncio = runner.query("SELECT titolo, contenuto, foto FROM ANNUNCIO WHERE id_lido = ?", ANNUNCIO_MAPPER, id_lido);
    return annuncio;
  }

  /**
   * Ricerca di tutti gli annunci
   *
   * @return List<Annuncio>
   * @throws SQLException
   */
  @Override
  public List<Annuncio> retriveAll() throws SQLException {
    List<Annuncio> lista = runner.query("SELECT * FROM ANNUNCIO",ANNUNCIO_MAPPER_LIST);
    return lista;
  }

  /**
   * Modifica di un annuncio
   *
   * @param annuncio
   * @throws SQLException
   */
  @Override
  public void update(Annuncio annuncio) throws SQLException {
    runner.update("UPDATE ANNUNCIO SET titolo = ?,contenuto = ?,foto = ? WHERE id = ?",
       annuncio.getTitolo(), annuncio.getContenuto(), annuncio.getFoto(), annuncio.getId());
  }

  /**
   * Eliminazione di un annuncio tramite id
   *
   * @param id
   * @throws SQLException
   */
  @Override
  public void delete(int id) throws SQLException {
    runner.update("DELETE FROM ANNUNCIO WHERE id = ?",id);
  }

  /**
   * Eliminazione degli annunci tramite id_lido
   *
   * @param id_lido
   * @throws SQLException
   */
  @Override
  public void deleteById_Lido(String id_lido) throws SQLException {
    runner.update("DELETE FROM ANNUNCIO WHERE id_lido = ?",id_lido);
  }





}

