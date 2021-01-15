package theboys.sorrentomarina.managers.managersAnnuncio;

import theboys.sorrentomarina.models.modelsAnnuncio.Annuncio;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Luigi Maiorano
 * @version 0.1
 */

public interface AnnuncioManager {
  //CRUD
  void create(String titolo, String contenuto, String foto, int id_lido) throws SQLException;

  Annuncio retriveById(int id) throws SQLException;

  List<Annuncio> retriveById_Lido(int id_lido) throws SQLException;

  List<Annuncio> retriveAll() throws SQLException;

  void update(Annuncio annuncio) throws SQLException;

  void delete(int id) throws SQLException;

  void deleteById_Lido(int id_lido) throws SQLException;

}
