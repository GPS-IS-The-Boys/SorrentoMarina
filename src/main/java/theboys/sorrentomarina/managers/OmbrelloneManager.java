package theboys.sorrentomarina.managers;

import java.sql.SQLException;
import java.util.List;

import theboys.sorrentomarina.models.Ombrellone;
import theboys.sorrentomarina.models.Prenotazione;

public interface OmbrelloneManager {

  void create(int num_riga,int num_colonna,int id_prenotazione) throws SQLException;
  List<Ombrellone> retriveByIdPrenotazione(int id_prenotazione) throws SQLException;
  Ombrellone retrviveById(int id)throws SQLException;

}
