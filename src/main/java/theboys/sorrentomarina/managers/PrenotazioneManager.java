package theboys.sorrentomarina.managers;

import theboys.sorrentomarina.models.Lido;
import theboys.sorrentomarina.models.Prenotazione;

import java.sql.SQLException;
import java.util.List;

public interface PrenotazioneManager {
  //CRUD
  void create(int id, String data_inizio, String data_fine, int num_posti, float costo, int id_lido, int id_turista) throws SQLException;
  void create(String data_inizio, String data_fine, int num_posti, float costo, int id_lido, int id_turista) throws SQLException;
  Prenotazione retriveById(int id) throws SQLException;
  List<Prenotazione> retriveAll(int id) throws SQLException;
  void update(Prenotazione prenotazione) throws SQLException;
  void delete(int id) throws SQLException;

  //BUSINESS
  int prenotazioniTotali() throws SQLException;
  float incassoConsorzio() throws SQLException;
  float incassoLidoTotale(int id_lido) throws SQLException;
  float incassoLidoDa_A(int id_lido, String inizio, String fine) throws SQLException;
  int ombrelloniDisponibili(String inizio, String fine, Lido lido) throws SQLException;
}
