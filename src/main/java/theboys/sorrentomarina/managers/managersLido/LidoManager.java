package theboys.sorrentomarina.managers.managersLido;

import theboys.sorrentomarina.models.modelsLido.Lido;
import theboys.sorrentomarina.models.modelsLido.Servizio;

import java.sql.SQLException;
import java.util.List;

public interface LidoManager {
  //CRUD
  void create(String nome, String indirizzo, String telefono, String email, String logo, float prezzo_singolo, int num_righe, int num_colonne, int id_servizi, int id_resp_ente) throws SQLException;

  Lido retriveById(int id) throws SQLException;

  List<Lido> retriveByName(String nome) throws SQLException;

  List<Lido> retriveByServizi(Servizio servizio) throws SQLException;

  List<Lido> retriveAll() throws SQLException;

  void update(Lido lido) throws SQLException;

  void delete(int id) throws SQLException;

  //BUSINESS

  int getNumRighe(int id) throws SQLException;

  int getNumColonne(int id) throws SQLException;

}
