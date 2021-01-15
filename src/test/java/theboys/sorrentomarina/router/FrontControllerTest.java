package theboys.sorrentomarina.router;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import theboys.sorrentomarina.actions.ActionSetupDB;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Disabled
public class FrontControllerTest extends ActionSetupDB {

  private FrontController  frontController=new FrontController();


  @Test
  public void processRequestTest() throws ServletException, IOException {
    HttpServletRequest request= mockReq;
    HttpServletResponse response= mockRes;
    Mockito.when(request.getPathInfo()).thenReturn("/index");
    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);
    frontController= new FrontController();
    frontController.init();
  }
}