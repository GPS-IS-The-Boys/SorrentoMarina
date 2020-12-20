package theboys.sorrentomarina.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.mockito.Mockito;

/**
 *
 * @author Diequ
 */
public class ActionSetup {
    
    protected HttpServletRequest mockReq;
    protected HttpServletResponse mockRes;
    
    public void setup(){
        mockReq = Mockito.mock(HttpServletRequest.class);
        mockRes = Mockito.mock(HttpServletResponse.class);
    }
}
