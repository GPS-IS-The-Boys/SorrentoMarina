package theboys.sorrentomarina.actions;

import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Diequ
 */
public abstract class ChainableAction implements Action {
    
    private Action next;
    
    public void setNext(Action next) {
        this.next = next;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)  {
        return Objects.nonNull(next) ? next.execute(request, response) : 
                view("500");
    }
    
    
}
