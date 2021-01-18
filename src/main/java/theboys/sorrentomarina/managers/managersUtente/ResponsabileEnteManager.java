package theboys.sorrentomarina.managers.managersUtente;

import theboys.sorrentomarina.models.modelsUtente.ResponsabileEnte;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface ResponsabileEnteManager {

  ResponsabileEnte retriveById(int id) throws SQLException;

  List<ResponsabileEnte> retriveAll() throws SQLException;

  void update(ResponsabileEnte responsabileEnte) throws SQLException;

  Optional<ResponsabileEnte> findResponsabileEnte(String username, String password) throws SQLException;
}
