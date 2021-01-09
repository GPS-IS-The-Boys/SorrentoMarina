package theboys.sorrentomarina.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MostraDisponibilitaRespLidoAction implements Action{
  /**
   * Mostra la pagina di disponibilita' del lido
   *
   * @param request  la request
   * @param response la response
   * @return ritorna la jsp che mostra la disponibilita' di ombrelloni del lido
   */
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {
    response.setStatus(HttpServletResponse.SC_ACCEPTED);
    return view("respLidoDisponibilita");
  }
}
