package theboys.sorrentomarina.managers.managersLido;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import theboys.sorrentomarina.managers.managersUtils.TableManager;
import theboys.sorrentomarina.models.modelsLido.Servizio;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
/**
 * @author theboys
 */
public class TableServizioManager extends TableManager implements ServizioManager {

  private static final ResultSetHandler<Servizio> SER_MAPPER =
      new BeanHandler<>(Servizio.class);

  private static final ResultSetHandler<List<Servizio>> SER_MAPPER_LIST =
      new BeanListHandler<>(Servizio.class);

  public TableServizioManager(DataSource dataSource) {
    super(dataSource);
  }

  /**
   * Inserimento servizio
   * @param bar
   * @param ristorante
   * @param animazione
   * @param wifi
   * @param cabina
   * @param beach_volley
   * @param canoa
   * @throws SQLException
   */
  @Override
  public void create1(boolean bar, boolean ristorante, boolean animazione, boolean wifi, boolean cabina, boolean beach_volley, boolean canoa) throws SQLException {
    int bar_, ristorante_, animazione_, wifi_, cabina_, beach_volley_, canoa_;
    if (bar) bar_ = 1;
    else bar_ = 0;
    if (ristorante) ristorante_ = 1;
    else ristorante_ = 0;
    if (animazione) animazione_ = 1;
    else animazione_ = 0;
    if (wifi) wifi_ = 1;
    else wifi_ = 0;
    if (cabina) cabina_ = 1;
    else cabina_ = 0;
    if (beach_volley) beach_volley_ = 1;
    else beach_volley_ = 0;
    if (canoa) canoa_ = 1;
    else canoa_ = 0;
    runner.update("INSERT INTO SERVIZI(bar,ristorante,animazione,wifi,cabina,beach_volley,canoa) VALUES (?,?,?,?,?,?,?)", bar_, ristorante_, animazione_, wifi_, cabina_, beach_volley_, canoa_);
  }

  /**
   * Inserimento servizio
   * @param bar
   * @param ristorante
   * @param animazione
   * @param wifi
   * @param cabina
   * @param beach_volley
   * @param canoa
   * @throws SQLException
   */
  @Override
  public void create2(boolean bar, boolean ristorante, boolean animazione, boolean wifi, boolean cabina, boolean beach_volley, boolean canoa) throws SQLException {
    runner.update("INSERT INTO SERVIZI(bar,ristorante,animazione,wifi,cabina,beach_volley,canoa) VALUES (?,?,?,?,?,?,?)", bar, ristorante, animazione, wifi, cabina, beach_volley, canoa);
  }



  /**
   * Ricerca servizio tramite id
   * @param id
   * @return un servizio
   * @throws SQLException
   */
  @Override
  public Servizio retriveById(int id) throws SQLException {
    Servizio servizio = runner.query("SELECT * FROM SERVIZI WHERE id=?", SER_MAPPER, id);
    return servizio;
  }

  /**
   * Modifica servizio
   * @param servizio
   * @throws SQLException
   */
  @Override
  public void update(Servizio servizio) throws SQLException {
    int bar_, ristorante_, animazione_, wifi_, cabina_, beach_volley_, canoa_;
    if (servizio.isBar()) bar_ = 1;
    else bar_ = 0;
    if (servizio.isRistorante()) ristorante_ = 1;
    else ristorante_ = 0;
    if (servizio.isAnimazione()) animazione_ = 1;
    else animazione_ = 0;
    if (servizio.isWifi()) wifi_ = 1;
    else wifi_ = 0;
    if (servizio.isCabina()) cabina_ = 1;
    else cabina_ = 0;
    if (servizio.isBeach_volley()) beach_volley_ = 1;
    else beach_volley_ = 0;
    if (servizio.isCanoa()) canoa_ = 1;
    else canoa_ = 0;
    runner.update("UPDATE SERVIZI SET bar=?,ristorante=?,animazione=?,wifi=?,cabina=?,beach_volley=?,canoa=? WHERE id=?",
        bar_, ristorante_, animazione_, wifi_, cabina_, beach_volley_, canoa_, servizio.getId());
  }

  /**
   * Eliminazione servizio
   * @param id
   * @throws SQLException
   */
  @Override
  public void delete(int id) throws SQLException {
    runner.update("DELETE FROM SERVIZI WHERE id=?", id);
  }

  /**
   * Ritorna tutti i servizi
   *
   * @return una lista di servizi
   * @throws SQLException
   */
  @Override
  public List<Servizio> retriveAll() throws SQLException {
    List<Servizio> lista = runner.query("SELECT * FROM SERVIZI", SER_MAPPER_LIST);
    return lista;
  }
}
