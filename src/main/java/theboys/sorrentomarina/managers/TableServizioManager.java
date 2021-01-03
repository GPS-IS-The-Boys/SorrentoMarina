package theboys.sorrentomarina.managers;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import theboys.sorrentomarina.models.Servizio;
import theboys.sorrentomarina.models.Turista;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

public class TableServizioManager extends TableManager implements ServizioManager {

  private static final ResultSetHandler<Servizio> SER_MAPPER =
      new BeanHandler<>(Servizio.class);

  private static final ResultSetHandler<List<Servizio>> SER_MAPPER_LIST =
      new BeanListHandler<>(Servizio.class);

  public TableServizioManager(DataSource dataSource) {
    super(dataSource);
  }

  @Override
  public void create(int id, boolean bar, boolean ristorante, boolean animazione, boolean wifi, boolean cabina, boolean beach_volley, boolean canoa) throws SQLException {
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
    runner.update("INSERT INTO SERVIZI VALUES (?,?,?,?,?,?,?,?)", id, bar_, ristorante_, animazione_, wifi_, cabina_, beach_volley_, canoa_);
  }

  @Override
  public void create(boolean bar, boolean ristorante, boolean animazione, boolean wifi, boolean cabina, boolean beach_volley, boolean canoa) throws SQLException {
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
    runner.update("INSERT INTO SERVIZI VALUES (?,?,?,?,?,?,?,?)", bar_, ristorante_, animazione_, wifi_, cabina_, beach_volley_, canoa_);
  }

  @Override
  public Servizio retriveById(int id) throws SQLException {
    Servizio servizio = runner.query("SELECT * FROM SERVIZI WHERE id=?", SER_MAPPER, id);
    return servizio;
  }

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

  @Override
  public void delete(int id) throws SQLException {
    runner.update("DELETE FROM SERVIZI WHERE id=?", id);
  }

  @Override
  public List<Servizio> retrieveAll() throws SQLException {
    List<Servizio> lista = runner.query("SELECT * FROM SERVIZI", SER_MAPPER_LIST);
    return lista;
  }
}
