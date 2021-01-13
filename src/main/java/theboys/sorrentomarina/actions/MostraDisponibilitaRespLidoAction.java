package theboys.sorrentomarina.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author theboys
 */


public class MostraDisponibilitaRespLidoAction extends ChainableAction {

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
    String dataInizio = request.getParameter("dataInizio");
    if (dataInizio != null) {
      setNext(new ControllaDisponibilitaAction());
      super.execute(request, response);
    }
    return view("respLidoDisponibilita");
  }
}
