package theboys.sorrentomarina.managers.managersPrenotazione;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import theboys.sorrentomarina.managers.managersUtils.TableManager;
import theboys.sorrentomarina.models.modelsPrenotazione.Ombrellone;
/**
 * @author theboys
 */
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

public class TableOmbrelloneManager extends TableManager implements OmbrelloneManager {
  private static final ResultSetHandler<Ombrellone> OMBRELLONE_MAPPER =
      new BeanHandler<>(Ombrellone.class);

  private static final ResultSetHandler<List<Ombrellone>> OMBRELLONE_MAPPER_LIST =
      new BeanListHandler<>(Ombrellone.class);

  public TableOmbrelloneManager(DataSource datasorce){
    super(datasorce);
  }

  /**
   * Inserimento di un ombrellone
   * @param num_riga
   * @param num_colonna
   * @param id_prenotazione
   * @throws SQLException
   */
  @Override
  public void create(int num_riga, int num_colonna, int id_prenotazione)throws SQLException {
    runner.update("INSERT INTO OMBRELLONE(num_riga,num_colonna,id_prenotazione) VALUES (?, ?, ?)",num_riga, num_colonna, id_prenotazione);
  }

  /**
   * Ricerca ombrellone tramite prenotazione
   * @param id_prenotazione
   * @return lista di ombrelloni
   * @throws SQLException
   */
  @Override
  public List<Ombrellone> retriveByIdPrenotazione(int id_prenotazione) throws SQLException{
    List<Ombrellone> lista;
    lista=runner.query("SELECT * FROM OMBRELLONE WHERE id_prenotazione=?",OMBRELLONE_MAPPER_LIST ,id_prenotazione);
    return lista;
  }

  /**
   * Ricerca ombrellone tramite id
   * @param id
   * @return un ombrellone
   * @throws SQLException
   */
  @Override
  public Ombrellone retrviveById(int id)throws SQLException{
    Ombrellone ombrellone;
    ombrellone=runner.query("SELECT * FROM OMBRELLONE WHERE id=?",OMBRELLONE_MAPPER,id);
    return ombrellone;
  }



}
