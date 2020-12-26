package theboys.sorrentomarina.managers;

import theboys.sorrentomarina.models.Annuncio;

import java.sql.SQLException;
import java.util.List;

public interface AnnuncioManager {
  //CRUD
  void create(String titolo, String contenuto, String foto, String id_lido) throws SQLException;
  Annuncio retriveById(int id) throws SQLException;
  Annuncio retriveById_Lido(String id_lido) throws SQLException;
  List<Annuncio> retriveAll() throws SQLException;
  void update(Annuncio annuncio) throws SQLException;
  public void delete(int id) throws SQLException;
  public void deleteById_Lido(String id_lido) throws SQLException;
}
