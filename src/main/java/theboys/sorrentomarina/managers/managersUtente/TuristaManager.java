package theboys.sorrentomarina.managers.managersUtente;

import theboys.sorrentomarina.models.modelsUtente.Turista;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface TuristaManager {
  //CRUD
  void create(String nome, String cognome, String email, String username, String password) throws SQLException;

  void create(int id, String nome, String cognome, String email, String username, String password) throws SQLException;

  void create(String nome, String cognome, String email) throws SQLException;

  Turista retriveById(int id) throws SQLException;

  List<Turista> retriveAll() throws SQLException;

  void update(Turista turista) throws SQLException;

  void delete(int id) throws SQLException;

  Optional<Turista> findTurista(String username, String password) throws SQLException;

  public int ultimateId() throws SQLException;


}
