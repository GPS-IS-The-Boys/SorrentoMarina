package theboys.sorrentomarina.actions;

import theboys.sorrentomarina.managers.RecensioneManager;
import theboys.sorrentomarina.managers.TableRecensioneManager;
import theboys.sorrentomarina.managers.TableTuristaManager;
import theboys.sorrentomarina.managers.TuristaManager;
import theboys.sorrentomarina.models.Lido;
import theboys.sorrentomarina.models.Recensione;
import theboys.sorrentomarina.models.Turista;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

public class RecensioniLidoAction implements Action{
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {
    response.setStatus(HttpServletResponse.SC_ACCEPTED);
    try{
      RecensioneManager manager = new TableRecensioneManager(this.getSource(request));
      TuristaManager managerTurista = new TableTuristaManager(this.getSource(request));
      Lido lido = (Lido)request.getSession().getAttribute("lido");
      List<Recensione> listaRecensioni = manager.retriveById_Lido(lido.getId());
      HashMap<String,Recensione> map =new HashMap<String,Recensione>();
      for (Recensione r: listaRecensioni) {
        Turista turista = managerTurista.retriveById(r.getId_turista());
        map.put(turista.getUsername(),r);
      }
      request.setAttribute("mapRecensioni",map);
      return view("recensioniLido");
    }catch(Exception e){
      return view("500");
    }
  }
}
