package theboys.sorrentomarina.managers;

import theboys.sorrentomarina.models.Servizio;

import java.sql.SQLException;

public interface ServizioManager {
  void create(int id, boolean bar, boolean ristorante, boolean animazione, boolean wifi, boolean cabina, boolean beach_volley, boolean canoa)throws SQLException;
  void create(boolean bar, boolean ristorante, boolean animazione, boolean wifi, boolean cabina, boolean beach_volley, boolean canoa)throws SQLException;
  Servizio retriveById(int id)throws SQLException;
  void update(Servizio servizio)throws SQLException;
  void delete(int id)throws SQLException;
}
