package theboys.sorrentomarina.actions;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.servlet.ServletContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RimuoviLidoActionTest extends ActionSetupDB{

  private RimuoviLidoAction rla;

  @Test
  public void SuccessTest(){
    Mockito.when(mockReq.getParameter("id")).thenReturn(String.valueOf(1));

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);

    rla = new RimuoviLidoAction();
    String page = this.rla.execute(mockReq, mockRes);
    assertEquals("redirect:/SorrentoMarina/dashboardEnte", page, "Should return dashboard redirect");
  }

  @Test
  public void FailureTest(){
    Mockito.when(mockReq.getParameter("id")).thenReturn(String.valueOf(10));

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);

    rla = new RimuoviLidoAction();
    String page = this.rla.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/500.jsp", page, "Should return 500 jsp");
  }
}