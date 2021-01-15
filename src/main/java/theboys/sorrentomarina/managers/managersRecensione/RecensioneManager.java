package theboys.sorrentomarina.managers.managersRecensione;

import theboys.sorrentomarina.models.modelsRecensione.Recensione;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Luigi Maiorano
 * @version 0.1
 */

public interface RecensioneManager {
  //CRUD
  void create(int giudizio, String contenuto, int id_lido, int id_turista) throws SQLException;

  Recensione retriveById(int id) throws SQLException;

  List<Recensione> retriveById_Lido(int id_lido) throws SQLException;

  List<Recensione> retriveById_Turista(int id_turista) throws SQLException;

  List<Recensione> retriveAll() throws SQLException;

  void update(Recensione recensione) throws SQLException;

  void delete(int id) throws SQLException;

  void deleteById_Lido(int id_lido) throws SQLException;

  void deleteById_Turista(int id_turista) throws SQLException;
}
