package theboys.sorrentomarina.managers.managersUtente;

import theboys.sorrentomarina.models.modelsUtente.ResponsabileLido;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface ResponsabileLidoManager {
  //CRUD
  void create(String nome, String cognome, String email, String username, String password, int id_lido, int id_resp_ente) throws SQLException;

  ResponsabileLido retriveById(int id) throws SQLException;

  List<ResponsabileLido> retriveAll() throws SQLException;

  void update(ResponsabileLido responsabileLido) throws SQLException;

  void delete(int id) throws SQLException;

  Optional<ResponsabileLido> findResponsabileLido(String username, String password) throws SQLException;
}
