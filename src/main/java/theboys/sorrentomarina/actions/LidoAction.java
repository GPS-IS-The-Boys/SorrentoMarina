package theboys.sorrentomarina.actions;

import theboys.sorrentomarina.managers.LidoManager;
import theboys.sorrentomarina.managers.ServizioManager;
import theboys.sorrentomarina.managers.TableLidoManager;
import theboys.sorrentomarina.managers.TableServizioManager;
import theboys.sorrentomarina.models.Lido;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LidoAction implements Action {
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {
    response.setStatus(HttpServletResponse.SC_ACCEPTED);
    try{
      int idLido = Integer.parseInt(request.getParameter("id"));
      LidoManager manager = new TableLidoManager(this.getSource(request));
      Lido lido = manager.retriveById(idLido);
      request.getSession().setAttribute("lido",lido);
      ServizioManager servizioManager = new TableServizioManager(this.getSource(request));
      request.setAttribute("serviziLido",servizioManager.retriveById(lido.getId_servizi()));
      return view("lido");
  }catch (Exception e){
      return view("500");
    }
  }
}
