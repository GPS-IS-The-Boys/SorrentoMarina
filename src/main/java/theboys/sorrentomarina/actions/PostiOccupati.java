package theboys.sorrentomarina.actions;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import theboys.sorrentomarina.managers.TablePrenotazioneManager;
import theboys.sorrentomarina.models.Lido;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class PostiOccupati implements Action {

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {

    TablePrenotazioneManager manager = new TablePrenotazioneManager(getSource(request));

    String dataInizio = request.getParameter("dataInizio");
    String dataFine = request.getParameter("dataFine");
    Lido lido = (Lido) request.getSession().getAttribute("lido");
    try {
      List<String> postiOccupati = manager.ombrelloniOccupati(dataInizio, dataFine, lido);
      System.out.println(postiOccupati.toString());
      JSONObject obj = new JSONObject();
      JSONArray array = new JSONArray();
      for (String s : postiOccupati) {
        array.add(s);
      }
      obj.put("occupati", array);
      response.setContentType("application/json");
      response.getWriter().write(obj.toJSONString());
      System.out.println(obj.toJSONString());
      System.out.println(array);
      return "ajax";

    } catch (SQLException | IOException throwables) {
      return view("500");
    }
  }
}
