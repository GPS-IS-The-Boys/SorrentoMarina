package theboys.sorrentomarina.actions;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import theboys.sorrentomarina.models.Lido;

import javax.servlet.ServletContext;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PostiOccupatiTest extends ActionSetupDB{

  @Test
  public void textView() throws IOException {
    Action ac = Mockito.mock(PostiOccupati.class, Mockito.CALLS_REAL_METHODS);
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);
    Mockito.when(mockReq.getParameter("dataInizio")).thenReturn("2020-06-08");
    Mockito.when(mockReq.getParameter("dataFine")).thenReturn("2020-06-10");
    Lido lido=new Lido(1,"Nome1","Indirizzo1","Telefono1","email1","logo1", 12.5F,4,5,1);
    Mockito.when(mockReq.getSession().getAttribute("lido")).thenReturn(lido);
    StringWriter sw = new StringWriter();
    PrintWriter pw  =new PrintWriter(sw);
    Mockito.when(mockRes.getWriter()).thenReturn(pw);
    String result = ac.execute(mockReq, mockRes);
    assertEquals("ajax", result,
        "It should return the view path");
  }

  @Test
  public void textView500() throws IOException {
    Action ac = Mockito.mock(PostiOccupati.class, Mockito.CALLS_REAL_METHODS);
    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(null);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);
    Mockito.when(mockReq.getParameter("dataInizio")).thenReturn("2020-06-08");
    Mockito.when(mockReq.getParameter("dataFine")).thenReturn("2020-06-10");
    Lido lido=new Lido(1,"Nome1","Indirizzo1","Telefono1","email1","logo1", 12.5F,4,5,1);
    Mockito.when(mockReq.getSession().getAttribute("lido")).thenReturn(lido);
    StringWriter sw = new StringWriter();
    PrintWriter pw  =new PrintWriter(sw);
    Mockito.when(mockRes.getWriter()).thenReturn(pw);
    String result = ac.execute(mockReq, mockRes);
    assertEquals("/WEB-INF/views/500.jsp", result,
        "It should return the view path");
  }
}
