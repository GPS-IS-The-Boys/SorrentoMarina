package theboys.sorrentomarina.managers.managersLido;

import theboys.sorrentomarina.models.modelsLido.Servizio;

import java.sql.SQLException;
import java.util.List;

public interface ServizioManager {
  public void create1(boolean bar, boolean ristorante, boolean animazione, boolean wifi, boolean cabina, boolean beach_volley, boolean canoa) throws SQLException;

  void create2(boolean bar, boolean ristorante, boolean animazione, boolean wifi, boolean cabina, boolean beach_volley, boolean canoa) throws SQLException;

  Servizio retriveById(int id) throws SQLException;

  void update(Servizio servizio) throws SQLException;

  void delete(int id) throws SQLException;

  List<Servizio> retriveAll() throws SQLException;
}
