package theboys.sorrentomarina.managers;

import theboys.sorrentomarina.models.Lido;
import theboys.sorrentomarina.models.Servizio;

import java.sql.SQLException;
import java.util.List;

public interface LidoManager {
  //CRUD
  void create(int id, String nome, String indirizzo, String telefono, String email, String logo, float prezzo_singolo, int num_righe, int num_colonne) throws SQLException;

  void create(String nome, String indirizzo, String telefono, String email, float prezzo_singolo, int num_righe, int num_colonne) throws SQLException;

  Lido retriveById(int id) throws SQLException;

  Lido retriveByName(String nome) throws SQLException;

  List<Lido> retriveByServizi(Servizio servizio) throws SQLException;

  List<Lido> retriveAll() throws SQLException;

  void update(Lido lido) throws SQLException;

  void delete(int id) throws SQLException;

  //BUSINESS
  int getPostiDisponibili(int id) throws SQLException;

  int getNumRighe(int id) throws SQLException;

  int getNumColonne(int id) throws SQLException;

}
