package theboys.sorrentomarina.managers.managersAnnuncio;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import theboys.sorrentomarina.managers.managersUtils.TableManager;
import theboys.sorrentomarina.models.modelsAnnuncio.Annuncio;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

/**
 * @author theboys
 */

public class TableAnnuncioManager extends TableManager implements AnnuncioManager {

  private static final ResultSetHandler<Annuncio> ANNUNCIO_MAPPER =
      new BeanHandler<>(Annuncio.class);

  private static final ResultSetHandler<List<Annuncio>> ANNUNCIO_MAPPER_LIST =
      new BeanListHandler<>(Annuncio.class);


  /**
   * Creazione TableAnnuncioManager e collegamento al database
   *
   * @param dataSource - oggetto che permette la connessione al database
   */
  public TableAnnuncioManager(DataSource dataSource) {
    super(dataSource);
  }

  /**
   * Inserimento di un annuncio
   *
   * @param titolo - titolo dell'annunicio
   * @param contenuto - testo dell'annuncio
   * @param foto - foto rappresentativa
   * @param id_lido - codice del lido a cui fa riferimento l'annuncio
   * @throws SQLException - eccezione lanciata a causa di problemi con la query
   */
  @Override
  public void create(String titolo, String contenuto, String foto, int id_lido) throws SQLException {
    runner.update("INSERT INTO ANNUNCIO(titolo,contenuto,foto,id_lido) VALUES (?, ?, ?, ?)", titolo, contenuto, foto, id_lido);
  }

  /**
   * Ricerca di un annuncio tramite id
   *
   * @param id - codice univoco di un annuncio
   * @return Annuncio - un annucio con quello specifico id o null se non esistesse
   * @throws SQLException - eccezione lanciata a causa di problemi con la query
   */
  @Override
  public Annuncio retriveById(int id) throws SQLException {
    Annuncio annuncio = runner.query("SELECT titolo, contenuto, foto, id_lido FROM ANNUNCIO WHERE id = ?", ANNUNCIO_MAPPER, id);
    return annuncio;
  }

  /**
   * Ricerca degli annunci tramite id_lido
   *
   * @param id_lido - codice del lido di cui cercare gli annunci
   * @return List<Annuncio> una lista di annunci riferiti a qeullo specifico lido che sarà vuota se non ci sono
   * @throws SQLException - eccezione lanciata a causa di problemi con la query
   */
  @Override
  public List<Annuncio> retriveById_Lido(int id_lido) throws SQLException {
    List<Annuncio> lista = runner.query("SELECT * FROM ANNUNCIO WHERE id_lido = ?", ANNUNCIO_MAPPER_LIST, id_lido);
    return lista;
  }

  /**
   * Ricerca di tutti gli annunci
   *
   * @return List<Annuncio> - una lista di tutti gli annunci che sarà vuota se non ci sono
   * @throws SQLException - eccezione lanciata a causa di problemi con la query
   */
  @Override
  public List<Annuncio> retriveAll() throws SQLException {
    List<Annuncio> lista = runner.query("SELECT * FROM ANNUNCIO", ANNUNCIO_MAPPER_LIST);
    return lista;
  }

  /**
   * Modifica di un annuncio
   *
   * @param annuncio - annuncio da modificare
   * @throws SQLException - eccezione lanciata a causa di problemi con la query
   */
  @Override
  public void update(Annuncio annuncio) throws SQLException {
    runner.update("UPDATE ANNUNCIO SET titolo = ?,contenuto = ?,foto = ? WHERE id = ?",
        annuncio.getTitolo(), annuncio.getContenuto(), annuncio.getFoto(), annuncio.getId());
  }

  /**
   * Eliminazione di un annuncio tramite id
   *
   * @param id - codice dell'annuncio da eliminare
   * @throws SQLException - eccezione lanciata a causa di problemi con la query
   */
  @Override
  public void delete(int id) throws SQLException {
    runner.update("DELETE FROM ANNUNCIO WHERE id = ?", id);
  }

  /**
   * Eliminazione degli annunci tramite id_lido
   *
   * @param id_lido - codice del lido di cui eliminare gli annunci
   * @throws SQLException - eccezione lanciata a causa di problemi con la query
   */
  @Override
  public void deleteById_Lido(int id_lido) throws SQLException {
    runner.update("DELETE FROM ANNUNCIO WHERE id_lido = ?", id_lido);
  }

}

