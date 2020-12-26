package theboys.sorrentomarina.managers;

import theboys.sorrentomarina.models.ResponsabileLido;
import theboys.sorrentomarina.models.Turista;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface ResponsabileLidoManager {
    //CRUD
    void create(String nome, String cognome, String email, String username, String password) throws SQLException;
    ResponsabileLido retriveById(int id) throws SQLException;
    List<ResponsabileLido> retriveAll() throws SQLException;
    void update(ResponsabileLido responsabileLido) throws SQLException;
    void delete(int id) throws SQLException;
    Optional<ResponsabileLido> findResponsabileLido(String username, String password) throws SQLException;
}
