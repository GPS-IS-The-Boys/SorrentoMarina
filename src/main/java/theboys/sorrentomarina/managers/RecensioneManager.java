package theboys.sorrentomarina.managers;

import theboys.sorrentomarina.models.Lido;
import theboys.sorrentomarina.models.Recensione;

import java.sql.SQLException;
import java.util.List;

public interface RecensioneManager {
  //CRUD
  void create(int giudizio, String id_lido, String id_turista) throws SQLException;
  Lido retriveById(int id) throws SQLException;
  List<Recensione> retriveById_Lido(String id_lido) throws SQLException;
  List<Recensione> retriveById_Turista(String id_turista) throws SQLException;
  List<Recensione> retriveAll(String id_lido) throws SQLException;
  void update(Recensione recensione) throws SQLException;
  void delete(int id) throws SQLException;
  void deleteById_Lido(String id_lido) throws SQLException;
  void deleteById_Turista(String id_turista) throws SQLException;
}
