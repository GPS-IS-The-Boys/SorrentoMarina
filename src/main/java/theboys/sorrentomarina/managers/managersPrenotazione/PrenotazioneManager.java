package theboys.sorrentomarina.managers.managersPrenotazione;

import theboys.sorrentomarina.models.modelsLido.Lido;
import theboys.sorrentomarina.models.modelsPrenotazione.Prenotazione;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public interface PrenotazioneManager {
  //CRUD
  void create(int id, String data_inizio, String data_fine, int num_posti, float costo,String codice, int id_lido, int id_turista) throws SQLException;
  void create(String data_inizio, String data_fine, int num_posti, float costo, String codice, int id_lido, int id_turista) throws SQLException;
  Prenotazione retriveById(int id) throws SQLException;
  List<Prenotazione> retriveByIdTurista(int id_turista) throws SQLException;
  List<Prenotazione> retriveAll() throws SQLException;
  void update(Prenotazione prenotazione) throws SQLException;
  void delete(int id) throws SQLException;
  List<Prenotazione> retriveByIdLido(int id_lido) throws SQLException;


  //BUSINESS
  int prenotazioniTotali() throws SQLException;
  float incassoConsorzio() throws SQLException;
  float incassoLidoTotale(int id_lido) throws SQLException;
  float incassoLidoDa_A(int id_lido, String inizio, String fine) throws SQLException;
  List<String> ombrelloniOccupati(String inizio, String fine, Lido lido) throws SQLException;
  int ultimateId() throws SQLException;
  HashMap<String,Integer> getAffluenza() throws SQLException;
  boolean codiceIsPresent(String codice) throws SQLException;
}
